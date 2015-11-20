package edu.ksu.cis.cis560.Questions;

import edu.ksu.cis.cis560.QuestionOption;
import edu.ksu.cis.cis560.TitledQuestion;

public class EssayQuestion extends TitledQuestion {
    public EssayQuestion(int number, String title, String description, String answer) {
        super(number, description, title);
        this._options.add(new QuestionOption(answer, true));
    }

    public String getAnswer() {
        return this._options.get(0).getDescription();
    }
}
