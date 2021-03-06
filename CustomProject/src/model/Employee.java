package model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String empCode;
	private String empName;
	private boolean empGender;
	private int empAge;
	private String empAddress;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empCode, String empName, boolean empGender, int empAge, String empAddress) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empGender = empGender;
		this.empAge = empAge;
		this.empAddress = empAddress;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empAddress == null) {
			if (other.empAddress != null)
				return false;
		} else if (!empAddress.equals(other.empAddress))
			return false;
		if (empAge != other.empAge)
			return false;
		if (empCode == null) {
			if (other.empCode != null)
				return false;
		} else if (!empCode.equals(other.empCode))
			return false;
		if (empGender != other.empGender)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public int getEmpAge() {
		return empAge;
	}

	public String getEmpCode() {
		return empCode;
	}

	public String getEmpName() {
		return empName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empAddress == null) ? 0 : empAddress.hashCode());
		result = prime * result + empAge;
		result = prime * result + ((empCode == null) ? 0 : empCode.hashCode());
		result = prime * result + (empGender ? 1231 : 1237);
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}

	public boolean isEmpGender() {
		return empGender;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public void setEmpGender(boolean empGender) {
		this.empGender = empGender;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", empGender=" + empGender + ", empAge="
				+ empAge + ", empAddress=" + empAddress + "]";
	}

}
