package edu.ksu.cis.cis560;

public class QuestionOption {
    private String _description = "";
    private boolean _isCorrect = false;

    public QuestionOption() {}

    public QuestionOption(String description, boolean isCorrect) {
        _description = description;
        _isCorrect = isCorrect;
    }

    public String getDescription() {
        return _description;
    }

    public boolean isCorrect() {
        return _isCorrect;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public void setCorrect(boolean correct) {
        _isCorrect = correct;
    }
}
