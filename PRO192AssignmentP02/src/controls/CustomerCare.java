package controls;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import validation.Validation;

public class CustomerCare {

	ArrayList<Customer> customers = new ArrayList<>();

	private void addAnIssueAGivenName() {
		System.out.println("Enter customer name:");
		String name = Validation.checkInputString();
		System.out.println("Enter customer issue:");
		Customer customer = findCustomerByName(name);
		String issue = Validation.checkInputString();
		customer.setIssue(issue);
	}

	private void checkIssueAGivenName() {
		System.out.println("Enter customer name:");
		String name = Validation.checkInputString();
		Customer customer = findCustomerByName(name);
		if (customer != null) {
			if (customer.isStatus()) {
				System.out.println("This User has issue!");
			} else {
				System.out.println("This User has not issue!");
			}
		}
	}

	private void exit() {
		System.exit(0);
	}

	private Customer findCustomerByName(String name) {
		for (Customer customer : customers) {
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;
	}

	private void handle(int choice) {
		switch (choice) {
		case 0:
			exit();
			break;
		case 1:
			listAvailableCustomer(customers);
			break;
		case 2:
			checkIssueAGivenName();
			break;
		case 3:
			addAnIssueAGivenName();
			break;
		case 4:
			splitSolvedAndUnSolved();
			break;
		case 5:
			toogleIssueStatus();
			break;
		case 6:
			findByDate();
			break;

		default:
			System.out.println("???");
			break;
		}

	}

	private void findByDate() {
		String date = Validation.checkInputString();
		List<String> rs = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getDate().equals(date)) {
				rs.add(customer.getDate());
			}
		}

		for (String string : rs) {
			System.out.println(string);
		}
	}

	private void toogleIssueStatus() {
		for (Customer customer : customers) {
			if (customer.isStatus()) {
				customer.setStatus(false);
			}
		}
	}

	private void listAvailableCustomer(List<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		System.out.println();
	}

	public void run() {

		customers.add(new Customer("Nguyen Van A", "A", "01/01/2000", false));
		customers.add(new Customer("Nguyen Van b", "B", "01/01/2001", false));
		customers.add(new Customer("Nguyen Van c", "C", "01/01/2002", false));
		customers.add(new Customer("Nguyen Van d", "D", "01/01/2003", true));

		while (true) {
			try {
				showMenu();
				int choice = Validation.checkInputInt();
				handle(choice);

			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	private void showMenu() {

		System.out.println("1. A list of all available customers in the system");
		System.out.println("2. Whether a given customer’s name has any issue or not");
		System.out.println("3. Record/Add an issue for a customer");
		System.out.println("4. A list of all solved issues and unsolved issues");
		System.out.println("5. Update an issue’s status from unsolved to solved only");
		System.out.println("6. A list of all issues on a specific date");
		System.out.println("0. Exit");
		System.out.print("> ");
	}

	private void splitSolvedAndUnSolved() {
		List<Customer> list1 = new ArrayList<>();
		List<Customer> list2 = new ArrayList<>();

		for (Customer customer : customers) {
			if (customer.isStatus()) {
				list1.add(customer);
			} else {
				list2.add(customer);
			}
		}

		listAvailableCustomer(list1);
		listAvailableCustomer(list2);

	}

}
