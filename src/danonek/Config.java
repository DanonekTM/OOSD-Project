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
	public static final String TABLES[] = {"customer", "invoice", "product"};
	
	// Customer Database Columns
	public static final String CUSTOMER_ID = "customer_id";
	public static final String CUSTOMER_NAME = "customer_name";
	public static final String CUSTOMER_SURNAME = "customer_surname";
	public static final String CUSTOMER_ADDRESS = "customer_address";
	public static final String CUSTOMER_PHONE = "customer_phone";
	
	// Invoice Database Columns
	public static final String INVOICE_ID = "invoice_id";
	
	// Product Database Columns
	public static final String PRODUCT_ID = "product_id";
	public static final String PRODUCT_NAME = "product_name";
	public static final String PRODUCT_DESCRIPTION = "product_description";
	public static final String PRODUCT_QUANTITY = "product_quantity";
	public static final String PRODUCT_UNIT_COST = "product_unit_cost";

	// Font
	public static final String FONT_NAME = "Tahoma";

	// Main Strings
	public static final String MAIN_FRAME_TITLE = "Invoice Managment";

	public static final String ADD_INVOICE_STRING = "Add Invoice";
	public static final String ADD_CUSTOMER_STRING = "Add Customer";
	public static final String ADD_PRODUCT_STRING = "Add Product";

	public static final String VIEW_PRODUCT_STRING = "View Product";
	public static final String VIEW_CUSTOMER_STRING = "View Customer";
	public static final String VIEW_INVOICE_STRING = "View Invoice";
	
	// Strings For CustomerAddFrame
	public static final String CUSTOMER_ADD_FRAME_TITLE = "Add Customer Form";

	public static final String CUSTOMER_NAME_STRING = "Customer Name";
	public static final String CUSTOMER_SURNAME_STRING = "Customer Surname";
	public static final String CUSTOMER_ADDRESS_STRING = "Customer Address";
	public static final String CUSTOMER_PHONE_STRING = "Customer Phone";

	// Strings for ProductAddFrame
	public static final String PRODUCT_ADD_FRAME_TITLE = "Add Product Form";

	public static final String PRODUCT_NAME_STRING = "Product Name";
	public static final String PRODUCT_DESCRIPTION_STRING = "Product Description";
	public static final String PRODUCT_QUANTITY_STRING = "Product Quantity";
	public static final String PRODUCT_UNIT_COST_STRING = "Product Unit Cost";
	
	// Strings For InvoiceAddFrame
	public static final String INVOICE_ADD_FRAME_TITLE = "Add Invoice Form";
	
	
	// Strings For CustomerViewFrame
	public static final String CUSTOMER_VIEW_FRAME_TITLE = "View Customer";

	public Config()
	{
		
	}
}
