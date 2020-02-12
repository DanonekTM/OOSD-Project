package danonek;

import java.sql.ResultSet;
import java.util.logging.Level;

import danonek.Database.DatabaseController;
import danonek.Interface.*;

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
			// Init Frame
			CustomerAddFrame caf = new CustomerAddFrame();
			
			// Get Text & Insert To DB on click
			caf.getBtnAddCustomer().addActionListener(a ->
			{
				String customerNameField = caf.getTextFieldCustomerName().getText();
				String customerSurnameField = caf.getTextFieldCustomerSurname().getText();
				String customerAddressField = caf.getTextFieldCustomerAddress().getText();
				String customerPhoneField = caf.getTextFieldCustomerPhone().getText();
				
				if (customerNameField.isEmpty() || customerSurnameField.isEmpty() || customerAddressField.isEmpty() || customerPhoneField.isEmpty())
				{
					caf.setErrorMessage("* Fill out all fields!");
				}
				else
				{
					try
					{
						int customerPhone = Integer.parseInt(customerPhoneField.trim());

						db.addCustomer(customerNameField, customerSurnameField, customerAddressField, customerPhone);
						caf.getFrame().dispose();
					}
					catch (NumberFormatException nfe)
					{
						caf.setErrorMessage("* Phone number must be a number!");
					}
				}
			});

		});
		
		mainFrame.getAddInvoiceBtn().addActionListener(e ->
		{

		});

		
		mainFrame.getAddProductBtn().addActionListener(e ->
		{
			// Init Frame
			ProductAddFrame paf = new ProductAddFrame();
			
			// Get Text & Insert To DB on click
			paf.getBtnAddProduct().addActionListener(a ->
			{
				String productNameField = paf.getTextFieldProductName().getText();
				String productDescriptionField = paf.getTextFieldProductDescription().getText();
				String productQuantityField = paf.getTextFieldProductQuantity().getText();
				String productUnitCostField = paf.getTextFieldProductUnitPrice().getText();
				
				if (productNameField.isEmpty() || productDescriptionField.isEmpty() || productQuantityField.isEmpty() || productUnitCostField.isEmpty())
				{
					paf.setErrorMessage("* Fill out all fields!");
				}
				else
				{
					try
					{
						int productQuantity = Integer.parseInt(productQuantityField.trim());
						double productUnitCost = Double.parseDouble(productUnitCostField.trim());
						
						db.addProduct(productNameField, productDescriptionField, productQuantity, productUnitCost);
						paf.getFrame().dispose();
					}
					catch (NumberFormatException nfe)
					{
						paf.setErrorMessage("* Product Quantity & Product Unit Cost must be a number!");
					}
				}
			});
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
				Config.LOGGER.log(Level.INFO, e.getMessage());
			}
			
			cvf.getDeleteCustomerBtn().addActionListener(g ->
			{
				try
				{
					int id = Integer.parseInt((cvf.getJTable().getValueAt(cvf.getJTable().getSelectedRow(), 0).toString().trim()));
					db.deleteCustomerById(id);
					cvf.getTableModel().removeRow(cvf.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					cvf.setErrorMessage("* Select an entry first!");
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
