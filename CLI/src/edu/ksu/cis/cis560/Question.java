package edu.ksu.cis.cis560;

import java.util.ArrayList;

public abstract class Question {

    private String _description = "";
    private ArrayList<QuestionOption> _options = new ArrayList<>();

    public Question() {}

    public Question(String description, ArrayList<QuestionOption> options) {
        _description = description;
        _options = options;
    }

    public String getDescription() {
        return _description;
    }

    public ArrayList<QuestionOption> getOptions() {
        return _options;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public void setOptions(ArrayList<QuestionOption> options) {
        _options = options;
    }

    public void addOption(QuestionOption option) {
        _options.add(option);
    }
}
