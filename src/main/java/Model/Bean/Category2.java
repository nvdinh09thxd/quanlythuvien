package Model.Bean;

public class Category2 {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category2() {
		super();
	}

}
