package questionBloc;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Vector;
import java.io.BufferedReader;


// Under construction...
public class Aiken extends Question {
	
	private String question;
	private Vector<Choice> choices = new Vector<Choice>();
	private char answer;
	
	private class Choice { 
		private char choice; 
		private String answer;
		public Choice(String answerPair) {
			choice = answerPair.trim().toUpperCase().charAt(0);
			answer = answerPair.substring(3);
		}
		public char getChoice;
		public String getAnswer;
	}
	
	public String getQuestion() { return this.question; }
	public Vector<Choice> getChoices() { return this.choices; }
	public char getAnswer() { return this.answer; }
	
	Aiken(String qstr) {
		super(QuestionFormat.AIKEN);
		construct(qstr);
	}
	
	@Override
	protected void construct(String qstr) {
		System.out.println(qstr);
		
		try {
		InputStream istream = new ByteArrayInputStream(qstr.getBytes());
		InputStreamReader isReader = new InputStreamReader(istream);
		BufferedReader in = new BufferedReader(isReader);
		question = in.readLine();
		String nextLine;
		while ((nextLine = in.readLine()).charAt(1) != ')' && nextLine.charAt(1) != '.') {
			choices.add(new Choice(nextLine));
		}
		String[] array = nextLine.split(":");
		answer = array[1].toUpperCase().trim().charAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
