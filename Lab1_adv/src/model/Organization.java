package model;

import java.util.Objects;

public class Organization {
	private String name;
	private int numOfEmployees;

	public Organization(String name) {
		this(name, 0);
	}

	public Organization(String name, int numOfEmployees) {
		super();

		Objects.requireNonNull(name);
		if (numOfEmployees < 0) {
			throw new RuntimeException("Number of Employees must be >= 0");
		}

		this.name = name;
		this.numOfEmployees = numOfEmployees;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		if (numOfEmployees < 0) {
			throw new RuntimeException("Number of Employees must be >= 0");
		}
		this.numOfEmployees = numOfEmployees;
	}

	@Override
	public String toString() {
		return "Organization [name=" + name + ", numOfEmployees=" + numOfEmployees + "]";
	}

}
