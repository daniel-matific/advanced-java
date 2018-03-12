package mmn12.exercise1;

public class Owner {
	private String name;
	private String phone;
	
	public Owner() {
		name = "";
		phone = "";
	}
	
	public Owner(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getOwnerName() {
		return name;
	}
	
	public String getOwnerPhone() {
		return phone;
	}
	
	public void setOwnerName(String name) {
		this.name = name;
	}
	
	public void setOwnerPhone(String phone) {
		this.phone = phone;
	}
}
