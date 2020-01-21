package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Get
{
	public String getPersonNameById(int id)
	{		
		String sql = "SELECT name FROM person WHERE id = ?";
		
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(Config.name);
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
		return null;
	}
}