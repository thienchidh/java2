package ex2.model;

import java.util.Date;

public class Student {
	private String name;
	private String studentId;
	private Date birthDate;
	private String address;
	private String major;
	private double gpa;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String studentId, Date birthDate, String address, String major, double gpa) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.birthDate = birthDate;
		this.address = address;
		this.major = major;
		this.gpa = gpa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public double getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}

	public String getName() {
		return name;
	}

	public String getStudentId() {
		return studentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	public void printAllAttributes() {
		System.out.println(this);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + ", birthDate=" + birthDate + ", address="
				+ address + ", major=" + major + ", gpa=" + gpa + "]";
	}
}
