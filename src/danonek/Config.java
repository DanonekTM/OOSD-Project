package danonek;

import java.sql.Connection;
import java.util.logging.Logger;

public class Config 
{
	// Variables
	public static Connection CONNECTION = null;
	public static final String DB_PATH = "jdbc:sqlite:project.db";
	public static final Logger LOGGER = Logger.getGlobal();
	
	// Database Tables
	public static final String tables[] = {"customer", "invoice", "product"};
	
	// Customer Database Columns
	public static final String customer_id = "customer_id";
	public static final String customer_name = "customer_name";
	public static final String customer_surname = "customer_surname";
	
	// Invoice Database Columns
	public static final String invoice_id = "invoice_id";
	
	// Product Database Columns
	public static final String product_id = "product_id";
	public static final String product_name = "product_name";
	public static final String product_description = "product_description";
	public static final String product_quantity = "product_quantity";
	public static final String product_unit_cost = "product_unit_cost";
	
	public Config()
	{
		
	}
}
