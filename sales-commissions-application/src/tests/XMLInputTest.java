package tests;

import org.junit.Before;
import org.junit.Test;

import input.XMLInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class XMLInputTest {

    private static final String TEST_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testInputFile.xml";

    private XMLInput xmlInput;
    private File path;

    @Before
    public void setUp() {
        createTestInputFile();
    }

    @Test
    public void testXMLInput() {
        path = new File(TEST_FILE_PATH);
        xmlInput = new XMLInput(path);
        xmlInput.parseInputFile();

        assertEquals("George Papas", xmlInput.getAgent().getName());
        assertEquals("123456789", xmlInput.getAgent().getAfm());
        assertEquals(1, xmlInput.getAgent().getReceipts().get(0).getReceiptID());
        assertEquals("21/12/2023", xmlInput.getAgent().getReceipts().get(0).getDate());
        assertEquals("Coats", xmlInput.getAgent().getReceipts().get(0).getKind());
        double epsilon = 0.000001d;
        assertEquals(76.0, xmlInput.getAgent().getReceipts().get(0).getSales(), epsilon);
        assertEquals(5, xmlInput.getAgent().getReceipts().get(0).getItems());
        assertEquals("Nike", xmlInput.getAgent().getReceipts().get(0).getCompany().getName());
        assertEquals("Greece", xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCountry());
        assertEquals("Ioannina", xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCity());
        assertEquals("Zerva", xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreet());
        assertEquals(10, xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreetNumber());
    }

    private void createTestInputFile() {
        try (FileWriter writer = new FileWriter(TEST_FILE_PATH)) {
            writer.write("<Agent>\n");
            writer.write("  <Name>George Papas</Name>\n");
            writer.write("  <AFM>123456789</AFM>\n");
            writer.write("  <Receipts>\n");
            writer.write("  <Receipt>\n");
            writer.write("    <ReceiptID>"+1+"</ReceiptID>\n");
            writer.write("    <Date>21/12/2023</Date>\n");
            writer.write("    <Kind>Coats</Kind>\n");
            writer.write("    <Sales>"+76.0+"</Sales>\n");
            writer.write("    <Items>"+5+"</Items>\n");
            writer.write("    <Company> Nike </Company>\n");
            writer.write("    <Country>Greece</Country>\n");
            writer.write("    <City>Ioannina</City>\n");
            writer.write("    <Street>Zerva</Street>\n");
            writer.write("    <Number>"+10+"</Number>\n");
            writer.write("  </Receipt>\n");
            writer.write("  </Receipts>\n");
            writer.write("</Agent>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}