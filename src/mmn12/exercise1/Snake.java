package mmn12.exercise1;

import java.awt.Color;

public class Snake extends Reptile {

	public Snake() {
		name = "";
		age = 0;
		color = new Color(0);
	}
	
	public Snake(String name, int age, Color color) {
		this.name = name;
		this.age = age;
		this.color = color;
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
