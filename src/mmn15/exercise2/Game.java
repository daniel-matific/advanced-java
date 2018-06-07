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

	// constructs the game of life and gui
	public Game(int size) {
		setTitle("Game Of Life");
		mainPanel = new JPanel(new BorderLayout());
		restart = new JButton("Restart");
        restart.addActionListener(this);
        this.size = size;
        gameOfLife = new GameOfLife(size);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.add(gameOfLife, BorderLayout.CENTER);
        mainPanel.add(restart, BorderLayout.SOUTH);
        add(mainPanel);
        pack();
        setVisible(true);
	}

	// restarts the game upon clicking the restart button
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

	// returns GameOfLife
	public GameOfLife getGameOfLife() {
		return gameOfLife;
	}
}
