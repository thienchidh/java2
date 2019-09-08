package controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.CanBo;
import model.GiangVien;
import model.NhanVien;

public class QuanLyCanBo {

	private List<CanBo> canBos = new ArrayList<>();

	private Scanner sc = new Scanner(System.in);

	private int choice() {
		return Integer.parseInt(sc.nextLine().trim());
	}

	private void handle(int id) {

		switch (id) {
		case 0:
			System.err.println("bye!");
			System.exit(0);
		case 1:
			nhapCanBo();
			break;
		case 2:
			hienThiCanBo();
			break;
		case 3:
			tinhTongLuong();
			break;

		default:
			System.out.println("???");
			break;
		}

	}

	private void tinhTongLuong() {
		System.out.println("Tong luong tat ca can bo:");

		double s = 0;

		for (CanBo canBo : canBos) {
			s += canBo.tinhLuong();
		}

		System.out.println(s);
	}

	private void nhapCanBo() {
		System.out.println("Loai can bo:");
		System.out.println("1. Giang vien");
		System.out.println("2. Nhan vien");
		System.out.println("0. Back");
		System.out.print("> ");
		int x = choice();

		if (x == 0) {
			return;
		}
		if (x == 1) {
			CanBo canBo = new GiangVien();
			canBo.nhap();
			canBos.add(canBo);
		} else if (x == 2) {
			CanBo canBo = new NhanVien();
			canBo.nhap();
			canBos.add(canBo);
		}
	}

	private void hienThiCanBo() {
		for (CanBo canBo : canBos) {
			System.out.println(canBo);
		}
	}

	public void run() {
		while (true) {
			try {
				showMenu();
				int choiceId = choice();
				handle(choiceId);
			} catch (Exception e) {
				System.out.println("ensure you type correct!");
			}
		}
	}

	private void showMenu() {
		System.out.println("-------------------");
		System.out.println("1. nhap can bo");
		System.out.println("2. hien thi toan bo can bo");
		System.out.println("3. tinh tong luong");
		System.out.println("0. exit");
		System.out.print("> ");
	}
}
