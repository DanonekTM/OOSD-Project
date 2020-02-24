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
		
		// Lambda listeners for each button
		mainFrame.getAddCustomerBtn().addActionListener(e ->
		{
			// Initialize Frame
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
			// Initializes Frame
			InvoiceAddFrame iaf = new InvoiceAddFrame();
			
			TreeMap<Integer,String> customerMap = new TreeMap<>();
			TreeMap<Integer,String> productMap = new TreeMap<>();
			List<String> customerList = new ArrayList<>();
			List<String> productList = new ArrayList<>();
			
			try
			{
				ResultSet rs = db.getAllFromCustomerAndProducts();
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
			
			for (Map.Entry<Integer, String> m : customerMap.entrySet())
			{
				String entry = m.getKey() + " - " + m.getValue();
				customerList.add(entry);
			}
			
			for (Map.Entry<Integer, String> m : productMap.entrySet())
			{
				String entry = m.getKey() + " - " + m.getValue();
				productList.add(entry);
			}
			
			String[] customerArr = customerList.toArray(new String[customerList.size()]);
			String[] productArr = productList.toArray(new String[productList.size()]);
			
			iaf.getCustomerNameBox().setModel(new DefaultComboBoxModel<>(customerArr));
			iaf.getProductNameBox().setModel(new DefaultComboBoxModel<>(productArr));
			
			// Get Text & Insert To DB on click
			iaf.getBtnAddInvoice().addActionListener(a ->
			{
				StringTokenizer stCn = new StringTokenizer(String.valueOf(iaf.getCustomerNameBox().getSelectedItem()));
				int customerIdField = 0;
				if (stCn.hasMoreTokens()) 
				{
					customerIdField = Integer.parseInt(stCn.nextToken());
			    }
				StringTokenizer stPn = new StringTokenizer(String.valueOf(iaf.getProductNameBox().getSelectedItem()), " - ");
				int productId = 0; 
				String productName = null;
				if (stPn.hasMoreTokens()) 
				{
					productId = Integer.parseInt(stPn.nextToken());
					productName = stPn.nextToken();
			    }
				
				String productQuantityField = iaf.getTextFieldQuantity().getText();
				
				try
				{
					int quantity = Integer.parseInt(productQuantityField.trim());

					db.addInvoice(customerIdField, productId, productName, quantity);
					iaf.getFrame().dispose();
				}
				catch (NumberFormatException nfe)
				{
					iaf.setErrorMessage("* Quantity must be a number!");
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

		mainFrame.getViewCustomerBtn().addActionListener(e -> 
		{
			// Initializes Frame
			CustomerViewFrame customerView = new CustomerViewFrame();

			try 
			{
				ResultSet rs = db.getAllFromCustomer();
				while (rs.next())
				{
					customerView.getTableModel().addRow(new Object[]{rs.getString(Config.CUSTOMER_ID), rs.getString(Config.CUSTOMER_NAME), rs.getString(Config.CUSTOMER_SURNAME), rs.getString(Config.CUSTOMER_ADDRESS), rs.getString(Config.CUSTOMER_PHONE)});
				}
			}
			catch (Exception ex) 
			{
				Config.LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			customerView.getDeleteCustomerBtn().addActionListener(g ->
			{
				try
				{
					int id = Integer.parseInt((customerView.getJTable().getValueAt(customerView.getJTable().getSelectedRow(), 0).toString().trim()));
					db.deleteCustomerById(id);
					customerView.getTableModel().removeRow(customerView.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					customerView.setErrorMessage("* Select an entry first!");
				}
			});
			
		});
		
		mainFrame.getViewInvoiceBtn().addActionListener(e ->
		{
			// Initializes Frame
			InvoiceViewFrame invoiceViewFrame = new InvoiceViewFrame();
			
			TreeMap<Integer,String> customerMap = new TreeMap<>();
			List<String> invoiceList = new ArrayList<>();
			
			try
			{
				ResultSet rs = db.getAllFromCustomer();
				while (rs.next())
				{
					customerMap.put(rs.getInt(Config.CUSTOMER_ID), rs.getString(Config.CUSTOMER_NAME));
				}
			}
			catch (Exception ex)
			{
				Config.LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			for (Map.Entry<Integer, String> m : customerMap.entrySet())
			{
				String entry = m.getKey() + " - " + m.getValue();
				invoiceList.add(entry);
			}
			
			String[] invoicesArr = invoiceList.toArray(new String[invoiceList.size()]);
			
			if (invoicesArr.length <= 0)
			{
				invoiceViewFrame.getComboBox().setVisible(false);
				invoiceViewFrame.setErrorMessage("* Add An Entry first");
			}
			else
			{
				invoiceViewFrame.getComboBox().setVisible(true);
				invoiceViewFrame.getComboBox().setModel(new DefaultComboBoxModel<>(invoicesArr));
			}
			
			invoiceViewFrame.getViewCustomerBtn().addActionListener(g ->
			{
				try
				{
					invoiceViewFrame.getTableModel().getDataVector().removeAllElements();
					invoiceViewFrame.getTableModel().fireTableDataChanged();
					
					StringTokenizer st = new StringTokenizer(String.valueOf(invoiceViewFrame.getComboBox().getSelectedItem()));
					int id = 0; 
					if (st.hasMoreTokens()) 
					{
						id = Integer.parseInt(st.nextToken());
				    }
					ResultSet rs = db.getInvoicesByCustomerId(id);
					while (rs.next())
					{
						invoiceViewFrame.getTableModel().addRow(new Object[]{rs.getString(Config.INVOICE_ID), rs.getString(Config.CUSTOMER_ID), rs.getString(Config.PRODUCT_ID), rs.getString(Config.PRODUCT_NAME), rs.getString(Config.PRODUCT_QUANTITY)});
					}
				}
				catch (Exception ex)
				{
					invoiceViewFrame.setErrorMessage("* Select an entry first!");
				}
			});
			
			invoiceViewFrame.getDeleteCustomerBtn().addActionListener(x ->
			{
				try
				{
					int id = Integer.parseInt((invoiceViewFrame.getJTable().getValueAt(invoiceViewFrame.getJTable().getSelectedRow(), 0).toString().trim()));
					db.deleteInvoiceById(id);
					invoiceViewFrame.getTableModel().removeRow(invoiceViewFrame.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					invoiceViewFrame.setErrorMessage("* Select an entry first!");
				}
			});
			
		});
		
		mainFrame.getViewProductBtn().addActionListener(e ->
		{
			// Initializes Frame
			ProductViewFrame productView = new ProductViewFrame();

			try 
			{
				ResultSet rs = db.getAllFromProduct();
				while (rs.next())
				{
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
					int id = Integer.parseInt((productView.getJTable().getValueAt(productView.getJTable().getSelectedRow(), 0).toString().trim()));
					db.deleteProductById(id);
					productView.getTableModel().removeRow(productView.getJTable().getSelectedRow());
				}
				catch (Exception ex)
				{
					productView.setErrorMessage("* Select an entry first!");
				}
			});
			
		});
		
		Config.LOGGER.log(Level.INFO, "Program initialised.");
	}
}
