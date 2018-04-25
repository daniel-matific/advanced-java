package mmn14.exercise2;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@SuppressWarnings("serial")
public class Garage<V extends Vehicle> extends LinkedList<V> {
	private int garageCapacity;

	public Garage(int garageCapacity) {
		this.garageCapacity = garageCapacity;
	}
	
	public boolean add(V vehicle) {
		try {
			if(size() == garageCapacity) {
				throw new GarageException();
			}
		}
		catch(GarageException e) {
			System.out.println(e.getMessage());
			return false;
		}
		super.add(vehicle);
		return true;
	}
	
	public Vehicle work() {
		try {
			return super.remove();
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	public V remove(String license) {
		ListIterator<V> listIterator = listIterator();
		while (listIterator.hasNext()) {
			int index = listIterator.nextIndex();
			V vehicle = listIterator.next();
			if(vehicle.getLicense().equals(license)) {
				super.remove(index);
				return vehicle;
			}
		}
		return null;
	}
	
	public int size() {
		return super.size();
	}

	@Override
	public String toString() {
		String vehiclesInGarage = "";
		ListIterator<V> listIterator = listIterator();
		while (listIterator.hasNext()) {
			V vehicle = listIterator.next();
			vehiclesInGarage += vehicle.toString();
		}
		return vehiclesInGarage;
	}
	
}
