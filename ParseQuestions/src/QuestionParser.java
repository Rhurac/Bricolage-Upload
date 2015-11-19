
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

public class QuestionParser {
	
	public static void main(String[] args) throws IOException{
		File directory = new File("C:\\Users\\ispeer\\Documents\\TestDirectory");

		File [] children = getFilesInDirectory(directory, ".txt");

		for(File child: children)
		{
			if(!child.isDirectory())
			{
				List<String> lines; 
				String path = child.getAbsolutePath();
				lines = parseFile.getTxtFileAsStringList(path);
				Debug.printListOfStrings(lines);
			}
		}
		
	}
	
	public static File[] getFilesInDirectory(File parent, String filter)
	{
		File[] children = parent.listFiles(new FileFilter() {
	        public boolean accept(File file) {
	            return file.isDirectory() ||  file.getName().toLowerCase().endsWith(filter);
	        }
	    });
		
		for(File file: children)
		{
			if (file.isDirectory())
			{
				children = combineArrays(children, getFilesInDirectory(file, filter));
			}
		}
		return children;
	}
	
	//Just re-inventing the wheel.
	public static File[] combineArrays(File [] array1, File[] array2)
	{
		    File [] newArray = new File[array1.length + array2.length];
		    
		    // copy first half
		    System.arraycopy(array1, 0, newArray, 0, array1.length);
		    
		    // copy second half
		    System.arraycopy(array2, 0, newArray, array1.length, array2.length);
		    
		    return newArray;
	}
	
	
}

