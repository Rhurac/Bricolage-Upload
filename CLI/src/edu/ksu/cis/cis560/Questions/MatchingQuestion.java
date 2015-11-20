package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.QuestionOption;
import edu.ksu.cis.cis560.TitledQuestion;

public class MatchingQuestion extends TitledQuestion {
    private String _correctFeedback = "";
    private String _incorrectFeedback = "";

    public MatchingQuestion(int number, String description, String title, String correctFeedback, String incorrentFeedback) {
        super(number, description, title);
        this._correctFeedback = correctFeedback;
        this._incorrectFeedback = incorrentFeedback;
    }

    public void addOption(QuestionOption option) {
        this._options.add(option);
    }

    public String getCorrectFeedback() {
        return this._correctFeedback;
    }

    public String getIncorrectFeedback() {
        return this._incorrectFeedback;
    }
}
