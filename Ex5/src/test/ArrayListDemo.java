package test;
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();

		strings.add("a b c");
		strings.add("b c d");
		strings.add("c d e");
		strings.add("d e f");

		for (String string : strings) {
			if (string.contains("d")) {
				System.out.println(string);
			}
		}
	}
}
