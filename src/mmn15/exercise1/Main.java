package mmn15.exercise1;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
        final int FIRST = 0;
        IntegerPool<Integer> integerPool = null;
        String n, m;
        n = JOptionPane.showInputDialog("Please insert the amount of numbers in the Integer Pool: (Enter an integer only)");
        m = JOptionPane.showInputDialog("Please insert the max number of threads: (Enter an integer only)");
        try {
        integerPool = new IntegerPool<>(Integer.parseInt(n), Integer.parseInt(m));
        }
        catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(null, "One of the inserted numbers is not an integer!");
        	System.exit(0);
        }
        
        //System.out.println(integerPool.testSum());
        while(integerPool.size() > 1) {
        	integerPool.waitForThread();
            new Thread(new Sum(integerPool)).start();
        }
        integerPool.waitForAll();
        JOptionPane.showMessageDialog(null, "Sum is: " + integerPool.get(FIRST));
	}

}
