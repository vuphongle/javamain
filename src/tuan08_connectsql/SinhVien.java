package tuan08_connectsql;

import java.util.Objects;

public class SinhVien {
	private String maLop, tenLop;

	public SinhVien(String maLop, String tenLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLop);
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
		return Objects.equals(maLop, other.maLop);
	}

	@Override
	public String toString() {
		return "SinhVien [maLop=" + maLop + ", tenLop=" + tenLop + "]";
	}

}
