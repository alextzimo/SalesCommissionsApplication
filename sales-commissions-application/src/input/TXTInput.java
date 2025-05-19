package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class TXTInput extends Input{
	
	List<String> values = new ArrayList<>();
	
	public TXTInput(File recieptFileTXT){
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
		
	}
	
	@Override
	public void parseInputFile() {
		BufferedReader br = null;
	    try {
	            	
			br = new BufferedReader(new FileReader(inputFilePath));
		} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}
	    BufferedReader br1 = null;
	    try {
	            	
			br1 = new BufferedReader(new FileReader(inputFilePath));
		} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}
	    
	    String line;
	    try {

	    	int counter = 0;
	    	line = br.readLine();
	    	name = (line.substring(line.indexOf(":") + 1).trim());
			line = br.readLine();
			afm = (line.substring(line.indexOf(":") + 1).trim());
			addAgent();
	    	
			
			while ((line = br.readLine()) != null) {
				
				if(line.startsWith("Receipts")){
					
					continue;
					
				}
				
				if(line.startsWith("Receipt ID")) {
					counter++;
				}
	    		  
			}
			
			for (int i = 0; i<counter; i++) {
				while ((line = br1.readLine()) != null) {
					if (line.startsWith("Name:") || line.startsWith("AFM") || line.startsWith("Receipts") || line.equals("")) {
						continue;
					}
					
					values.add(line.substring(line.indexOf(":") + 1).trim());
					
					if (line.startsWith("Number")) break;
					
				}
				
				addReceiptFromValues(values);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}