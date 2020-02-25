package danonek.Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;

import danonek.Config;

public class DatabaseController 
{
	private Add Add = new Add();
	private Get Get = new Get();
	private Delete Delete = new Delete();
	private Update Update = new Update();
	
	/**
	 * Constructs DB connection with the specified path from the configuration file.
	 */
	public DatabaseController()
	{
		try
		{
			Config.DB_CONNECTION = DriverManager.getConnection(Config.DB_PATH);
			
			Config.LOGGER.log(Level.INFO, "Connection Established.");
			this.setup();
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	/**
	 * Sets up a database statement, drops existing databases and builds the database again
	 */
	public void setup() throws SQLException
	{
		Statement statement = Config.DB_CONNECTION.createStatement();

		for (String table: Config.TABLES)
		{
			statement.executeUpdate("DROP TABLE IF EXISTS " + table);
		}
		
		String createCustomer = "CREATE TABLE " + Config.TABLES[0] + " (" + Config.CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.CUSTOMER_NAME + " STRING, " + Config.CUSTOMER_SURNAME + " STRING, " + Config.CUSTOMER_ADDRESS + " STRING, " + Config.CUSTOMER_PHONE + " INT)";
		String createInvoice = "CREATE TABLE " + Config.TABLES[1] + " (" + Config.INVOICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.CUSTOMER_ID + " INTEGER, " + Config.PRODUCT_ID + " INTEGER, " + Config.PRODUCT_NAME + " STRING, " + Config.PRODUCT_QUANTITY + " INTEGER)";
		String createProduct = "CREATE TABLE " + Config.TABLES[2] + " (" + Config.PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.PRODUCT_NAME + " STRING, " + Config.PRODUCT_DESCRIPTION + " STRING, " + Config.PRODUCT_QUANTITY + " INTEGER, " + Config.PRODUCT_UNIT_COST + " REAL)";

		statement.executeUpdate(createCustomer);
		statement.executeUpdate(createInvoice);
		statement.executeUpdate(createProduct);
			
		Config.LOGGER.log(Level.INFO, "Database created.");
	}
	
	/**
	 * All functions below link functions from files together for easier access.
	 */

	/*
		    _       _     _
		   / \   __| | __| |
		  / _ \ / _` |/ _` |
		 / ___ \ (_| | (_| |
		/_/   \_\__,_|\__,_|
	*/

	public void addCustomer(String name, String surname, String address, int phone)
	{
		Add.addCustomer(name, surname, address, phone);
	}
	
	public void addProduct(String name, String description, int quantity, double cost)
	{
		Add.addProduct(name, description, quantity, cost);
	}
	
	public void addInvoice(int customerId, int productId, String productName, int productQuantity)
	{
		Add.addInvoice(customerId, productId, productName,  productQuantity);
	}
	
	

	/*
		 ____       _      _
		|  _ \  ___| | ___| |_ ___
		| | | |/ _ \ |/ _ \ __/ _ \
		| |_| |  __/ |  __/ ||  __/
		|____/ \___|_|\___|\__\___|
	*/

	public void deleteCustomerById(int id)
	{
		Delete.deleteCustomerById(id);
	}
	
	public void deleteProductById(int id)
	{
		Delete.deleteProductById(id);
	}
	
	public void deleteInvoiceById(int id)
	{
		Delete.deleteInvoiceById(id);
	}
	
	public void deleteInvoicesByCustomerId(int id)
	{
		Delete.deleteInvoicesByCustomerId(id);
	}
	
	public void deleteInvoicesByProductId(int id)
	{
		Delete.deleteInvoicesByProductId(id);
	}
	
	/*
		  ____      _
		 / ___| ___| |_
		| |  _ / _ \ __|
		| |_| |  __/ |_
		 \____|\___|\__|
	*/

	public String getCustomerNameById(int id)
	{
		return Get.getCustomerNameById(id);
	}
	
	public String getCustomerSurnameById(int id)
	{
		return Get.getCustomerSurnameById(id);
	}
	
	public String getProductNameById(int id)
	{
		return Get.getProductNameById(id);
	}
	
	public ResultSet getInvoicesByCustomerId(int id) throws SQLException
	{
		return Get.getInvoicesByCustomerId(id);
	}
	
	public ResultSet getAllFromCustomerAndProducts() throws SQLException
	{
		return Get.getAllFromCustomerAndProducts();
	}
	
	public ResultSet getInvoicesByProductId(int id) throws SQLException
	{
		return Get.getInvoicesByProductId(id);
	}
	
	public ResultSet getAllFromCustomer() throws SQLException
	{
		return Get.getAllFromCustomer();
	}
	
	public ResultSet getAllFromInvoice() throws SQLException
	{
		return Get.getAllFromInvoice();
	}
	
	public ResultSet getAllFromProduct() throws SQLException
	{
		return Get.getAllFromProduct();
	}

	/*
		 _   _           _       _
		| | | |_ __   __| | __ _| |_ ___
		| | | | '_ \ / _` |/ _` | __/ _ \
		| |_| | |_) | (_| | (_| | ||  __/
		 \___/| .__/ \__,_|\__,_|\__\___|
		      |_|
	*/

	public void updateCustomerNameById(int id, String name)
	{
		Update.updateCustomerNameById(id, name);
	}
	
	public void updateCustomerPhoneById(int id, int phone)
	{
		Update.updateCustomerPhoneById(id, phone);
	}
	
	public void updateProductNameById(int id, String name)
	{
		Update.updateProductNameById(id, name);
	}
	
	public void updateProductQuantityById(int id, int quantity)
	{
		Update.updateProductQuantityById(id, quantity);
	}
}