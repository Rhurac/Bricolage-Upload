package edu.ksu.cis.cis560;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Alex on 11/1/2015.
 */
public class AikenReader implements IExam{
    private ArrayList<Question> _questions;

    public AikenReader()
    {
        _questions = new ArrayList<Question>();
    }

    @Override
    public Pair<Integer, Question> ReadQuestion(ArrayList<String> fileContents, int location) {
        System.out.println("\n\nDEBUG INFORMATION\n\n");
        int loc = location;
        System.out.println("\nLocation: "+loc);
        MultipleChoiceQuestion currentQuest = new MultipleChoiceQuestion();
        String title = fileContents.get(location);
        System.out.println("\ntitle: "+title);
        System.out.println(title);
        currentQuest.SetQuestion(title);
        String line = fileContents.get(++loc);
        do{
            System.out.println("\nUnproccessed Line: "+ line);
            String[] split = line.split("\\.|\\)");
            System.out.println("\nSplit Line: " + split[0]);
            currentQuest.AddOption(split[0].charAt(0), split[1]);
            line = fileContents.get(++loc);
        }while(!line.matches("ANSWER: [A-Z]"));
        System.out.println("\nUnprocessed Answer Line: "+ line);
        char answer = fileContents.get(loc).split(":")[1].trim().charAt(0);
        currentQuest.AddAnswer(answer);
        Pair<Integer, Question> result = new Pair<Integer, Question>(loc, currentQuest);
        return result;
    }

    @Override
    public void ReadAllQuestions(ArrayList<String> fileContents) {
        int location = 0;
        Pair<Integer, Question> questionResult;
        while(location < fileContents.size())
        {
            questionResult = ReadQuestion(fileContents,location);
            location = questionResult.getKey();
            _questions.add(questionResult.getValue());
            while(++location < fileContents.size() && fileContents.get(location).matches(" *"));
        }
        DatabaseUpload();
    }

    @Override
    public void DatabaseUpload() {

        for(Question q : _questions)
        {
            System.out.println("\n\nQuestion: "+ q.ToString());
        }

    }
}
