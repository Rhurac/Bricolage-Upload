package controllers;
import java.io.File;
import designPatterns.QuestionFactory.QuestionFormat;
import designPatterns.QuestionFactory.QuestionFactory;

public class Main {

	public static void main(String[] args) {
		try {
			UserIOManager iomgr = UserIOManager.getInstance();
			FileManager fmgr = FileManager.getInstance();
			
			String dirPath = iomgr.getPath();
			File parent = fmgr.getFile(dirPath);
			fmgr.initFileManager(parent);
			// get format from user
			QuestionFormat qformat = charToQFormat(iomgr.getFormat());
			String[] qstrings;
			for (File file : fmgr.listFiles()) {
				// for each file parse into qstring
				qstrings = fmgr.fileToQStrings(file);
				    // for each qstring build a question
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
