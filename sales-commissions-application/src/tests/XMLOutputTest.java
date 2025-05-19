package tests;

import org.junit.Test;

import input.XMLInput;
import output.XMLOutput;

import static org.junit.Assert.assertEquals;

import java.io.File;

public class XMLOutputTest {

    private static final String TEST_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testInputFile.xml";
    private static final String REPORT_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testReportFile.xml";

    private XMLOutput xmlOutput;
    private XMLInput xmlInput;



    @Test
    public void testXMLOutput() {
    	File path = new File(TEST_FILE_PATH);
    	xmlInput = new XMLInput(path);
    	xmlInput.parseInputFile();
    	xmlOutput = new XMLOutput(xmlInput.getAgent()); 
        xmlOutput.writeToFile(REPORT_FILE_PATH);
                
        
        assertEquals("George Papas", xmlOutput.getAgent().getName());
        assertEquals("123456789", xmlOutput.getAgent().getAfm());
        
        double epsilon = 0.000001d;
        assertEquals(76.0, xmlOutput.getAgent().calculateTotalSales(), epsilon);
        assertEquals(0.0, xmlOutput.getAgent().calculateClothesSales("Trousers"), epsilon);
        assertEquals(0.0, xmlOutput.getAgent().calculateClothesSales("Skirts"), epsilon);
        assertEquals(0.0, xmlOutput.getAgent().calculateClothesSales("Shirts"), epsilon);
        assertEquals(5.0, xmlOutput.getAgent().calculateClothesSales("Coats"), epsilon);
        assertEquals(0.0, xmlOutput.getAgent().calculateCommission(), epsilon);
    }
}