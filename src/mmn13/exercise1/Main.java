package mmn13.exercise1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
        JFrame frame = new JFrame("MyPaint");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        OutputPanel outputPanel = new OutputPanel();
        ButtonPanel buttonPanel = new ButtonPanel();
        frame.add(outputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
	}

}
