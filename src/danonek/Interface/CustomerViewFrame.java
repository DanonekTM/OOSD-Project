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

public class CustomerViewFrame
{
	// Variables
	private JFrame customerViewFrame;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable jtbl = new JTable(model);
	
	private JButton deleteCustomerBtn;
	private JLabel labelErrorMessage;
	
	public CustomerViewFrame()
	{
		// Creating the Frame
		customerViewFrame = new JFrame(Config.CUSTOMER_VIEW_FRAME_TITLE);
		customerViewFrame.getContentPane().setBackground(Color.WHITE);
		customerViewFrame.getContentPane().setLayout(null);
		customerViewFrame.setSize(700, 500);
		customerViewFrame.setVisible(true);
		customerViewFrame.setResizable(false);
		customerViewFrame.setLocationRelativeTo(null);
		customerViewFrame.setIconImage(Config.ICON.getImage());
		
		model.addColumn(Config.CUSTOMER_ID_STRING);
		model.addColumn(Config.CUSTOMER_NAME_STRING);
		model.addColumn(Config.CUSTOMER_SURNAME_STRING);
		model.addColumn(Config.CUSTOMER_ADDRESS_STRING);
		model.addColumn(Config.CUSTOMER_PHONE_STRING);
		
		JScrollPane pg = new JScrollPane(jtbl);
		pg.setSize(670, 320);
		pg.setLocation(10, 10);
		customerViewFrame.getContentPane().add(pg);
		
		
		deleteCustomerBtn = new JButton(Config.DELETE_CUSTOMER_STRING);
		deleteCustomerBtn.setBackground(Color.LIGHT_GRAY);
		deleteCustomerBtn.setForeground(Color.BLACK);
		deleteCustomerBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		deleteCustomerBtn.setBounds(250, 400, 150, 50);
		customerViewFrame.getContentPane().add(deleteCustomerBtn);
		
		labelErrorMessage = new JLabel("");
		labelErrorMessage.setVisible(false);
		labelErrorMessage.setBounds(250, 354, 150, 20);
		labelErrorMessage.setForeground(Color.RED);
		customerViewFrame.getContentPane().add(labelErrorMessage);
		
	
		jtbl.setDefaultEditor(Object.class, null);
		jtbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Config.LOGGER.log(Level.INFO, "Created CustomerViewFrame.");
	}
	
	public DefaultTableModel getTableModel()
	{
		return model;
	}
	
	public JTable getJTable()
	{
		return jtbl;
	}
	
	public JButton getDeleteCustomerBtn()
	{
		return deleteCustomerBtn;
	}
	
	public void setErrorMessage(String error)
	{
		labelErrorMessage.setText(error);
		labelErrorMessage.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return customerViewFrame;
	}
}
