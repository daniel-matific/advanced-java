package mmn12.exercise1;

public abstract class Animal {
	
	protected String name;
	protected int age;
	protected String color;
	
	protected abstract void eat();
	protected abstract void sleep();
	
	public int getAge() {
		return age;
	}
}
