package mmn12.exercise1;

import java.awt.Color;

public class Sardine extends Fish {
	
	public Sardine() {
		name = "";
		age = 0;
		color = new Color(0);
	}
	
	public Sardine(String name, int age, Color color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public void eat() {
		System.out.println("Sardine eats plankton.");
	}

	@Override
	public void sleep() {
		System.out.println("Sardine doesn't sleep, it just rests.");
	}

	@Override
	public void swim() {
		System.out.println("Sardine swims in the ocean.");
	}

	@Override
	public Sardine clone() {
		return new Sardine(this.name, this.age, this.color);
	}
}