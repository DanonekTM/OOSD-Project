package danonek.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Config;

public class Delete 
{
	public void deletePersonById(int id)
	{
		String sql = "DELETE FROM person WHERE id = ?";
		 
		try (Connection conn = Config.CONNECTION; PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql))
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
