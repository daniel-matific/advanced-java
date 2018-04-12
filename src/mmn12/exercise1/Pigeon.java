package mmn12.exercise1;

import java.awt.Color;

public class Pigeon extends Bird {
	
	public Pigeon() {
		super();
	}
	
	public Pigeon(String name, int age, Color color) {
		super(name, age, color);
	}

	@Override
	public void eat() {
		System.out.println("Pigeon eats bread crumbs.");
	}

	@Override
	public void sleep() {
		System.out.println("Pigeon sleeps on one leg.");
	}

	@Override
	public void fly() {
		System.out.println("Pigeon likes to fly in the city.");
	}

	@Override
	public Pigeon clone() {
		return new Pigeon(this.name, this.age, this.color);
	}
}
