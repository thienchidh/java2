package controls;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import model.Employee;
import model.Organization;

public class MySystemManager implements IManager {

	private static class Singleton {
		private static MySystemManager instance = new MySystemManager();
	}

	public static MySystemManager getInstance() {
		return Singleton.instance;
	}

	private Set<Employee> employees;
	private Map<String, Organization> organizations;

	private Scanner sc = new Scanner(System.in);

	private MySystemManager() {
		super();
		employees = new LinkedHashSet<>();
		organizations = new LinkedHashMap<>();
	}

	private void getAllEmp() {
		if (employees.isEmpty()) {
			System.out.println("employees is empty");
			return;
		}
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	private void getAllOrg() {
		if (organizations.isEmpty()) {
			System.out.println("organizations is empty");
			return;
		}
		for (Entry<String, Organization> e : organizations.entrySet()) {
			System.out.println(e.getValue());
		}
	}

	private String getLine() {
		return sc.nextLine();
	}

	private void handle(int choiceId) {

		switch (choiceId) {
		case 0:
			System.exit(0);
			break;
		case 1:
			getAllEmp();
			break;
		case 2:
			getAllOrg();
			break;
		case 3:
			makeNewOrg();
			break;
		case 4:
			makeNewEmp();
			break;
		default:
			System.out.println("???");
		}

	}

	private void makeNewEmp() {
		System.out.println("name:");
		String name = getLine();
		System.out.println("sex:");
		String sex = getLine();
		System.out.println("jobTitle:");
		String jobTitle = getLine();
		System.out.println("org name:");
		String orgName = getLine();

		Organization organization = organizations.get(orgName);

		if (organization == null) {
			System.out.println("Organization " + name + " not already exists!");
			return;
		}
		System.out.println("birthday:");
		String birthday = getLine();
		Employee employee = new Employee(name, sex, jobTitle, organization, birthday);

		boolean isOK = employees.add(employee);
		if (isOK) {
			System.out.println("add success!");
			int numOfEmployees = organization.getNumOfEmployees();
			organization.setNumOfEmployees(numOfEmployees + 1);
		} else {
			System.out.println("add failed, employee already exists!");
		}
	}

	private void makeNewOrg() {
		System.out.println("enter name of org:");
		String name = getLine();
		Organization org = new Organization(name);

		if (organizations.put(name, org) == null) {
			System.out.println("Add Organization " + name + ": success!");
		} else {
			System.out.println("Organization " + name + " already exists!");
		}
	}

	public void run() {
		while (true) {
			try {
				showMenu();
				int choiceId = Integer.parseInt(getLine());
				handle(choiceId);
			} catch (Exception e) {
				System.err.println("ensure you type correct!");
			}
		}
	}

	private void showMenu() {
		System.out.println("---------");
		System.out.println("1. Display all Employees");
		System.out.println("2. Display all Organizations");
		System.out.println("3. Create new Organization");
		System.out.println("4. Create new Employee");
		System.out.println("0. exit");
		System.out.print("> ");
	}

}
