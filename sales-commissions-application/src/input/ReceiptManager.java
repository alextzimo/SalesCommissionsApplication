package input;

import java.io.File;
import java.io.IOException;

import data.Receipt;



public abstract class ReceiptManager {
	
	protected Receipt receipt;
	
	protected File fileToAppend;
	

	public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
	}
			
	
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
	}		

	public void appendFile() {
		try {
			updateFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected abstract void updateFile() throws IOException, Exception;
	
}