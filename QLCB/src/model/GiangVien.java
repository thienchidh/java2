package model;

public class GiangVien extends CanBo {

	private String khoa;

	private String trinhDo;

	private int soTietDay;

	public GiangVien() {
		super();
	}

	public GiangVien(String hoTen, double heSoLuong, double phuCap, String khoa, String trinhDo, int soTietDay) {
		super(hoTen, heSoLuong, phuCap);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiangVien other = (GiangVien) obj;
		if (khoa == null) {
			if (other.khoa != null)
				return false;
		} else if (!khoa.equals(other.khoa))
			return false;
		if (soTietDay != other.soTietDay)
			return false;
		if (trinhDo == null) {
			if (other.trinhDo != null)
				return false;
		} else if (!trinhDo.equals(other.trinhDo))
			return false;
		return true;
	}

	public String getKhoa() {
		return khoa;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((khoa == null) ? 0 : khoa.hashCode());
		result = prime * result + soTietDay;
		result = prime * result + ((trinhDo == null) ? 0 : trinhDo.hashCode());
		return result;
	}

	@Override
	public void nhap() {
		System.out.println("Khoa");
		khoa = sc.nextLine().trim();

		System.out.println("Trình độ");

		System.out.println(CU_NHAN + ": 0");
		System.out.println(THAC_SI + ": 1");
		System.out.println(TIEN_SI + ": 2");

		int x = Integer.parseInt(sc.nextLine().trim());
		if (x == 0) {
			trinhDo = CU_NHAN;
			phuCap = 300;
		} else if (x == 1) {
			trinhDo = THAC_SI;
			phuCap = 500;
		} else if (x == 2) {
			trinhDo = TIEN_SI;
			phuCap = 1000;
		} else {
			throw new RuntimeException("Chọn sai...");
		}

		System.out.println("Số tiết dạy:");
		soTietDay = Integer.parseInt(sc.nextLine().trim());
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	@Override
	public double tinhLuong() {
		return heSoLuong * 730 + phuCap + soTietDay * 45;
	}

	@Override
	public String toString() {
		return "GiangVien [khoa=" + khoa + ", trinhDo=" + trinhDo + ", soTietDay=" + soTietDay + "]";
	}

}
