package controls;

import java.util.ArrayList;
import java.util.List;

import model.Flower;

public class ListFlower {
	private List<Flower> list;

	public ListFlower() {
		super();
		list = new ArrayList<>();
	}

	public boolean add(Flower o) {
		return list.add(o);
	}

	public boolean checkEmpty() {
		return list.isEmpty();
	}

	public void delete(int pos) {
		list.remove(pos);
	}

	public void display() {
		for (Flower t : list) {
			System.out.println(t);
		}
	}

	public int find(Flower o) {
		return list.indexOf(o);
	}

	public int getSize() {
		return list.size();
	}

	public void sort() {
		list.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
		display();
	}

}
