package test;

import java.util.Scanner;

import model.Doctor;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// TODO
		Doctor doctor = new Doctor();
		doctor.setCode(scanner.nextLine());
		doctor.setName(scanner.nextLine());
		doctor.setSpecialzation(scanner.nextLine());
		doctor.setAvailability(scanner.nextLine());

		System.out.println(doctor);

		scanner.close();

	}
}
