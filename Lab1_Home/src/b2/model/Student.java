package b2.model;

public class Student {
	private static int counter = 0;

	public static void setCounter(int counter) {
		Student.counter = counter;
	}

	public static int setRollNo() {
		return ++counter;
	}

	private String name;

	private int rollNo;

	public Student(String name) {
		super();
		this.name = name;
		rollNo = setRollNo();
	}

	public void getStudentInfo() {
		System.out.println("no = " + rollNo);
		System.out.println("name = " + name);
	}

}
