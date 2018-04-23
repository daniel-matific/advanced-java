package mmn13.exercise1;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame("MyPaint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300,400));
		frame.add(new MainPanel());
		frame.pack();
		frame.setVisible(true);
	} 
}
