package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.FeedbackQuestion;
import edu.ksu.cis.cis560.QuestionOption;
import edu.ksu.cis.cis560.TitledQuestion;

public class MatchingQuestion extends FeedbackQuestion {
    public MatchingQuestion(int number, String description, String title, String correctFeedback, String incorrectFeedback) {
        super(number, title, description, correctFeedback, incorrectFeedback);
    }

    public void addOption(QuestionOption option) {
        this._options.add(option);
    }
}
