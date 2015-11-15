package controllers;

import java.io.File;
import java.util.Vector;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


// Singleton Class controls all file operations
public class FileManager {
	
	private static FileManager filemanager = new FileManager(); 
	@SuppressWarnings("unused")
	private File parent = null; // The root directory loaded into File Manager
	private Vector<File> children; // All children of the root directory
	
	private FileManager() {
		children = new Vector<File>();
	}
	
	// Recursively retrieves all children of parent File
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
	
	// Returns the only allowable instance of FileManager
	public static FileManager getInstance() {
		return filemanager;
	}
	
	protected File getParent() {
		return this.parent;
	}
	
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
					System.out.println(qstring);
					qstring = "";
				} else {
					qstring += (nextLine + '\n');
				}
			}
			fstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qstrings;
	}
	
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

















