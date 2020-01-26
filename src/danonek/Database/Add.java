package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Add 
{	
	public void addCustomer(String name, String surname, String address, String phone)
	{
		String sql = "INSERT INTO " + Config.tables[0] + " (" + Config.customer_name + ", " + Config.customer_surname + ", " + Config.customer_address + ", " + Config.customer_phone + ") VALUES (?, ?, ?, ?)";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setString(1, name);
			pstmt.setString(2, surname);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	public void addProduct(String name, String description, int quantity, double cost)
	{
		String sql = "INSERT INTO " + Config.tables[2] + " (" + Config.product_name + ", " + Config.product_description + ", " + Config.product_quantity + ", " + Config.product_unit_cost + ") VALUES (?, ?, ?, ?)";
		 
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
			System.out.println(e.getMessage());
		}
	}
}
