package mmn12.exercise1;

import java.awt.*;

public class Snake extends Reptile {

	public Snake() {
		super();
	}
	
	public Snake(String name, int age, Color color) {
		super(name, age, color);
	}
	
	@Override
	public void eat() {
		System.out.println("Snake eats his prey whole.");
	}

	@Override
	public void sleep() {
		System.out.println("Snake sleeps with his eyes open.");
	}

	@Override
	public Snake clone() {
		return new Snake(this.name, this.age, this.color);
	}
}
