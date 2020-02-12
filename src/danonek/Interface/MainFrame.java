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
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500,500);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setIconImage(Config.ICON.getImage());
		
		addCustomerBtn = new JButton(Config.ADD_CUSTOMER_STRING);
		addCustomerBtn.setBackground(Color.LIGHT_GRAY);
		addCustomerBtn.setForeground(Color.BLACK);
		addCustomerBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		addCustomerBtn.setBounds(80, 50, 140, 90);
		mainFrame.getContentPane().add(addCustomerBtn);

		addInvoiceBtn = new JButton(Config.ADD_INVOICE_STRING);
		addInvoiceBtn.setBackground(Color.LIGHT_GRAY);
		addInvoiceBtn.setForeground(Color.BLACK);
		addInvoiceBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		addInvoiceBtn.setBounds(80, 300, 140, 90);
		mainFrame.getContentPane().add(addInvoiceBtn);

		addProductBtn = new JButton(Config.ADD_PRODUCT_STRING);
		addProductBtn.setBackground(Color.LIGHT_GRAY);
		addProductBtn.setForeground(Color.BLACK);
		addProductBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		addProductBtn.setBounds(80, 180, 140, 90);
		mainFrame.getContentPane().add(addProductBtn);
			
		viewInvoiceBtn = new JButton(Config.VIEW_INVOICE_STRING);
		viewInvoiceBtn.setBackground(Color.LIGHT_GRAY);
		viewInvoiceBtn.setForeground(Color.BLACK);
		viewInvoiceBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		viewInvoiceBtn.setBounds(280, 50, 140, 90);
		mainFrame.getContentPane().add(viewInvoiceBtn);
		
		viewProductBtn = new JButton(Config.VIEW_PRODUCT_STRING);
		viewProductBtn.setBackground(Color.LIGHT_GRAY);
		viewProductBtn.setForeground(Color.BLACK);
		viewProductBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		viewProductBtn.setBounds(280, 300, 140, 90);
		mainFrame.getContentPane().add(viewProductBtn);
		
		viewCustomerBtn = new JButton(Config.VIEW_CUSTOMER_STRING);
		viewCustomerBtn.setBackground(Color.LIGHT_GRAY);
		viewCustomerBtn.setForeground(Color.BLACK);
		viewCustomerBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		viewCustomerBtn.setBounds(280, 180, 140, 90);
		mainFrame.getContentPane().add(viewCustomerBtn);
		
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