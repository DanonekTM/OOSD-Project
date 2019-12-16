package danonek.Interface;
import javax.swing.*;
import java.awt.*;
/*• Front end GUI
– Should provide CRUD (create, retrieve, update,delete) operations
on the database
– Should demonstrate use of a variety of Swing components (Buttons, Textboxes, etc.)*/



public class Gui 
{
    public static void main(String args[]) {
    	
    //Creating the Frame
    JFrame frame = new JFrame("Chat Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 800);

    //Creating the MenuBar and adding components
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("FILE");
    JMenu m2 = new JMenu("Help");
    mb.add(m1);
    mb.add(m2);
    JMenuItem m11 = new JMenuItem("Open");
    JMenuItem m22 = new JMenuItem("Save as");
    m1.add(m11);
    m1.add(m22);

    //Creating the panel at bottom and adding components
    JPanel panel = new JPanel(); // the panel is not visible in output
    JLabel label = new JLabel("Enter Text");
    JTextField tf = new JTextField(10); // accepts upto 10 characters
    JButton create = new JButton("Create");
    JButton retrieve = new JButton("Retrieve");
    JButton update = new JButton("Update");
    JButton reset = new JButton("delete");
    panel.add(label); // Components Added using Flow Layout
    panel.add(label); // Components Added using Flow Layout
    panel.add(tf);
    panel.add(create);
    panel.add(retrieve);
    panel.add(update);
    panel.add(reset);


    // Text Area at the Center
    JTextArea ta = new JTextArea();

    //Adding Components to the frame.
    frame.getContentPane().add(BorderLayout.SOUTH, panel);
    frame.getContentPane().add(BorderLayout.NORTH, mb);
    frame.getContentPane().add(BorderLayout.CENTER, ta);
    frame.setVisible(true);



	 }//body
}//class
