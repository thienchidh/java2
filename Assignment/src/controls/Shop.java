package controls;

import java.util.Objects;

public class Shop {
	Store store;
	Basket basket;
	String customerName;

	public Shop() {
		super();
		store = new Store();
		basket = new Basket();
	}

	public Shop(Store store, Basket basket, String customerName) {
		super();

		Objects.requireNonNull(store);
		Objects.requireNonNull(basket);
		Objects.requireNonNull(customerName);

		this.store = store;
		this.basket = basket;
		this.customerName = customerName;
	}

	public Shop(String customerName) {
		this();

		Objects.requireNonNull(customerName);

		this.customerName = customerName;
	}

	public Basket getBasket() {
		return basket;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Store getStore() {
		return store;
	}

}
