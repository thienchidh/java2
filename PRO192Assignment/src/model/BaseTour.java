package model;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseTour implements ITour, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String code;
	protected String title;
	protected double price;
	protected String transport;
	protected Date startDate;
	protected Date endDate;

	public BaseTour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseTour(String code, String title, double price, String transport, Date startDate, Date endDate) {
		super();
		this.code = code;
		this.title = title;
		this.price = price;
		this.transport = transport;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	protected int computeNumOfDay() {
		long diff = endDate.getTime() - startDate.getTime();
		return (int) Math.ceil(diff / (1000 * 60 * 60 * 24));// 1day = 1000(milis)*60(second) *60(minute)*24(hour)
	}

	protected abstract double computeSurcharge();

	@Override
	public double computeTourCharge() {
		return price + computeSurcharge();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseTour other = (BaseTour) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (transport == null) {
			if (other.transport != null)
				return false;
		} else if (!transport.equals(other.transport))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public Date getEndDate() {
		return endDate;
	}

	public double getPrice() {
		return price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getTitle() {
		return title;
	}

	public String getTransport() {
		return transport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((transport == null) ? 0 : transport.hashCode());
		return result;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	@Override
	public String toString() {
		return "BaseTour [code=" + code + ", title=" + title + ", price=" + price + ", transport=" + transport
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}