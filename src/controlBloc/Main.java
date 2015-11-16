package controlBloc;
import java.io.File;
import java.util.Vector;

import questionBloc.QuestionFactory;
import questionBloc.QuestionFormat;


// Then main entry-point of the application
public class Main {

	// The main method
	public static void main(String[] args) {
		try {
			//UserIOManager iomgr = UserIOManager.getInstance();
			FileManager fmgr = FileManager.getInstance();
			
			//String dirPath = iomgr.getPath();
 			//File parent = fmgr.getFile(dirPath); 
			
			// This block tests class FileManager: ****************************************
			File parent = fmgr.getFile("/home/testdir"); // hard-coded path with a test doc
			fmgr.initFileManager(parent);
			Vector<File> flist = fmgr.getChildren();
			//fmgr.printFile(flist.firstElement());
			//fmgr.printFile(flist.elementAt(1));
			
			// This block tests fileToQStrings method
			for (File f : flist) {
				Vector<String> qstrings = fmgr.fileToQStrings(f);
				for (String qstring : qstrings) {
					QuestionFactory.buildQuestion('A', qstring);
				}
			}
			// *****************************************************************************
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
}
