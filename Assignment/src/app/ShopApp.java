package app;

import java.util.List;

import controls.Basket;
import controls.Menu;
import controls.Shop;
import controls.Store;
import model.ShopItem;
import validation.Validation;

public class ShopApp {
	public static void main(String[] args) {
		new ShopApp().run();
	}

	Menu menu;
	Shop shop;

	public ShopApp() {
		super();
		menu = new Menu();
		shop = new Shop("");
	}

	private void addToShopingBasket() {
		
		shop.getStore().displayItems();

		Basket basket = shop.getBasket();

		System.out.println("Enter name");
		String name = Validation.checkInputString();

		ShopItem item = shop.getStore().findItemByName(name);
		if (item != null) {
			System.out.println("Enter Quantity");
			int quantity = Validation.checkInputInt();
			boolean addItem = basket.addItem(item, quantity);
			if (addItem) {
				System.out.println("Success!");
			} else {
				System.out.println("Failed!");
			}
		} else {
			System.out.println("Not found!");
		}
		return;
	}

	private boolean handleAdminChoice(int id) {
		Store store = shop.getStore();

		switch (id) {
		case 1:
			store.addItems();
			break;
		case 2:
			store.updateItems();
			break;
		case 3:
			store.viewItems();
			break;
		case 4:
			store.removeItems();
			break;
		case 0:
			return true;
		}
		return false;

	}

	private boolean handleCustomerChoice(int id) {

		switch (id) {
		case 1: {
			addToShopingBasket();
			break;
		}
		case 2:
			shop.getBasket().display();
			break;
		case 3:
			removeFromBasket();
			break;
		case 4:
			printInvoice();
			break;
		case 0:
			return true;
		}
		return false;
	}

	private void handleHome(int choice) {
		switch (choice) {
		case 0:
			System.exit(0);
			break;
		case 1: {
			while (true) {
				int id = menu.menuAdmin();
				boolean b = handleAdminChoice(id);
				if (b) {
					break;
				}
			}
			break;
		}
		case 2: {
			while (true) {
				int id = menu.menuCustomer();
				boolean b = handleCustomerChoice(id);
				if (b) {
					break;
				}
			}
			break;
		}

		default:
			break;
		}

	}

	private void printInvoice() {
		System.out.println(shop.getCustomerName());
		List<ShopItem> items = shop.getBasket().getItems();
		shop.getBasket().display();

		double total = 0.0;
		for (ShopItem shopItem : items) {
			total += shopItem.computeFee();
		}

		System.out.println("TOTAL = " + total);
	}

	private void removeFromBasket() {
		System.out.println("Enter name");
		String name = Validation.checkInputString();

		ShopItem item = shop.getStore().findItemByName(name);
		Basket basket = shop.getBasket();
		if (item != null) {
			boolean b = basket.removeItem(item);
			if (b) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}
		} else {
			System.out.println("Not found!");
		}
	}

	private void run() {

		while (true) {
			int choice = menu.menuHome();
			handleHome(choice);
		}

	}
}
