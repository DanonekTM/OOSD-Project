package danonek;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;

import javax.swing.DefaultComboBoxModel;
import danonek.Database.DatabaseController;
import danonek.Interface.*;

public class Program 
{
	/**
	 * This is the main function of the program.
	 */
	void run()
	{
		// Initializes the main frame of the program and database.
		MainFrame mainFrame = new MainFrame();
		DatabaseController db = new DatabaseController();
		
		// Lambda listener for Add Customer button.
		mainFrame.getAddCustomerBtn().addActionListener(e ->
		{
			// Initialize Frame.
			CustomerAddFrame caf = new CustomerAddFrame();
			
			// Get Text & Insert To DB on click on Add Customer Button.
			caf.getBtnAddCustomer().addActionListener(a ->
			{
				// Set variables equal to the gui text fields.
				String customerNameField = caf.getTextFieldCustomerName().getText();
				String customerSurnameField = caf.getTextFieldCustomerSurname().getText();
				String customerAddressField = caf.getTextFieldCustomerAddress().getText();
				String customerPhoneField = caf.getTextFieldCustomerPhone().getText();
				
				// Check if the fields are empty.
				if (customerNameField.isEmpty() || customerSurnameField.isEmpty() || customerAddressField.isEmpty() || customerPhoneField.isEmpty())
				{
					caf.setErrorMessage("* Fill out all fields!");
				}
				else
				{
					try
					{
						// Trim the integer value for the phone.
						int customerPhone = Integer.parseInt(customerPhoneField.trim());

						// Insert it into the database.
						db.addCustomer(customerNameField, customerSurnameField, customerAddressField, customerPhone);
						
						// Close the frame.
						caf.getFrame().dispose();
					}
					catch (NumberFormatException nfe)
					{
						// Set an error if the phone number isn't a number.
						caf.setErrorMessage("* Phone number must be a number!");
					}
				}
			});

		});
		
		// Lambda listener for Add Invoice button.
		mainFrame.getAddInvoiceBtn().addActionListener(e ->
		{
			// Initializes Frame.
			InvoiceAddFrame iaf = new InvoiceAddFrame();
			
			// Create 2 TreeMaps to store id and names for customer & product.
			TreeMap<Integer,String> customerMap = new TreeMap<>();
			TreeMap<Integer,String> productMap = new TreeMap<>();
			// 2 lists to later convert to array for JComboBox.
			List<String> customerList = new ArrayList<>();
			List<String> productList = new ArrayList<>();
			
			try
			{
				// Get all the data needed from the database.
				ResultSet rs = db.getAllFromCustomerAndProducts();
				// While there still is rows in the ResultSet add the Id's and names into the TreeMaps.
				while (rs.next())
				{
					customerMap.put(rs.getInt(Config.CUSTOMER_ID), rs.getString(Config.CUSTOMER_NAME));
					productMap.put(rs.getInt(Config.PRODUCT_ID), rs.getString(Config.PRODUCT_NAME));
				}
			}
			catch (Exception ex)
			{
				Config.LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			// Loop for customer TreeMap.
			for (Map.Entry<Integer, String> m : customerMap.entrySet())
			{
				// Make a string that has " - " between the id and name.
				String entry = m.getKey() + " - " + m.getValue();
				// Add the string into the list.
				customerList.add(entry);
			}
			
			// Loop for product TreeMap.
			for (Map.Entry<Integer, String> m : productMap.entrySet())
			{
				String entry = m.getKey() + " - " + m.getValue();
				productList.add(entry);
			}
			
			// Convert the lists into arrays.
			String[] customerArr = customerList.toArray(new String[customerList.size()]);
			String[] productArr = productList.toArray(new String[productList.size()]);
			
			// Set the arrays into the relevant combo boxes in the gui.
			iaf.getCustomerNameBox().setModel(new DefaultComboBoxModel<>(customerArr));
			iaf.getProductNameBox().setModel(new DefaultComboBoxModel<>(productArr));
			
			// Get Text & Insert To DB on click
			iaf.getBtnAddInvoice().addActionListener(a ->
			{
				// Check if the combo boxes are empty.
				if (iaf.getCustomerNameBox().getSelectedItem() != null || iaf.getProductNameBox().getSelectedItem() != null)
				{
					// Declare StringTokenizer with the customer name combo box contents without a delimiter.
					StringTokenizer stCn = new StringTokenizer(String.valueOf(iaf.getCustomerNameBox().getSelectedItem()));
					// initialize customer id to 0.
					int customerIdField = 0;
					// if there is a character after the first index get the integer value.
					if (stCn.hasMoreTokens()) 
					{
						// Assign customer id to next token and get the int value of it.
						customerIdField = Integer.parseInt(stCn.nextToken());
					}
					// Declare StringTokenizer for the product name combo box with a delimiter " - ".
					StringTokenizer stPn = new StringTokenizer(String.valueOf(iaf.getProductNameBox().getSelectedItem()), " - ");
					// initialize product id to 0.
					int productId = 0; 
					// Initialize the product name to null.
					String productName = null;
					if (stPn.hasMoreTokens()) 
					{
						// get the product id and set the name to anything after " - " as in the delimiter.
						productId = Integer.parseInt(stPn.nextToken());
						productName = stPn.nextToken();
					}
					// Set quantity equal to the text field value from the gui.
					String productQuantityField = iaf.getTextFieldQuantity().getText();
					
					// Check if everything is correct and insert into the database.
					try
					{
						// trim the quantity up so there is no blank spaces and assign it.
						int quantity = Integer.parseInt(productQuantityField.trim());
						
						// Add invoice to the database
						db.addInvoice(customerIdField, productId, productName, quantity);
						// Close the frame.
						iaf.getFrame().dispose();
					}
					catch (NumberFormatException nfe)
					{
						// Show error if the number is not in the correct INT format.
						iaf.setErrorMessage("* Quantity must be a number!");
					}
				}
				else
				{
					// Set an error if there is no products & customers selected.
					iaf.setErrorMessage("* Select a product and customer!");
				}
			});
			
		});

		
		mainFrame.getAddProductBtn().addActionListener(e ->
		{
			// Initializes Frame
			ProductAddFrame paf = new ProductAddFrame();
			
			// Get Text & Insert To DB on click
			paf.getBtnAddProduct().addActionListener(a ->
			{
				// Assign values of the text fields to variables.
				String productNameField = paf.getTextFieldProductName().getText();
				String productDescriptionField = paf.getTextFieldProductDescription().getText();
				String productQuantityField = paf.getTextFieldProductQuantity().getText();
				String productUnitCostField = paf.getTextFieldProductUnitPrice().getText();
				
				// Check if they're all filled out.
				if (productNameField.isEmpty() || productDescriptionField.isEmpty() || productQuantityField.isEmpty() || productUnitCostField.isEmpty())
				{
					// If not set an error message.
					paf.setErrorMessage("* Fill out all fields!");
				}
				else
				{
					try
					{
						// Trim the unit cost and quantity.
						int productQuantity = Integer.parseInt(productQuantityField.trim());
						double productUnitCost = Double.parseDouble(productUnitCostField.trim());
						
						// Add the data to the database.
						db.addProduct(productNameField, productDescriptionField, productQuantity, productUnitCost);
						
						// Close the frame.
						paf.getFrame().dispose();
					}
					catch (NumberFormatException nfe)
					{
						// Show error if the product quantity or unit cost is text.
						paf.setErrorMessage("* Product Quantity & Product Unit Cost must be a number!");
					}
				}
			});
		});

		// View Customer button listener
		mainFrame.getViewCustomerBtn().addActionListener(e -> 
		{
			// Initializes Frame
			CustomerViewFrame customerView = new CustomerViewFrame();

			try 
			{
				// Get relevant data from database.
				ResultSet rs = db.getAllFromCustomer();
				while (rs.next())
				{
					// Add everything to the table.
					customerView.getTableModel().addRow(new Object[]{rs.getString(Config.CUSTOMER_ID), rs.getString(Config.CUSTOMER_NAME), rs.getString(Config.CUSTOMER_SURNAME), rs.getString(Config.CUSTOMER_ADDRESS), rs.getString(Config.CUSTOMER_PHONE)});
				}
			}
			catch (Exception ex) 
			{
				Config.LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			// Delete customer button listener.
			customerView.getDeleteCustomerBtn().addActionListener(g ->
			{
				try
				{
					// Get Id from the selected row.
					int id = Integer.parseInt((customerView.getJTable().getValueAt(customerView.getJTable().getSelectedRow(), 0).toString().trim()));
					
					// Delete the customer from the database.
					db.deleteCustomerById(id);
					
					// Remove that row from the table.
					customerView.getTableModel().removeRow(customerView.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					// Set error if there is no entry selected by the user.
					customerView.setErrorMessage("* Select an entry first!");
				}
			});
			
		});
		
		// View Invoice button listener
		mainFrame.getViewInvoiceBtn().addActionListener(e ->
		{
			// Initializes Frame
			InvoiceViewFrame invoiceViewFrame = new InvoiceViewFrame();
			
			// Declare a customer TreeMap
			TreeMap<Integer,String> customerMap = new TreeMap<>();
			// Declare a invoice list 
			List<String> invoiceList = new ArrayList<>();
			
			try
			{
				// Get all relevant data from the database.
				ResultSet rs = db.getAllFromCustomer();
				while (rs.next())
				{
					// Put it all in the TreeMap.
					customerMap.put(rs.getInt(Config.CUSTOMER_ID), rs.getString(Config.CUSTOMER_NAME));
				}
			}
			catch (Exception ex)
			{
				Config.LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			// Loop the TreeMap.
			for (Map.Entry<Integer, String> m : customerMap.entrySet())
			{
				// Make a string out of all keys and values.
				String entry = m.getKey() + " - " + m.getValue();
				// Add them to the list.
				invoiceList.add(entry);
			}
			
			// Convert the list into the array.
			String[] invoicesArr = invoiceList.toArray(new String[invoiceList.size()]);
			
			// If the array's length is 0 or less then disable the combo box and output an error.
			if (invoicesArr.length <= 0)
			{
				invoiceViewFrame.getComboBox().setVisible(false);
				invoiceViewFrame.setErrorMessage("* Add an entry first!");
			}
			else
			{
				// Show the combo box and fill it with the invoice array's values.
				invoiceViewFrame.getComboBox().setVisible(true);
				invoiceViewFrame.getComboBox().setModel(new DefaultComboBoxModel<>(invoicesArr));
			}
			
			// Listener for the view customer button.
			invoiceViewFrame.getViewCustomerBtn().addActionListener(g ->
			{
				try
				{
					// Removes all previous elements from the table
					invoiceViewFrame.getTableModel().getDataVector().removeAllElements();

					// Notifies listeners that the data has changed.
					invoiceViewFrame.getTableModel().fireTableDataChanged();
					
					// Initialize a StringTokenizer with the value of the combo box.
					StringTokenizer st = new StringTokenizer(String.valueOf(invoiceViewFrame.getComboBox().getSelectedItem()));

					// Initialize id with 0.
					int id = 0; 

					// If there is a character in the string tokenizer after index 0.
					if (st.hasMoreTokens()) 
					{
						// set id to the first integer in the token.
						id = Integer.parseInt(st.nextToken());
					}

					// Get all relevant data from the database.
					ResultSet rs = db.getInvoicesByCustomerId(id);

					// Loop through all rows.
					while (rs.next())
					{
						// Add all the information into the table.
						invoiceViewFrame.getTableModel().addRow(new Object[]{rs.getString(Config.INVOICE_ID), rs.getString(Config.CUSTOMER_ID), rs.getString(Config.PRODUCT_ID), rs.getString(Config.PRODUCT_NAME), rs.getString(Config.PRODUCT_QUANTITY)});
					}

					// If the result set was null show an error.
					if (rs.wasNull())
					{
						invoiceViewFrame.setErrorMessage("* No invoices found!");
					}
				}
				catch (Exception ex)
				{
					// If anything else went wrong show error.
					invoiceViewFrame.setErrorMessage("* No invoices found!");
				}
			});
			
			// Delete customer button listener.
			invoiceViewFrame.getDeleteCustomerBtn().addActionListener(x ->
			{
				try
				{
					// Set id to the selected row in the table and trim it.
					int id = Integer.parseInt((invoiceViewFrame.getJTable().getValueAt(invoiceViewFrame.getJTable().getSelectedRow(), 0).toString().trim()));

					// delete the selected id from the database.
					db.deleteInvoiceById(id);

					// Delete the row selected.
					invoiceViewFrame.getTableModel().removeRow(invoiceViewFrame.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					// Show error if there is no row selected.
					invoiceViewFrame.setErrorMessage("* Select an entry first!");
				}
			});
			
		});
		
		// View Product Button listener.
		mainFrame.getViewProductBtn().addActionListener(e ->
		{
			// Initializes Frame
			ProductViewFrame productView = new ProductViewFrame();

			try 
			{
				// Get all relevant info from the database.
				ResultSet rs = db.getAllFromProduct();
				// Loop through the ResultSet row by row.
				while (rs.next())
				{
					// Add the data into the table row by row.
					productView.getTableModel().addRow(new Object[]{rs.getString(Config.PRODUCT_ID), rs.getString(Config.PRODUCT_NAME), rs.getString(Config.PRODUCT_DESCRIPTION), rs.getString(Config.PRODUCT_QUANTITY), rs.getString(Config.PRODUCT_UNIT_COST)});
				}
			}
			catch (Exception ex) 
			{
				Config.LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			productView.getDeleteProductBtn().addActionListener(g ->
			{
				try
				{
					// Set id to the selected row and trim it down so there is no whitespaces.
					int id = Integer.parseInt((productView.getJTable().getValueAt(productView.getJTable().getSelectedRow(), 0).toString().trim()));

					// Delete the product by id from the database.
					db.deleteProductById(id);

					// Remove the selected row after delete from database.
					productView.getTableModel().removeRow(productView.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					// Show the error if the user didn't select any row in the table.
					productView.setErrorMessage("* Select an entry first!");
				}
			});
			
		});
		
		Config.LOGGER.log(Level.INFO, "Program initialised.");
	}
}
