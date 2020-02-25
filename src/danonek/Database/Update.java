package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Update 
{
	/**
	 * updateCustomerNameById updates customer name by given customer id.
	 * @param id
	 * @param name
	 */
	public void updateCustomerNameById(int id, String name)
	{
		String sql = "UPDATE " + Config.TABLES[0] + " SET " + Config.CUSTOMER_NAME + " = ? WHERE " + Config.CUSTOMER_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * updateCustomerPhoneById updates customer phone by customer id. 
	 * @param id
	 * @param phone
	 */
	public void updateCustomerPhoneById(int id, int phone)
	{
		String sql = "UPDATE " + Config.TABLES[0] + " SET " + Config.CUSTOMER_PHONE + " = ? WHERE " + Config.CUSTOMER_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, phone);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * updateProductNameById updates product name by given product id.
	 * @param id
	 * @param name
	 */
	public void updateProductNameById(int id, String name)
	{
		String sql = "UPDATE " + Config.TABLES[2] + " SET " + Config.PRODUCT_NAME + " = ? WHERE " + Config.PRODUCT_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	/**
	 * updateProductQuantityById updates product quantity of a given product by its id.
	 * @param id
	 * @param quantity
	 */
	public void updateProductQuantityById(int id, int quantity)
	{
		String sql = "UPDATE " + Config.TABLES[2] + " SET " + Config.PRODUCT_QUANTITY + " = ? WHERE " + Config.PRODUCT_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
}
