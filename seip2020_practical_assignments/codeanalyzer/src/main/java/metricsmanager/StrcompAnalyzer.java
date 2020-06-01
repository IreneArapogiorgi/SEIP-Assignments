package metricsmanager;

import java.io.IOException;
import java.util.List;

import inputreader.InputFileReader;

/**
 * Analyzes metrics with the use of string comparison.
 * 
 * @purpose This class is implemented using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public class StrcompAnalyzer extends AnalyzerType {

	public StrcompAnalyzer(InputFileReader _fileReader, String _filepath) {
		super(_fileReader, _filepath);
	}

	@Override
	public int calculateLOC() throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals("")) {
				nonCodeLinesCounter++;
			}
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc;
	}

	@Override
	public int calculateNOM() throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected")) || line.contains("void") || line.contains("int") || line.contains("String")) && line.contains("(") && line.contains(")") && line.contains("{") ) {
				methodCounter++;
			}
		}
		return methodCounter;
	}

	@Override
	public int calculateNOC() throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter;
	}

}
