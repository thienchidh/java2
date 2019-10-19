package b4.test;

import validation.Validation;

public class Main {
	public static void main(String[] args) {
		String phoneNumber = Validation.checkInputPhone();
		System.out.println(phoneNumber);
	}
}
