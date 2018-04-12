package mmn12.exercise1;

import java.awt.Color;

public class Parrot extends Bird {
	
	protected Owner owner;
	
	public Parrot() {
		super();
		owner = new Owner();
	}
	
	public Parrot(String name, int age, Color color) {
		super(name, age, color);
		owner = new Owner();
	}
	
	public Parrot(String name, int age, Color color, String ownerName, String ownerPhone) {
		super(name, age, color);
		owner = new Owner(ownerName, ownerPhone);
	}
	
	@Override
	public void eat() {
		System.out.println("Parrot eats seeds.");
	}

	@Override
	public void sleep() {
		System.out.println("Parrot sleeps while standing.");
	}

	@Override
	public void fly() {
		System.out.println("Parrot flies in the sky.");
	}

	@Override
	public Parrot clone() {
		return new Parrot(this.name, this.age, this.color, this.owner.getOwnerName(), this.owner.getOwnerPhone());
	}
}
