package edu.ksu.cis.cis560;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alex on 11/10/2015.
 */
public class MultipleChoiceQuestion extends Question {
    private String _question;
    private HashMap<Character, String> _options;
    private ArrayList<Character> _answers;

    public MultipleChoiceQuestion(){
        _question = "";
        _options = new HashMap<Character,String>();
        _answers = new ArrayList<Character>();
    }

    public void SetQuestion(String q)
    {
        _question = q;
    }

    public String GetQuestion()
    {
        return _question;
    }

    public void AddOption(char letter, String option)
    {
        _options.put(letter,option);
    }

    public HashMap<Character, String> GetOptions() {return _options;}

    public void AddAnswer(char letter)
    {
        _answers.add(letter);
    }

    public String ToString()
    {
        StringBuilder str = new StringBuilder();
        str.append(_question);
        for(char c : _options.keySet())
        {
            str.append(c);
            str.append(".");
            str.append(_options.get(c));
        }
        str.append(":");
        for(char c : _answers)
        {
            str.append(c);
            str.append(",");
        }
        return str.toString();
    }
}
