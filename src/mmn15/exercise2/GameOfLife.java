package mmn15.exercise2;

import java.awt.GridLayout;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameOfLife extends JPanel {
	
	protected Zone[][] matrix;
	private int activeThreads;
	private Lock lock;
	private Condition condition;
	
	// creates matrix of Zones in the supplied size
    public GameOfLife(int size) {
    	
        activeThreads = 0;
        lock = new ReentrantLock();
        condition = lock.newCondition();
        
        matrix = new Zone[size][size];
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		matrix[i][j] = new Zone();
        	}
        }
        
        for(int j = 0; j < 10; j++) {
        	matrix[10][j+10].setNextState(true);
        	matrix[10][j+10].setCurrentState();
        	matrix[10][j+10].updateZone();
        }
        
        visualizeMatrix(matrix, size);
    }
    
    // adds the matrix of Zones to the JFrame
    public void visualizeMatrix(Zone[][] matrix, int size) {
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(size, size));
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		gridPanel.add(matrix[i][j]);
        	}
        }
        add(gridPanel);
    }
    
    // calls a function to compute the next state of each Zone and then updates all Zones
    public void nextGeneration() {
        for (int i = 0; i < matrix[0].length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		lock.lock();
        		activeThreads++;
        		lock.unlock();
        		new Thread(new GenerateNextState(i, j, this)).start();
        	}
        }
        waitForAll();
    }

	/*@Override
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

	        visualizeMatrix(matrix, size);
	        panel.add(restart, BorderLayout.SOUTH);
	        add(panel);
	        pack();
		}
	}*/
	
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
    	lock.lock();
    	activeThreads++;
    	lock.unlock();
    }
}
