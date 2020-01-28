package danonek.Interface;
import javax.swing.*;

import danonek.Config;

import java.awt.*;
import java.util.logging.Level;

public class MainFrame 
{
	// Variables
	private JButton addCustomerBtn;
	private JButton addInvoiceBtn;
	private JButton addProductBtn;
	private JButton viewCustomerBtn;
	private JButton viewInvoiceBtn;
	private JButton viewProductBtn;
	private JFrame mainFrame;
	
	public MainFrame()
	{
		// Creating the Frame
		mainFrame = new JFrame(Config.MAIN_FRAME_TITLE);
		mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		mainFrame.getContentPane().setLayout(null);
		
		addCustomerBtn = new JButton(Config.ADD_CUSTOMER_STRING);
		addCustomerBtn.setForeground(Color.BLACK);
		addCustomerBtn.setBackground(Color.CYAN);
		addCustomerBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 8));
		addCustomerBtn.setBounds(36, 41, 100, 55);
		mainFrame.getContentPane().add(addCustomerBtn);

		addInvoiceBtn = new JButton(Config.ADD_INVOICE_STRING);
		addInvoiceBtn.setBackground(Color.CYAN);
		addInvoiceBtn.setForeground(Color.BLACK);
		addInvoiceBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 8));
		addInvoiceBtn.setBounds(36, 173, 100, 55);
		mainFrame.getContentPane().add(addInvoiceBtn);

		addProductBtn = new JButton(Config.ADD_PRODUCT_STRING);
		addProductBtn.setBackground(Color.CYAN);
		addProductBtn.setForeground(Color.BLACK);
		addProductBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 8));
		addProductBtn.setBounds(36, 107, 100, 55);
		mainFrame.getContentPane().add(addProductBtn);
			
		viewInvoiceBtn = new JButton(Config.VIEW_INVOICE_STRING);
		viewInvoiceBtn.setBackground(Color.CYAN);
		viewInvoiceBtn.setForeground(Color.BLACK);
		viewInvoiceBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 8));
		viewInvoiceBtn.setBounds(144, 41, 100, 55);
		mainFrame.getContentPane().add(viewInvoiceBtn);
		
		viewProductBtn = new JButton(Config.VIEW_PRODUCT_STRING);
		viewProductBtn.setBackground(Color.CYAN);
		viewProductBtn.setForeground(Color.BLACK);
		viewProductBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 8));
		viewProductBtn.setBounds(144, 173, 100, 55);
		mainFrame.getContentPane().add(viewProductBtn);
		
		viewCustomerBtn = new JButton(Config.VIEW_CUSTOMER_STRING);
		viewCustomerBtn.setBackground(Color.CYAN);
		viewCustomerBtn.setForeground(Color.BLACK);
		viewCustomerBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 8));
		viewCustomerBtn.setBounds(144, 107, 100, 55);
		mainFrame.getContentPane().add(viewCustomerBtn);
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300,300);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		
		
		Config.LOGGER.log(Level.INFO, "Created MainFrame.");
	}

	public JButton getAddCustomerBtn() 
	{
		return addCustomerBtn;
	}

	public JButton getAddInvoiceBtn() 
	{
		return addInvoiceBtn;
	}

	public JButton getAddProductBtn() 
	{
		return addProductBtn;
	}

	public JButton getViewCustomerBtn() 
	{
		return viewCustomerBtn;
	}

	public JButton getViewInvoiceBtn() 
	{
		return viewInvoiceBtn;
	}

	public JButton getViewProductBtn() 
	{
		return viewProductBtn;
	}
}