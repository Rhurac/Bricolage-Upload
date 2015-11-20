package edu.ksu.cis.cis560;

import java.util.ArrayList;

public class Question {

    protected int _number = 0;
    protected String _description = "";
    protected ArrayList<QuestionOption> _options = new ArrayList<>();
    protected ArrayList<String> _images = new ArrayList<>();

    public Question() {}

    public Question(int number, String description) {
        _number = number;
        _description = description;
    }

    public Question(int number, String description, ArrayList<QuestionOption> options) {
        _number = number;
        _description = description;
        _options = options;
    }

    public int getNumber() {
        return _number;
    }

    public String getDescription() {
        return _description;
    }

    public ArrayList<QuestionOption> getOptions() {
        return _options;
    }

    public void addImage(String name) {
        this._images.add(name);
    }

    public ArrayList<String> getImages() {
        return _images;
    }
}
