package mmn14.exercise2;

public abstract class Vehicle {
	
	private String license;
	private String vehicleType;
	private int manufactureYear;
	private String comment;
	
	public Vehicle(String license, String vehicleType, int manufactureYear, String comment) {
		this.license = license;
		this.vehicleType = vehicleType;
		this.manufactureYear = manufactureYear;
		this.comment = comment;
	}

	// returns license
	public String getLicense() {
		return license;
	}

	// sets license
	public void setVehicleNumber(String license) {
		this.license = license;
	}

	// returns vehicle type
	public String getVehicleType() {
		return vehicleType;
	}

	// sets vehicle type
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	// returns manufacture year
	public int getManufactureYear() {
		return manufactureYear;
	}

	// sets manufacture year
	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	// returns comment
	public String getComment() {
		return comment;
	}

	// sets comment
	public void setComment(String comment) {
		this.comment = comment;
	}

	// returns string representation of vehicle
	@Override
	public String toString() {
		if(this instanceof PrivateVehicle) {
			return "Vehicle license: " + license + ", Type: " + vehicleType + ", Manufacture Year: " + manufactureYear + ", Comment: " + comment + ", Owner: " + ((PrivateVehicle)this).getOwnerName() + ".\n";
		}
		else if(this instanceof LeasingVehicle) {
			return "Vehicle license: " + license + ", Type: " + vehicleType + ", Manufacture Year: " + manufactureYear + ", Comment: " + comment + ", Company: " + ((LeasingVehicle)this).getCompanyName() + ", Worker: " + ((LeasingVehicle)this).getWorkerName() + ".\n";
		}
		return "Vehicle license: " + license + ", Type: " + vehicleType + ", Manufacture Year: " + manufactureYear + ", Comment: " + comment + ".\n";
	}

	public static class PrivateVehicle extends Vehicle {

		private String ownerName;

		public PrivateVehicle(String license, String vehicleType, int manufactureYear, String comment, String ownerName) {
			super(license, vehicleType, manufactureYear, comment);
			this.ownerName = ownerName;
		}

		// returns owner name
		public String getOwnerName() {
			return ownerName;
		}

		// sets owner name
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		
	}
	
	public static class LeasingVehicle extends Vehicle {
		
		private String companyName;
		private String workerName;

		public LeasingVehicle(String license, String vehicleType, int manufactureYear, String comment, String companyName, String workerName) {
			super(license, vehicleType, manufactureYear, comment);
			this.companyName = companyName;
			this.workerName = workerName;
		}

		// returns company name
		public String getCompanyName() {
			return companyName;
		}

		// sets company name
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		// returns worker name
		public String getWorkerName() {
			return workerName;
		}

		// sets worker name
		public void setWorkerName(String workerName) {
			this.workerName = workerName;
		}
	}
}
