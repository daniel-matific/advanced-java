package mmn12.exercise1;

import java.awt.Color;

public class Tiger extends Mammal {

	public Tiger() {
		name = "";
		age = 0;
		color = new Color(0);
	}
	
	public Tiger(String name, int age, Color color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	@Override
	public void eat() {
		System.out.println("Tiger eats boars, wild pigs, bears, buffalo, wild cattle, dear, antelopes, and even weak or young elephants.");
	}

	@Override
	public void sleep() {
		System.out.println("Tiger sleeps for 16-20 hours a day.");
	}

	@Override
	public Tiger clone() {
		return new Tiger(this.name, this.age, this.color);
	}
}
