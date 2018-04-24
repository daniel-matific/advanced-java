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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
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
