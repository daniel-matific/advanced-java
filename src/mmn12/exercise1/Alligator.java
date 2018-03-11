package mmn12.exercise1;

public class Alligator extends Reptile {

	@Override
	protected void eat() {
		System.out.println("Alligator eats any animal close to or inside water.");
	}

	@Override
	protected void sleep() {
		System.out.println("Alligator sleep in the water or on the shore.");
	}

}
