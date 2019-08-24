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
		// TODO Auto-generated method stub

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
