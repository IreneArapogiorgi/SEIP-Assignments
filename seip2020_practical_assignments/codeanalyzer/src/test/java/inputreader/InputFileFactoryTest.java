package inputreader;

import org.junit.Test;
import org.junit.Assert;

/**
 * A class that provides test cases for the
 * read_by_type method of the InputFileFactory class.
 * 
 * @author Irene Arapogiorgi
 */
public class InputFileFactoryTest {
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	private final static String TYPE_NULL = "non-existing-type";
	
	InputFileFactory if_factory = new InputFileFactory();
	InputFileReader file_reader;
	
	/*
	 * A unit test that checks the return type when TYPE_WEB given
	 */
	@Test
	public void testReadByWebType() {
		file_reader = if_factory.read_by_type(TYPE_WEB);
		Assert.assertTrue(file_reader instanceof InputFileReader);
	}
	
	/*
	 * A unit test that checks the return type when TYPE_LOCAL given
	 */
	@Test
	public void testReadByLocalType() {
		file_reader = if_factory.read_by_type(TYPE_LOCAL);
		Assert.assertTrue(file_reader instanceof InputFileReader);
	}
	
	/*
	 * A unit test that checks the return type when TYPE_NULL given
	 */
	@Test
	public void testReadByNullType() {
		file_reader = if_factory.read_by_type(TYPE_NULL);
		Assert.assertTrue(file_reader instanceof InputFileReader);
	}
}
