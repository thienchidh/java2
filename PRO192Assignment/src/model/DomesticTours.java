package model;

import java.util.Date;

public class DomesticTours extends BaseTour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double tourGuideTip;

	public DomesticTours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomesticTours(String code, String title, double price, String transport, Date startDate, Date endDate) {
		super(code, title, price, transport, startDate, endDate);
		// TODO Auto-generated constructor stub
	}

	public DomesticTours(String code, String title, double price, String transport, Date startDate, Date endDate,
			double tourGuideTip) {
		super(code, title, price, transport, startDate, endDate);
		this.tourGuideTip = tourGuideTip;
	}

	@Override
	protected double computeSurcharge() {
		return tourGuideTip * computeNumOfDay();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomesticTours other = (DomesticTours) obj;
		if (Double.doubleToLongBits(tourGuideTip) != Double.doubleToLongBits(other.tourGuideTip))
			return false;
		return true;
	}

	public double getTourGuideTip() {
		return tourGuideTip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(tourGuideTip);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void setTourGuideTip(double tourGuideTip) {
		this.tourGuideTip = tourGuideTip;
	}

	@Override
	public String toString() {
		return "DomesticTours [tourGuideTip=" + tourGuideTip + ", code=" + code + ", title=" + title + ", price="
				+ price + ", transport=" + transport + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
