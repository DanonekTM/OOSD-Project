package danonek.Interface;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
			
		SwingUtilities.invokeLater(new Runnable() {

			//methods
			public void run() {
				new MainFrame();

							
			} });
		


	}

}
