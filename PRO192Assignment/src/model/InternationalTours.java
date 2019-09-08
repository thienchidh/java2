package model;

import java.util.Date;

public class InternationalTours extends BaseTour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double aviationTax;
	private double entryFee;

	public InternationalTours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternationalTours(String code, String title, double price, String transport, Date startDate, Date endDate) {
		super(code, title, price, transport, startDate, endDate);
		// TODO Auto-generated constructor stub
	}

	public InternationalTours(String code, String title, double price, String transport, Date startDate, Date endDate,
			double aviationTax, double entryFee) {
		super(code, title, price, transport, startDate, endDate);
		this.aviationTax = aviationTax;
		this.entryFee = entryFee;
	}

	@Override
	protected double computeSurcharge() {
		return aviationTax + entryFee;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InternationalTours other = (InternationalTours) obj;
		if (Double.doubleToLongBits(aviationTax) != Double.doubleToLongBits(other.aviationTax))
			return false;
		if (Double.doubleToLongBits(entryFee) != Double.doubleToLongBits(other.entryFee))
			return false;
		return true;
	}

	public double getAviationTax() {
		return aviationTax;
	}

	public double getEntryFee() {
		return entryFee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(aviationTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(entryFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void setAviationTax(double aviationTax) {
		this.aviationTax = aviationTax;
	}

	public void setEntryFee(double entryFee) {
		this.entryFee = entryFee;
	}

	@Override
	public String toString() {
		return "InternationalTours [aviationTax=" + aviationTax + ", entryFee=" + entryFee + ", code=" + code
				+ ", title=" + title + ", price=" + price + ", transport=" + transport + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
