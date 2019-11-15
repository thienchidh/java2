package controls;

import static validation.Validation.checkInputDouble;
import static validation.Validation.checkInputInt;
import static validation.Validation.checkInputIntLimit;
import static validation.Validation.checkInputString;
import static validation.Validation.checkInputYN;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.InputServices;
import io.OutputServices;
import model.Clothes;
import model.Shopping;
import validation.Validation;

class MySaveData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final ArrayList<Shopping> shoppings;
	final HashMap<String, List<Shopping>> map;
	final ArrayList<Clothes> clothers;

	public MySaveData(ArrayList<Shopping> shoppings, HashMap<String, List<Shopping>> map, ArrayList<Clothes> clothers) {
		super();
		this.shoppings = shoppings;
		this.map = map;
		this.clothers = clothers;
	}
}

public class StoreManagement {

	ArrayList<Clothes> clothers = new ArrayList<>();
	ArrayList<Shopping> shoppings = new ArrayList<>();

	HashMap<String, List<Shopping>> map = new HashMap<>();

	private void addNewClothes() {
		System.out.println("Enter Id:");
		String id = Validation.checkInputString();

		if (checkExitsClotherById(id)) {
			System.out.println("Id is alredy exists!");
			return;
		}

		System.out.println("Enter Name:");
		String name = checkInputString();
		System.out.println("Enter quantity:");
		int quantity = Validation.checkInputInt();
		System.out.println("Enter price:");
		double price = checkInputDouble();

		clothers.add(new Clothes(name, id, price, quantity));
	}

