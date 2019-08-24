package model;

public class Student {
	private int mssv;
	private String ten;
	private int namSinh;
	private String khoa;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int mssv, String ten, int namSinh, String khoa) {
		super();
		this.mssv = mssv;
		this.ten = ten;
		this.namSinh = namSinh;
		this.khoa = khoa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (khoa == null) {
			if (other.khoa != null)
				return false;
		} else if (!khoa.equals(other.khoa))
			return false;
		if (mssv != other.mssv)
			return false;
		if (namSinh != other.namSinh)
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		return true;
	}

	public String getKhoa() {
		return khoa;
	}

	public int getMssv() {
		return mssv;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public String getTen() {
		return ten;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((khoa == null) ? 0 : khoa.hashCode());
		result = prime * result + mssv;
		result = prime * result + namSinh;
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		return result;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Override
	public String toString() {
		return "Student [mssv=" + mssv + ", ten=" + ten + ", namSinh=" + namSinh + ", khoa=" + khoa + "]";
	}

}
