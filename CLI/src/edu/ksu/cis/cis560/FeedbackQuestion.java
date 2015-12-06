package edu.ksu.cis.cis560;


public class FeedbackQuestion extends TitledQuestion {
    private String _correctFeedback = "";
    private String _incorrectFeedback = "";

    public FeedbackQuestion(int number, String title, String description, String correctFeedback, String incorrectFeedback) {
        super(number, description, title);
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
