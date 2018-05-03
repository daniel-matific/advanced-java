package mmn15.exercise2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			mainPanel.removeAll();
			gameOfLife = new GameOfLife(size);
			mainPanel.add(gameOfLife, BorderLayout.CENTER);
			mainPanel.add(restart, BorderLayout.SOUTH);
			add(mainPanel);
			revalidate();
			repaint();
		}
	}
	
	public GameOfLife getGameOfLife() {
		return gameOfLife;
	}
}
