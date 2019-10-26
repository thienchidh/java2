package model;

public class Software extends ShopItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numOfCD;

	public Software() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Software(int numOfCD) {
		super();
		this.numOfCD = numOfCD;
	}

	public Software(String title, double price, int quantity, int numOfCD) {
		super(title, price, quantity);
		this.numOfCD = numOfCD;
	}

	@Override
	public Software clone() {
		return new Software(title, price, quantity, numOfCD);
	}

	@Override
	public double computeFee() {
		double total = 0.0;

		int numOfCD = this.numOfCD;
		int q = Math.min(numOfCD, 3);

		total += (3.25 * q);
		numOfCD -= q;
		total += (1.5 * q);

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
		Software other = (Software) obj;
		if (numOfCD != other.numOfCD)
			return false;
		return true;
	}

	public int getNumOfCD() {
		return numOfCD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numOfCD;
		return result;
	}

	public void setNumOfCD(int numOfCD) {
		this.numOfCD = numOfCD;
	}

	@Override
	public String toString() {
		return "Software [numOfCD=" + numOfCD + ", title=" + title + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

}
