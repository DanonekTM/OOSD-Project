package danonek;

import java.sql.ResultSet;
import java.util.logging.Level;

import danonek.Database.DatabaseController;
import danonek.Interface.CustomerAddFrame;
import danonek.Interface.CustomerViewFrame;
import danonek.Interface.MainFrame;

public class Program 
{
	void run()
	{
		MainFrame mainFrame = new MainFrame();
		DatabaseController db = new DatabaseController();
		
		db.addCustomer("TEST1 NAME", "TEST1 SURNAME", "TEST1 ADD", 1);
		db.addCustomer("TEST2 NAME", "TEST2 SURNAME", "TEST2 ADD", 2);
		
		// Lambda listeners for each button
		mainFrame.getAddCustomerBtn().addActionListener(e ->
		{
			CustomerAddFrame caf = new CustomerAddFrame();
			
			// Get Text & Insert To DB on click
			caf.getBtnAddCustomer().addActionListener(a ->
			{
				String customerName = caf.getTextFieldCustomerName().getText();
				String customerSurname = caf.getTextFieldCustomerSurname().getText();
				String customerAddress = caf.getTextFieldCustomerAddress().getText();
				int customerPhone = Integer.parseInt(caf.getTextFieldCustomerPhone().getText());
				
				System.out.println(customerName);
				System.out.println(customerSurname);
				System.out.println(customerAddress);
				System.out.println(customerPhone);
			});

		});
		
		mainFrame.getAddInvoiceBtn().addActionListener(e ->
		{

		});

		
		mainFrame.getAddProductBtn().addActionListener(e ->
		{
			
		});

		mainFrame.getViewCustomerBtn().addActionListener(event -> 
		{
			CustomerViewFrame cvf = new CustomerViewFrame();
			
			try 
			{
				ResultSet rs = db.getAllFromCustomer();
				while(rs.next())
				{
					cvf.getTableModel().addRow(new Object[]{rs.getString(Config.CUSTOMER_ID), rs.getString(Config.CUSTOMER_NAME), rs.getString(Config.CUSTOMER_SURNAME), rs.getString(Config.CUSTOMER_ADDRESS), rs.getString(Config.CUSTOMER_PHONE)});
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
			
			cvf.getJTable().getSelectionModel().addListSelectionListener(a ->
			{
		    	  if (!a.getValueIsAdjusting()) 
		    	  {
		    		  System.out.println(cvf.getJTable().getValueAt(cvf.getJTable().getSelectedRow(), 0).toString());
		    	  }
			});
			
		});
		
		mainFrame.getViewInvoiceBtn().addActionListener(e ->
		{

		});
		
		mainFrame.getViewProductBtn().addActionListener(e ->
		{

		});
		
		Config.LOGGER.log(Level.INFO, "Program initialised.");
	}
}
