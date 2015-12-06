package edu.ksu.cis.cis560;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.xml.internal.ws.resources.TubelineassemblyMessages;
import edu.ksu.cis.cis560.Questions.*;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        //String fileName = RetrieveFileText(args[0]);
        String fileName = "src/edu/ksu/cis/cis560/Tests";
        LynxConnector lc = new LynxConnector();
        //ProcessFiles(fileName, lc);

//        ArrayList<String> lines = new ArrayList<>();
//        lines.add("3) Who determined the exact speed of light?");
//        lines.add("a. Albert Einstein");
//        lines.add("*b) Albert Michelson");
//        lines.add("c) Thomas Edison");
//        lines.add("d. Guglielmo Marconi");
//
//        FileFormatter ff = new FileFormatter();
//        MultiChoiceQuestion q = ff.formatMultiChoiceQuestion(lines);
//
//        ArrayList<String> lines = new ArrayList<>();
//        lines.add("3) Albert Michelson determined the exact speed of light?");
//        lines.add("");
//        lines.add("*a) True");
//        lines.add("b) False");
//
//        FileFormatter ff = new FileFormatter();
//        TrueFalseQuestion q = ff.formatTrueFalseQuestion(lines);

//        ArrayList<String> lines = new ArrayList<>();
//        lines.add("Type: E");
//        lines.add("Title: Michelson-Morely experiment");
//        lines.add("4) How is the Michelson-Morely experiment related to Albert Einstein’s theory of relativity?");
//        lines.add("");
//        lines.add("If you are importing an essay question into an Exam file, you can supply an answer two different ways. First, you may provide an answer immediately after the question wording, beginning the answer with “a.” or “a)” (without the quotes).");
//
//        FileFormatter ff = new FileFormatter();
//        EssayQuestion q = ff.formatEssayQuestion(lines);
    }

    /**
     * Recursively processes directories for exam files, sends every file to be interpreted
     * into a collection of question objects, and finally uploads this collection to the
     * database.
     */
    private static void ProcessFiles(String FileName, LynxConnector Database){
        try {
            File directory = new File(FileName);
            if (directory.isDirectory()) {
                String[] fileList = directory.list();
                for (String x : fileList) {
                    ProcessFiles(FileName+"/"+x, Database);
                }
            } else {
                ArrayList<String> fileContents = RetrieveFileText(FileName);
                String[] fileTypeTokens = FileName.split("\\.");
                String fileType = fileTypeTokens[fileTypeTokens.length-1];
                ArrayList<Question> quiz = ReadFileContents(fileContents, fileType);
                for(Question q : quiz) {
                    Database.uploadQuestion(q);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static ArrayList<Question> ReadFileContents(ArrayList<String> fileContents, String fileType) {
        System.out.println("Filetype: " + fileType);
        for(String line : fileContents) {
            System.out.println(line);
        }
        return new ArrayList<Question>();
    }

    /**
     * Reads in file from given filePath and returns it's text contents
     */
    private static ArrayList<String> RetrieveFileText(String filePath) throws Exception {
        if(filePath == null || filePath.length() == 0) {
            throw new Exception(String.format("Invalid file path provided: '{0}'", filePath));
        }

        if(!filePath.contains(".rsp") && !filePath.contains(".gift")) {
            throw new Exception("Provided filePath does not contain a .rsp file extension");
        }

        File tempFile = new File(filePath).getCanonicalFile();
        if(tempFile == null) {
            throw new Exception(String.format("Invalid file path provided: '{0}'", filePath));
        }

        ArrayList<String> outputList = new ArrayList<>();

        Scanner sc = new Scanner(tempFile);
        while (sc.hasNextLine()) {
            outputList.add(sc.nextLine());
        }

        if(outputList.size() == 0) {
            throw new Exception("Provided file does not contain any text.");
        }

        return outputList;
    }

    //For Demoing Purposes
    private static void DemoQuestion()
    {
    }
}
