package danonek.Interface;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import danonek.Config;

public class CustomerViewFrame
{
	// Variables
	private JFrame customerViewFrame;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable jtbl = new JTable(model);
	
	public CustomerViewFrame()
	{
		// Creating the Frame
		customerViewFrame = new JFrame(Config.CUSTOMER_VIEW_FRAME_TITLE);
		customerViewFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		customerViewFrame.getContentPane().setLayout(null);
		customerViewFrame.setSize(800, 800);
		customerViewFrame.setVisible(true);
		
		customerViewFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
		model.addColumn(Config.CUSTOMER_ID);
		model.addColumn(Config.CUSTOMER_NAME);
		model.addColumn(Config.CUSTOMER_SURNAME);
		model.addColumn(Config.CUSTOMER_ADDRESS);
		model.addColumn(Config.CUSTOMER_PHONE);
		
		JScrollPane pg = new JScrollPane(jtbl);
		pg.setSize(500, 402);
		pg.setLocation(400, 5);
		customerViewFrame.getContentPane().add(pg);		
		customerViewFrame.setVisible(true);
		jtbl.setDefaultEditor(Object.class, null);
	}
	
	public DefaultTableModel getTableModel()
	{
		return model;
	}
	
	public JTable getJTable()
	{
		return jtbl;
	}
}
