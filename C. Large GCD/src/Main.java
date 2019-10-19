import java.util.Scanner;

public class Main {

	static int power(int a, int k) {
		int r = 1;
		for (; k > 0; k >>= 1) {
			if ((k & 1) != 0) {
				r = r * a;
			}
			a = a * a;
		}
		return r;
	}

	static int F(int n, int m) {
		int a = 5;
		int b = 7;
		return b + power(-1, m + n) * a;
	}

	public static void main(String[] args) {

		int a = 0;
		for (int i = 0; i < 8e8; i++) {
			a++;
		}
		System.out.println(a);

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {

			System.out.println(F(sc.nextInt(), sc.nextInt()));
		}

//		sc.close();
	}
}
