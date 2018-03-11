package mmn12.exercise1;

public class Tiger extends Mammal {

	@Override
	protected void eat() {
		System.out.println("Tiger eats boars, wild pigs, bears, buffalo, wild cattle, dear, antelopes, and even weak or young elephants.");
	}

	@Override
	protected void sleep() {
		System.out.println("Tiger sleeps for 16-20 hours a day.");
	}

}
