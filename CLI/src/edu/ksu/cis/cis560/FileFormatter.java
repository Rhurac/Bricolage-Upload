package edu.ksu.cis.cis560;


import edu.ksu.cis.cis560.Questions.*;
import javafx.util.Pair;

import java.util.ArrayList;

public class FileFormatter {
    public FileFormatter() {

    }

    public MultiChoiceQuestion formatMultiChoiceQuestion(ArrayList<String> lines) {
        String firstLine = lines.get(0);
        Pair<Integer, String> titlePair = getTitleAndNumber(firstLine);

        MultiChoiceQuestion output = new MultiChoiceQuestion(titlePair.getKey(), null, titlePair.getValue(), null, null);

        for(int x = 1; x < lines.size(); x++) {
            String currentLine = lines.get(x);

            if(currentLine.length() == 0)
                continue;

            boolean optionIsCorrect = currentLine.charAt(0) == '*';
            String optionDescription = currentLine.substring(3, currentLine.length());
            output.addOption(new QuestionOption(optionDescription, optionIsCorrect));
        }

        return output;
    }

    public TrueFalseQuestion formatTrueFalseQuestion(ArrayList<String> lines) {
        String firstLine = lines.get(0);
        Pair<Integer, String> titlePair = getTitleAndNumber(firstLine);
        boolean isTrue = false;

        for(int x = 1; x < lines.size(); x++) {
            String currentLine = lines.get(x).toLowerCase();

            if(currentLine.length() == 0)
                continue;

            if(currentLine.contains("*") || currentLine.contains("t")) {
                isTrue = true;
            }
        }

        return new TrueFalseQuestion(titlePair.getKey(), titlePair.getValue(), isTrue);
    }

    public EssayQuestion formatEssayQuestion(ArrayList<String> lines) {
        int number = 0;
        String title = null;
        String description = null;
        String answer = null;

        for(int x = 0; x < lines.size(); x++) {
            String currentLine = lines.get(x);

            if(currentLine.length() == 0) {
                continue;
            }

            if(currentLine.startsWith("Title:")) {
                title = currentLine.substring(7, currentLine.length());
            } else if(currentLine.charAt(1) == ')' && description == null) {
                Pair<Integer, String> tempTitle = getTitleAndNumber(currentLine);
                number = tempTitle.getKey();
                description = tempTitle.getValue();
            } else if(!currentLine.startsWith("Type:")){
                int beginIndex = 0;

                if(currentLine.charAt(1) == ')' || currentLine.charAt(1) == 'x') {
                    beginIndex = 3;
                }

                answer = currentLine.substring(beginIndex, currentLine.length());
            }
        }

        return new EssayQuestion(number, title, description, answer);
    }

    public FillInTheBlankQuestion formatFillInTheBlankQuestion(ArrayList<String> lines) {
        int number = 0;
        String title = null;
        String description = null;
        ArrayList<String> answers = new ArrayList<>();

        for(int x = 0; x < lines.size(); x++) {
            String currentLine = lines.get(x);

            if(currentLine.length() == 0) {
                continue;
            }

            if(currentLine.startsWith("Title:")) {
                title = currentLine.substring(7, currentLine.length());
            } else if(currentLine.charAt(1) == ')' || currentLine.charAt(1) == '.' && description == null) {
                Pair<Integer, String> tempTitle = getTitleAndNumber(currentLine);
                number = tempTitle.getKey();
                description = tempTitle.getValue();
            } else if(!currentLine.startsWith("Type:")){
                int beginIndex = 0;

                if(currentLine.charAt(1) == ')' || currentLine.charAt(1) == 'x' || currentLine.charAt(1) == '.') {
                    beginIndex = 3;
                }

                answers.add(currentLine.substring(beginIndex, currentLine.length()));
            }
        }

        FillInTheBlankQuestion output = new FillInTheBlankQuestion(number, title, description, null, null);

        for(String answer : answers) {
            output.addAnswer(answer);
        }

        return output;
    }

    public MultipleFillInBlankQuestion formatMultipleFillInBlankQuestion(ArrayList<String> lines) {
        int number = 0;
        String title = null;
        String description = null;
        String correctFeedback = null, incorrectFeedback = null;

        for(int x = 0; x < lines.size(); x++) {
            String currentLine = lines.get(x);

            if(currentLine.length() == 0) {
                continue;
            }

            if(currentLine.startsWith("Title:")) {
                title = currentLine.substring(7, currentLine.length());
            } else if(currentLine.charAt(1) == ')' || currentLine.charAt(1) == '.' && description == null) {
                Pair<Integer, String> tempTitle = getTitleAndNumber(currentLine);
                number = tempTitle.getKey();
                description = tempTitle.getValue();
            } else if(!currentLine.startsWith("Type:")){
                if(currentLine.startsWith("~ ")) {
                    correctFeedback = currentLine.substring(2, currentLine.length());
                } else if(currentLine.startsWith("@ ")) {
                    incorrectFeedback = currentLine.substring(2, currentLine.length());
                }
            }
        }

        return new MultipleFillInBlankQuestion(number, title, description, correctFeedback, incorrectFeedback);
    }


    private Pair<Integer, String> getTitleAndNumber(String titleLine) {
        int splitCharIndex = titleLine.indexOf(')');

        if(splitCharIndex == -1) {
            splitCharIndex = titleLine.indexOf('.');
        }

        int number = Integer.parseInt(titleLine.substring(0, splitCharIndex));
        String description = titleLine.substring(splitCharIndex+2, titleLine.length());

        return new Pair<>(number, description);
    }
}
