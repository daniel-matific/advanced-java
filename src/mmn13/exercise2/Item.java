package mmn13.exercise2;

public class Item {
	
	private String description;
	private Category category;
	private int price;
	
	public Item() {
		this.description = "";
		this.category = null;
		this.price = 0;
	}
	
	public Item(String description, Category category, int price) {
		this.description = description;
		this.category = category;
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
