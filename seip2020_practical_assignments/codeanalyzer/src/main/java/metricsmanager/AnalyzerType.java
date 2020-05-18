package metricsmanager;

import java.io.IOException;

/**
 * @purpose This class is implemented as an interface using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public interface AnalyzerType {
	public int calculateLOC() throws IOException;
	public int calculateNOM() throws IOException;
	public int calculateNOC() throws IOException;
}
