package model;

public class Car {
	private String name;
	private String price;
	private String production;

	public Car() {
		super();
	}

	public Car(String name, String price, String production) {
		super();
		this.name = name;
		this.price = price;
		this.production = production;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (production == null) {
			if (other.production != null)
				return false;
		} else if (!production.equals(other.production))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getProduction() {
		return production;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((production == null) ? 0 : production.hashCode());
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", production=" + production + "]";
	}

}
