package danonek;

import java.sql.Connection;
import java.util.logging.Logger;

public class Config 
{
	// Variables
	public static Connection CONNECTION = null;
	public static String DB_PATH = "jdbc:sqlite:project.db";
	public static Logger LOGGER = Logger.getGlobal();
	
	// Person Database Columns
	public static String id = "id";
	public static String name = "name";
	
	public Config()
	{
		
	}
}
