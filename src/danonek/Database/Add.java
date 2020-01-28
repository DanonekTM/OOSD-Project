package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Add 
{	
	public void addCustomer(String name, String surname, String address, int phone)
	{
		String sql = "INSERT INTO " + Config.TABLES[0] + " (" + Config.CUSTOMER_NAME + ", " + Config.CUSTOMER_SURNAME + ", " + Config.CUSTOMER_ADDRESS + ", " + Config.CUSTOMER_PHONE + ") VALUES (?, ?, ?, ?)";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
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
	
	public void addProduct(String name, String description, int quantity, double cost)
	{
		String sql = "INSERT INTO " + Config.TABLES[2] + " (" + Config.PRODUCT_NAME + ", " + Config.PRODUCT_DESCRIPTION + ", " + Config.PRODUCT_QUANTITY + ", " + Config.PRODUCT_UNIT_COST + ") VALUES (?, ?, ?, ?)";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
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
	
	public void addInvoice(int customerId, int productId, String productName, int productQuantity)
	{
		String sql = "INSERT INTO " + Config.TABLES[1] + " (" + Config.CUSTOMER_ID + ", " + Config.PRODUCT_ID + ", " + Config.PRODUCT_NAME + ", " + Config.PRODUCT_QUANTITY + ") VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
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
