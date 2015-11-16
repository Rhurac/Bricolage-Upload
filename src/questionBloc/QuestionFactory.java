package questionBloc;

public class QuestionFactory {

	public static Question buildQuestion(char questionType, String qstr) {
		Question q = null;
		switch (questionType) {
		case 'a':
		case 'A':
			q = new Aiken(qstr);
			QuestionBank.addAiken(q);
		case 'r':
		case 'R':
			q = new Respondus(qstr);
			QuestionBank.addRespondus(q);
		default:
			; // TODO handle exception
		}
		return q;
	}
	
}
