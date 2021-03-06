package controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Atoms;
import model.Molecule;

public class MyManage {

	private Scanner sc = new Scanner(System.in);

	private List<Atoms> atoms;

	private List<Molecule> molecules;

	public MyManage() {
		super();
		atoms = new ArrayList<>();
		molecules = new ArrayList<>();
	}

	private void handle(int choice) {
		switch (choice) {
		case 0: {
			System.exit(0);
		}
		case 1: {
			System.out.println("enter Molecules");
			Molecule molecule = new Molecule();
			molecule.input();

			molecules.add(molecule);
			break;
		}
		case 2: {
			Atoms atom = new Atoms();
			if (atom.accept()) {
				atom.input();
				atoms.add(atom);
			}
			break;

		}
		case 3: {
			for (Molecule e : molecules) {
				System.out.println(e);
			}
			break;
		}
		case 4: {
			for (Atoms e : atoms) {
				System.out.println(e);
			}
			break;
		}
		default: {
			System.out.println("???");
			break;
		}
		}

	}

	public void run() {
		while (true) {
			try {
				showMenu();
				int choice = Integer.parseInt(sc.nextLine().trim());
				handle(choice);

			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	private void showMenu() {
		System.out.println("----------------");
		System.out.println("1. enter Molecules");
		System.out.println("2. enter Atoms");
		System.out.println("3. display all Molecules");
		System.out.println("4. display all Atoms");
		System.out.println("0. exit");
		System.out.print("> ");
	}

}
