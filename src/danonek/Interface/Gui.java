package danonek.Interface;
import javax.swing.*;

import java.awt.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;


public class Gui 
{
	public Gui()
	{
		//Creating the Frame
		JFrame frame = new JFrame("Invoice Managment");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				
		//dividing the mainframe
				
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(60dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//Labels and text fields 
		
		JLabel CustomerNameLabel = new JLabel("Customer Name :");
		CustomerNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(CustomerNameLabel, "4, 4");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField, "5, 4, 3, 1");
		
		JLabel lblNewLabel_4 = new JLabel("Product name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_4, "12, 4, 7, 1");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_1, "19, 4, 9, 1, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Customer Adress :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_1, "4, 10");
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_4, "5, 10, 3, 1, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Product Qty :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_5, "12, 10, 7, 1");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_2, "19, 10, 9, 1, fill, default");
		
		JLabel lblNewLabel_2 = new JLabel("Customer phone :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_2, "4, 16");
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_5, "5, 16, 3, 1");
		
		JLabel lblNewLabel_6 = new JLabel("Product Price :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_6, "12, 16, 7, 1");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_3, "19, 16, 9, 1, fill, default");
		
		//buttons on panel1
		
		JPanel btnpanel = new JPanel();
		frame.getContentPane().add(btnpanel, "1, 23, 34, 3, fill, fill");
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpanel.add(btnAdd);
		
		JButton btnUpd = new JButton("UPDATE");
		btnUpd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpanel.add(btnUpd);
		
		JButton btnRet = new JButton("RETRIEVE");
		btnRet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpanel.add(btnRet);
		
		JButton btnDel = new JButton("DELETE");
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpanel.add(btnDel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Customer Database");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product Database");
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(btnNewButton_1);
		
		//Action Listeners
		
		JButton.addActionListener(new ActionListener()
				{
			
				});
				


	
		frame.setVisible(true);
	}//body
}//class