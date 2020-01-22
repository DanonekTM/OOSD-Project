package danonek.Database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;

import danonek.Config;

public class DatabaseController 
{
	private Add Add = new Add();
	private Get Get = new Get();
	private Delete Delete = new Delete();
	private Update Update = new Update();
	
	public DatabaseController()
	{
		try
		{
			Config.CONNECTION = DriverManager.getConnection(Config.DB_PATH);
			
			Config.LOGGER.log(Level.INFO, "Connection Established.");
			this.setup();
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.INFO, e.getMessage());
		}
	}
	
	public void setup() throws SQLException
	{
		Statement statement = Config.CONNECTION.createStatement();

		statement.executeUpdate("DROP TABLE IF EXISTS person");
		statement.executeUpdate("CREATE TABLE person (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		Config.LOGGER.log(Level.INFO, "DB created.");
	}
	
	public void addPerson(String name)
	{
		Add.addPerson(name);
	}
	
	public String getPersonNameById(int id)
	{
		return Get.getPersonNameById(id);
	}
	
	public void updatePersonNameById(int id, String name)
	{
		Update.updatePersonNameById(id, name);
	}
	
	public void deletePersonById(int id)
	{
		Delete.deletePersonById(id);
	}
}