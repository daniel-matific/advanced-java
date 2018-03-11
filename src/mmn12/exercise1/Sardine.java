package mmn12.exercise1;

public class Sardine extends Fish {

	@Override
	protected void eat() {
		System.out.println("Sardine eats plankton.");
	}

	@Override
	protected void sleep() {
		System.out.println("Sardine doesn't sleep, it just rests.");
	}

	@Override
	protected void swim() {
		System.out.println("Sardine swims in the ocean.");
	}

}
