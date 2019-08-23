package test;

import model.IPersonInt;
import model.Student;

public class Main {
	public static void main(String[] args) {
		IPersonInt student = new Student();
		student.input();

		student.display();

	}
}
