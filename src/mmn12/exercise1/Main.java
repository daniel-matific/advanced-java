package mmn12.exercise1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Animal> animalHouse = new ArrayList<Animal>();
		animalHouse.add(new Sardine("Bob", 2, "Gray"));
		animalHouse.add(new Snake("George", 12, "Green"));
		animalHouse.add(new Parrot("Donald", 6, "Blue"));
		animalHouse.add(new Pigeon("Ella", 8, "Turquoise"));
		animalHouse.add(new Tiger("Max", 15, "Orange"));
		animalHouse.add(new Dog("Stephanie", 1, "Brown"));
		
		for (Animal animal : animalHouse) {
			System.out.println(animal.toString());
			animal.eat();
			animal.sleep();
			if (animal instanceof Fish) {
				((Fish) animal).swim();
			}
			else if (animal instanceof Bird) {
				((Bird) animal).fly();
			}
		}
		
		System.out.println();
		
		Dog original = new Dog("Norman", 5, "White", "Mrs. Smith", "0525873551");
		Dog clone = original.clone();
		
		if (original.equals(clone)) {
			System.out.println("Original and clone are equal!");
		}
		else {
			System.out.println("Original and clone are NOT equal!");
		}
		System.out.println();
		System.out.println("Original:");
		System.out.println(original.toString());
		System.out.println(original.getName() + "'s owner is named " + original.owner.getOwnerName() + " and owner's phone number is " + original.owner.getOwnerPhone());
		System.out.println("Clone:");
		System.out.println(clone.toString());
		System.out.println(clone.getName() + "'s owner is named " + clone.owner.getOwnerName() + " and owner's phone number is " + clone.owner.getOwnerPhone());
		System.out.println();
		clone.owner.setOwnerName("Mr. Lee");
		clone.owner.setOwnerPhone("0547879507");
		System.out.println("Original:");
		System.out.println(original.toString());
		System.out.println(original.getName() + "'s owner is named " + original.owner.getOwnerName() + " and owner's phone number is " + original.owner.getOwnerPhone());
		System.out.println("Clone:");
		System.out.println(clone.toString());
		System.out.println(clone.getName() + "'s owner is named " + clone.owner.getOwnerName() + " and owner's phone number is " + clone.owner.getOwnerPhone());
	}
}
