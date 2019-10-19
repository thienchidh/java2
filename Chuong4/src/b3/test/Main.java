package b3.test;

import b3.model.Fraction;
import b3.model.FractionExepction;

public class Main {
	public static void main(String[] args) {

		Fraction fraction = new Fraction(2, 0);
		try {
			double kq = fraction.compute();
			System.out.println(kq);
		} catch (FractionExepction e) {
			System.err.println("Mau phai != 0");
		}
	}
}