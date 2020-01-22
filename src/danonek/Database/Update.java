package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Update 
{
	public void updateCustomerNameById(int id, String name)
	{
		String sql = "UPDATE " + Config.tables[0] + " SET " + Config.customer_name + " = ? WHERE " + Config.customer_id + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
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
	
	public void updateProductNameById(int id, String name)
	{
		String sql = "UPDATE " + Config.tables[2] + " SET " + Config.product_name + " = ? WHERE " + Config.product_id + " = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
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
}
