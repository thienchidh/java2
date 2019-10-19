package controls;

import static validation.Validation.checkInputDouble;
import static validation.Validation.checkInputInt;
import static validation.Validation.checkInputIntLimit;
import static validation.Validation.checkInputString;
import static validation.Validation.checkInputYN;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.InputServices;
import io.OutputServices;
import model.Order;
import model.Product;
import validation.Validation;

class MySaveData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final ArrayList<Order> orders;

	public MySaveData(ArrayList<Order> orders) {
		super();
		this.orders = orders;
	}
}

public class StoreManagement {

	ArrayList<Product> productsInStore = new ArrayList<>();

	ArrayList<Order> orders = new ArrayList<>();

	private void addNewProduct() {
		System.out.println("Enter Name:");
		String name = checkInputString();
		System.out.println("Enter price:");
		double price = checkInputDouble();
		productsInStore.add(new Product(name, price));
	}

	private void createNewOrder() {
		System.out.println("Enter Date");
		String date = checkInputString();
		System.out.println("Enter Customer Name");
		String customerName = checkInputString();
		System.out.println("Enter Customer Address");
		String customerAddress = checkInputString();

		ArrayList<Product> listProducts = new ArrayList<>();
		do {

			Product product = null;
			do {
				System.out.println("Add product to order by select a product from below list:");
				showAllAvailableProduct();

				System.out.print("Enter Product ID:");
				int productId = checkInputInt();
				product = findProductById(productId);
				if (product == null) {
					System.out.println("Id product is not exists!");
				}
			} while (product == null);
			System.out.println("Enter Quantity:");

			int quantity = checkInputIntLimit(0, 10000000);
			for (int i = 0; i < quantity; ++i) {
				listProducts.add(product);
			}
			System.out.println("Add more product(y/n): ");
		} while (checkInputYN());
		Order order = new Order(date, customerName, customerAddress, listProducts);
		orders.add(order);

		System.out.println("add Order Success!");
	}

	private void exit() {
		System.exit(0);
	}

	private void findOrderById() {
		System.out.println("Enter Order Id:");
		Order o = findOrderById(checkInputString());
		if (o != null) {
			System.out.println(o);
		} else {
			System.out.println("Not Found!");
		}
	}

	private Order findOrderById(String id) {
		for (Order order : orders) {
			if (order.getId().equals(id)) {
				return order;
			}
		}
		return null;
	}

	private Product findProductById(int id) {
		for (Product product : productsInStore) {
			if (id == product.getId()) {
				return product;
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
			addNewProduct();
			break;
		case 2:
			updatePriceForProduct();
			break;
		case 3:
			showAllAvailableProduct();
			break;
		case 4:
			createNewOrder();
			break;
		case 5:
			showOrderByIdAsc();
			break;
		case 6:
			sortOrderByPriceDesc();
			break;
		case 7:
			findOrderById();
			break;
		case 8:
			saveToTextFile();
			break;
		case 9:
			printAllOrder(orders);
			break;
		case 10:
			loadFromTextFile();
			break;
		default:
			System.out.println("???");
			break;
		}

	}

	private void loadFromTextFile() {

		try {
			Object readObject = new InputServices().readObject("data");
			MySaveData data = (MySaveData) readObject;
			printAllOrder(data.orders);

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printAllOrder(List<Order> orders) {
		for (Order order : orders) {
			System.out.println(order);
		}
		System.out.println();
	}

	public void run() {

		productsInStore.add(new Product("01", 2.5));
		productsInStore.add(new Product("02", 2.6));
		productsInStore.add(new Product("03", 2.7));
		productsInStore.add(new Product("04", 2.7));
		productsInStore.add(new Product("05", 2.7));
		productsInStore.add(new Product("06", 2.7));

		orders.add(new Order("1/1/2011", "Nguyen Van  Ti", "Da Nang", productsInStore));
		orders.add(new Order("2/3/2014", "Nguyen Van  Ti", "Da Nang", null));

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

	private void saveToTextFile() {
		printAllOrder(orders);

		ArrayList<Order> orders = new ArrayList<>();
		do {
			System.out.println("Enter Id:");
			String id = checkInputString();
			Order order = findOrderById(id);
			if (order != null) {
				orders.add(order);
			}
			System.out.println("Input again (y/n)?");
		} while (checkInputYN());

		new OutputServices().writeObject("data", new MySaveData(orders));
	}

	private void showAllAvailableProduct() {
		System.out.println(String.format("%-25s%-25s%-25s", "Product ID", "Product Name", "Product Price"));
		for (Product e : productsInStore) {
			System.out.println(e);
		}
		System.out.println();
	}

	private void showMenu() {
		System.out.println("1. Add a new product to the Store");
		System.out.println("2. Update price for a particular product");
		System.out.println("3. A list of all available products in the Store");
		System.out.println("4. Create a new Order");
		System.out.println("5. Print information of an Order by Order ID");
		System.out.println("6. Sort all products by product price as ascending");
		System.out.println("7. Print information of all Orders by a specific customer ID");
		System.out.println("8. Export information of a specific Order ID to text file");
		System.out.println("0. Exit");
		System.out.print("> ");
	}

	private void showOrderByIdAsc() {
		List<Order> orders = new ArrayList<>(this.orders);// clone this.orders
		orders.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
		printAllOrder(orders);
	}

	private void sortOrderByPriceDesc() {
		Collections.sort(orders);
		printAllOrder(orders);
	}

	private void updatePriceForProduct() {

		System.out.println("Enter Id:");
		int id = checkInputInt();

		Product product = findProductById(id);
		if (product != null) {
			System.out.println("Enter new Price:");
			double price = checkInputDouble();
			product.setPrice(price);

			System.out.println("Update success!");
		} else {
			System.out.println("Id not exists!");
		}
	}

}
