package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Add 
{	
	/**
	 * addCustomer adds a customer to the database.
	 * @param name Name of the Customer.
//	 * @param surname Surname of the Customer.
	 * @param address Address of the Customer.
	 * @param phone Phone number of the Customer.
	 */
	public void addCustomer(String name, String surname, String address, int phone)
	{
		String sql = "INSERT INTO " + Config.TABLES[0] + " (" + Config.CUSTOMER_NAME + ", " + Config.CUSTOMER_SURNAME + ", " + Config.CUSTOMER_ADDRESS + ", " + Config.CUSTOMER_PHONE + ") VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setString(1, name);
			pstmt.setString(2, surname);
			pstmt.setString(3, address);
			pstmt.setInt(4, phone);
			pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * addProduct adds a product to the database.
	 * @param name Name of the product.
	 * @param description Description of the product.
	 * @param quantity Quantity of the product.
	 * @param cost Cost of the product per unit.
	 */
	public void addProduct(String name, String description, int quantity, double cost)
	{
		String sql = "INSERT INTO " + Config.TABLES[2] + " (" + Config.PRODUCT_NAME + ", " + Config.PRODUCT_DESCRIPTION + ", " + Config.PRODUCT_QUANTITY + ", " + Config.PRODUCT_UNIT_COST + ") VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setString(1, name);
			pstmt.setString(2, description);
			pstmt.setInt(3, quantity);
			pstmt.setDouble(4, cost);
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * addInvoice adds an invoice to the database.
	 * @param customerId Customer Id.
	 * @param productId Product Id.
	 * @param productName Product Name
	 * @param productQuantity Product Quantity.
	 */
	public void addInvoice(int customerId, int productId, String productName, int productQuantity)
	{
		String sql = "INSERT INTO " + Config.TABLES[1] + " (" + Config.CUSTOMER_ID + ", " + Config.PRODUCT_ID + ", " + Config.PRODUCT_NAME + ", " + Config.PRODUCT_QUANTITY + ") VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, productId);
			pstmt.setString(3, productName);
			pstmt.setInt(4, productQuantity);
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
}
