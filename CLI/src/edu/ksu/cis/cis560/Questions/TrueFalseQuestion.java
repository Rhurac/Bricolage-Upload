package edu.ksu.cis.cis560.Questions;
import edu.ksu.cis.cis560.Question;
import edu.ksu.cis.cis560.QuestionOption;

public class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(int number, String description, boolean isTrue) {
        super(number, description);
        this._options.add(new QuestionOption("a) True", isTrue));
        this._options.add(new QuestionOption("b) False", !isTrue));
    }
}
