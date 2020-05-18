package codeanalyzer;

import java.io.IOException;

/**
 * @purpose This class is implemented as an abstract class using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public abstract class Metrics {
	protected AnalyzerType type;
	
	public Metrics(AnalyzerType _type) {
		this.type = _type;
	}
	
	public abstract int calculate() throws IOException;
}
