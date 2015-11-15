package designPatterns.QuestionFactory;


public class Aiken extends Question {
	
	Aiken(String qstr) {
		super(QuestionFormat.AIKEN);
		construct(qstr);
	}
	
	@Override
	protected void construct(String qstr) {
		// parse qstring and store in Aiken members
		
		/*
		// Parses all files loaded in the FileManager into discrete question strings
		protected String[] parseFilesToQStrings(File file, char flag) {
			try {
				FileInputStream fstream = new FileInputStream(file);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String nextLine;
				while ((nextLine = br.readLine()) != null) {
					
				}
				fstream.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}*/
	}
}
