package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.FeedbackQuestion;
import edu.ksu.cis.cis560.Question;
import edu.ksu.cis.cis560.QuestionOption;
import edu.ksu.cis.cis560.TitledQuestion;

public class FillInTheBlankQuestion extends FeedbackQuestion {
    public FillInTheBlankQuestion(int number, String title, String description,
                                  String correctFeedback, String incorrectFeedback) {
        super(number, description, title, correctFeedback, incorrectFeedback);
    }

    public void addAnswer(String answer) {
        this._options.add(new QuestionOption(answer, true));
    }
}
