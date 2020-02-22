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
import javax.swing.JComboBox;

public class CustomerFilterView
{
	// Variables
	private JFrame customerFilterView;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable jtbl = new JTable(model);
	private JScrollPane pg = new JScrollPane(jtbl);
	
	private JButton viewCustomerBtn;
	private JComboBox<String> comboBox = new JComboBox<>();
	
	public CustomerFilterView()
	{
		// Creating the Frame
		customerFilterView = new JFrame(Config.CUSTOMER_FILTER_FRAME_TITLE);
		customerFilterView.getContentPane().setBackground(Color.WHITE);
		customerFilterView.getContentPane().setLayout(null);
		customerFilterView.setSize(700, 500);
		customerFilterView.setResizable(false);
		customerFilterView.setLocationRelativeTo(null);
		customerFilterView.setIconImage(Config.ICON.getImage());
	
		model.addColumn(Config.INVOICE_ID_STRING);
		model.addColumn(Config.CUSTOMER_ID_STRING);
		model.addColumn(Config.PRODUCT_ID_STRING);
		model.addColumn(Config.PRODUCT_NAME_STRING);
		model.addColumn(Config.PRODUCT_QUANTITY_STRING);
		
		pg.setSize(670, 320);
		pg.setLocation(10, 10);
		customerFilterView.getContentPane().add(pg);
		
		viewCustomerBtn = new JButton(Config.VIEW_CUSTOMER_STRING);
		viewCustomerBtn.setBackground(Color.LIGHT_GRAY);
		viewCustomerBtn.setForeground(Color.BLACK);
		viewCustomerBtn.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		viewCustomerBtn.setBounds(250, 400, 150, 50);
		customerFilterView.getContentPane().add(viewCustomerBtn);
		
		comboBox.setFont(new Font(Config.FONT_NAME, Font.BOLD, 12));
		comboBox.setBounds(250, 354, 150, 20);
		customerFilterView.getContentPane().add(comboBox);
		
		jtbl.setDefaultEditor(Object.class, null);
		jtbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		customerFilterView.setVisible(true);
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
	
	public JButton getViewCustomerBtn()
	{
		return viewCustomerBtn;
	}
	
	public JComboBox<String> getComboBox()
	{
		return comboBox;
	}
	
	public JFrame getFrame()
	{
		return customerFilterView;
	}
}
