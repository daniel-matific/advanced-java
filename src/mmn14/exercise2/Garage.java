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

	// add a vehicle to garage
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

		for (V existingVehicle : this) {
			try {
				if (existingVehicle.getLicense().equals(vehicle.getLicense())) {
					throw new VehicleAlreadyExistsException();
				}
			} catch (VehicleAlreadyExistsException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}

		super.add(vehicle);
		return true;
	}

	// returns the first vehicle
	public Vehicle work() {
		try {
			return super.remove();
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	// removes the requested vehicle
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

	// returns size of garage
	public int size() {
		return super.size();
	}

	// returns string representation of garage status
	@Override
	public String toString() {
		StringBuilder vehiclesInGarage = new StringBuilder();
		for (V vehicle : this) {
			vehiclesInGarage.append(vehicle.toString());
		}
		return vehiclesInGarage.toString();
	}
	
}
