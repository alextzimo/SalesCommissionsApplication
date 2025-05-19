package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.SalesCalculator;

public class XMLOutput extends Output{
	
	public XMLOutput(SalesCalculator a) {
		agent = a;
	}

	@Override
	public void writeToFile(String fullPathName) {
        try {
        	 DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        	 DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        	 Document document = documentBuilder.newDocument();
        	 
        	 Element agentElem = document.createElement("Agent");
        	 document.appendChild(agentElem);
        	 
        	 
        	 Element name = document.createElement("Name");
        	 name.appendChild(document.createTextNode(agent.getName()));
        	 agentElem.appendChild(name);
        	 
        	 Element afm = document.createElement("AFM");
        	 afm.appendChild(document.createTextNode(agent.getAfm()));	
        	 agentElem.appendChild(afm);
        	 
        	 Element totalSales = document.createElement("TotalSales");
        	 totalSales.appendChild(document.createTextNode(Double.toString(agent.calculateTotalSales())));
        	 agentElem.appendChild(totalSales);
        	 
        	 Element trouserSales = document.createElement("TrouserSales");
        	 trouserSales.appendChild(document.createTextNode(Float.toString(agent.calculateClothesSales("Trousers"))));
        	 agentElem.appendChild(trouserSales);
        	 
        	 Element skirtsSales = document.createElement("SkirtsSales");
        	 skirtsSales.appendChild(document.createTextNode(Float.toString(agent.calculateClothesSales("Skirts"))));
        	 agentElem.appendChild(skirtsSales);
        	 
        	 Element shirtsSales = document.createElement("ShirtsSales");
        	 shirtsSales.appendChild(document.createTextNode(Float.toString(agent.calculateClothesSales("Shirts"))));
        	 agentElem.appendChild(shirtsSales);
        	 
        	 Element coatsSales = document.createElement("CoatsSales");
        	 coatsSales.appendChild(document.createTextNode(Float.toString(agent.calculateClothesSales("Coats"))));
        	 agentElem.appendChild(coatsSales);
        	 
        	 Element commission = document.createElement("Commission");
        	 commission.appendChild(document.createTextNode(Double.toString(agent.calculateCommission())));
        	 agentElem.appendChild(commission);
        
        	 
        	 
        	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	 Transformer transformer = transformerFactory.newTransformer();
        	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        	 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        	 DOMSource domSource = new DOMSource(document);
        	 StreamResult streamResult = new StreamResult(new File(outputFilePath));
        	 transformer.transform(domSource, streamResult);
      
    		
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    		
	}

}

