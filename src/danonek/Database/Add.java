package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import danonek.Config;

public class Add 
{
	public void addPerson(String name)
	{
		String sql = "INSERT INTO person(name) VALUES(?)";
		 
		try (PreparedStatement pstmt = Config.CONNECTION.prepareStatement(sql)) 
		{
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } 
		catch (SQLException e) 
		{
            System.out.println(e.getMessage());
        }
	}
}
