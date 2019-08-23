package ex2.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import ex2.model.Student;

public class Test {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		new Student().printAllAttributes();

		new Student("1", "2", sdf.parse("01/01/2000"), "VIetNam", "x", 5.0).printAllAttributes();
	}
}
