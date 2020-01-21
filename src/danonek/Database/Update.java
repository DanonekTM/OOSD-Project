package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import danonek.Config;

public class Update 
{
	public void updatePersonNameById(int id, String name)
	{
		String sql = "UPDATE person SET name = ? WHERE id = ?";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
			pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } 
		catch (SQLException e) 
		{
            System.out.println(e.getMessage());
        }
	}
}
