package b1.packagedemo;

import java.util.Scanner;

import b1.letmecaculate.Calculator;

public class PackageDemo {
	public void caculate() {
		try (Scanner sc = new Scanner(System.in)) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());

			System.out.println(new Calculator().add(a, b));
		}
	}
}
