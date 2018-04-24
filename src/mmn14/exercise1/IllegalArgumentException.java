package mmn14.exercise1;

@SuppressWarnings("serial")
public class IllegalArgumentException extends Exception {
	
	public IllegalArgumentException() {
		super("Number of keys and values not equal!\n");
	}
}
