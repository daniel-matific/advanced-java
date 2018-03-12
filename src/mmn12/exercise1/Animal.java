package mmn12.exercise1;

public abstract class Animal {
	
	protected String name;
	protected int age;
	protected String color;
	
	public abstract void eat();
	public abstract void sleep();
	public abstract Object clone();
	
	public Animal() {};
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "This animal is a " + getClass().getSimpleName() + " of the type " + getClass().getSuperclass().getSimpleName() + " and is named " + name + ", " + age + " years old, " + color + " colored.";
	}
	
	public boolean equals(Object animal) {
		Animal animalObject = (Animal) animal;
		return getClass().getSuperclass() == animal.getClass().getSuperclass() && name.equals(animalObject.name) && age == animalObject.age && color.equals(animalObject.color);
	}
}
