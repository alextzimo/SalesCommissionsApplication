package output;

import java.io.IOException;

import data.SalesCalculator;

public abstract class Output {
	
	protected String outputFilePath;

	protected SalesCalculator agent;
	
	protected void saveFile() throws IOException {
		try {
			writeToFile(outputFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SalesCalculator getAgent() {
		return agent;
	}

	public abstract void writeToFile(String outputFilePath);
}
