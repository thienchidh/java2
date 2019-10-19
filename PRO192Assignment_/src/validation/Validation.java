package validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
	private static final Scanner sc = new Scanner(System.in);

	public static double checkInputDouble() {
		while (true) {
			try {
				String line = checkInputString();
				double num = Double.parseDouble(line);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Chuoi Nhap Vao Khong Duoc De Trong!");
				System.out.println("Vui Long Nhap Lai");
			}
		}
	}

	public static int checkInputInt() {
		while (true) {
			try {
				String line = checkInputString();
				int num = Integer.parseInt(line);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Chuoi Nhap Vao Khong Duoc De Trong!");
				System.out.println("Vui Long Nhap Lai");
			}
		}
	}

	public static int checkInputIntLimit(int min, int max) {
		while (true) {
			try {
				int result = checkInputInt();
				if (result < min || result > max) {
					throw new Exception();
				}
				return result;
			} catch (Exception ex) {
				System.err.println("Input must be from " + min + " to " + max);
				System.out.print("Enter again: ");
			}
		}
	}

	public static String checkInputPhone() {
		while (true) {
			String phone = checkInputString();
			if (Pattern.matches("[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+",
					phone)) {
				return phone;
			}
			System.out.println("Sdt ko hop le! vui long nhap lai!");
		}
	}

	public static String checkInputString() {
		while (true) {
			try {
				String line = sc.nextLine();
				if (!line.isEmpty()) {
					return line;
				}
				System.out.println("Chuoi Nhap vao khong duoc de trong, vui long nhap lai");
			} catch (Exception e) {
				System.out.println("Co loi xay ra, Vui Long Nhap Lai");
			}
		}
	}

	public static boolean checkInputYN() {
		while (true) {
			String line = checkInputString();
			if (line.equalsIgnoreCase("Y")) {
				return true;
			} else if (line.equalsIgnoreCase("N")) {
				return false;
			}
			System.err.println("You must input Y or N");
			System.out.print("Enter again: ");
		}
	}

}
