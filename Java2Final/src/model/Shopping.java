package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Shopping implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String id;
	String dateCreated;
	String customerName;
	String customerAddress;
	ArrayList<Clothes> clothes;

	public Shopping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shopping(String id, String dateCreated, String customerName, String customerAddress,
			ArrayList<Clothes> clothes) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.clothes = clothes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shopping other = (Shopping) obj;
		if (clothes == null) {
			if (other.clothes != null)
				return false;
		} else if (!clothes.equals(other.clothes))
			return false;
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
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ArrayList<Clothes> getClothes() {
		return clothes;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clothes == null) ? 0 : clothes.hashCode());
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setClothes(ArrayList<Clothes> clothes) {
		this.clothes = clothes;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String cl = String.format("\n%-25s%-25s%-25s%-25s\n", "Clothes ID", "Clothes Name", "Clothes Price",
				"Clothes Quantity");
		for (Clothes e : clothes) {
			cl += e;
			cl += "\n";
		}
		return "Shopping [id=" + id + ", dateCreated=" + dateCreated + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + cl + "]";
	}

}
