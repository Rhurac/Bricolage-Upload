import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class parseFile {
	
	public static List<String> getTxtFileAsStringList(String fileLocation) throws IOException
	{
		Path location = Paths.get(fileLocation);
		return Files.readAllLines(location, Charset.defaultCharset());
	}
	
	
	
}
