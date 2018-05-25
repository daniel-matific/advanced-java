package mmn14.exercise1;

import java.util.Set;

public class Main {

	// create two arrays of workers and salaries, creates association table, add worker, remove worker, iterate and print
	public static void main(String[] args) {
		
		Worker[] workers = new Worker[3];
		Worker worker1 = new Worker("Bob", "Smith", 386442309L, 1955);
		Worker worker2 = new Worker("John", "Doe", 357331209L, 1974);
		workers[0] = worker1;
		workers[1] = worker2;
		workers[2] = new Worker("Donald", "Ro", 231377452L, 1961);
		
		Double[] salaries = new Double[3];
		salaries[0] = 23553.5;
		salaries[1] = 5572.1;
		salaries[2] = 14700.2;
		
		try {
			AssociationTable<Worker, Double> associationTable = new AssociationTable<>(workers, salaries);
			associationTable.add(new Worker("George", "Sun", 183551275L, 1981), 11450.0);
			associationTable.add(worker1, 7777.7);
			associationTable.remove(worker2);
			Set<Worker> workersSet = associationTable.keyIterator();
			for(Worker w : workersSet) {
				System.out.println(w + ", salary: " + associationTable.get(w));
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
