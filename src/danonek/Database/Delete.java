package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Delete 
{	
	/**
	 * deleteCustomerById deletes a customer with the given id from the database.
	 * @param id
	 */
	public void deleteCustomerById(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[0] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * deleteProductById deletes a product with the given id from the database.
	 * @param id
	 */
	public void deleteProductById(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[2] + " WHERE " + Config.PRODUCT_ID + " = ?";

		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * deleteInvoiceById deletes a invoice with the given id from the database.
	 * @param id
	 */
	public void deleteInvoiceById(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[1] + " WHERE " + Config.INVOICE_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * deleteInvoicesByCustomerId deletes all invoices from the database based on the customer id.
	 * @param id
	 */
	public void deleteInvoicesByCustomerId(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[1] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	/**
	 * deleteInvoicesByProductId deletes all invoices from the database based on the product id.
	 * @param id
	 */
	public void deleteInvoicesByProductId(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[1] + " WHERE " + Config.PRODUCT_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
}
