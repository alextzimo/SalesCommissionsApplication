package tests;

import org.junit.Test;

import input.TXTInput;
import output.TXTOutput;


import static org.junit.Assert.assertEquals;

import java.io.File;

public class TXTOutputTest {

    private static final String TEST_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testInputFile.txt";
    private static final String REPORT_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testReportFile.txt";

    private TXTOutput txtOutput;
    private TXTInput txtInput;



    @Test
    public void testTXTInput() {
    	File path = new File(TEST_FILE_PATH);
    	txtInput = new TXTInput(path);
    	txtOutput = new TXTOutput(txtInput.getAgent()); 
    	txtInput.parseInputFile();
        txtOutput.writeToFile(REPORT_FILE_PATH);
                
        
        assertEquals("George Papas", txtOutput.getAgent().getName());
        assertEquals("123456789", txtOutput.getAgent().getAfm());

        double epsilon = 0.000001d;
        assertEquals(76.0, txtOutput.getAgent().calculateTotalSales(), epsilon);
        assertEquals(0.0, txtOutput.getAgent().calculateClothesSales("Trousers"), epsilon);
        assertEquals(0.0, txtOutput.getAgent().calculateClothesSales("Skirts"), epsilon);
        assertEquals(0.0, txtOutput.getAgent().calculateClothesSales("Shirts"), epsilon);
        assertEquals(5.0, txtOutput.getAgent().calculateClothesSales("Coats"), epsilon);
        assertEquals(0.0, txtOutput.getAgent().calculateCommission(), epsilon);
    }
}