package mmn14.exercise2;

import mmn14.exercise2.Vehicle.LeasingVehicle;
import mmn14.exercise2.Vehicle.PrivateVehicle;

public class Main {

	// create vehicles, fill the garage, work on vehicles
	public static void main(String[] args) {
		PrivateVehicle vehicle1 = new PrivateVehicle("1", "Mercedes", 2015, "No comment", "Bob");
		PrivateVehicle vehicle1Duplicate = new PrivateVehicle("1", "Mercedes", 2015, "No comment", "Bob");
		PrivateVehicle vehicle2 = new PrivateVehicle("2", "Toyota", 2011, "No comment", "George");
		LeasingVehicle vehicle3 = new LeasingVehicle("3", "Subaru", 2016, "No comment", "Leasing is Cool", "Leon");
		LeasingVehicle vehicle4 = new LeasingVehicle("4", "Kia", 2010, "No comment", "Leasio", "Abraham");
		Garage<Vehicle> garage = new Garage<>(4);
		System.out.println("Starting the work day, let's work!\n");
		if(garage.work() == null) {
			System.out.println("Oh, Garage is empty!\n");
		}
		System.out.println("Adding to Garage Vehicle \"1\", Vehicle \"2\", Vehicle \"3\" and Vehicle \"4\".\n");
		garage.add(vehicle1);
		garage.add(vehicle1Duplicate);
		garage.add(vehicle2);
		garage.add(vehicle3);
		garage.add(vehicle4);
		System.out.println("Garage status:\n" + garage.toString());
		System.out.println("Now working on:\n" + garage.work());
		System.out.println("Garage status:\n" + garage.toString());
		System.out.println("Removing Vehicle \"3\".\n");
		garage.remove("3");
		System.out.println("Garage status:\n" + garage.toString());
		System.out.println("Adding to Garage Vehicle \"1\" and Vehicle \"3\".\n");
		garage.add(vehicle1);
		garage.add(vehicle3);
		System.out.println("Garage status:\n" + garage.toString());
		PrivateVehicle vehicle5 = new PrivateVehicle("5", "Hyundai", 2007, "No comment", "John");
		System.out.println("Adding Vehicle \"5\": " + vehicle5.toString());
		garage.add(vehicle5);
	}

}
