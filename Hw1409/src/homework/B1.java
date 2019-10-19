package homework;

import java.util.ArrayList;

public class B1 {
	public static void main(String[] args) {

		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(0);
		System.out.println(integers);

		ArrayList<Double> doubles = new ArrayList<>();
		doubles.add(55.5);
		System.out.println(doubles);

		ArrayList<Boolean> booleans = new ArrayList<>();
		booleans.add(true);
		System.out.println(booleans);

		ArrayList<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("0");
		System.out.println(strings);
	}
}