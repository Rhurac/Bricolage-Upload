package edu.ksu.cis.cis560;

import java.util.ArrayList;

public class QuestionSeperator {

    public ArrayList<ArrayList<String>> seperateRespondusQuestionsByType (ArrayList<String> fileContents)
    {

        ArrayList<ArrayList<String>> questionList = new ArrayList<ArrayList<String>>();

        for(int i = 0; i<fileContents.size();)
        {
            if(fileContents.get(i).contains("Type:") || fileContents.get(i).matches("^\\d{0,3}[\\)\\.].*"))
            {
                ArrayList<String> questionContents = new ArrayList<String>();
                questionContents.add(fileContents.get(i));
                i++;

                boolean questionNumberHasOccured = false;

                while(i<fileContents.size() && !fileContents.get(i).contains("Type:"))
                {
                    if(questionNumberHasOccured && fileContents.get(i).matches("^\\d{0,3}[\\)\\.].*"))
                        break;
                    else if(!questionNumberHasOccured && fileContents.get(i).matches("^\\d{0,3}[\\)\\.].*"))
                        questionNumberHasOccured = true;

                    questionContents.add(fileContents.get(i));
                    i++;
                }

                questionList.add(questionContents);
            }
        }

        return questionList;
    }
}
