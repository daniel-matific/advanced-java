package mmn12.exercise1;

import java.awt.Color;

public class Dog extends Mammal {
	
	protected Owner owner;

	public Dog() {
		name = "";
		age = 0;
		color = new Color(0);
		owner = new Owner();
	}
	
	public Dog(String name, int age, Color color) {
		this.name = name;
		this.age = age;
		this.color = color;
		owner = new Owner();
	}
	
	public Dog(String name, int age, Color color, String ownerName, String ownerPhone) {
		this.name = name;
		this.age = age;
		this.color = color;
		owner = new Owner(ownerName, ownerPhone);
	}
	
	@Override
	public void eat() {
		System.out.println("Dog eats dog food.");
	}

	@Override
	public void sleep() {
		System.out.println("Dog sleeps for 12-14 hours a day.");
	}

	@Override
	public Dog clone() {
		return new Dog(this.name, this.age, this.color, this.owner.getOwnerName(), this.owner.getOwnerPhone());
	}
}
