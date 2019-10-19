package b1.model;

public class SinhVien {
	private String masv;
	private String hoTen;
	private String diem;
	private String xepLoai;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String masv, String hoTen, String diem, String xepLoai) {
		super();
		this.masv = masv;
		this.hoTen = hoTen;
		this.diem = diem;
		this.xepLoai = xepLoai;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		if (diem == null) {
			if (other.diem != null)
				return false;
		} else if (!diem.equals(other.diem))
			return false;
		if (hoTen == null) {
			if (other.hoTen != null)
				return false;
		} else if (!hoTen.equals(other.hoTen))
			return false;
		if (masv == null) {
			if (other.masv != null)
				return false;
		} else if (!masv.equals(other.masv))
			return false;
		if (xepLoai == null) {
			if (other.xepLoai != null)
				return false;
		} else if (!xepLoai.equals(other.xepLoai))
			return false;
		return true;
	}

	public String getDiem() {
		return diem;
	}

	public String getHoTen() {
		return hoTen;
	}

	public String getMasv() {
		return masv;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diem == null) ? 0 : diem.hashCode());
		result = prime * result + ((hoTen == null) ? 0 : hoTen.hashCode());
		result = prime * result + ((masv == null) ? 0 : masv.hashCode());
		result = prime * result + ((xepLoai == null) ? 0 : xepLoai.hashCode());
		return result;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", hoTen=" + hoTen + ", diem=" + diem + ", xepLoai=" + xepLoai + "]";
	}

}
