package mmn15.exercise2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameOfLife extends JFrame implements ActionListener {
	
	protected Zone[][] matrix;
	private JPanel panel;
	private JButton restart;
	private int size;
	private int activeThreads;
	private Lock lock;
	private Condition condition;
	ArrayList<Thread> threads = new ArrayList<Thread>();
	
	// creates matrix of Zones in the supplied size
    public GameOfLife(int size) {
        super("Game of Life");
        
        activeThreads = 0;
        lock = new ReentrantLock();
        condition = lock.newCondition();
        
        panel = new JPanel(new BorderLayout());
        restart = new JButton("Restart");
        restart.addActionListener(this);
        this.size = size;
        
        matrix = new Zone[size][size];
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		matrix[i][j] = new Zone();
        	}
        }
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visualizeMatrix(getContentPane(), matrix, size);
        panel.add(restart, BorderLayout.SOUTH);
        add(panel);
        pack();
        setVisible(true);
    }
    
    // adds the matrix of Zones to the JFrame
    public void visualizeMatrix(final Container pane, Zone[][] matrix, int size) {
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(size, size));
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		gridPanel.add(matrix[i][j]);
        	}
        }
        panel.add(gridPanel, BorderLayout.CENTER);
    }
    
    // calls a function to compute the next state of each Zone and then updates all Zones
    public void nextGeneration() {
        for (int i = 0; i < matrix[0].length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		Thread thread = new Thread(new GenerateNextState(i, j, this));
        		threads.add(thread);
        		thread.start();
        	}
        }
        waitForAll();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == restart) {
			for(Thread thread : threads) {
					thread.interrupt();
			}
			threads = new ArrayList<Thread>();
			
	        for (int i = 0; i < size; i++) {
	        	for (int j = 0; j < size; j++) {
	        		matrix[i][j] = new Zone();
	        	}
	        }

	        visualizeMatrix(getContentPane(), matrix, size);
	        panel.add(restart, BorderLayout.SOUTH);
	        add(panel);
	        pack();
		}
	}
	
    public void finished()
    {
    	lock.lock();
        activeThreads--;
        condition.signalAll();
        lock.unlock();
    }
	
    public void waitForAll()
    {
    	lock.lock();
        while(activeThreads > 0) {
            try {
            	condition.await();
            }
            catch(InterruptedException e){}
        }
        lock.unlock();
    }
    
    public void increaseActiveThreads() {
    	activeThreads++;
    }
}
