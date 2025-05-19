package tests;

import org.junit.Test;

import input.HTMLInput;
import output.HTMLOutput;

import static org.junit.Assert.assertEquals;

import java.io.File;

public class HTMLOutputTest {

    private static final String TEST_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testInputFile.html";
    private static final String REPORT_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testReportFile.html";

    private HTMLOutput htmlOutput;
    private HTMLInput htmlInput;



    @Test
    public void testXMLOutput() {
    	File path = new File(TEST_FILE_PATH);
    	htmlInput = new HTMLInput(path);
    	htmlInput.parseInputFile();
    	htmlOutput = new HTMLOutput(htmlInput.getAgent()); 
        htmlOutput.writeToFile(REPORT_FILE_PATH);
                
        
        assertEquals("George Papas", htmlOutput.getAgent().getName());
        assertEquals("123456789", htmlOutput.getAgent().getAfm());
        
        double epsilon = 0.000001d;
        assertEquals(76.0, htmlOutput.getAgent().calculateTotalSales(), epsilon);
        assertEquals(0.0, htmlOutput.getAgent().calculateClothesSales("Trousers"), epsilon);
        assertEquals(0.0, htmlOutput.getAgent().calculateClothesSales("Skirts"), epsilon);
        assertEquals(0.0, htmlOutput.getAgent().calculateClothesSales("Shirts"), epsilon);
        assertEquals(5.0, htmlOutput.getAgent().calculateClothesSales("Coats"), epsilon);
        assertEquals(0.0, htmlOutput.getAgent().calculateCommission(), epsilon);
    }
}