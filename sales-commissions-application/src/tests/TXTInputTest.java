package tests;

import org.junit.Before;
import org.junit.Test;

import input.TXTInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TXTInputTest {

    private static final String TEST_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testInputFile.txt";

    private TXTInput txtInput;
    private File path;

    @Before
    public void setUp() {
        createTestInputFile(); 
    }

    @Test
    public void testTXTInput() {
    	
    	path = new File(TEST_FILE_PATH);
    	
    	txtInput = new TXTInput(path); 
    	
        txtInput.parseInputFile();
                
        
        assertEquals("George Papas", txtInput.getAgent().getName());
        assertEquals("123456789", txtInput.getAgent().getAfm());
        assertEquals(1, txtInput.getAgent().getReceipts().get(0).getReceiptID());
        assertEquals("21/12/2023", txtInput.getAgent().getReceipts().get(0).getDate());
        assertEquals("Coats", txtInput.getAgent().getReceipts().get(0).getKind());
        double epsilon = 0.000001d;
        assertEquals(76.0, txtInput.getAgent().getReceipts().get(0).getSales(), epsilon);
        assertEquals(5, txtInput.getAgent().getReceipts().get(0).getItems());
        assertEquals("Nike", txtInput.getAgent().getReceipts().get(0).getCompany().getName());
        assertEquals("Greece", txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCountry());
        assertEquals("Ioannina", txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCity());
        assertEquals("Zerva", txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreet());
        assertEquals(10, txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreetNumber());
        
    }

    private void createTestInputFile() {
        try (FileWriter writer = new FileWriter(TEST_FILE_PATH)) {
            writer.write("Name: George Papas\n");
            writer.write("AFM: "+123456789+"\n");
            //writer.write("Receipts:");
            writer.write("Receipt ID: "+1+"\n");
            writer.write("Date: 21/12/2023\n");
            writer.write("Kind: Coats\n");
            writer.write("Sales: "+76.0+"\n");
            writer.write("Items: "+5+"\n");
            writer.write("Company: Nike\n");
            writer.write("Country: Greece\n");
            writer.write("City: Ioannina\n");
            writer.write("Street: Zerva\n");
            writer.write("Number: "+10+"\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}