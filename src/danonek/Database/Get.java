package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import danonek.Config;

public class Get
{
	public void getPerson(int id)
	{
		String sql = "INSERT INTO person (name) VALUES (?)";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } 
		catch (SQLException e) 
		{
            System.out.println(e.getMessage());
        }
	}
}
