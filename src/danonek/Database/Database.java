package danonek.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;

import danonek.Config;
 
public class Database 
{
	private static Logger LOGGER = Logger.getGlobal();
	
    public Database()
    {
        try 
        {
            Config.CONNECTION = DriverManager.getConnection(Config.DB_PATH);
            
            LOGGER.log(Level.INFO, "Connection Established.");
            this.setup();
                
        }
        catch (SQLException e) 
        {
        	LOGGER.log(Level.INFO, e.getMessage());
        }
    }
    
    public void setup() throws SQLException
    {
    	Statement statement = Config.CONNECTION.createStatement();
        statement.setQueryTimeout(30);

        statement.executeUpdate("DROP TABLE IF EXISTS person");
        statement.executeUpdate("CREATE TABLE person (id INTEGER, name STRING)");
        
        LOGGER.log(Level.INFO, "DB created.");
        
        this.selectAll();
    }
    
    public void selectAll() throws SQLException
    {
    	LOGGER.log(Level.INFO, "Gonna select from DB.");
    	
		String sql = "SELECT id, name FROM person";
		
		Statement stmt = Config.CONNECTION.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
			
		while (rs.next()) 
		{
			LOGGER.log(Level.INFO, rs.getInt("id") +  "\t" + rs.getString("name") + "\t" + rs.getDouble("capacity"));
		}
    }
    
}