	private boolean checkExitsClotherById(String id) {
		for (Clothes clothes : clothers) {
			if (clothes.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIdShoppingExists(String id) {
		for (Shopping e : shoppings) {
			if (e.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private void createNewShopping() {

		System.out.println("Enter Id Shopping");
		String id = checkInputString();

		if (checkIdShoppingExists(id)) {
			System.out.println("Id Shopping is already exists!");
			return;
		}

		System.out.println("Enter Date Created");
		String dateCreated = checkInputString();
		System.out.println("Enter Customer Id");
		String customerId = checkInputString();
		System.out.println("Enter Customer Name");
		String customerName = checkInputString();

		System.out.println("Enter Customer Address");
		String customerAddress = checkInputString();

		ArrayList<Clothes> clothes = new ArrayList<>();
		do {
			Clothes c = null;
			do {
				System.out.println("Add Clother to shopping by select a clother from below list:");
				showAllAvailableClotherInStore();

				System.out.print("Enter Clother ID:");
				String clotherId = checkInputString();
				c = findClothersById(clotherId);
				if (c == null) {
					System.out.println("Id clother is not exists!");
				}
			} while (c == null);
			System.out.println("Enter Quantity:");

			int quantity = checkInputIntLimit(0, 10000000);
			for (int i = 0; i < quantity; ++i) {
				clothes.add(c);
			}
			System.out.println("Add more clother(y/n): ");
		} while (checkInputYN());
		Shopping shopping = new Shopping(id, dateCreated, customerName, customerAddress, clothes);
		shoppings.add(shopping);

		System.out.println("add Shopping Success!");

		List<Shopping> list = map.get(id);
		if (list == null) {
			list = new ArrayList<>();
		}

		list.add(shopping);
		map.put(customerId, list);
	}

	private Clothes findClothersById(String id) {
		for (Clothes clother : clothers) {
			if (id.equals(clother.getId())) {
				return clother;
			}
		}
		return null;
	}

	private Shopping findShoppingById(String id) {
		for (Shopping e : shoppings) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

	private void handle(int choice) {
		switch (choice) {
		case 1:
			addNewClothes();
			break;
		case 2:
			updatePriceAndQuantity();
			break;
		case 3:
			showAllAvailableClotherInStore();
			break;
		case 4:
			createNewShopping();
			break;
		case 5:
			printClotherPriceMin();
			break;
		case 6:
			sortAllClotherByIdAsc();
			break;
		case 7:
			printAllShoppingByCustomerId();
			break;
		case 8:
			saveToTextFileByShoppingID();
			break;
		case 9:
			loadFormFile();
			break;
		default:
			System.out.println("???");
			break;
		}

	}

	private void loadFormFile() {
		try {
			Object o = new InputServices().readObject("data.txt");
			MySaveData data = (MySaveData) o;

			if (data.map != null) {
				map = data.map;
			}
			if (data.clothers != null) {
				clothers = data.clothers;
			}
			if (data.shoppings != null) {
				shoppings = data.shoppings;
			}

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	private void printAllShoppingByCustomerId() {
		System.out.println(map.keySet());
		System.out.println("Enter Customer Id:");
		String cId = checkInputString();

		if (map.containsKey(cId)) {
			List<Shopping> list = map.get(cId);
			if (list == null || list.isEmpty()) {
				System.out.println("empty");
			} else {
				for (Shopping shopping : list) {
					System.out.println(shopping);
				}
			}
		} else {
			System.out.println("customer id not exists!");
		}

	}

	private void printAllShoppings(List<Shopping> shoppings) {
		for (Shopping shopping : shoppings) {
			System.out.println(shopping);
		}
		System.out.println();
	}

	private void printClotherPriceMin() {
		if (clothers.isEmpty()) {
			System.out.println("Clothers In Store is empty!");
			return;
		}
		List<Clothes> clothersInStore = new ArrayList<>(this.clothers);// clone this.clother
		clothersInStore.sort((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
		System.out.println(String.format("%-25s%-25s%-25s%-25s", "Clothes ID", "Clothes Name", "Clothes Price",
				"Clothes Quantity"));
		System.out.println(clothersInStore.get(0));
	}

	public void run() {

		while (true) {
			try {
				showMenu();
				int choice = Validation.checkInputIntLimit(1, 9);
				handle(choice);

			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	private void saveToTextFileByShoppingID() {
		printAllShoppings(shoppings);

		ArrayList<Shopping> shoppings = new ArrayList<>();
		do {
			System.out.println("Enter Id:");
			String id = checkInputString();
			Shopping shopping = findShoppingById(id);
			if (shopping != null) {
				shoppings.add(shopping);
			}
			System.out.println("Input again (y/n)?");
		} while (checkInputYN());

		new OutputServices().writeObject("data.txt", new MySaveData(shoppings, map, clothers));
	}

	private void showAllAvailableClotherInStore() {
		System.out.println(String.format("%-25s%-25s%-25s%-25s", "Clothes ID", "Clothes Name", "Clothes Price",
				"Clothes Quantity"));
		for (Clothes e : clothers) {
			System.out.println(e);
		}
		System.out.println();
	}

	private void showMenu() {
		System.out.println("1. Add a new Clothes to the Store");
		System.out.println(
				"2. Update price and quantity for a particular Clothes ( cập nhật giá và số lượng của Áo quần)");
		System.out.println("3. A list of all available Clothes in the Store");
		System.out.println("4. Create a new Shopping");
		System.out.println(
				"5. Print information of Clothes that haved minimum Price (In ra sản phẩm có giá nhỏ nhất trong Store)");
		System.out.println("6. Sort all Clothes by Clothes ID as ascending");
		System.out.println("7. Print information of all Shopping by a specific customer ID");
		System.out.println("8. Export information of a specific Shopping ID to text file");
		System.out.println("9. Read File");
		System.out.print("> ");
	}

	private void sortAllClotherByIdAsc() {
		clothers.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
		System.out.println("Sort done!");
	}

	private void updatePriceAndQuantity() {

		System.out.println("Enter Id:");
		String id = checkInputString();

		Clothes clothes = findClothersById(id);
		if (clothes != null) {
			System.out.println("Enter new Price:");
			double price = checkInputDouble();
			clothes.setPrice(price);
			System.out.println("Enter new Quantity:");
			int quantity = checkInputInt();
			clothes.setQuantity(quantity);

			System.out.println("Update success!");
		} else {
			System.out.println("Id not exists!");
		}
	}
}
