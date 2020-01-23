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
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(60dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel CustomerNameLabel = new JLabel("Customer Name :");
		CustomerNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(CustomerNameLabel, "4, 4, right, default");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField, "6, 4");
		
		JLabel lblNewLabel_4 = new JLabel("Product name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_4, "8, 4");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_1, "10, 4, 6, 1, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Customer Adress :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_1, "4, 10, right, default");
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_4, "6, 10, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Product Qty :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_5, "8, 10");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_2, "10, 10, 6, 1, fill, default");
		
		JLabel lblNewLabel_2 = new JLabel("Customer phone :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_2, "4, 16, right, default");
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_5, "6, 16, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("Product Price :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_6, "8, 16");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField_3, "10, 16, 6, 1, fill, default");
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnAdd, "4, 24, 2, 3");
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnUpdate, "6, 24, 1, 3");
		
		JButton btnRetrieve = new JButton("RETRIEVE");
		btnRetrieve.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnRetrieve, "7, 24, 3, 3");
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnDelete, "12, 24, 3, 3");

	
		frame.setVisible(true);
	}//body
}//class