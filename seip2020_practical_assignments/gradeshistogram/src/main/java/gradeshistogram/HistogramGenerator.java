package gradeshistogram;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
* The HistogramGenerator program implements a Java application that
* reads a file with students' grades and generates its histogram.
*
* @author  Irene Arapogiorgi
* @version 1.0
* @since   2020-03-23 
*/
public class HistogramGenerator {
	
	/*** 
	 * Receives a String variable.
	 * Given this variable, grades from the text file are extracted.
	 * Uses the exact following steps because total number of integers
	 * inside the given file is unknown.
	 * 
	 * @param argument String argument given by the user.
	 * @return dataValues Single dimension integer array.
	 * @exception IOException If file is not given as argument.
	 * @see IOException
	*/
	public int[] extractGrades(String argument) throws IOException {
		// Read file
		File file = new File(argument);
		
		// Store file's content into a byte[] array
		byte[] bytes = new byte[(int) file.length()];
		
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytes);
		fis.close();
		
		/*
		 * Convert byte values to string,
		 * eliminate leading and trailing spaces,
		 * and split on one or more whitespaces.
		 */
		String[] stringValues = new String(bytes).trim().split("\\s+");
		
		// Convert string values to integers
		int[] dataValues = new int[stringValues.length];
		
		for (int i = 0; i < stringValues.length; i++) {
			dataValues[i] = Integer.parseInt(stringValues[i]);
		}
		return dataValues;
	}
	
	/*** 
	 * Receives a single dimension integer array.
	 * From this array each grade's frequency is calculated.
	 * 
	 * @param dataValues Single dimension integer array.
	 * @return dataFrequencies Single dimension integer array.
	*/
	public int[] calculateFrequencies(int[] dataValues) {
		// Create dataFrequencies array
		int[] dataFrequencies = new int[11];
		
		// Search for each and every grade inside dataValues array
		for (int i = 0; i < 11; i++) {
			int frequency = 0;
			for (int j = 0; j < dataValues.length; j++) {
	            if (i == dataValues[j]) {
	            	frequency++;
	            }
			}
			dataFrequencies[i] = frequency;
		}
		return dataFrequencies;
	}
	
	/***
	 * Receives a single dimension integer array.
	 * From this array the dataset that will be used for the visualization is generated.
	 * Finally, the chart is generated with the use of the aforementioned dataset
	 * and then presented in the screen.
	 * 
	 * @param uniqueValues Single dimension integer array.
	 * @param dataFrequencies Single dimension integer array.
	 */
	public void generateChart(int[] uniqueValues, int[] dataFrequencies) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset)
		 * that can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		/*
		 * The XYSeries that are loaded in the dataset.
		 * There might be many series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		// Populating the XYSeries data object from the input integer array values
		for (int i = 0; i < uniqueValues.length; i++) {
			data.add(uniqueValues[i], dataFrequencies[i]);
		}

		// Add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // Do not visualize a legend
		boolean tooltips = false; // Do not visualize tooltips
		boolean urls = false; // Do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart
		 * and attach the previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// Makes the previously created frame visible
		frame.setVisible(true);
	}
	
	/***
	 * This is the main method which prints student' grades histogram.
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 * @exception IOException On input error.
	 * @see IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// Create object HistogramGenerator
		HistogramGenerator demo = new HistogramGenerator();
		
		// Extract grades from text file
		int[] dataValues = demo.extractGrades(args[0]);
		
		// Calculate each grade's frequency
		int[] dataFrequencies = demo.calculateFrequencies(dataValues);
		
		// Store unique grades' values in array
		int[] uniqueValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// Generate histogram chart
		demo.generateChart(uniqueValues, dataFrequencies);
	}

}
