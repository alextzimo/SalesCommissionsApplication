package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.SalesCalculator;


public class TXTOutput extends Output{

	public TXTOutput(SalesCalculator a) {
		agent = a;
	}
	
	@Override
	public void writeToFile(String fullPathName) {
        BufferedWriter bufferedWriter = null;
        try{
        	bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
            
        	bufferedWriter.write("Name: " + agent.getName()); 
            bufferedWriter.newLine();

            bufferedWriter.write("AFM: " + agent.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            
            bufferedWriter.write("Total Sales: " + agent.calculateTotalSales());
            bufferedWriter.newLine();
 
            bufferedWriter.write("Trousers Sales: " + agent.calculateClothesSales("Trousers"));
            bufferedWriter.newLine();

            bufferedWriter.write("Skirts Sales: " + agent.calculateClothesSales("Skirts"));
            bufferedWriter.newLine();

            bufferedWriter.write("Shirts Sales: " + agent.calculateClothesSales("Shirts"));
            bufferedWriter.newLine();
            
            bufferedWriter.write("Coats Sales: " + agent.calculateClothesSales("Coats"));
            bufferedWriter.newLine();

            bufferedWriter.write("Commission: " + agent.calculateCommission());
            
        	bufferedWriter.close();


        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"������ ������ �������� ���� ��� ���������� ��� �������");

        }
		
	}

}
