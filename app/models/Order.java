package models;



public class Order extends DomainEntity {
	private Integer id;
	private Integer cook;
	private Integer buyer;
	private Integer meal;
	private Integer loation;
	private String mealName = "fake meal ame";
	private String cookName = "fake cook name";
	private String fileName = "cook-dishes1.png";

	public Order(Integer id, Integer cook, Integer buyer, Integer meal,
			Integer loation) {
		this.id = id;
		this.cook = cook;
		this.buyer = buyer;
		this.meal = meal;
		this.loation = loation;
	}

	public Order(Integer cook, Integer buyer, Integer meal, Integer loation) {
		this.cook = cook;
		this.buyer = buyer;
		this.meal = meal;
		this.loation = loation;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCook() {
		return cook;
	}

	public Integer getBuyer() {
		return buyer;
	}

	public Integer getMeal() {
		return meal;
	}

	public Integer getLoation() {
		return loation;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCook(Integer cook) {
		this.cook = cook;
	}

	public void setBuyer(Integer buyer) {
		this.buyer = buyer;
	}

	public void setMeal(Integer meal) {
		this.meal = meal;
	}

	public void setLoation(Integer loation) {
		this.loation = loation;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getCookName() {
		return cookName;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}


}
