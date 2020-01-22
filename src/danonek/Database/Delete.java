package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Delete 
{	
	public void deleteCustomerById(int id)
	{
		String sql = "DELETE FROM " + Config.tables[0] + " WHERE " + Config.customer_id + " = ?";
		 
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
		String sql = "DELETE FROM " + Config.tables[2] + " WHERE " + Config.product_id + " = ?";
		 
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
