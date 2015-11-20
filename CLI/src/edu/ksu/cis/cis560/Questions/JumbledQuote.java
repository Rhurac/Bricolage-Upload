package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.QuestionOption;
import edu.ksu.cis.cis560.TitledQuestion;

public class JumbledQuote extends TitledQuestion {
    private String _correctFeedback = "";
    private String _incorrectFeedback = "";

    public JumbledQuote(int number, String description, String title, String correctFeedback, String incorrectFeedback) {
        super(number, description, title);
        this._correctFeedback = correctFeedback;
        this._incorrectFeedback = incorrectFeedback;
    }

    public void addAnswer(String answer) {
        this._options.add(new QuestionOption(answer, true));
    }

    public void addDistraction(String distraction) {
        this._options.add(new QuestionOption(distraction, false));
    }

    public String getCorrectFeedback() {
        return this._correctFeedback;
    }

    public String getIncorrectFeedback() {
        return this._incorrectFeedback;
    }
}
