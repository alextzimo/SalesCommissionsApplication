package input;


import java.io.File;
import java.io.IOException;
import java.util.List;

import data.SalesCalculator;
import data.Receipt;


public abstract class Input {
	
	protected SalesCalculator agent;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;
	
	
	
	public Input() {
		agent = new SalesCalculator();
		kind  = new String("");
	}
	

	public void readFile() throws IOException {
		try {
			parseInputFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	protected abstract void parseInputFile();

	
	public void addAgent() {
		agent.setName(name);
		agent.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt;			

		receipt= new Receipt();
		receipt.setKind(kind);

			
		receipt.setReceiptID(receiptID);			
		receipt.setDate(date);
		receipt.setSales(sales);
		receipt.setItems(items);
		receipt.getCompany().setName(companyName);
		receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
		receipt.getCompany().getCompanyAddress().setCity(companyCity);
		receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
		receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
		agent.getReceipts().add(receipt);
	}
	
	
	public SalesCalculator getAgent() {
		return agent;
	}
	
	
	protected void addReceiptFromValues(List<String> values) {
        receiptID = Integer.parseInt(values.get(0).toString());
        date = (String) values.get(1);
        kind = (String) values.get(2);
        sales = Double.parseDouble(values.get(3).toString());
        items = Integer.parseInt((values.get(4).toString()));
        companyName = (String) values.get(5);
        companyCountry = (String) values.get(6);
        companyCity = (String) values.get(7);
        companyStreet = (String) values.get(8);
        companyStreetNumber = Integer.parseInt((values.get(9).toString()));
        addReceipt();
        values.clear();
    }
}
