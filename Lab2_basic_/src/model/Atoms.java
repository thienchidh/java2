package model;

import controls.IInputOutput;

public class Atoms implements IInputOutput {

	private static final int LIMIT_ATOMS = 10;
	private static int currentAtoms = 0;

	private int number;
	private String symbol;
	private String fullname;
	private float weight;

	public Atoms() {
		super();
		if (++currentAtoms > LIMIT_ATOMS) {
			currentAtoms = LIMIT_ATOMS;
			throw new RuntimeException("accepts < " + LIMIT_ATOMS + " elements!");
		}
	}

	public boolean accept() {
		System.out.println("Enter from keyboard, continue? (Y/N)");
		return scanner.nextLine().trim().equalsIgnoreCase("Y");
	}

	@Override
	public void input() {
		System.out.print("Enter atomic number : ");
		number = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter symbol : ");
		symbol = scanner.nextLine().trim();
		System.out.print("Enter full name : ");
		fullname = scanner.nextLine().trim();
		System.out.print("Enter atomic weight : ");
		weight = Float.parseFloat(scanner.nextLine());
	}

	@Override
	public String toString() {
		return String.format("%-10d%-10s%-10s%-10f", number, symbol, fullname, weight);
	}

}
