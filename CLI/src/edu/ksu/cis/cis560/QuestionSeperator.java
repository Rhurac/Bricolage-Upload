package edu.ksu.cis.cis560;

import java.util.ArrayList;

public class QuestionSeperator {

    public ArrayList<ArrayList<String>> seperateRespondusQuestionsByType (ArrayList<String> fileContents)
    {

        ArrayList<ArrayList<String>> questionList = new ArrayList<ArrayList<String>>();

        for(int lineNumber = 0; lineNumber<fileContents.size();)
        {
            if(fileContents.get(lineNumber).contains("Type:") || isQuestionNumber(fileContents, lineNumber))
            {
                ArrayList<String> questionContents = new ArrayList<String>();
                questionContents.add(fileContents.get(lineNumber));
                lineNumber++;

                boolean questionNumberHasOccured = false;

                while(lineNumber<fileContents.size() && !fileContents.get(lineNumber).contains("Type:"))
                {
                    if(questionNumberHasOccured && isQuestionNumber(fileContents, lineNumber))
                        break;
                    else if(!questionNumberHasOccured && isQuestionNumber(fileContents, lineNumber))
                        questionNumberHasOccured = true;

                    questionContents.add(fileContents.get(lineNumber));
                    lineNumber++;
                }

                questionList.add(questionContents);
            }
        }

        return questionList;
    }

    private boolean isQuestionNumber(ArrayList<String> fileContents, int i) {
        return fileContents.get(i).matches("^\\d{0,3}[\\)\\.].*");
    }
}
