package mmn13.exercise2;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				File menu = new File("menu.txt"); // Default path is the directory of the project
				JFrame frame = new JFrame("My Restaurant");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(400,400));
				frame.add(new Menu(menu));
				frame.pack();
				frame.setVisible(true);
			}
		});  
	} 
}