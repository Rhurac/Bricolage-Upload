package edu.ksu.cis.cis560;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Alex on 11/1/2015.
 */
public interface IExam {

    abstract Pair<Integer, Question> ReadQuestion(ArrayList<String> fileContents, int location);
    abstract void ReadAllQuestions(ArrayList<String> fileContents);
    abstract void DatabaseUpload();
}
