package danonek.Interface;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import danonek.Config;
import javax.swing.JComboBox;

public class InvoiceAddFrame 
{
	// Variables
	private JFrame InvoiceAddFrame;

	private JLabel labelCustomerName;
	private JLabel labelProductName;
	private JLabel labelCustomerPhone;
	private JLabel labelErrorMessage;
	private JTextField textFieldQuantity;

	private JButton btnAddInvoice;
	private JComboBox<String> customerNameBox = new JComboBox<>();
	private JComboBox<String> productNameBox = new JComboBox<>();
	
	public InvoiceAddFrame()
	{	
		// Creating the Frame
		InvoiceAddFrame = new JFrame(Config.INVOICE_ADD_FRAME_TITLE);
		InvoiceAddFrame.getContentPane().setBackground(Color.WHITE);
		InvoiceAddFrame.getContentPane().setLayout(null);
		InvoiceAddFrame.setSize(400, 400);
		InvoiceAddFrame.setResizable(false);
		InvoiceAddFrame.setLocationRelativeTo(null);
		InvoiceAddFrame.setIconImage(Config.ICON.getImage());
		
		labelCustomerName = new JLabel(Config.CUSTOMER_NAME_STRING);
		labelCustomerName.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerName.setBounds(24, 30, 128, 14);
		InvoiceAddFrame.getContentPane().add(labelCustomerName);
		
		customerNameBox.setBounds(162, 30, 195, 20);
		InvoiceAddFrame.getContentPane().add(customerNameBox);
	
		
		labelProductName = new JLabel(Config.PRODUCT_NAME_STRING);
		labelProductName.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelProductName.setBounds(24, 76, 128, 14);
		InvoiceAddFrame.getContentPane().add(labelProductName);
		
		productNameBox.setBounds(162, 76, 195, 20);
		InvoiceAddFrame.getContentPane().add(productNameBox);
		
		labelCustomerPhone = new JLabel("Product Quantity");
		labelCustomerPhone.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerPhone.setBounds(24, 122, 128, 14);
		InvoiceAddFrame.getContentPane().add(labelCustomerPhone);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(162, 120, 195, 20);
		InvoiceAddFrame.getContentPane().add(textFieldQuantity);
		
		labelErrorMessage = new JLabel("");
		labelErrorMessage.setVisible(false);
		labelErrorMessage.setBounds(24, 237, 330, 20);
		labelErrorMessage.setForeground(Color.RED);
		InvoiceAddFrame.getContentPane().add(labelErrorMessage);
		
		btnAddInvoice = new JButton(Config.ADD_INVOICE_STRING);
		btnAddInvoice.setBackground(Color.LIGHT_GRAY);
		btnAddInvoice.setForeground(Color.BLACK);
		btnAddInvoice.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		btnAddInvoice.setBounds(120, 290, 150, 50);
		InvoiceAddFrame.getContentPane().add(btnAddInvoice);
		
		InvoiceAddFrame.setVisible(true);
		Config.LOGGER.log(Level.INFO, "Created InvoiceAddFrame.");
	}

	public JTextField getTextFieldQuantity()
	{
		return textFieldQuantity;
	}

	public JButton getBtnAddInvoice()
	{
		return btnAddInvoice;
	}
	
	public JComboBox<String> getCustomerNameBox()
	{
		return customerNameBox;
	}
	
	public JComboBox<String> getProductNameBox()
	{
		return productNameBox;
	}
	
	public void setErrorMessage(String error)
	{
		labelErrorMessage.setText(error);
		labelErrorMessage.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return InvoiceAddFrame;
	}
}
