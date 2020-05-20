package metricsmanager;

import java.io.IOException;

import inputreader.InputFileReader;

/**
 * @purpose This class is implemented as an abstract class using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public abstract class AnalyzerType {
	protected InputFileReader fileReader;
	protected String filepath;
	
	public AnalyzerType(InputFileReader _fileReader, String _filepath) {
		this.fileReader = _fileReader;
		this.filepath = _filepath;
	}
	
	public abstract int calculateLOC() throws IOException;
	public abstract int calculateNOM() throws IOException;
	public abstract int calculateNOC() throws IOException;
}
