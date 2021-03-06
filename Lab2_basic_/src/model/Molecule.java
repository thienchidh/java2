package model;

import controls.IInputOutput;

public class Molecule implements IInputOutput {
	private String structure;
	private String name;
	private float weight;

	public Molecule() {
		super();
	}

	public Molecule(String structure, String name, float weight) {
		super();
		this.structure = structure;
		this.name = name;
		this.weight = weight;
	}

	@Override
	public void input() {
		System.out.print("Enter structure : ");
		structure = scanner.nextLine().trim();
		System.out.print("Enter name : ");
		name = scanner.nextLine().trim();
		System.out.print("Enter weight : ");
		weight = Float.parseFloat(scanner.nextLine());
	}

	@Override
	public String toString() {
		return String.format("%-10s%-10s%-10f", structure, name, weight);
	}
}
