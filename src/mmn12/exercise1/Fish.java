package mmn12.exercise1;

import java.awt.*;

public abstract class Fish extends Animal {
	
	public Fish() {
		super();
	}
	
	public Fish(String name, int age, Color color) {
		super(name, age, color);
	}

	protected abstract void swim();
}
