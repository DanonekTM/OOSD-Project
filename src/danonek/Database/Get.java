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
		String sql = "SELECT " + Config.customer_name + " FROM " + Config.tables[0] + " WHERE " + Config.customer_id + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.customer_name);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public String getCustomerSurnameById(int id)
	{		
		String sql = "SELECT " + Config.customer_surname + " FROM " + Config.tables[0] + " WHERE " + Config.customer_id + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.customer_surname);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public String getProductNameById(int id)
	{		
		String sql = "SELECT " + Config.product_name + " FROM " + Config.tables[2] + " WHERE " + Config.product_id + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.product_name);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public ResultSet getInvoicesByCustomerId(int id) throws SQLException
	{
		String sql = "SELECT * FROM " + Config.tables[1] + " WHERE " + Config.customer_id + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs;
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public ResultSet getInvoicesByProductId(int id) throws SQLException
	{
		String sql = "SELECT * FROM " + Config.tables[1] + " WHERE " + Config.product_id + " = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs;
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
	
	public ResultSet getAllFromCustomer() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.tables[0];
		Statement stmt = Config.CONNECTION.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		return rs;
	}
	
	public ResultSet getAllFromInvoice() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.tables[1];
		Statement stmt = Config.CONNECTION.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		return rs;
	}
	
	public ResultSet getAllFromProduct() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.tables[2];
		Statement stmt = Config.CONNECTION.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		return rs;
	}
}