package controllers;

import java.io.File;
import java.util.Vector;
import java.io.FileInputStream;
import java.io.DataInputStream;
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
	private Vector<File> getAllFiles(File parent) {
		File[] files = parent.listFiles();
		for (File child : files) {
			children.add(child);
		}
		for (File child : children) {
			if (child.isDirectory()) {
				Vector<File> filesBelow = new Vector<File>();
				filesBelow = getAllFiles(child);
				for (File file : filesBelow) {
					children.add(file);
				}
			} else {
				children.add(child);
			}
		}
		return children;
	}
	
	// Returns the only allowable instance of FileManager
	public static FileManager getInstance() {
		return filemanager;
	}
	
	// Returns the file for the given file-path
	protected File getFile(String path) {
		File file = new File(path);
		return file;
	}
	
	// Populates file manager with the parent and all sub-directories
	protected void initFileManager(File parent) {
		this.parent = parent;
		this.children = getAllFiles(parent);
	}
	
	protected Vector<File> listFiles() {
		return children;
	}
	
	protected String[] fileToQStrings(File file) throws IOException {
		FileInputStream fstream = new FileInputStream(file);
		DataInputStream dstream = new DataInputStream(fstream);
		BufferedReader in = new BufferedReader(new InputStreamReader(dstream));
		
		while ((String nextLine = in.readLine())
		
		
		fstream.close();
	}
	
}

















