package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import danonek.Config;

public class Get
{
	/**
	 * getCustomerNameById returns customer name by given customer id.
	 * @param id Customer id.
	 * @return customer name or null if customer not found.
	 */
	public String getCustomerNameById(int id)
	{		
		String sql = "SELECT " + Config.CUSTOMER_NAME + " FROM " + Config.TABLES[0] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
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
	
	/**
	 * getCustomerSurnameById returns customer surname with the given id.
	 * @param id Customer id.
	 * @return customer surname or null if not customer not found.
	 */
	public String getCustomerSurnameById(int id)
	{		
		String sql = "SELECT " + Config.CUSTOMER_SURNAME + " FROM " + Config.TABLES[0] + " WHERE " + Config.CUSTOMER_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
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
	
	/**
	 * getProductNameById returns product name by given product id.
	 * @param id Product Id
	 * @return product name with the given id or null if not found.
	 */
	public String getProductNameById(int id)
	{		
		String sql = "SELECT " + Config.PRODUCT_NAME + " FROM " + Config.TABLES[2] + " WHERE " + Config.PRODUCT_ID + " = ?";
		
		try (PreparedStatement pstmt = Config.DB_CONNECTION.prepareStatement(sql)) 
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
	
	/**
	 * getInvoicesByCustomerId returns all invoices based on the given customer id.
	 * @param id Customer Id.
	 * @return ResultSet of all invoices that have the given customer id.
	 * @throws SQLException
	 */
	public ResultSet getInvoicesByCustomerId(int id) throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[1] + " WHERE " + Config.CUSTOMER_ID + " = " + id;
		Statement stmt = Config.DB_CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	/**
	 * getInvoicesByProductId returns all invoices based on the given product id.
	 * @param id Product id.
	 * @return ResultSet of all invoices that have the given product id.
	 * @throws SQLException
	 */
	public ResultSet getInvoicesByProductId(int id) throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[1] + " WHERE " + Config.PRODUCT_ID + " = " + id;
		Statement stmt = Config.DB_CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	/**
	 * getAllFromCustomer returns everything from the customer table.
	 * @return ResultSet of all customers from the customer table.
	 * @throws SQLException
	 */
	public ResultSet getAllFromCustomer() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[0];
		Statement stmt = Config.DB_CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	/**
	 * getAllFromInvoice returns everything from the customer table.
	 * @return ResultSet of all invoices from the invoice table.
	 * @throws SQLException
	 */
	public ResultSet getAllFromInvoice() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[1];
		Statement stmt = Config.DB_CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	/**
	 * getAllFromProduct returns everything from the product table.
	 * @return ResultSet of all products from the product table.
	 * @throws SQLException
	 */
	public ResultSet getAllFromProduct() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[2];
		Statement stmt = Config.DB_CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
	
	/**
	 * getAllFromCustomerAndProducts joins products and customers and returns everything from both tables.
	 * @return ResultSet of all products and customers.
	 * @throws SQLException
	 */
	public ResultSet getAllFromCustomerAndProducts() throws SQLException
	{
		String sql = "SELECT * FROM " + Config.TABLES[0] + " JOIN " + Config.TABLES[2];
		Statement stmt = Config.DB_CONNECTION.createStatement();
		return stmt.executeQuery(sql);
	}
}