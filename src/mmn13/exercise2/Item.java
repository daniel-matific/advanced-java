package mmn13.exercise2;

public class Item {
	
	private String description;
	private Category category;
	private double price;
	
	public Item() {
		this.description = "";
		this.category = null;
		this.price = 0;
	}

	// Returns the description of the item
	public String getDescription() {
		return description;
	}

	// Returns the category of the item
	public Category getCategory() {
		return category;
	}

	// Returns the price of the item
	public double getPrice() {
		return price;
	}

	// Sets the description of the item
	public void setDescription(String description) {
		this.description = description;
	}

	// Sets the category of the item
	public void setCategory(Category category) {
		this.category = category;
	}

	// Sets the price of the item
	public void setPrice(double d) {
		this.price = d;
	}
}
