package mmn12.exercise1;

import java.awt.Color;

public class Pigeon extends Bird {
	
	public Pigeon() {
		name = "";
		age = 0;
		color = new Color(0);
	}
	
	public Pigeon(String name, int age, Color color) {
		this.name = name;
		this.age = age;
		this.color = color;
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