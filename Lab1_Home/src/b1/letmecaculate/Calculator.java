package b1.letmecaculate;

public class Calculator {
	public int add(int... arr) {
		int rs = 0;
		for (int e : arr) {
			rs += e;
		}
		return rs;
	}

}
