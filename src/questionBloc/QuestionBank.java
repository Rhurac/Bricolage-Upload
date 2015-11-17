package questionBloc;

import java.util.Vector;

// Singleton class object which stores all question types
public class QuestionBank {
	
	private static Vector<Question> aikenList = new Vector<Question>(); // list of all Aiken-type questions
	private static Vector<Question> respondusList = new Vector<Question>(); // list of all Respondus-type questions
	private static QuestionBank qbank = new QuestionBank(); // Stores the static question-bank object
	private QuestionBank(){} // Default constructor required
	
	// Returns an instance of the static question-bank object
	public static QuestionBank getInstance() {
		return qbank;
	}
	
	// Getter methods for private members
	protected Vector<Question> getAikenList() {
		return aikenList;
	}
	protected Vector<Question> getRespondusList() {
		return respondusList;
	}
	
	// Appends a question to the corresponding question type list
	protected static void addAiken(Question q) {
		aikenList.add(q);
	}
	protected static void addRespondus(Question q) {
		respondusList.add(q);
	}
}
