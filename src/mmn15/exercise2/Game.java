package mmn15.exercise2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import mmn13.exercise2.Category;
import mmn13.exercise2.MenuPage;
import mmn13.exercise2.Order;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {
	
	private JPanel mainPanel;
	private GameOfLife gameOfLife;
	private JButton restart;
	private int size;
	
	public Game(int size) {
		setTitle("Game Of Life");
		mainPanel = new JPanel(new BorderLayout());
		restart = new JButton("Restart");
        restart.addActionListener(this);
        this.size = size;
        gameOfLife = new GameOfLife(size);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.add(gameOfLife, BorderLayout.CENTER);
        mainPanel.add(restart, BorderLayout.SOUTH);
        add(mainPanel);
        pack();
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == restart) {
			/*removeAll();
			getContentPane().removeAll();

			mainPanel = new JPanel(new BorderLayout());
			//restart = new JButton("Restart");
			gameOfLife = new GameOfLife(size);
	        mainPanel.add(gameOfLife, BorderLayout.CENTER);
	        //mainPanel.add(restart, BorderLayout.SOUTH);
	        add(mainPanel);
			//revalidate();
			//repaint();
			pack();
	        setVisible(true);*/
		}
	}
	
	public GameOfLife getGameOfLife() {
		return gameOfLife;
	}
}
