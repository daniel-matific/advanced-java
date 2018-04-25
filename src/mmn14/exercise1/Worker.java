package mmn14.exercise1;

public class Worker implements Comparable<Worker>{
	
	private String firstName;
	private String lastName;
	private Long id;
	private int yearOfBirth;
	
	public Worker() {
		firstName = "";
		lastName = "";
		id = new Long(0);
		yearOfBirth = 0;
	}
	
	public Worker(String firstName, String lastName, Long id, int yearOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.yearOfBirth = yearOfBirth;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int compareTo(Worker worker) {
		if(id < worker.getId()) {
			return -1;
		}
		else if(id > worker.getId()) {
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		return id + " " + firstName + " " + lastName + ", born in " + yearOfBirth;
	}
}
