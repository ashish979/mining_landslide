package dm;

import dm.predict;
import dm.predict2;
import java.awt.*; 
import java.awt.event.*;
import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; 
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class testdataimport extends JFrame { 
	static JTable table; 
        JTable training;
	static JScrollPane scroll; 
	// header is Vector contains table Column 
	static Vector headers = new Vector(); 
	 static Vector data = new Vector();
	// Model is used to construct 
	DefaultTableModel model = null; 
	// data is Vector contains Data from Excel File static Vector data = new Vector();
	static JButton jbClick; 
	static JFileChooser jChooser; 
	static int tableWidth = 0; 
	// set the tableWidth 
	static int tableHeight = 0; 
	// set the tableHeight 
	public testdataimport() 
	{ 
		super("Import Excel To JTable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setBackground(Color.white); 
		jChooser = new JFileChooser(); 
		jbClick = new JButton("Select Excel File"); 
		buttonPanel.add(jbClick, BorderLayout.CENTER); 
		
		// Show Button Click Event 
		jbClick.addActionListener(new ActionListener() 
		{ 
			@Override public void actionPerformed(ActionEvent arg0) 
			{ 
			jChooser.showOpenDialog(null); 
			jChooser.setDialogTitle("Select only Excel workbooks");
			File file = jChooser.getSelectedFile();			
			 
			if(file==null)
				{
					JOptionPane.showMessageDialog(null, "Please select any Excel file.", "Help",JOptionPane.INFORMATION_MESSAGE); 
					return;
				}
			else if(!file.getName().endsWith("xls"))
				{ 
				JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error",JOptionPane.ERROR_MESSAGE); 
				}
			else 
				{ 
					fillData(file);
					model = new DefaultTableModel(data, headers); 
					tableWidth = model.getColumnCount() * 150; 
					tableHeight = model.getRowCount() * 25; 
					table.setPreferredSize(new Dimension( tableWidth, tableHeight)); table.setModel(model); 
				} 
			} 
		}
		);
		table = new JTable(); 
		table.setAutoCreateRowSorter(true); 
		model = new DefaultTableModel(data, headers);
		table.setModel(model); 
		table.setBackground(Color.white);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		table.setEnabled(false); 
		table.setRowHeight(25); 
		table.setRowMargin(4); 
		tableWidth = model.getColumnCount() * 150; 
		tableHeight = model.getRowCount() * 25;
		table.setPreferredSize(new Dimension( tableWidth, tableHeight)); 
		scroll = new JScrollPane(table); scroll.setBackground(Color.white);
		scroll.setPreferredSize(new Dimension(300, 300)); 
		scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		getContentPane().add(buttonPanel, BorderLayout.NORTH); 
		getContentPane().add(scroll, BorderLayout.CENTER); 
		setSize(600, 600); 
		setResizable(true); setVisible(true); 
	} 
        public testdataimport(JTable training) 
	{ 
		super("Test Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setBackground(Color.white); 
		jChooser = new JFileChooser(); 
		jbClick = new JButton("Select Test Data"); 
		buttonPanel.add(jbClick, BorderLayout.CENTER); 
		
		// Show Button Click Event 
		jbClick.addActionListener(new ActionListener() 
		{ 
			@Override public void actionPerformed(ActionEvent arg0) 
			{ 
			jChooser.showOpenDialog(null); 
			jChooser.setDialogTitle("Select only Excel workbooks");
			File file = jChooser.getSelectedFile();			
			 
			if(file==null)
				{
					JOptionPane.showMessageDialog(null, "Please select any Excel file.", "Help",JOptionPane.INFORMATION_MESSAGE); 
					return;
				}
			else if(!file.getName().endsWith("xls"))
				{ 
				JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error",JOptionPane.ERROR_MESSAGE); 
				}
			else 
				{ 
					fillData(file);
					model = new DefaultTableModel(data, headers); 
					tableWidth = model.getColumnCount() * 150; 
					tableHeight = model.getRowCount() * 25; 
					table.setPreferredSize(new Dimension( tableWidth, tableHeight)); table.setModel(model); 
				} 
			} 
		}
		);
		table = new JTable(); 
		table.setAutoCreateRowSorter(true); 
		model = new DefaultTableModel(data, headers);
		table.setModel(model); 
		table.setBackground(Color.white);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		table.setEnabled(false); 
		table.setRowHeight(25); 
		table.setRowMargin(4); 
		tableWidth = model.getColumnCount() * 150; 
		tableHeight = model.getRowCount() * 25;
		table.setPreferredSize(new Dimension( tableWidth, tableHeight)); 
		scroll = new JScrollPane(table); scroll.setBackground(Color.white);
		scroll.setPreferredSize(new Dimension(300, 300)); 
		scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		getContentPane().add(buttonPanel, BorderLayout.NORTH); 
		getContentPane().add(scroll, BorderLayout.CENTER); 
		setSize(600, 600); 
                this.training=training;
		setResizable(true); setVisible(true); 
	} 
	/** * Fill JTable with Excel file data. * * @param file * file :contains xls file to display in jTable */ 
	void fillData(File file) 
	{ 
		int index=-1;
		HSSFWorkbook workbook = null; 
		try { 
		     try { 
			       FileInputStream inputStream = new FileInputStream (file);
			       workbook = new HSSFWorkbook(inputStream);
			     } 
		     catch (IOException ex) 
		        { 
		    	 	Logger.getLogger(testdataimport.class. getName()).log(Level.SEVERE, null, ex);
		        } 
		      
		     String[] strs=new String[workbook.getNumberOfSheets()];
		     //get all sheet names from selected workbook
		     for (int i = 0; i < strs.length; i++)
		     {  		    	
	             strs[i]= workbook.getSheetName(i);
	                
	         }  
		     
		     JFrame frame = new JFrame("Input Dialog");
		     String selectedsheet = (String) JOptionPane.showInputDialog(frame, "Which worksheet you want to import ?", "Select Worksheet",
		         JOptionPane.QUESTION_MESSAGE, 
		         null, 
		         strs, 
		         strs[0]);
		     
		     
		     if (selectedsheet!=null)
		     {
		    	 for (int i = 0; i < strs.length; i++)
		    	 {  		    	
		    		 if (workbook.getSheetName(i).equalsIgnoreCase(selectedsheet))
		    			 index=i;
	                
		    	 }  
		     
		    	 HSSFSheet sheet = workbook.getSheetAt(index);
		    	 HSSFRow row=sheet.getRow(0);
		    	 headers.clear(); 
		    	 for (int i = 0; i < row.getLastCellNum(); i++) 
		    	 	{ 
		    		 	HSSFCell cell1 = row.getCell(i); 
		    		 	headers.add(cell1.toString());
		    	 	} 
		    	 data.clear(); 
		    	 for (int j = 1; j < sheet.getLastRowNum() + 1; j++) 
		    	 { 
		    		 Vector d = new Vector(); 
		    		 row=sheet.getRow(j);
		    		 int noofrows=row.getLastCellNum();
		    		 for (int i = 0; i < noofrows; i++) 
		    		 {		    			 
			    		 //To handle empty excel cells
		    			 HSSFCell cell=row.getCell(i, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK );		    			 
		    			 //System.out.println (cell.getCellType());		    			 
		    			 d.add(cell.toString()); 
		    		 		    		 
		    		 } 
		    		 d.add("\n"); 
		    		 data.add(d); 
		    	 } 
		     }
		     else
		     {		    	 
		    	 return;
		     }
		} 
		catch (Exception e) 
		{ 
		e.printStackTrace(); 
		} 
               predict2 p=new predict2(training,table);
               p.setVisible(true);
	} 
	public static void main(String[] args) {
		new testdataimport(); 
                             
		} 

}