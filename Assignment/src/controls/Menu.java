package controls;

import validation.Validation;

public class Menu {

	public int menuAdmin() {
		System.out.println("-----ADMIN-----");
		System.out.println("1. Add Items");
		System.out.println("2. Update Items");
		System.out.println("3. View Items");
		System.out.println("4. Remove Items");
		System.out.println("0. Back");
		System.out.print("> ");
		return Validation.checkInputIntLimit(0, 4);
	}

	public int menuCustomer() {
		System.out.println("-----CUSTOMER-----");
		System.out.println("1. Add to Shopping Basket");
		System.out.println("2. Display the Shopping Basket");
		System.out.println("3. Remove from Shopping Basket");
		System.out.println("4. Print Invoice(Orders)");
		System.out.println("0. Back");
		System.out.print("> ");
		return Validation.checkInputIntLimit(0, 4);
	}

	public int menuHome() {
		System.out.println("-------------");
		System.out.println("1. Menu Admin");
		System.out.println("2. Menu Customer");
		System.out.println("0. Exit");
		System.out.print("> ");

		return Validation.checkInputIntLimit(0, 2);
	}

}
