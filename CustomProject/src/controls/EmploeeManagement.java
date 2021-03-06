package controls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Employee;

public class EmploeeManagement {

	private static final Scanner sc = new Scanner(System.in);

	private static final String FILE_PATH = "save.txt";

	private List<Employee> employees;

	public EmploeeManagement() {
		super();
		employees = new ArrayList<>();
	}

	private void addNewEmp() {

		System.out.println("empCode: ");
		String empCode = sc.nextLine().trim();
		System.out.println("empName: ");
		String empName = sc.nextLine().trim();
		System.out.println("empGender: ");
		boolean empGender = sc.nextLine().trim().equalsIgnoreCase("0");
		System.out.println("empAge: ");
		int empAge = Integer.parseInt(sc.nextLine().trim());
		System.out.println("empAddress: ");
		String empAddress = sc.nextLine().trim();

		Employee e = new Employee(empCode, empName, empGender, empAge, empAddress);
		employees.add(e);
	}

	private int choiceId() {
		return Integer.parseInt(sc.nextLine().trim());
	}

	private boolean deleteEmp() {
		System.out.println("empCode delete: ");
		String empCode = sc.nextLine().trim();
		int oldSize = employees.size();
		employees.removeIf(t -> empCode.equals(t.getEmpCode()));
		int newSize = employees.size();
		return oldSize != newSize;
	}

	private void handleId(int id) {
		switch (id) {
		case 1:
			addNewEmp();
			break;
		case 2:
			searchByEmpCode();
			break;
		case 3:
			updateEmp();
			break;
		case 4:
			deleteEmp();
			break;
		case 5:
			listAllEmp();
			break;
		case 6:
			saveAllEmp();
			break;
		case 7:
			loadFileListEmp();
			break;
		case 8:
			System.exit(0);
		default:
			System.out.println("???");
			break;
		}
	}

	private void listAllEmp() {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@SuppressWarnings("unchecked")
	private void loadFileListEmp() {
		try (FileInputStream fis = new FileInputStream(FILE_PATH);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			Object object = ois.readObject();
			if (object != null && object instanceof List) {
				employees = (List<Employee>) object;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			showMenu();
			int id = choiceId();
			handleId(id);
		}
	}

	private void saveAllEmp() {
		File file = new File(FILE_PATH);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(employees);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchByEmpCode() {
		String empCode = sc.nextLine().trim();
		for (Employee employee : employees) {
			if (empCode.equals(employee.getEmpCode())) {
				System.out.println(employee);
				break;
			}
		}
	}

	private void showMenu() {
		System.out.println("EMPLOYEE MANAGEMENT");
		System.out.println("1. Add new employee");
		System.out.println("2. Search by employee code");
		System.out.println("3. Update an employee");
		System.out.println("4. Delete an employee");
		System.out.println("5. List all employee");
		System.out.println("6. Save all employee in an object file");
		System.out.println("7. Load file and show employee list");
		System.out.println("8. Exit program");
		System.out.print("> ");
	}

	private void updateEmp() {
		System.out.println("empCode update: ");
		String empCode = sc.nextLine().trim();
		int i;
		for (i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.getEmpCode().equals(empCode)) {
				break;
			}
		}
		if (i != employees.size()) {
			System.out.println("UPDATE!!!");

			System.out.println("empName: ");
			String empName = sc.nextLine().trim();
			System.out.println("empGender: ");
			boolean empGender = sc.nextLine().trim().equalsIgnoreCase("0");
			System.out.println("empAge: ");
			int empAge = Integer.parseInt(sc.nextLine().trim());
			System.out.println("empAddress: ");
			String empAddress = sc.nextLine().trim();

			employees.set(i, new Employee(empCode, empName, empGender, empAge, empAddress));
		} else {
			System.out.println("not found!");
		}

	}
}
