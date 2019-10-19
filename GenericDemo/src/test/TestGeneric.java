package test;

import java.util.ArrayList;
import java.util.Collections;

import model.Actor;

public class TestGeneric {
	public static void main(String[] args) {

		ArrayList<Actor> list = new ArrayList<>();
		list.add(new Actor("Nguyễn Văn", "Tý"));
		list.add(new Actor("Nguyễn Văn", "Tòe"));
		list.add(new Actor("Nguyễn Văn", "Tèo"));
		list.add(new Actor("Trần Văn", "Tý"));
		list.add(new Actor("Nguyễn Thành", "Luân"));

		for (Actor actor : list) {
			System.out.println(actor);
		}
		Collections.sort(list);

		System.out.println("----------------");
		for (Actor actor : list) {
			System.out.println(actor);
		}
	}
}
