package mmn13.exercise1;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Shape extends JPanel {
	protected int x, y, size;
	protected Color color;
	protected boolean isFilled;
}
