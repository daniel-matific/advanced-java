package mmn15.exercise1;

import java.security.SecureRandom;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class IntegerPool<I> extends LinkedList<Integer> {
	
	private static final int MAX_NUMBER = 100;
	private static final SecureRandom randomNumbers = new SecureRandom();

	public IntegerPool() {
		super();
	}
	
	public IntegerPool(int n) {
		for(; n > 0; n--) {
			add(new Integer(randomNumbers.nextInt(MAX_NUMBER+1)));
		}
	}
	
}
