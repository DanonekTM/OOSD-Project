package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import danonek.Config;

public class Get
{
	public String getCustomerNameById(int id)
	{		
		String sql = "SELECT " + Config.CUSTOMER_NAME + " FROM " + Config.TABLES[0] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.CUSTOMER_NAME);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public String getCustomerSurnameById(int id)
	{		
		String sql = "SELECT " + Config.CUSTOMER_SURNAME + " FROM " + Config.TABLES[0] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.CUSTOMER_SURNAME);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public String getProductNameById(int id)
	{		
		String sql = "SELECT " + Config.PRODUCT_NAME + " FROM " + Config.TABLES[2] + " WHERE " + Config.PRODUCT_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.PRODUCT_NAME);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public ResultSet getInvoicesByCustomerId(int id) throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[1] + " WHERE " + Config.CUSTOMER_ID + " = " + id;
		Statement stmt = Config.CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public ResultSet getInvoicesByProductId(int id) throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[1] + " WHERE " + Config.PRODUCT_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
		{
			pstmt.setInt(1, id);
			return pstmt.executeQuery(sql);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public ResultSet getAllFromCustomer() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[0];
		Statement stmt = Config.CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public ResultSet getAllFromInvoice() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[1];
		Statement stmt = Config.CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public ResultSet getAllFromProduct() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[2];
		Statement stmt = Config.CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
}