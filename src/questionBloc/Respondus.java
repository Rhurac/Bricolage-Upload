package questionBloc;

public class Respondus extends Question {
	
	Respondus(String qstr) {
		super(QuestionFormat.RESPONDUS);
		construct(qstr);
	}
	
	@Override
	protected void construct(String qstr) {
		// parse qstring and store in Respondus members
	}
}
