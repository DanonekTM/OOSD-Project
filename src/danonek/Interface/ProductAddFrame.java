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

	private JTextField textFieldProductName;
	private JTextField textFieldProductDescription;
	private JTextField textFieldProductQuantity;
	private JTextField textFieldProductUnitPrice;

	private JButton btnAddProduct;
	
	public ProductAddFrame()
	{
		// Creating the Frame
		addProductFrame = new JFrame(Config.PRODUCT_ADD_FRAME_TITLE);
		addProductFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addProductFrame.getContentPane().setLayout(null);

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
		textFieldProductQuantity.setBounds(162, 125, 195, 45);
		addProductFrame.getContentPane().add(textFieldProductQuantity);

		LabelProductUnitCost = new JLabel(Config.PRODUCT_UNIT_COST_STRING);
		LabelProductUnitCost.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		LabelProductUnitCost.setBounds(24, 187, 128, 14);
		addProductFrame.getContentPane().add(LabelProductUnitCost);

		textFieldProductUnitPrice = new JTextField();
		textFieldProductUnitPrice.setColumns(10);
		textFieldProductUnitPrice.setBounds(162, 187, 195, 20);
		addProductFrame.getContentPane().add(textFieldProductUnitPrice);

		btnAddProduct = new JButton(Config.ADD_PRODUCT_STRING);
		btnAddProduct.setBackground(Color.CYAN);
		btnAddProduct.setFont(new Font(Config.FONT_NAME, Font.BOLD | Font.ITALIC, 9));
		btnAddProduct.setBounds(120, 260, 147, 45);
		addProductFrame.getContentPane().add(btnAddProduct);

		addProductFrame.setSize(400, 400);
		addProductFrame.setVisible(true);
		
		Config.LOGGER.log(Level.INFO, "Created AddProductFrame.");
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

	public JButton getBtnAddProduct()
	{
		return btnAddProduct;
	}
	
}
