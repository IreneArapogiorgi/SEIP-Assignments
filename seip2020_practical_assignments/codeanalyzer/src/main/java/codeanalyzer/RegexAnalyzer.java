package codeanalyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analyzes metrics with the use of regular expressions.
 * 
 * @purpose This class is implemented using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public class RegexAnalyzer implements AnalyzerType {
	private InputFileReader fileReader;
	private String filepath;
	
	public RegexAnalyzer(InputFileReader _fileReader, String _filepath) {
		this.fileReader = _fileReader;
		this.filepath = _filepath;
	}
	
	@Override
	public int calculateLOC() throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
        	nonCodeLinesCounter++;
        }
		
        int sourceFileLength = sourceCode.split("\n").length;
        int loc =  sourceFileLength - nonCodeLinesCounter;
        
		return loc;
	}

	@Override
	public int calculateNOM() throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
        	methodCounter++;
        }
		return methodCounter;
	}

	@Override
	public int calculateNOC() throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
        	classCounter++;
        }
		return classCounter;
	}

}
