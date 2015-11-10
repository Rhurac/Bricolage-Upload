import java.io.File;
import java.io.FileFilter;

public class QuestionParser {
	
	public static void main(String[] args){
		//change to pull from args
		File parent = new File("U:\\Pictures\\Sample Pictures");
		
		File [] children = getDirectoryList(parent, ".jpg");
		
		displayFileList(children);
	}
	
	public static File[] getDirectoryList(File parent, String filter)
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
				children = combineArrays(children, getDirectoryList(file, filter));
			}
		}
		
		return children;
	}
	
	//convert to generic type?
	public static File[] combineArrays(File [] array1, File[] array2)
	{
		    File [] newArray = new File[array1.length + array2.length];
		    
		    // copy first half
		    System.arraycopy(array1, 0, newArray, 0, array1.length);
		    
		    // copy second half
		    System.arraycopy(array2, 0, newArray, array1.length, array2.length);
		    
		    return newArray;
	}
	
	public static void displayFileList(File[] contents)
	{
		for ( File f : contents) {
			System.out.println(f.getAbsolutePath());
		}
	}
}

