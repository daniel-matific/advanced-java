package mmn13.exercise2;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				File menu = new File("C:\\workspace\\advanced-java\\bin\\mmn13\\exercise2\\menu.txt");
				JFrame frame = new JFrame("My Restaraunt");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(400,400));
				frame.add(new Menu(menu));
				frame.pack();
				frame.setVisible(true);
			}
		});  
	} 
}