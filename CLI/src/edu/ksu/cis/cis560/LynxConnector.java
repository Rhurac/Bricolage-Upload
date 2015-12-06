package edu.ksu.cis.cis560;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import edu.ksu.cis.cis560.Questions.*;

import java.sql.*;
import java.util.ArrayList;

public class LynxConnector {
    private static Connection _connection;

    protected LynxConnector() {
        if(_connection == null) {
            try {
                try {
                    Class.forName("org.postgresql.Driver");
                    _connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lynx",
                            "postgres", "aster2.00");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("An error has occurred:");
                System.out.println("\t\t" + e.toString());
            }
        }
    }

    public void uploadQuestion(Question question) {
        try {
            Statement stmt = _connection.createStatement();

            String query = "SELECT create_question({0},{1},{2},{3},{4},{5});";

            // Question number
            query = query.replace("{0}", "'" + question.getNumber() + "'");

            // Question title
            String title = "null";
            if(question instanceof TitledQuestion) {
                title = "'" +((TitledQuestion) question).getTitle() + "'";
            }
            query = query.replace("{1}", title);

            // Question description
            query = query.replace("{2}", "'" + question.getDescription() + "'");

            // Question type
            int questionType = findQuestionType(question);
            query = query.replace("{3}", "" + questionType);

            // Question feedback
            if(question instanceof FeedbackQuestion) {
                String correctFeedback = ((FeedbackQuestion)question).getCorrectFeedback();
                String incorrectFeedback = ((FeedbackQuestion)question).getIncorrectFeedback();

                if(correctFeedback != null && correctFeedback != "null") {
                    query = query.replace("{4}", "'" + correctFeedback + "'");
                } else {
                    query = query.replace("{4}", "null");
                }

                if(incorrectFeedback != null && incorrectFeedback != "null") {
                    query = query.replace("{5}", "'" + incorrectFeedback + "'");
                } else {
                    query = query.replace("{5}", "null");
                }
            } else {
                query = query.replace("{4}", "null");
                query = query.replace("{5}", "null");
            }


            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
            {
                int associatedQuestionId = rs.getInt(1);
                uploadOptions(question.getOptions(), associatedQuestionId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Uploaded");
    }

    private int findQuestionType(Question question) {
        if(question instanceof MultiChoiceQuestion) {
            return 2;
        }

        if(question instanceof TrueFalseQuestion) {
            return 3;
        }

        if(question instanceof EssayQuestion) {
            return 4;
        }

        if(question instanceof FillInTheBlankQuestion) {
            return 5;
        }

        if(question instanceof MatchingQuestion) {
            return 6;
        }

        if(question instanceof JumbledQuote) {
            return 8;
        }

        if(question instanceof MultipleFillInBlankQuestion) {
            return 9;
        }

        return 1;
    }

    private void uploadOptions(ArrayList<QuestionOption> options, int associatedQuestionId) {
        for(QuestionOption option : options) {
            try {
                Statement stmt = _connection.createStatement();

                String query = "SELECT create_option({0},{1},{2});";
                // Question description
                query = query.replace("{0}", "'" + option.getDescription() + "'");
                // Question isCorrect
                int isCorrect= 0;
                if(option.isCorrect()) {
                    isCorrect = 1;
                }
                query = query.replace("{1}", "CAST(" + isCorrect + " as bit)");
                // Question associated question
                query = query.replace("{2}", "" + associatedQuestionId);
                stmt.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
