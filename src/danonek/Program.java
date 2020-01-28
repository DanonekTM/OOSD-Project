package danonek;

import java.util.logging.Level;

import danonek.Database.DatabaseController;
import danonek.Interface.CustomerAddFrame;
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

			});

		});
		
		mainFrame.getAddInvoiceBtn().addActionListener(e ->
		{

		});

		
		mainFrame.getAddProductBtn().addActionListener(e ->
		{
			
		});

		mainFrame.getViewCustomerBtn().addActionListener(e -> 
		{

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
