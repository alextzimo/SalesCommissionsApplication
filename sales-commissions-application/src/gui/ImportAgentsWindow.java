package gui;
import input.HTMLInput;
import input.TXTInput;
import input.XMLInput;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Vector;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.LayoutStyle.ComponentPlacement;

import data.SalesCalculator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImportAgentsWindow extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel inputWindowPanel = new JPanel();
	private DefaultListModel <String> listModel = new DefaultListModel <String>();
	private JList <String> agentsList = new JList <String>();
	private Vector <SalesCalculator> allAgents;
	private  SalesCalculator agent = new SalesCalculator();
	private SalesCalculator selectedAgent = null;
	static ImportAgentsWindow dialog = new ImportAgentsWindow();
	@SuppressWarnings("unused")
	public File inputFile;
	private String fileTypeFlag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
			for (int i = 0; i < installedLookAndFeels.length; i++) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ImportAgentsWindow(){
		
		initialise();
	}
	
	public void initialise() {
		allAgents = new Vector <SalesCalculator>();
		
		setBackground(new Color(0, 0, 0));
		setBounds(100, 100, 736, 472);
		getContentPane().setLayout(new BorderLayout());
		inputWindowPanel.setBackground(SystemColor.controlHighlight);
		inputWindowPanel.setBorder(null);
		getContentPane().add(inputWindowPanel, BorderLayout.CENTER);
		
				
				JButton buttonTXTInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC TXT");
				buttonTXTInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				buttonTXTInput.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				buttonTXTInput.setFocusPainted(false);
				
				JButton buttonXMLInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC XML");
				buttonXMLInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				buttonXMLInput.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				buttonXMLInput.setFocusPainted(false);
				
				JButton buttonHTMLInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC HTML");
				buttonHTMLInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt3) {
						insertFromHTML(evt3);
					}
				});
				buttonHTMLInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				buttonHTMLInput.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				buttonHTMLInput.setFocusPainted(false);
				
				JLabel label = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03B5\u03AF\u03B4\u03BF\u03C2 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF\u03C5 \u03B3\u03B9\u03B1 \u03C6\u03CC\u03C1\u03C4\u03C9\u03C3\u03B7 \u03B1\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03C9\u03BD:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				agentsList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						selectAgent(e);
					}
				});
				
				agentsList.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				agentsList.setBackground(UIManager.getColor("Button.light"));
				agentsList.setBorder(new LineBorder(new Color(0, 0, 0)));
				
				
				JLabel label_1 = new JLabel("\u039B\u03B9\u03C3\u03C4\u03B1 \u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03BF\u03C3\u03CE\u03C0\u03C9\u03BD");
				label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				JButton button = new JButton("OK");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						okButtonPressed(evt);						
					}

				
				});
				button.setToolTipText("");
				button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				button.setBackground(UIManager.getColor("Button.shadow"));
				
				JButton button_1 = new JButton("Cancel");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonPressed(e);
					}
				});
				button_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				button_1.setBackground(UIManager.getColor("Button.shadow"));
				
				
				GroupLayout gl_inputWindowPanel = new GroupLayout(inputWindowPanel);
				gl_inputWindowPanel.setHorizontalGroup(
					gl_inputWindowPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addContainerGap(451, Short.MAX_VALUE)
							.addComponent(label_1)
							.addGap(143))
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addGap(258)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addComponent(label)
								.addComponent(buttonTXTInput, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
								.addComponent(buttonXMLInput, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
								.addComponent(buttonHTMLInput, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(agentsList, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addGap(73))
				);
				gl_inputWindowPanel.setVerticalGroup(
					gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(label)
							.addGap(11)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addComponent(buttonTXTInput, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(buttonXMLInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addComponent(agentsList, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(buttonHTMLInput, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(80)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(32, Short.MAX_VALUE))
				);
				inputWindowPanel.setLayout(gl_inputWindowPanel);
				buttonTXTInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						insertFromTXT(evt);
					}
				});
				
				buttonXMLInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertFromXML(e);
					}
				});
	}
	
	
	private void cancelButtonPressed(ActionEvent e) {
		System.exit(0);	
	}

	private void insertFromTXT(ActionEvent evt){
		
		JFileChooser TXTFileChooser;
		TXTFileChooser = new JFileChooser();     
		TXTFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);		       
		TXTFileChooser.showOpenDialog(null);
		boolean agentDuplicate = false;
		try{
			File recieptFileTXT = TXTFileChooser.getSelectedFile();
			TXTInput inputFileTXT = new TXTInput(recieptFileTXT);	
			inputFileTXT.parseInputFile();
			agent = inputFileTXT.getAgent();
			agent.setFileType("TXT");
			agent.getFileAppender().setFileToAppend(recieptFileTXT);				
			allAgents.add(agent);
			for(int i = 0; i< listModel.getSize(); i++){
				if(agent.getName().equals(listModel.getElementAt(i))){
					agentDuplicate = true;

				}
			}
			if(agentDuplicate == true){
				JOptionPane.showMessageDialog(null,"� ������������ ������� ��� ��� �����");

			}
			else{
				listModel.addElement(agent.getName());
				agentsList.setModel(listModel);
				fileTypeFlag = "TXT";
			}
			
		}catch (NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"��� ���������� ������ ������");

		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null,"�������� ������ �������� ���� ��� �������� ��� �������");
		}
		
	}
	
	private void insertFromXML(ActionEvent evt2){
		JFileChooser XMLFileChooser;
		XMLFileChooser = new JFileChooser();     
		XMLFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);		       
		XMLFileChooser.showOpenDialog(null);
		boolean agentDuplicate = false;
		try{
			File recieptFileXML = XMLFileChooser.getSelectedFile();
			XMLInput inputFileXML = new XMLInput(recieptFileXML);	
			inputFileXML.parseInputFile();
			agent = inputFileXML.getAgent();
			agent.setFileType("XML");
			agent.getFileAppender().setFileToAppend(recieptFileXML);				
			allAgents.add(agent);
			for(int i = 0; i< listModel.getSize(); i++){
				if(agent.getName().equals(listModel.getElementAt(i))){
					agentDuplicate = true;

				}
			}
			if(agentDuplicate == true){
				JOptionPane.showMessageDialog(null,"� ������������ ������� ��� ��� �����");

			}
			else{
				listModel.addElement(agent.getName());
				agentsList.setModel(listModel);
				fileTypeFlag = "XML";
			}
		}catch (IllegalArgumentException e){
		
			JOptionPane.showMessageDialog(null,"��� ���������� ������ ������");

		}
        
             
	}
	
	private void insertFromHTML(ActionEvent evt3) {
		JFileChooser HTMLFileChooser = new JFileChooser();
	    HTMLFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);

	    HTMLFileChooser.showOpenDialog(null);

	    boolean agentDuplicate = false;

	    try {		
	    	

	        File receiptFileHTML = HTMLFileChooser.getSelectedFile();
	        HTMLInput inputFileHTML = new HTMLInput(receiptFileHTML);
	        inputFileHTML.parseInputFile();
	        agent = inputFileHTML.getAgent();
	        agent.setFileType("HTML");
	        agent.getFileAppender().setFileToAppend(receiptFileHTML);
	        allAgents.add(agent);
	        for (int i = 0; i < listModel.getSize(); i++) {
	            if (agent.getName().equals(listModel.getElementAt(i))) {
	                agentDuplicate = true;
	            }
	        }

	        if (agentDuplicate == true) {
	            JOptionPane.showMessageDialog(null, "Duplicate agent");
	        } else {
	        	System.out.println(agent.getName());
	            listModel.addElement(agent.getName());
	            agentsList.setModel(listModel);
	            fileTypeFlag = "HTML";
	        }
	    } catch (IllegalArgumentException e) {
	        JOptionPane.showMessageDialog(null, "Error reading HTML file");
	    }
	}
	
	
	private void selectAgent(MouseEvent e){
		
		String agentName;
        if(agentsList.getSelectedIndex()>=0){
        	
            agentName = agentsList.getSelectedValue().toString();
            for(int i=0; i<allAgents.size(); i++){
                if(agentName.equals(allAgents.get(i).getName())){
                	
                		selectedAgent = allAgents.get(i);
                		break;
                		
                }
            }
        	
        }
	}
	
	private void okButtonPressed(ActionEvent evt) {
		if(agentsList.isSelectionEmpty()){
			JOptionPane.showMessageDialog(null,"��� ����� �������� �����������");

		}
		else{
			SalesFilterWindow sw = new SalesFilterWindow(dialog,selectedAgent,fileTypeFlag);
			this.setVisible(false);
			sw.setVisible(true);
		}	
	}	
}
