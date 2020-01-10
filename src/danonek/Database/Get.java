package danonek.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import danonek.Config;

public class Get
{
	Statement stmt;
	
	public void getPerson(int id) throws SQLException
	{
		stmt = Config.CONNECTION.createStatement();
		
		String sql = "SELECT * FROM person WHERE id = " + id;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) 
		{
	        String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
	         System.out.println();
	      }
	      rs.close();
	}
}
