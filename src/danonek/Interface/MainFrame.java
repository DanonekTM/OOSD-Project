package danonek.Interface;
import javax.swing.*;

import java.awt.*;

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
		mainFrame = new JFrame("Invoice Managment");
		mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		mainFrame.getContentPane().setLayout(null);
		
		addCustomerBtn = new JButton("Add Customer");
		addCustomerBtn.setForeground(Color.BLACK);
		addCustomerBtn.setBackground(Color.CYAN);
		addCustomerBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		addCustomerBtn.setBounds(36, 41, 100, 55);
		mainFrame.getContentPane().add(addCustomerBtn);
		
		viewInvoiceBtn = new JButton("View Invoice");
		viewInvoiceBtn.setBackground(Color.CYAN);
		viewInvoiceBtn.setForeground(Color.BLACK);
		viewInvoiceBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		viewInvoiceBtn.setBounds(36, 173, 100, 55);
		mainFrame.getContentPane().add(viewInvoiceBtn);
		
		viewProductBtn = new JButton("View Product");
		viewProductBtn.setBackground(Color.CYAN);
		viewProductBtn.setForeground(Color.BLACK);
		viewProductBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		viewProductBtn.setBounds(144, 173, 100, 55);
		mainFrame.getContentPane().add(viewProductBtn);
		
		addInvoiceBtn = new JButton("Add Invoice");
		addInvoiceBtn.setBackground(Color.CYAN);
		addInvoiceBtn.setForeground(Color.BLACK);
		addInvoiceBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		addInvoiceBtn.setBounds(144, 41, 100, 55);
		mainFrame.getContentPane().add(addInvoiceBtn);
		
		addProductBtn = new JButton("Add Product");
		addProductBtn.setBackground(Color.CYAN);
		addProductBtn.setForeground(Color.BLACK);
		addProductBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		addProductBtn.setBounds(36, 107, 100, 55);
		mainFrame.getContentPane().add(addProductBtn);
		
		viewCustomerBtn = new JButton("View Customer");
		viewCustomerBtn.setBackground(Color.CYAN);
		viewCustomerBtn.setForeground(Color.BLACK);
		viewCustomerBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
		viewCustomerBtn.setBounds(144, 107, 100, 55);
		mainFrame.getContentPane().add(viewCustomerBtn);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300,300);
		mainFrame.setVisible(true);
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