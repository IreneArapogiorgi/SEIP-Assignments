package metricsmanager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculates metrics of input file.
 * Metrics can be LOC, NOM or NOC.
 * 
 * @purpose This class is implemented using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public class MetricsManagement {
	private Map<String, Integer> metrics = new HashMap<>();
	
	public Map<String, Integer> calculate_metrics(Metrics lc, Metrics nm, Metrics nc) throws IOException {
		int loc = lc.calculate();
		int nom = nm.calculate();
		int noc = nc.calculate();
		
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);
		
		return metrics;
	}
}
