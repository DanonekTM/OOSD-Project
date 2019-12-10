package danonek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config 
{
	// Variables
	public static Connection CONNECTION = null;
	public static String DB_PATH = "jdbc:sqlite:project.db";
	
	public Config()
	{
		
	}
}
