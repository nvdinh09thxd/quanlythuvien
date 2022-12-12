package Model.Bean;

public class News {
	private int id;
	private String name;
	private String description;
	private String detail;
	private int idCat;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int id_cat) {
		this.idCat = id_cat;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public News(int id, String name, String description, String detail, int idCat) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.idCat = idCat;
	}

	public News() {
		super();
	}

}
