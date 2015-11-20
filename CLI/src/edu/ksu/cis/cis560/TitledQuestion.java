package edu.ksu.cis.cis560;

public class TitledQuestion extends Question {
    protected String _title = "";

    public TitledQuestion(int number, String description, String title) {
        super(number, description);
        this._title = title;
    }

    public String getTitle() {
        return this._title;
    }
}
