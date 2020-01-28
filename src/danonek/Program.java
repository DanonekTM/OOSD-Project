package danonek;

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
		
		mainFrame.getAddCustomerBtn().addActionListener(e ->
		{
			System.out.println("ADD CUSTOMER WINDOW");
			CustomerAddFrame caf = new CustomerAddFrame();
			
			// Get Text & Insert To DB on click
			caf.getBtnAddCustomer().addActionListener(a ->
			{
				System.out.println("ADD CUSTOMER BTN");
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
	}
}
