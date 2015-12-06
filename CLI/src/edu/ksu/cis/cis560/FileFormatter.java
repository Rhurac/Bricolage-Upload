package edu.ksu.cis.cis560;


import edu.ksu.cis.cis560.Questions.EssayQuestion;
import edu.ksu.cis.cis560.Questions.MultiChoiceQuestion;
import edu.ksu.cis.cis560.Questions.TrueFalseQuestion;
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

    private Pair<Integer, String> getTitleAndNumber(String titleLine) {
        int splitCharIndex = titleLine.indexOf(')');
        int number = Integer.parseInt(titleLine.substring(0, splitCharIndex));
        String description = titleLine.substring(splitCharIndex+1, titleLine.length());

        return new Pair<>(number, description);
    }
}
