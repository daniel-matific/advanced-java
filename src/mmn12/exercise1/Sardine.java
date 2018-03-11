package mmn12.exercise1;

public class Sardine extends Fish {

	@Override
	protected void eat() {
		System.out.println("Sardine eats plankton.");
	}

	@Override
	protected void sleep() {
		System.out.println("Sardine don't sleep, it just rests.");
	}

}
