package model;

public class Employee {
	private String name;
	private String sex;
	private String jobTitle;
	private Organization organization;
	private String birthday;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String sex, String jobTitle, Organization organization, String birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.jobTitle = jobTitle;
		this.organization = organization;
		this.birthday = birthday;
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
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getName() {
		return name;
	}

	public Organization getOrganization() {
		return organization;
	}

	public String getSex() {
		return sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sex=" + sex + ", jobTitle=" + jobTitle + ", organization=" + organization
				+ ", birthday=" + birthday + "]";
	}

}