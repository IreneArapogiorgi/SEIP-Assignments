package inputreader;

/**
 * Retrieves content of input file based on its location type.
 * The file can be stored locally or exist on the web.
 * 
 * @purpose This class is implemented using Factory design pattern.
 * @author Irene Arapogiorgi
 */
public class InputFileFactory {
	public InputFileReader read_by_type(String type) {
		if (type.equals("web")) {
			return new WebReader();
		} else if (type.equals("local")) {
			return new LocalReader();
		} else {
			return new NullReader();
		}
	}
}
