package danonek;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import danonek.Database.*;
import danonek.Interface.Gui;

public class Driver
{
	public static void main(String[] args)
	{
		DatabaseController db = new DatabaseController();
		new Gui();
		
		db.addCustomer("TEST1 NAME", "TEST1 SURNAME", "TEST1 ADD", 1);
		db.addCustomer("TEST2 NAME", "TEST2 SURNAME", "TEST2 ADD", 2);
		try {
			ResultSet rs = db.getAllFromCustomer();
			while (rs.next())
			{
				System.out.println("ID: " + rs.getString(Config.customer_id));
				System.out.println("NAME: " + rs.getString(Config.customer_name));
				System.out.println("SURNAME: " + rs.getString(Config.customer_surname));
				System.out.println("ADDRESS: " + rs.getString(Config.customer_address));
				System.out.println("PHONE: " + rs.getString(Config.customer_phone));
			}
		}
		catch (SQLException e)
		{
			Config.LOGGER.log(Level.WARNING, e.getMessage());
		}
	}
}
