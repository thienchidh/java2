package controls;

import java.util.ArrayList;
import java.util.List;

import model.ShopItem;

public class Basket {
	List<ShopItem> items;

	public Basket() {
		super();
		items = new ArrayList<>();
	}

	public boolean addItem(ShopItem item, int quantity) {
		if (item.getQuantity() >= quantity) {
			item.setQuantity(item.getQuantity() - quantity);

			ShopItem clone = item.clone();
			clone.setQuantity(quantity);
			return items.add(clone);
		}
		return false;
	}

	public void display() {
		for (ShopItem shopItem : items) {
			System.out.println(shopItem);
		}
	}

	public List<ShopItem> getItems() {
		return items;
	}

	public boolean removeItem(ShopItem item) {
		return items.remove(item);
	}

}
