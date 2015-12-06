package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.FeedbackQuestion;
import edu.ksu.cis.cis560.QuestionOption;

public class MultiChoiceQuestion extends FeedbackQuestion {
    public MultiChoiceQuestion(int number, String title, String description, String correctFeedback, String incorrectFeedback) {
        super(number, title, description, correctFeedback, incorrectFeedback);
    }

    public void addOption(QuestionOption option) {
        this._options.add(option);
    }
}
