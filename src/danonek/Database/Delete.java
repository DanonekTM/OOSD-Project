package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Delete 
{	
	public void deleteCustomerById(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[0] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	public void deleteProductById(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[2] + " WHERE " + Config.PRODUCT_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	public void deleteInvoiceById(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[1] + " WHERE " + Config.INVOICE_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	public void deleteInvoicesByCustomerId(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[1] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	public void deleteInvoicesByProductId(int id)
	{
		String sql = "DELETE FROM " + Config.TABLES[1] + " WHERE " + Config.PRODUCT_ID + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
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
