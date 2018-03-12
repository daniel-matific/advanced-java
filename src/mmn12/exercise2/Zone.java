package mmn12.exercise2;

import java.security.SecureRandom;

public class Zone {
	private boolean currentState;
	private boolean nextState;
	private static SecureRandom random = new SecureRandom();
	
	public Zone() {
		currentState = random.nextBoolean();
	}
	
	public boolean getCurrentState() {
		return currentState;
	}
	
	public boolean getNextState() {
		return nextState;
	}
	
	public void setCurrentState(boolean state) {
		currentState = state;
	}
	
	public void setNextState(boolean state) {
		nextState = state;
	}
}
