package model;

public class Book extends ShopItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double weight;

	public Book(String title, double price, int quantity, double weight) {
		super(title, price, quantity);
		this.weight = weight;
	}

	@Override
	public Book clone() {
		return new Book(title, price, quantity, weight);
	}

	@Override
	public double computeFee() {
		double total = 0.0;

		double weight = this.weight;
		if (weight < 0.5) {
			total += (weight * 5.00);
		} else {
			if (weight <= 1.00) {
				total += (weight * 9.50);

				weight -= Math.min(weight, 1.00);
			}
			total += (weight * 7.00);
		}

		return total * quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Book [weight=" + weight + ", title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
