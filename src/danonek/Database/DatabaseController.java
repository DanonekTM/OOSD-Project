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

		for (String table: Config.tables)
		{
			statement.executeUpdate("DROP TABLE IF EXISTS " + table);
		}
		
		String createCustomer = "CREATE TABLE " + Config.tables[0] + " (" + Config.customer_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.customer_name + " STRING, " + Config.customer_surname + " STRING)";
		String createInvoice = "CREATE TABLE " + Config.tables[1] + " (" + Config.invoice_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.customer_id + " INTEGER, " + Config.product_id + " INTEGER, " + Config.product_name + " STRING)";
		String createProduct = "CREATE TABLE " + Config.tables[2] + " (" + Config.product_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.product_name + " STRING, " + Config.product_description + ", " + Config.product_quantity + " INTEGER, " + Config.product_unit_cost + " REAL)";

		statement.executeUpdate(createCustomer);
		statement.executeUpdate(createInvoice);
		statement.executeUpdate(createProduct);
		
		Config.LOGGER.log(Level.INFO, "DB created.");
	}

	/*
		    _       _     _
		   / \   __| | __| |
		  / _ \ / _` |/ _` |
		 / ___ \ (_| | (_| |
		/_/   \_\__,_|\__,_|
	*/

	public void addPerson(String name)
	{
		Add.addPerson(name);
	}

	/*
		 ____       _      _
		|  _ \  ___| | ___| |_ ___
		| | | |/ _ \ |/ _ \ __/ _ \
		| |_| |  __/ |  __/ ||  __/
		|____/ \___|_|\___|\__\___|
	*/

	public void deletePersonById(int id)
	{
		Delete.deletePersonById(id);
	}

	/*
		  ____      _
		 / ___| ___| |_
		| |  _ / _ \ __|
		| |_| |  __/ |_
		 \____|\___|\__|
	*/

	public String getPersonNameById(int id)
	{
		return Get.getPersonNameById(id);
	}

	/*
		 _   _           _       _
		| | | |_ __   __| | __ _| |_ ___
		| | | | '_ \ / _` |/ _` | __/ _ \
		| |_| | |_) | (_| | (_| | ||  __/
		 \___/| .__/ \__,_|\__,_|\__\___|
		      |_|
	*/

	public void updatePersonNameById(int id, String name)
	{
		Update.updatePersonNameById(id, name);
	}
}