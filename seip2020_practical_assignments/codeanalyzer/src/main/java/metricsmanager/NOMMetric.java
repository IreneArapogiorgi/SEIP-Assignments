package metricsmanager;

import java.io.IOException;

/**
 * Calculates NOM (number of methods) metric.
 * 
 * @purpose This class is implemented using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public class NOMMetric extends Metrics {
	
	public NOMMetric(AnalyzerType _type) {
		super(_type);
	}
	
	@Override
	public int calculate() throws IOException {
		return this.type.calculateNOM();
	}
}
