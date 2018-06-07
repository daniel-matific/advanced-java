package mmn15.exercise1;

import java.util.NoSuchElementException;

public class Sum implements Runnable {

	private IntegerPool<Integer> integerPool;
	
	public Sum(IntegerPool<Integer> integerPool) {
		this.integerPool = integerPool;
	}

	// sums the first two integers from the pool
	@Override
	public void run() {
		synchronized(integerPool) {
			if(integerPool.size() > 1) {
				Integer firstNumber, secondNumber;
				try {
					firstNumber = integerPool.remove();
					secondNumber = integerPool.remove();
					integerPool.add(firstNumber + secondNumber);
				}
				catch(NoSuchElementException e) {}
			}
			integerPool.finished();
		}
	}

}
