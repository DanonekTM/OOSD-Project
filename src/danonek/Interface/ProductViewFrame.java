package danonek.Interface;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import danonek.Config;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ProductViewFrame
{
	// Variables
	private JFrame productViewFrame;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable jtbl = new JTable(model);
	
	private JButton deleteProductBtn;
	private JLabel labelErrorMessage;
	
	public ProductViewFrame()
	{
		// Creating the Frame
		productViewFrame = new JFrame(Config.PRODUCT_VIEW_FRAME_TITLE);
		productViewFrame.getContentPane().setBackground(Color.WHITE);
		productViewFrame.getContentPane().setLayout(null);
		productViewFrame.setSize(700, 500);
		productViewFrame.setVisible(true);
		productViewFrame.setResizable(false);
		productViewFrame.setLocationRelativeTo(null);
		productViewFrame.setIconImage(Config.ICON.getImage());
		
		model.addColumn(Config.PRODUCT_ID_STRING);
		model.addColumn(Config.PRODUCT_NAME_STRING);
		model.addColumn(Config.PRODUCT_DESCRIPTION_STRING);
		model.addColumn(Config.PRODUCT_QUANTITY_STRING);
		model.addColumn(Config.PRODUCT_UNIT_COST_STRING);
		
		JScrollPane pg = new JScrollPane(jtbl);
		pg.setSize(670, 320);
		pg.setLocation(10, 10);
		productViewFrame.getContentPane().add(pg);
		
		
		deleteProductBtn = new JButton(Config.DELETE_PRODUCT_STRING);
		deleteProductBtn.setBackground(Color.LIGHT_GRAY);
		deleteProductBtn.setForeground(Color.BLACK);
		deleteProductBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		deleteProductBtn.setBounds(250, 400, 150, 50);
		productViewFrame.getContentPane().add(deleteProductBtn);
		
		labelErrorMessage = new JLabel("");
		labelErrorMessage.setVisible(false);
		labelErrorMessage.setBounds(250, 354, 150, 20);
		labelErrorMessage.setForeground(Color.RED);
		productViewFrame.getContentPane().add(labelErrorMessage);
		
	
		jtbl.setDefaultEditor(Object.class, null);
		jtbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Config.LOGGER.log(Level.INFO, "Created ProductViewFrame.");
	}
	
	public DefaultTableModel getTableModel()
	{
		return model;
	}
	
	public JTable getJTable()
	{
		return jtbl;
	}
	
	public JButton getDeleteProductBtn()
	{
		return deleteProductBtn;
	}
	
	public void setErrorMessage(String error)
	{
		labelErrorMessage.setText(error);
		labelErrorMessage.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return productViewFrame;
	}
}
