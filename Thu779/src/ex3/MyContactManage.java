package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyContactManage {
	private Scanner sc = new Scanner(System.in);
	private List<Contact> contacts;

	public MyContactManage() {
		super();
		contacts = new ArrayList<>();

		contacts.add(new Contact("Nguyễn Văn Tí", "Nguyễn Văn", "Tí", "1", "VN", "113"));
		contacts.add(new Contact("Trần Văn Tèo", "Trần Văn", "Tèo", "1", "VN", "114"));
		contacts.add(new Contact("Trần A", "Trần", "A", "1", "VN", "114"));

//		for (Contact contact : contacts) {
//			System.out.println(contact);
//		}
//		System.out.println();
	}

	private void addAContact() {
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("First Name:");
		String firstName = sc.nextLine();
		System.out.println("Last Name:");
		String lastName = sc.nextLine();
		System.out.println("Group:");
		String group = sc.nextLine();
		System.out.println("Address:");
		String address = sc.nextLine();
		System.out.println("Phone:");
		String phone = sc.nextLine();

		if (!Pattern.matches("[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+",
				phone)) {
			System.out.println("invalid phone!");
			return;
		}

		contacts.add(new Contact(name, firstName, lastName, group, address, phone));
	}

	private void deleteAContact() {

		System.out.println("id: ");
		String id = sc.nextLine();
		contacts.removeIf(t -> t.getId().equals(id));

	}

	private List<Contact> findByName(List<Contact> contacts) {
		List<Contact> result = new ArrayList<>();

		String name = sc.nextLine().trim();
		for (Contact contact : contacts) {
			if (contact.getName().contains(name)) {
				result.add(contact);
			}
		}
		return result;
	}

	private void handle(int choice) {
		switch (choice) {
		case 1: {
			addAContact();
			break;
		}
		case 2: {
			System.out.println();
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
			System.out.println();
			break;
		}
		case 3: {
			deleteAContact();
			break;
		}
		case 4: {
			List<Contact> findByName = findByName(contacts);
			for (Contact contact : findByName) {
				System.out.println(contact);
			}
			break;
		}
		case 0: {
			System.exit(0);
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
		System.out.println("1. Add a contact");
		System.out.println("2. Display all contact");
		System.out.println("3. Delete a contact");
		System.out.println("4. Find contact by name");
		System.out.println("0. Exit");
		System.out.print("> ");
	}
}
