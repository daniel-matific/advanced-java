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

	public String getLicense() {
		return license;
	}

	public void setVehicleNumber(String license) {
		this.license = license;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		if(this instanceof PrivateVehicle) {
			return "Vehicle license: " + license + ", Type: " + vehicleType + ", Manufacture Year: " + manufactureYear + ", Comment: " + comment + ", Owner: " + ((PrivateVehicle)this).getOwnerName() + ".\n";
		}
		else if(this instanceof LeesingVehicle) {
			return "Vehicle license: " + license + ", Type: " + vehicleType + ", Manufacture Year: " + manufactureYear + ", Comment: " + comment + ", Company: " + ((LeesingVehicle)this).getCompanyName() + ", Worker: " + ((LeesingVehicle)this).getWorkerName() + ".\n";
		}
		return "Vehicle license: " + license + ", Type: " + vehicleType + ", Manufacture Year: " + manufactureYear + ", Comment: " + comment + ".\n";
	}
	
	public static class PrivateVehicle extends Vehicle {

		private String ownerName;

		public PrivateVehicle(String license, String vehicleType, int manufactureYear, String comment, String ownerName) {
			super(license, vehicleType, manufactureYear, comment);
			this.ownerName = ownerName;
		}

		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		
	}
	
	public static class LeesingVehicle extends Vehicle {
		
		private String companyName;
		private String workerName;

		public LeesingVehicle(String license, String vehicleType, int manufactureYear, String comment, String companyName, String workerName) {
			super(license, vehicleType, manufactureYear, comment);
			this.companyName = companyName;
			this.workerName = workerName;
		}
		
		public String getCompanyName() {
			return companyName;
		}
		
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		
		public String getWorkerName() {
			return workerName;
		}
		
		public void setWorkerName(String workerName) {
			this.workerName = workerName;
		}
	}
}
