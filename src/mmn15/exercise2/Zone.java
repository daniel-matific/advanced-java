package mmn15.exercise2;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

@SuppressWarnings("serial")
public class Zone extends JPanel {

	private boolean currentState;
	private boolean nextState;
	private static SecureRandom random = new SecureRandom();

	// constructor of Zone panel
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

	// updates the panel according to current state
	public void updateZone() {
		if (currentState) {
			setBackground(Color.DARK_GRAY);
		}
		else {
			setBackground(Color.WHITE);
		}
	}

	// returns current state
	public boolean getCurrentState() {
		return currentState;
	}

	// sets current state
	public void setCurrentState() {
		currentState = nextState;
	}

	// sets next state
	public void setNextState(boolean state) {
		nextState = state;
	}
}
