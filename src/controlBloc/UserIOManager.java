package controlBloc;

import java.util.Scanner;


//A Singleton Class I/O object which controls all user input operations
public class UserIOManager {
	
	private static UserIOManager useriomanager = new UserIOManager(); // only one instance of user i/o manager allowed for consistency
	
	// Constructs a manager object for all user input operations 
	private UserIOManager(){}
	
	// Returns the only allowable instance of the user i/o manager object
	public static UserIOManager getInstance() {
		return useriomanager;
	}
	
	// Ask the user for the path of the directory to load into file-manager
	protected String getPath() {
		String directoryPath;
		System.out.println("Enter the directory path to import: ");
		Scanner in = new Scanner(System.in);
		directoryPath = in.nextLine();
		in.close();
		return directoryPath;
	}
	
	// Ask the user for the question type of files within the chosen directory
	protected char getFormat() {
		char qtype;
		System.out.println("Enter (A)iken or (R)espondus.");
		Scanner in = new Scanner(System.in);
		qtype = in.nextLine().toUpperCase().trim().charAt(0);
		in.close();
		return qtype;
	}
	
}
