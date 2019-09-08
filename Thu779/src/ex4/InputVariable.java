package ex4;

import java.util.Scanner;

public class InputVariable {

	private static final Scanner sc = new Scanner(System.in);

	public static float inputFloat() {
		return Float.parseFloat(sc.nextLine());
	}

	public static double inputDouble() {
		return Double.parseDouble(sc.nextLine());
	}

	public static int inputInteger() {
		return Integer.parseInt(sc.nextLine());
	}

	public static long inputLong() {
		return Long.parseLong(sc.nextLine());
	}

	public static String inputString() {
		return sc.nextLine();
	}

	public static char inputCharacter() {
		return sc.nextLine().charAt(0);
	}
}
