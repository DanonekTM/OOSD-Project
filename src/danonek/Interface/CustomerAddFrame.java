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
	private JLabel labelErrorMessage;

	private JTextField textFieldCustomerName;
	private JTextField textFieldCustomerSurname;
	private JTextField textFieldCustomerAddress;
	private JTextField textFieldCustomerPhone;

	
	private JButton btnAddCustomer;
	private JTextField textField;
	
	public CustomerAddFrame()
	{	
		// Creating the Frame
		customerAddFrame = new JFrame(Config.CUSTOMER_ADD_FRAME_TITLE);
		customerAddFrame.getContentPane().setBackground(Color.WHITE);
		customerAddFrame.getContentPane().setLayout(null);
		customerAddFrame.setSize(400, 400);
		customerAddFrame.setResizable(false);
		customerAddFrame.setLocationRelativeTo(null);
		customerAddFrame.setIconImage(Config.ICON.getImage());
		
		
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
		textFieldCustomerAddress.setBounds(162, 123, 195, 20);
		customerAddFrame.getContentPane().add(textFieldCustomerAddress);
		
		labelCustomerPhone = new JLabel(Config.CUSTOMER_PHONE_STRING);
		labelCustomerPhone.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelCustomerPhone.setBounds(24, 171, 128, 14);
		customerAddFrame.getContentPane().add(labelCustomerPhone);
		
		textFieldCustomerPhone = new JTextField();
		textFieldCustomerPhone.setColumns(10);
		textFieldCustomerPhone.setBounds(162, 171, 195, 20);
		customerAddFrame.getContentPane().add(textFieldCustomerPhone);
		
		labelErrorMessage = new JLabel("");
		labelErrorMessage.setVisible(false);
		labelErrorMessage.setBounds(24, 237, 330, 20);
		labelErrorMessage.setForeground(Color.RED);
		customerAddFrame.getContentPane().add(labelErrorMessage);
		
		btnAddCustomer = new JButton(Config.ADD_CUSTOMER_STRING);
		btnAddCustomer.setBackground(Color.LIGHT_GRAY);
		btnAddCustomer.setForeground(Color.BLACK);
		btnAddCustomer.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		btnAddCustomer.setBounds(120, 290, 150, 50);
		customerAddFrame.getContentPane().add(btnAddCustomer);
		
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
	
	public void setErrorMessage(String error)
	{
		labelErrorMessage.setText(error);
		labelErrorMessage.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return customerAddFrame;
	}
}
