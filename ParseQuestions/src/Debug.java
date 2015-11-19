import java.io.File;
import java.util.List;

public class Debug {
	public static void displayFileList(File[] contents)
	{
		for ( File f : contents) {
			System.out.println(f.getAbsolutePath());
		}
	}
	
	public static void printListOfStrings(List<String> list)
	{
		for(String s : list){
			System.out.println(s);
		}
	}
}
