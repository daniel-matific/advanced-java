package mmn15.exercise2;

import java.awt.Color;
import java.awt.Dimension;
import java.security.SecureRandom;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Zone extends JPanel {

	private boolean currentState;
	private boolean nextState;
	private static SecureRandom random = new SecureRandom();
	
	public Zone() {
		currentState = random.nextBoolean();
		setPreferredSize(new Dimension(30, 30)); 
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		if (currentState) {
			setBackground(Color.DARK_GRAY);
		}
		else {
			setBackground(Color.WHITE);
		}
	}
	
	public void updateZone() {
		if (currentState) {
			setBackground(Color.DARK_GRAY);
		}
		else {
			setBackground(Color.WHITE);
		}
	}
	
	public boolean getCurrentState() {
		return currentState;
	}
	
	public boolean getNextState() {
		return nextState;
	}
	
	public void setCurrentState() {
		currentState = nextState;
	}
	
	public void setNextState(boolean state) {
		nextState = state;
	}
}
