package edu.ksu.cis.cis560;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import edu.ksu.cis.cis560.Questions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    private static ArrayList<String> _fileContents = null;

    public static void main(String[] args) {
        //ParseFlags(args);
        //ReadFileContents(_fileContents);
        ArrayList<String> fileContents = new ArrayList<String>();
        fileContents.add("3) Who determined the exact speed of light?");
        fileContents.add("a. Albert Einstein");
        fileContents.add("*b) Albert Michelson");
        fileContents.add("c) Thomas Edison");
        fileContents.add("d. Guglielmo Marconi");
        fileContents.add(" ");
        fileContents.add("Type: MT");
        fileContents.add("Title: Scientific discoveries");
        fileContents.add(" ");
        fileContents.add("4) Match the correct name to the discovery or theory.");
        fileContents.add("a. Michelson-Morely = Speed of light");
        fileContents.add("b. Einstein = Theory of Relativity");
        fileContents.add("c. Marconi = radio waves");
        fileContents.add("");
        fileContents.add("Type: E");
        fileContents.add("Title: Michelson-Morely experiment");
        fileContents.add(        " ");
        fileContents.add("4) How is the Michelson-Morely experiment related to Albert Einstein’s theory of relativity?");
        fileContents.add(" ");
        fileContents.add("If you are importing an essay question into an Exam file, you can supply an answer two different ways. First, you may provide an answer immediately after the question wording, beginning the answer with “a.” or “a)” (without the quotes).");
        QuestionSeperator qs = new QuestionSeperator();
        qs.seperateRespondusQuestionsByType(fileContents);
    }


    private static void ReadFileContents(ArrayList<String> fileContents) {
        for(String line : fileContents) {
            System.out.println(line);
        }
    }

    /**
     * Pareses CLI arguments for supported flags
     */
    private static void ParseFlags(String[] args) throws Exception {
        for(String flag : args) {
            if(flag.contains("help")) {
                ShowHelpText();
                return;
            }
        }

        for(String flag : args) {
            if(flag.contains("--file")) {
                String filePath = flag.replace("--file=", "");
                _fileContents = RetrieveFileText(filePath);
            }
        }
    }

    /**
     * Reads in file from given filePath and returns it's text contents
     */
    private static ArrayList<String> RetrieveFileText(String filePath) throws Exception {
        if(filePath == null || filePath.length() == 0) {
            throw new Exception(String.format("Invalid file path provided: '{0}'", filePath));
        }

        if(!filePath.contains(".rsp")) {
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

    /**
     * Prints help text for --help flag inclusion
     */
    private static void ShowHelpText() {
        StringBuilder builder = new StringBuilder();
        builder.append("Welcome to the Bricolage File Importer! All flags are listed below:");
        builder.append("\t--file=./RelativeUrl.txt [REQUIRED]\t\tThe file flag is required and is the relative path to" +
                "an input file to import.");
        builder.append("\t--help\t\t\t\t\t\t\t\t\tThe help flag shows all required and optional CLI flags");
        String outputString = builder.toString();
        System.out.println(outputString);
    }
}
