package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.Question;
import edu.ksu.cis.cis560.QuestionOption;

public class MultiChoiceQuestion extends Question {
    public MultiChoiceQuestion(int number, String description) {
        super(number, description);
    }

    public void addOption(QuestionOption option) {
        this._options.add(option);
    }
}
