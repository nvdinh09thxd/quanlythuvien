package Model.Bean;

import java.util.Date;

public class Book {
	private String id;
	private String name;
	private String image;
	private String amount;
	private Category1 Category;
	private String day;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Category1 getCategory() {
		return Category;
	}
	public void setCategory(Category1 category) {
		Category = category;
	}
	
}
