package danonek.Interface;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import danonek.Config;

public class ProductAddFrame 
{
	// Variables
	private JFrame addProductFrame;

	private JLabel labelProductName;
	private JLabel LabelProductDescription;
	private JLabel LabelProductQuantity;
	private JLabel LabelProductUnitCost;
	private JLabel labelErrorMessage;

	private JTextField textFieldProductName;
	private JTextField textFieldProductDescription;
	private JTextField textFieldProductQuantity;
	private JTextField textFieldProductUnitPrice;

	private JButton btnAddProduct;
	
	public ProductAddFrame()
	{
		// Creating the Frame
		addProductFrame = new JFrame(Config.PRODUCT_ADD_FRAME_TITLE);
		addProductFrame.getContentPane().setBackground(Color.WHITE);
		addProductFrame.getContentPane().setLayout(null);
		addProductFrame.setSize(400, 400);
		addProductFrame.setResizable(false);
		addProductFrame.setLocationRelativeTo(null);
		addProductFrame.setIconImage(Config.ICON.getImage());

		textFieldProductName = new JTextField();
		textFieldProductName.setBounds(162, 30, 195, 20);
		addProductFrame.getContentPane().add(textFieldProductName);
		textFieldProductName.setColumns(10);

		labelProductName = new JLabel(Config.PRODUCT_NAME_STRING);
		labelProductName.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		labelProductName.setBounds(24, 30, 128, 14);
		addProductFrame.getContentPane().add(labelProductName);

		LabelProductDescription = new JLabel(Config.PRODUCT_DESCRIPTION_STRING);
		LabelProductDescription.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		LabelProductDescription.setBounds(24, 76, 128, 14);
		addProductFrame.getContentPane().add(LabelProductDescription);

		textFieldProductDescription = new JTextField();
		textFieldProductDescription.setColumns(10);
		textFieldProductDescription.setBounds(162, 76, 195, 20);
		addProductFrame.getContentPane().add(textFieldProductDescription);

		LabelProductQuantity = new JLabel(Config.PRODUCT_QUANTITY_STRING);
		LabelProductQuantity.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		LabelProductQuantity.setBounds(24, 125, 128, 14);
		addProductFrame.getContentPane().add(LabelProductQuantity);

		textFieldProductQuantity = new JTextField();
		textFieldProductQuantity.setColumns(10);
		textFieldProductQuantity.setBounds(162, 125, 195, 20);
		addProductFrame.getContentPane().add(textFieldProductQuantity);

		LabelProductUnitCost = new JLabel(Config.PRODUCT_UNIT_COST_STRING);
		LabelProductUnitCost.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		LabelProductUnitCost.setBounds(24, 172, 128, 14);
		addProductFrame.getContentPane().add(LabelProductUnitCost);

		textFieldProductUnitPrice = new JTextField();
		textFieldProductUnitPrice.setColumns(10);
		textFieldProductUnitPrice.setBounds(162, 172, 195, 20);
		addProductFrame.getContentPane().add(textFieldProductUnitPrice);

		labelErrorMessage = new JLabel("");
		labelErrorMessage.setVisible(false);
		labelErrorMessage.setBounds(24, 237, 330, 20);
		labelErrorMessage.setForeground(Color.RED);
		addProductFrame.getContentPane().add(labelErrorMessage);

		btnAddProduct = new JButton(Config.ADD_PRODUCT_STRING);
		btnAddProduct.setBackground(Color.LIGHT_GRAY);
		btnAddProduct.setForeground(Color.BLACK);
		btnAddProduct.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		btnAddProduct.setBounds(120, 290, 150, 50);
		addProductFrame.getContentPane().add(btnAddProduct);
		
		addProductFrame.setVisible(true);
		Config.LOGGER.log(Level.INFO, "Created ProductAddFrame.");
	}
	
	public JTextField getTextFieldProductName() 
	{
		return textFieldProductName;
	}

	public JTextField getTextFieldProductDescription()
	{
		return textFieldProductDescription;
	}

	public JTextField getTextFieldProductQuantity() 
	{
		return textFieldProductQuantity;
	}

	public JTextField getTextFieldProductUnitPrice() 
	{
		return textFieldProductUnitPrice;
	}

	public void setErrorMessage(String error)
	{
		labelErrorMessage.setText(error);
		labelErrorMessage.setVisible(true);
	}

	public JButton getBtnAddProduct()
	{
		return btnAddProduct;
	}

	public JFrame getFrame()
	{
		return addProductFrame;
	}
	
}
