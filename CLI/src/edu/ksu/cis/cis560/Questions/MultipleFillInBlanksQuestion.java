package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.TitledQuestion;

public class MultipleFillInBlanksQuestion extends FillInTheBlankQuestion {
    private String _correctFeedback = "";
    private String _incorrectFeedback = "";

    public MultipleFillInBlanksQuestion(int number, String title, String description, String correctFeedback, String incorrectFeedback) {
        super(number, title, description);
        this._correctFeedback = correctFeedback;
        this._incorrectFeedback = incorrectFeedback;
    }

    public String getCorrectFeedback() {
        return this._correctFeedback;
    }

    public String getIncorrectFeedback() {
        return this._incorrectFeedback;
    }
}
