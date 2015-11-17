package questionBloc;

public abstract class Question {
	
	private QuestionFormat qformat = null;
	
	public Question(QuestionFormat qformat) {
		this.qformat = qformat;
		// arrangeparts();
	}
	
	protected abstract void construct(String qstr);
	
	public QuestionFormat getQFormat() {
		return qformat;
	}
	
	public void setQFormat(QuestionFormat qformat) {
		this.qformat = qformat;
	}
}
