package models;



public class Location extends DomainEntity {
	private Integer id;
	private String name;
	public Location(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Location(String name) {
		super();
		this.name = name;
	}

	public Location() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
