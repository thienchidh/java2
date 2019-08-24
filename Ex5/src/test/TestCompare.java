package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Student;

public class TestCompare {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.addAll(Arrays.asList(new Student(1, "b", 2000, "2"), new Student(1, "a", 2000, "3"),
				new Student(1, "a", 2000, "1"), new Student(1, "b", 2000, "1")));

		for (Student student : list) {
			System.out.println(student);
		}

		//
		list.sort((o1, o2) -> {
			int x = o1.getKhoa().compareTo(o2.getKhoa());
			if (x == 0) {
				int y = o1.getTen().compareTo(o2.getTen());
				if (y == 0) {
					return Integer.compare(o1.getNamSinh(), o2.getNamSinh());
				}
				return y;
			}
			return x;
		});

		System.out.println("---");
		for (Student student : list) {
			System.out.println(student);
		}

		System.out.println("----------------------");
		// Khoa asc
		list.sort((o1, o2) -> o1.getKhoa().compareTo(o2.getKhoa()));

		System.out.println(list);

		// ten asc
		list.sort((o1, o2) -> o1.getTen().compareTo(o2.getTen()));

		System.out.println(list);

		// ns asc
		list.sort((o1, o2) -> Integer.compare(o1.getNamSinh(), o2.getNamSinh()));

		System.out.println(list);

	}
}
