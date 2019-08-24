package model;

import java.util.Scanner;

public abstract class CanBo {
	protected static final String CU_NHAN = "Cử nhân";
	protected static final String THAC_SI = "Thạc sĩ";
	protected static final String TIEN_SI = "Tiến sĩ";

	protected static final String TRUONG_PHONG = "Cử nhân";
	protected static final String PHO_PHONG = "Phó phòng";
	protected static final String NHAN_VIEN = "Nhân viên";

	protected static final Scanner sc = new Scanner(System.in);

	protected String hoTen;
	protected double heSoLuong;
	protected double phuCap;

	public CanBo() {
		super();
	}

	public CanBo(String hoTen, double heSoLuong, double phuCap) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CanBo other = (CanBo) obj;
		if (Double.doubleToLongBits(heSoLuong) != Double.doubleToLongBits(other.heSoLuong))
			return false;
		if (hoTen == null) {
			if (other.hoTen != null)
				return false;
		} else if (!hoTen.equals(other.hoTen))
			return false;
		if (Double.doubleToLongBits(phuCap) != Double.doubleToLongBits(other.phuCap))
			return false;
		return true;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public double getPhuCap() {
		return phuCap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(heSoLuong);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hoTen == null) ? 0 : hoTen.hashCode());
		temp = Double.doubleToLongBits(phuCap);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public abstract void nhap();

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public abstract double tinhLuong();

	@Override
	public String toString() {
		return "CanBo [hoTen=" + hoTen + ", heSoLuong=" + heSoLuong + ", phuCap=" + phuCap + "]";
	}

}