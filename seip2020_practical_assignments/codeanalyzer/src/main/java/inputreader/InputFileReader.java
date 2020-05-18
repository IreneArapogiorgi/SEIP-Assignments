package inputreader;

import java.io.IOException;
import java.util.List;

/**
 * @purpose This class is implemented as an interface using Strategy design pattern.
 * @author Irene Arapogiorgi
 */
public interface InputFileReader {
	public List<String> readFileIntoList(String filepath) throws IOException;
	public String readFileIntoString(String filepath) throws IOException;
}
