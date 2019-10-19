package controls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import model.Customer;
import model.Fruit;
import model.Order;

public class MyFruitShopSystem {

	private ArrayList<Fruit> fruits = new ArrayList<>();
	private HashMap<Customer, ArrayList<Order>> map = new HashMap<>();

	private void createFruit() {
		while (true) {
			try {
				System.out.println("id: ");
				String id = Validation.checkInputString();

				if (Validation.checkIdExist(fruits, id)) {
					System.out.println("id: " + id + " already exist!");
				} else {
					System.out.println("name: ");
					String name = Validation.checkInputString();
					System.out.println("price: ");
					double price = Validation.checkInputDouble();
					System.out.println("origin: ");
					String origin = Validation.checkInputString();

					Fruit fruit = new Fruit(id, name, price, origin);
					fruits.add(fruit);
				}

				boolean isContinued = Validation.checkInputYN();
				if (!isContinued) {
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void handle(int choice) {
		switch (choice) {
		case 1: {
			createFruit();
			break;
		}
		case 2: {
			viewOrders();
			break;
		}
		case 3: {
			shopping();
			break;
		}
		case 4: {
			System.exit(0);
		}
		case 5:
			for (Fruit fruit : fruits) {
				System.out.println(fruit);
			}
			break;
		default: {
			System.out.println("???");
			break;
		}
		}

	}

	private void orderNow(Fruit fruit, int quantity) {

		double price = fruit.getPrice();
		double amount = price * quantity;
		printOrder(new Order(null, fruit.getName(), quantity, price, amount));

		System.out.println("enter name:");
		String name = Validation.checkInputString();
		Customer customer = new Customer(name);
		ArrayList<Order> orders;
		if (map.containsKey(customer)) {
			orders = map.get(customer);
		} else {
			orders = new ArrayList<>();
		}

		Order order = new Order(customer, fruit.getName(), quantity, price, amount);
		orders.add(order);
		map.put(customer, orders);

		System.out.println("thanks you");
	}

	private void printOrder(List<Order> value) {
		System.out.println(String.format("%-10s%-10s%-10s%-10s", "Product", "Quantity", "Price", "Amount"));
		for (Order o : value) {
			System.out.println(o);
		}
	}

	private void printOrder(Order... value) {
		printOrder(Arrays.asList(value));
	}

	public void run() {

		fruits.add(new Fruit("1", "a", 10.0, "Viet Nam"));
		fruits.add(new Fruit("2", "b", 5.0, "Viet Nam"));
		fruits.add(new Fruit("3", "c", 2.0, "Viet Nam"));
		fruits.add(new Fruit("4", "d", 1.0, "Viet Nam"));

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

	private void shopping() {

		System.out.println(String.format("%-10s%-10s%-10s%-10s", "Item", "Name", "Origin", "Price"));
		for (Fruit fruit : fruits) {
			System.out.println(fruit);
		}
		System.out.println();

		System.out.println("id to buy: ");

		String id = Validation.checkInputString();
		int index = Validation.findIndexById(fruits, id);
		if (index != -1) {
			Fruit fruit = fruits.get(index);
			System.out.println("✓ You selected: " + fruit.getName());
			System.out.println("✓ Please input quantity: ");
			int quantity = Validation.checkInputInt();
			boolean inputYN = Validation.checkInputYN();
			if (inputYN) {
				orderNow(fruit, quantity);
			}
		} else {
			System.out.println("Not found!");
		}
	}

	private void showMenu() {
		System.out.println("----------------");
		System.out.println("1. Create Fruit");
		System.out.println("2. View orders");
		System.out.println("3. Shopping (for buyer)");
		System.out.println("4. Exit");
		System.out.print("> ");
	}

	private void viewOrders() {
		for (Entry<Customer, ArrayList<Order>> e : map.entrySet()) {
			System.out.println(e.getKey());
			ArrayList<Order> value = e.getValue();
			printOrder(value);
		}
	}
}
