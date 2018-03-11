package mmn12.exercise1;

public class Parrot extends Bird {
	
	private Owner owner;

	@Override
	protected void eat() {
		System.out.println("Parrot eats seeds.");
	}

	@Override
	protected void sleep() {
		System.out.println("Parrot sleeps while standing.");
	}

	@Override
	protected void fly() {
		System.out.println("Parrot flies in the sky.");
	}

}
