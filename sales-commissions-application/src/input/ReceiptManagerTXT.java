package input;

import java.io.FileWriter;
import java.io.IOException;



public class ReceiptManagerTXT extends ReceiptManager {



	
	
	@Override
	protected void updateFile() throws IOException, Exception {
		System.out.println("Mpike sto TXT");
		System.out.println(fileToAppend.getAbsolutePath());

		try {
			
			
			
			FileWriter fileWriter = new FileWriter(fileToAppend,true);		
			fileWriter.write("\n");
			fileWriter.write("Receipt ID: ");
			fileWriter.write(String.valueOf(receipt.getReceiptID()));
			fileWriter.write("\n");

			fileWriter.write("Date: ");
			fileWriter.write(receipt.getDate());
			fileWriter.write("\n");

			fileWriter.write("Kind: ");
			fileWriter.write(receipt.getKind());
			fileWriter.write("\n");

			fileWriter.write("Sales: ");
			fileWriter.write(String.valueOf(receipt.getSales()));
			fileWriter.write("\n");

			fileWriter.write("Items: ");
			fileWriter.write(String.valueOf(receipt.getItems()));
			fileWriter.write("\n");

			fileWriter.write("Company: ");
			fileWriter.write(String.valueOf(receipt.getCompany().getName()));
			fileWriter.write("\n");


			fileWriter.write("Country: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getCountry());
			fileWriter.write("\n");
			
			fileWriter.write("City: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getCity());
			fileWriter.write("\n");

			fileWriter.write("Street: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getStreet());
			fileWriter.write("\n");

			fileWriter.write("Number: ");
			fileWriter.write(String.valueOf(receipt.getCompany().getCompanyAddress().getStreetNumber()));
			fileWriter.write("\n");

			fileWriter.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}