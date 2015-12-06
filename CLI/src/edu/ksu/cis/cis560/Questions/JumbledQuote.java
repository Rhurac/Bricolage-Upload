package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.FeedbackQuestion;
import edu.ksu.cis.cis560.QuestionOption;
import edu.ksu.cis.cis560.TitledQuestion;

public class JumbledQuote extends FeedbackQuestion {

    public JumbledQuote(int number, String description, String title, String correctFeedback, String incorrectFeedback) {
        super(number, title, description, correctFeedback, incorrectFeedback);
    }

    public void addAnswer(String answer) {
        this._options.add(new QuestionOption(answer, true));
    }

    public void addDistraction(String distraction) {
        this._options.add(new QuestionOption(distraction, false));
    }
}
