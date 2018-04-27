package mmn15.exercise1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Sum implements Runnable {

	private LinkedList<Integer> integerPool;
	
	public Sum() {
		super();
	}
	
	public Sum(LinkedList<Integer> integerPool) {
		this.integerPool = integerPool;
	}

	@Override
	public void run() {
		Integer firstNumber = null, secondNumber = null;
		try {
			firstNumber = integerPool.remove();
			secondNumber = integerPool.remove();
			integerPool.add(firstNumber + secondNumber);
		}
		catch(NoSuchElementException e) {
			if(firstNumber == null) {
				System.out.println("Integer Pool is empty!\n");
			}
			else {
				System.out.println("Integer Pool only has one number!\n");
			}
		}
	}

}
