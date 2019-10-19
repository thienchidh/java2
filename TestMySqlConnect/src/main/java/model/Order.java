package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Comparable<Order>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String prefixId = "Order";
	private static int curPosfixId = 0;

	private String id;
	private String date;

	private String customerName;

	private String customerAddress;

	private List<Product> listProducts;

	private double totalPrice;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
		id = prefixId + (++curPosfixId);
		totalPrice = 0;
	}

	public Order(String date, String customerName, String customerAddress, List<Product> listProducts) {
		this();
		this.date = date;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.listProducts = listProducts;
	}

	private void computeTotalPrice() {
		if (listProducts == null || listProducts.isEmpty()) {
			return;
		}
		double total = 0.0;
		for (Product product : listProducts) {
			total += product.getPrice();
		}
		setTotalPrice(total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listProducts == null) {
			if (other.listProducts != null)
				return false;
		} else if (!listProducts.equals(other.listProducts))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public double getTotalPrice() {
		computeTotalPrice();
		return totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listProducts == null) ? 0 : listProducts.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		computeTotalPrice();
		return "Order [id=" + id + ", date=" + date + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", listProducts=" + listProducts + ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int compareTo(Order o) {
		return Double.compare(o.getTotalPrice(), this.getTotalPrice());
	}

}
