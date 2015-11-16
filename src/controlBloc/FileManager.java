package controlBloc;

import java.io.File;
import java.util.Vector;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


// A Singleton Class file-manager object which controls all file-related operations
public class FileManager {
	
	
	private static FileManager filemanager = new FileManager(); // only one instance of file-manager allowed for consistency
	@SuppressWarnings("unused")
	private File parent = null; // The root directory loaded into File Manager
	private Vector<File> children; // All children of the root directory
	
	// The default file-manager constructor
	private FileManager() {
		children = new Vector<File>();
	}
	
	// Recursively retrieves all children of current root directory loaded into the file-manager
	private void loadFiles(File parent) {
		File[] flist = parent.listFiles();
		for (File child : flist) {
			if (child.isDirectory()) {
				loadFiles(child);
			} else {
				this.children.add(child);
			}
		}
	}
	
	// Returns the only allowable instance of the file-manager object
	public static FileManager getInstance() {
		return filemanager;
	}
	
	// Returns the root directory currently loaded into the file-manager
	protected File getParent() {
		return this.parent;
	}
	
	// Returns all files below the parent directory currently loaded into the file-manager
	protected Vector<File> getChildren() {
		return this.children;
	}
	
	// Returns the file for the given file-path
	protected File getFile(String path) {
		File file = new File(path);
		return file;
	}
	
	// Populates file manager with the parent and all sub-directories
	protected void initFileManager(File parent) {
		this.parent = parent;
		this.loadFiles(parent);
	}
	
	// Takes a file and parses it into separate strings, each string a raw question.
	protected Vector<String> fileToQStrings(File file) {
		Vector<String> qstrings = new Vector<String>();
		try {
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream dstream = new DataInputStream(fstream);
			BufferedReader in = new BufferedReader(new InputStreamReader(dstream));
			String qstring = "";
			String nextLine;
			while ((nextLine = in.readLine()) != null) {
				if (nextLine.isEmpty()) {
					qstrings.add(qstring);
					qstring = "";
				} else {
					qstring += (nextLine + '\n');
				}
			}
			qstrings.add(qstring);
			fstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qstrings;
	}
	
	// Takes a file as input and prints that file
	protected void printFile(File file) {
		try {
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream dstream = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dstream));
			String nextLine;
			while ((nextLine = br.readLine()) != null) {
				System.out.println(nextLine);
			}
			fstream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
}

















