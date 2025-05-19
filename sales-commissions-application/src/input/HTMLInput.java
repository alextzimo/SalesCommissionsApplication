package input;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLInput extends Input {

    public HTMLInput(File receiptFileHTML) {
        inputFile = receiptFileHTML;
    }

    @Override
    public void parseInputFile() {
        try {
            Document doc = Jsoup.parse(inputFile);

            Element agentElement = doc.select("div#Agent").first();
            
            if (agentElement != null) {
            	name = agentElement.select("Name").text().trim();
	            afm = agentElement.select("AFM").text().trim();
	            addAgent();
	            Elements receiptsElements = agentElement.select("Receipt");
	            for (Element receiptElement : receiptsElements) {
	                receiptID = Integer.parseInt(receiptElement.select("ReceiptID").text().trim());
	                date = receiptElement.select("Date").text().trim();
	                kind = receiptElement.select("Kind").text().trim();
	                sales = Double.parseDouble(receiptElement.select("Sales").text().trim());
	                items = Integer.parseInt(receiptElement.select("Items").text().trim());
	                companyName = receiptElement.select("Company").text().trim();
	                companyCountry = receiptElement.select("Country").text().trim();
	                companyCity = receiptElement.select("City").text().trim();
	                companyStreet = receiptElement.select("Street").text().trim();
	                companyStreetNumber = Integer.parseInt(receiptElement.select("Number").text().trim());
	
	                addReceipt();
	            }
            }
            
            

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading HTML file");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error parsing numbers");
        }
    }
}