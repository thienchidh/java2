package model;

public class Doctor {
	private String code;
	private String name;
	private String specialzation;
	private String availability;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String code, String name, String specialzation, String availability) {
		super();
		this.code = code;
		this.name = name;
		this.specialzation = specialzation;
		this.availability = availability;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specialzation == null) {
			if (other.specialzation != null)
				return false;
		} else if (!specialzation.equals(other.specialzation))
			return false;
		return true;
	}

	public String getAvailability() {
		return availability;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getSpecialzation() {
		return specialzation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specialzation == null) ? 0 : specialzation.hashCode());
		return result;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecialzation(String specialzation) {
		this.specialzation = specialzation;
	}

	@Override
	public String toString() {
		return "Doctor [code=" + code + ", name=" + name + ", specialzation=" + specialzation + ", availability="
				+ availability + "]";
	}

}
