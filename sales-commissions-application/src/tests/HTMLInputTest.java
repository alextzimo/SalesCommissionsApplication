package tests;

import org.junit.Before;
import org.junit.Test;

import input.HTMLInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HTMLInputTest {

    private static final String TEST_FILE_PATH = "/Users/alextzimo/cs/SoftEngII/soft-devII-2024-project-material/test_input_files/testInputFile.html";

    private HTMLInput htmlInput;
    private File path;

    @Before
    public void setUp() {
        createTestInputFile();
    }

    @Test
    public void testXMLInput() {
        path = new File(TEST_FILE_PATH);
        htmlInput = new HTMLInput(path);
        htmlInput.parseInputFile();

        assertEquals("George Papas", htmlInput.getAgent().getName());
        assertEquals("123456789", htmlInput.getAgent().getAfm());
        assertEquals(1, htmlInput.getAgent().getReceipts().get(0).getReceiptID());
        assertEquals("21/12/2023", htmlInput.getAgent().getReceipts().get(0).getDate());
        assertEquals("Coats", htmlInput.getAgent().getReceipts().get(0).getKind());
        double epsilon = 0.000001d;
        assertEquals(76.0, htmlInput.getAgent().getReceipts().get(0).getSales(), epsilon);
        assertEquals(5, htmlInput.getAgent().getReceipts().get(0).getItems());
        assertEquals("Nike", htmlInput.getAgent().getReceipts().get(0).getCompany().getName());
        assertEquals("Greece", htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCountry());
        assertEquals("Ioannina", htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCity());
        assertEquals("Zerva", htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreet());
        assertEquals(10, htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreetNumber());
    }

    private void createTestInputFile() {
        try (FileWriter writer = new FileWriter(TEST_FILE_PATH)) {
        	writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write(" <head>\n");
            writer.write("  <title>Receipt Data</title>\n");
            writer.write(" </head>\n");
            writer.write(" <body>\n");
            writer.write("  <div id=\"Agent\">\n");
            writer.write("   <name>\n");
            writer.write("    George Papas\n");
            writer.write("   </name> <afm>\n");
            writer.write("    123456789\n");
            writer.write("   </afm> <receipts>\n");
            writer.write("    <receipt>\n");
            writer.write("     <receiptid>\n");
            writer.write("      "+1+"\n");
            writer.write("     </receiptid>\n");
            writer.write("     <date>\n");
            writer.write("      21/12/2023\n");
            writer.write("     </date>\n");
            writer.write("     <kind>\n");
            writer.write("      Coats\n");
            writer.write("     </kind>\n");
            writer.write("     <sales>\n");
            writer.write("      "+76.0+"\n");
            writer.write("     </sales>\n");
            writer.write("     <items>\n");
            writer.write("      "+5+"\n");
            writer.write("     </items>\n");
            writer.write("     <company>\n");
            writer.write("      Nike\n");
            writer.write("     </company>\n");
            writer.write("     <country>\n");
            writer.write("      Greece\n");
            writer.write("     </country>\n");
            writer.write("     <city>\n");
            writer.write("      Ioannina\n");
            writer.write("     </city>\n");
            writer.write("     <street>\n");
            writer.write("      Zerva\n");
            writer.write("     </street>\n");
            writer.write("     <number>\n");
            writer.write("      10\n");
            writer.write("     </number>\n");
            writer.write("    </receipt>\n");

            writer.write("   </receipts>\n");
            writer.write("  </div>\n");
            writer.write(" </body>\n");
            writer.write("</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}