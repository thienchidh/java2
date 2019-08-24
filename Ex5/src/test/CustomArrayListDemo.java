package test;

import java.util.ArrayList;

public class CustomArrayListDemo {

	public static void main(String[] args) {
		int roll[] = { 1, 2, 3, 4 };
		String name[] = { "TranLy", "HoangTuan", "TraNguyen", "VanTin" };
		int marks[] = { 100, 99, 93, 94 };
		long phone[] = { 8762357381L, 8762357382L, 8762357383L, 8762357384L };

		CustomArrayListDemo custom = new CustomArrayListDemo();
		custom.addValues(roll, name, marks, phone);
		custom.printValues(custom.list);
	}

	private ArrayList<Customer> list = new ArrayList<>();

	public void addValues(int roll[], String name[], int marks[], long phone[]) {

		int length = Math.min(Math.min(roll.length, name.length), Math.min(marks.length, phone.length));
		for (int i = 0; i < length; i++) {
			list.add(new Customer(roll[i], name[i], marks[i], phone[i]));
		}
	}

	public void printValues(ArrayList<Customer> list) {
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}

class Customer {
	private int roll;
	private String name;
	private int marks;
	private long phone;

	public Customer(int roll, String name, int marks, long phone) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.phone = phone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone != other.phone)
			return false;
		if (roll != other.roll)
			return false;
		return true;
	}

	public int getMarks() {
		return marks;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public int getRoll() {
		return roll;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + roll;
		return result;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Customer [roll=" + roll + ", name=" + name + ", marks=" + marks + ", phone=" + phone + "]";
	}

}