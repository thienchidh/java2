package controls;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.ShopItem;
import model.Software;
import validation.Validation;

public class Store {
	List<ShopItem> items;

	public Store() {
		super();
		items = new ArrayList<>();
	}

	public void addItems() {
		System.out.println("Type: Software(1) / Book(2)");
		System.out.println("Enter type (1)/(2): ");
		int type = Validation.checkInputIntLimit(1, 2);

		ShopItem item = makeItem(type);
		items.add(item);
	}

	public void displayItems() {
		System.out.println("Available items:");
		for (ShopItem shopItem : items) {
			System.out.println(shopItem);
		}
		System.out.println("________________");
	}

	public int findIndexByName(String name) {
		for (int i = 0; i < items.size(); ++i) {
			if (items.get(i).getTitle().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public ShopItem findItemByName(String name) {
		int idx = findIndexByName(name);
		if (idx != -1) {
			return items.get(idx);
		}
		return null;
	}

	private ShopItem makeItem(int type) {
		System.out.println("Title:");
		String title = Validation.checkInputString();
		System.out.println("Price:");
		double price = Validation.checkInputDouble();
		System.out.println("Quantity:");
		int quantity = Validation.checkInputInt();

		ShopItem item;
		if (type == 1) {
			System.out.println("Num Of CD:");
			int numOfCD = Validation.checkInputInt();
			item = new Software(title, price, quantity, numOfCD);
		} else {
			System.out.println("weight:");
			double weight = Validation.checkInputDouble();
			item = new Book(title, price, quantity, weight);
		}

		return item;
	}

	public void removeItems() {
		System.out.println("Name:");
		String name = Validation.checkInputString();

		ShopItem shopItem = findItemByName(name);
		boolean remove = items.remove(shopItem);
		if (remove) {
			System.out.println("Success!");
		} else {
			System.out.println("Failed!");
		}
	}

	public void updateItems() {
		System.out.println("Name:");
		String name = Validation.checkInputString();

		ShopItem shopItem = findItemByName(name);
		ShopItem item = null;
		if (shopItem instanceof Book) {
			item = makeItem(2);
		} else if (shopItem instanceof ShopItem) {
			item = makeItem(1);
		}
		boolean updated = false;
		if (item != null) {
			int index = findIndexByName(name);
			items.set(index, item);
			updated = true;
		}

		if (updated) {
			System.out.println("Success!");
		} else {
			System.out.println("Failed!");
		}
	}

	public void viewItems() {
		displayItems();
	}

}