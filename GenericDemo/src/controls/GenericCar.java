package controls;

import java.util.ArrayList;
import java.util.List;

public class GenericCar<T> {
	List<T> list;

	public GenericCar() {
		super();
		list = new ArrayList<>();
	}

	public boolean add(T o) {
		return list.add(o);
	}

	public boolean checkEmpty() {
		return list.isEmpty();
	}

	public void delete(int pos) {
		list.remove(pos);
	}

	public void display() {
		for (T t : list) {
			System.out.println(t);
		}
	}

	public int getSize() {
		return list.size();
	}

}