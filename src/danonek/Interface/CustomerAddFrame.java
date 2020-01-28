package danonek.Interface;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import danonek.Config;

public class CustomerAddFrame 
{
	// Variables
	private JFrame customerAddFrame;

	private JLabel labelCustomerName;
	private JLabel labelCustomerSurname;
	private JLabel labelCustomerAddress;
	private JLabel labelCustomerPhone;

	private JTextField textFieldCustomerName;
	private JTextField textFieldCustomerSurname;
	private JTextField textFieldCustomerAddress;
	private JTextField textFieldCustomerPhone;

	private JButton btnAddCustomer;
	
	public CustomerAddFrame()
	{	
		// Creating the Frame
		customerAddFrame = new JFrame(Config.CUSTOMER_ADD_FRAME_TITLE);
		customerAddFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		customerAddFrame.getContentPane().setLayout(null);
		
		textFieldCustomerName = new JTextField();
		textFieldCustomerName.setBounds(162, 30, 195, 20);
		customerAddFrame.getContentPane().add(textFieldCustomerName);
		textFieldCustomerName.setColumns(10);
		
		labelCustomerName = new JLabel(Config.CUSTOMER_NAME_STRING);
		labelCustomerName.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerName.setBounds(24, 30, 128, 14);
		customerAddFrame.getContentPane().add(labelCustomerName);
		
		labelCustomerSurname = new JLabel(Config.CUSTOMER_SURNAME_STRING);
		labelCustomerSurname.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerSurname.setBounds(24, 76, 128, 14);
		customerAddFrame.getContentPane().add(labelCustomerSurname);
		
		textFieldCustomerSurname = new JTextField();
		textFieldCustomerSurname.setColumns(10);
		textFieldCustomerSurname.setBounds(162, 76, 195, 20);
		customerAddFrame.getContentPane().add(textFieldCustomerSurname);
		
		labelCustomerAddress = new JLabel(Config.CUSTOMER_ADDRESS_STRING);
		labelCustomerAddress.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerAddress.setBounds(24, 125, 128, 14);
		customerAddFrame.getContentPane().add(labelCustomerAddress);
		
		textFieldCustomerAddress = new JTextField();
		textFieldCustomerAddress.setColumns(10);
		textFieldCustomerAddress.setBounds(162, 125, 195, 51);
		customerAddFrame.getContentPane().add(textFieldCustomerAddress);
		
		labelCustomerPhone = new JLabel(Config.CUSTOMER_PHONE_STRING);
		labelCustomerPhone.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerPhone.setBounds(24, 187, 128, 14);
		customerAddFrame.getContentPane().add(labelCustomerPhone);
		
		textFieldCustomerPhone = new JTextField();
		textFieldCustomerPhone.setColumns(10);
		textFieldCustomerPhone.setBounds(162, 187, 195, 20);
		customerAddFrame.getContentPane().add(textFieldCustomerPhone);
		
		btnAddCustomer = new JButton(Config.ADD_CUSTOMER_STRING);
		btnAddCustomer.setBackground(Color.CYAN);
		btnAddCustomer.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 9));
		btnAddCustomer.setBounds(120, 260, 147, 45);
		customerAddFrame.getContentPane().add(btnAddCustomer);
		
		customerAddFrame.setSize(400, 400);
		customerAddFrame.setVisible(true);
		
		Config.LOGGER.log(Level.INFO, "Created CustomerAddFrame.");
	}

	public JTextField getTextFieldCustomerName()
	{
		return textFieldCustomerName;
	}

	public JTextField getTextFieldCustomerSurname()
	{
		return textFieldCustomerSurname;
	}

	public JTextField getTextFieldCustomerAddress()
	{
		return textFieldCustomerAddress;
	}

	public JTextField getTextFieldCustomerPhone()
	{
		return textFieldCustomerPhone;
	}

	public JButton getBtnAddCustomer()
	{
		return btnAddCustomer;
	}

	
}
