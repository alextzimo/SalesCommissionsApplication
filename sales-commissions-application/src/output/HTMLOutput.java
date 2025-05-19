package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import data.SalesCalculator;

public class HTMLOutput extends Output{

	public HTMLOutput(SalesCalculator a) {
		agent = a;
	}

	@Override
	public void writeToFile(String fullPathName) {
        try {
            Document document = new Document(fullPathName);
            
            Element agentElem = document.appendElement("Agent");

            agentElem.appendElement("Name").text(agent.getName());
            agentElem.appendElement("AFM").text(agent.getAfm());
            agentElem.appendElement("TotalSales").text(Double.toString(agent.calculateTotalSales()));
            agentElem.appendElement("TrouserSales").text(Float.toString(agent.calculateClothesSales("Trousers")));
            agentElem.appendElement("SkirtsSales").text(Float.toString(agent.calculateClothesSales("Skirts")));
            agentElem.appendElement("ShirtsSales").text(Float.toString(agent.calculateClothesSales("Shirts")));
            agentElem.appendElement("CoatsSales").text(Float.toString(agent.calculateClothesSales("Coats")));
            agentElem.appendElement("Commission").text(Double.toString(agent.calculateCommission()));

            try (FileWriter fileWriter = new FileWriter(new File(fullPathName))) {
                fileWriter.write(document.outerHtml());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}