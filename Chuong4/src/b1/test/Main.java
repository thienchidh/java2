package b1.test;

import b1.model.SinhVien;
import static validation.Validation.*;

public class Main {
	public static void main(String[] args) {

		System.out.println("Moi Nhap:");
		SinhVien sv = new SinhVien(checkInputString(), checkInputString(), checkInputString(), checkInputString());

		System.out.println(sv);
	}
}
