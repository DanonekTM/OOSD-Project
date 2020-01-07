package danonek.Interface;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

	public class MainFrame extends JFrame {
	
		private JTextArea textArea;
		private JButton btn;
	
			public MainFrame () {
			super ("User Interface");
			
			setLayout(new BorderLayout());
			
			
			textArea = new JTextArea();
			btn = new JButton("CLick me ");
			
			add(textArea,BorderLayout.CENTER);
			add(btn, BorderLayout.SOUTH);
			
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setSize(600,600);
}//frame

} //main