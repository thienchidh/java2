package test;

import java.util.Arrays;

class MyTest {
	public static void main(String[] args) {
		String s1 = "parliament";
		String s2 = "partial men";

		boolean anagram = new MyTest().isAnagram(s1, s2);
		System.out.println(anagram);
	}

	public boolean isAnagram(String s1, String s2) {
		char[] x = removeDotSpace(s1).toCharArray();
		char[] y = removeDotSpace(s2).toCharArray();

		Arrays.sort(x);
		Arrays.sort(y);

		String sortX = new StringBuilder().append(x).toString();
		String sortY = new StringBuilder().append(y).toString();
		return sortX.equals(sortY);
	}

	private String removeDotSpace(String x) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length(); i++) {
			char at = x.charAt(i);
			if (at == ' ' || at == '.') {
				continue;
			}
			sb.append(at);
		}
		return sb.toString();
	}
}

public class TestEmployeeManager {

	public static void main(String[] args) {

		MyTest.main(args);
//		new EmploeeManagement().run();
	}

}
