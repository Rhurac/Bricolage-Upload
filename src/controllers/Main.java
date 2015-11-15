package controllers;
import java.io.File;
import java.util.Vector;

import designPatterns.QuestionFactory.QuestionFormat;
import designPatterns.QuestionFactory.QuestionFactory;

public class Main {

	public static void main(String[] args) {
		try {
			UserIOManager iomgr = UserIOManager.getInstance();
			FileManager fmgr = FileManager.getInstance();
			
			//String dirPath = iomgr.getPath();
 			//File parent = fmgr.getFile(dirPath); 
			
			// This block tests that the file-manager is populating correctly
			File parent = fmgr.getFile("/home/testdir"); // hard-coding path for testing
			fmgr.initFileManager(parent);
			Vector<File> flist = fmgr.getChildren();
			//fmgr.printFile(flist.firstElement());
			//fmgr.printFile(flist.elementAt(1));
			
			// This block tests fileToQStrings method
			Vector<String> qstrings = fmgr.fileToQStrings(flist.firstElement());
			for (String qstring : qstrings) {
				System.out.println(qstring);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// changes a char to a QuestionFormat 
	private static  QuestionFormat charToQFormat(char format) throws Exception {
		switch (format) {
		case 'a':
		case 'A':
			return QuestionFormat.AIKEN;
		case 'r':
		case 'R':
			return QuestionFormat.RESPONDUS;
		default:
			throw new Exception("char format out of bounds.\n");
		}
	}

}
