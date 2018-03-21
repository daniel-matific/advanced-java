package mmn12.exercise1;

import java.awt.Color;
import java.lang.reflect.Field;

public abstract class Animal {
	
	protected String name;
	protected int age;
	protected Color color;
	
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
	
	public Color getColor() {
		return color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return "This animal is a " + getClass().getSimpleName() + " of the type " + getClass().getSuperclass().getSimpleName() + " and is named " + name + ", " + age + " years old, " + getColorName(color) + " colored.";
	}
	
	public boolean equals(Object animal) {
		Animal animalObject = (Animal) animal;
		return getClass().getSuperclass() == animal.getClass().getSuperclass() && name.equals(animalObject.name) && age == animalObject.age && color.equals(animalObject.color);
	}
	
	private String getColorName(Color color) {
	    for (Field field : Color.class.getFields()) {
	    	try {
	    		if (field.getType() == Color.class && field.get(null).equals(color)) {
	    			return field.getName();
	    		}
	    	} catch (IllegalArgumentException e) {
	    		e.printStackTrace();
	    	} catch (IllegalAccessException e) {
	    		e.printStackTrace();
	    	}
	    }
	    return color.getRed() + "," + color.getGreen() + "," + color.getBlue();
	}
}
