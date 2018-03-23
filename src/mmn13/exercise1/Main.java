package mmn13.exercise1;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
        JFrame frame = new JFrame("MyPaint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
	}

}
