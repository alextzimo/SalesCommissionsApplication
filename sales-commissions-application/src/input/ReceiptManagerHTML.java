package input;

import java.io.IOException;
import java.nio.file.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ReceiptManagerHTML extends ReceiptManager {

    @Override
    protected void updateFile() throws IOException, Exception {
        try {
            Document doc = Jsoup.parse(fileToAppend, "UTF-8");

            Element body = doc.body();
            Element receiptElem = new Element("Receipt");
            
            receiptElem.appendElement("ReceiptID").text(String.valueOf(receipt.getReceiptID()));
            receiptElem.appendElement("Date").text(receipt.getDate());
            receiptElem.appendElement("Kind").text(receipt.getKind());
            receiptElem.appendElement("Sales").text(String.valueOf(receipt.getSales()));
            receiptElem.appendElement("Items").text(String.valueOf(receipt.getItems()));
            receiptElem.appendElement("Company").text(String.valueOf(receipt.getCompany().getName()));
            receiptElem.appendElement("Country").text(receipt.getCompany().getCompanyAddress().getCountry());
            receiptElem.appendElement("City").text(receipt.getCompany().getCompanyAddress().getCity());
            receiptElem.appendElement("Street").text(receipt.getCompany().getCompanyAddress().getStreet());
            receiptElem.appendElement("Number").text(String.valueOf(receipt.getCompany().getCompanyAddress().getStreetNumber()));

            body.appendChild(receiptElem);
            
            String htmlString = doc.outerHtml();
            Files.write(Paths.get(fileToAppend.toURI()), htmlString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}