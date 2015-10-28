package edu.ksu.cis.cis560;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> _fileContents = null;

    public static void main(String[] args) {
        try {
            ParseFlags(args);
            ReadFileContents(_fileContents);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("An error has occurred:");
            System.out.println("\t\t" + e.toString());
        }
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

        if(!filePath.contains(".txt")) {
            throw new Exception("Provided filePath does not contain a .txt file extension");
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
        builder.append("Welcome to the Bricolage File Importer! All flags are listed below:\n\n");
        builder.append("\t--file=./RelativeUrl.txt [REQUIRED]\t\tThe file flag is required and is the relative path to" +
                "an input file to import.\n");
        builder.append("\t--help\t\t\t\t\t\t\t\t\tThe help flag shows all required and optional CLI flags\n");
        String outputString = builder.toString();
        System.out.println(outputString);
    }
}
