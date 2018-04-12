package mmn12.exercise1;

import java.awt.Color;

public abstract class Bird extends Animal {
	
	public Bird() {
		super();
	}
	
	public Bird(String name, int age, Color color) {
		super(name, age, color);
	}
	
	protected abstract void fly();
}
