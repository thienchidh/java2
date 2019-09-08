package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
	private static final Scanner sc = new Scanner(System.in);
	private List<Student> students;

	public ManagerStudent() {
		students = new ArrayList<>();
	}

	private boolean checkChooseYN(char x) {
		return (x == 'y' || x == 'Y');
	}

	private int checkLimitInput(int _min, int _max) {
		int choice;

		while (true) {
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < _min || choice > _max) {
					throw new NumberFormatException();
				}
				return choice;
			} catch (NumberFormatException e) {
				System.err.println("range received from " + _min + " to " + _max);
			}
		}
	}

	private void create() {
		int id;
		String name, course, language;

		System.out.println("Enter id: ");
		id = InputVariable.inputInteger();
		System.out.println("Enter name: ");
		name = InputVariable.inputString();
		System.out.println("Enter course: ");
		course = InputVariable.inputString();
		System.out.println("Enter language: ");
		language = InputVariable.inputString();

		students.add(new Student(id, name, course, language));
		System.err.println("Add successfully!");
	}

	private void findAndSort() {
		int id;
		System.out.println("Enter id: ");
		id = InputVariable.inputInteger();

		boolean ok = false;
		for (Student student : students) {
			if (student.getId() == id) {
				student.display();
				ok = true;
				break;
			}
		}
		if (!ok) {
			System.err.println("Not found student");
		}

		System.out.println("You want sort student list? (Y/N)");
		char c = InputVariable.inputCharacter();

		if (checkChooseYN(c)) {
			Collections.sort(students);
			for (Student student : students) {
				student.display();
			}
		}
	}

	private int menu() {
		System.out.println("1. Create");
		System.out.println("2. Find and Sort");
		System.out.println("3. Delete");
		System.out.println("4. Report");
		System.out.println("5. Exit");
		System.out.print("Your choice: ");
		int choice = checkLimitInput(1, 5);
		return choice;
	}

	private void report() {
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}

	public void run() {
		while (true) {
			int choice = menu();
			switch (choice) {
			case 1:
				create();
				break;
			case 2:
				findAndSort();
				break;
			case 3:
				delete();
				break;
			case 4:
				report();
				break;
			case 5:
				return;
			}
		}
	}

	private void delete() {
		String id = InputVariable.inputString();
		students.removeIf(t -> (t.getId() + "").equals(id));
	}
}
