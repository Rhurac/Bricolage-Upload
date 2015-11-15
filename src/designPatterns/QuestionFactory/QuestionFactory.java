package designPatterns.QuestionFactory;

public class QuestionFactory {

	public static Question buildQuestion(QuestionFormat qtype, String qstr) {
		Question q = null;
		switch (qtype) {
		case AIKEN:
			q = new Aiken(qstr);
			break;
		case RESPONDUS:
			q = new Respondus(qstr);
			break;
		default:
			// throw exception
			break;
		}
		return q;
	}
	
}
