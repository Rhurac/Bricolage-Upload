package controllers;

import java.util.Scanner;


public class UserIOManager {
	
	private static UserIOManager useriomanager = new UserIOManager();
	
	private UserIOManager(){}
	
	public static UserIOManager getInstance() {
		return useriomanager;
	}
	
	protected String getPath() {
		String directoryPath;
		System.out.println("Enter the directory path to import: ");
		Scanner in = new Scanner(System.in);
		directoryPath = in.nextLine();
		in.close();
		return directoryPath;
	}
	
	protected char getFormat() {
		char format;
		System.out.println("Enter (A)iken or (R)espondus.");
		Scanner in = new Scanner(System.in);
		format = in.nextLine().toUpperCase().trim().charAt(0);
		in.close();
		return format;
	}
	
}
