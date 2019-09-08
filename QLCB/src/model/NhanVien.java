package model;

public class NhanVien extends CanBo {
	private String phongBan;
	private int soNgayCong;
	private String chucVu;

	public NhanVien() {
		super();
	}

	public NhanVien(String hoTen, double heSoLuong, double phuCap, String phongBan, int soNgayCong, String chucVu) {
		super(hoTen, heSoLuong, phuCap);
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (chucVu == null) {
			if (other.chucVu != null)
				return false;
		} else if (!chucVu.equals(other.chucVu))
			return false;
		if (phongBan == null) {
			if (other.phongBan != null)
				return false;
		} else if (!phongBan.equals(other.phongBan))
			return false;
		if (soNgayCong != other.soNgayCong)
			return false;
		return true;
	}

	public String getChucVu() {
		return chucVu;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chucVu == null) ? 0 : chucVu.hashCode());
		result = prime * result + ((phongBan == null) ? 0 : phongBan.hashCode());
		result = prime * result + soNgayCong;
		return result;
	}

	@Override
	public void nhap() {
		super.nhap();

		System.out.println("Phòng ban:");
		phongBan = sc.nextLine().trim();

		System.out.println("Số ngày công:");
		soNgayCong = Integer.parseInt(sc.nextLine().trim());

		System.out.println("Chức vụ:");
		System.out.println(TRUONG_PHONG + ": 0");
		System.out.println(PHO_PHONG + ": 1");
		System.out.println(NHAN_VIEN + ": 2");

		int x = Integer.parseInt(sc.nextLine().trim());
		if (x == 0) {
			chucVu = TRUONG_PHONG;
			phuCap = 2000;
		} else if (x == 1) {
			chucVu = PHO_PHONG;
			phuCap = 1000;
		} else if (x == 2) {
			chucVu = NHAN_VIEN;
			phuCap = 500;
		} else {
			throw new RuntimeException("Chọn sai...");
		}
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	@Override
	public double tinhLuong() {
		return heSoLuong * 730 + phuCap + soNgayCong * 200;
	}

	@Override
	public String toString() {
		return "NhanVien [phongBan=" + phongBan + ", soNgayCong=" + soNgayCong + ", chucVu=" + chucVu + "]";
	}
}
