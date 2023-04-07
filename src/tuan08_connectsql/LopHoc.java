package tuan08_connectsql;

import java.util.Objects;

public class LopHoc {
	private String maSV, ho, ten, phai, email, diachi, maLop;

	@Override
	public String toString() {
		return "LopHoc [maSV=" + maSV + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", email=" + email
				+ ", diachi=" + diachi + ", maLop=" + maLop + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LopHoc other = (LopHoc) obj;
		return Objects.equals(maSV, other.maSV);
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LopHoc(String maSV, String ho, String ten, String phai, String email, String diachi, String maLop) {
		super();
		this.maSV = maSV;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.email = email;
		this.diachi = diachi;
		this.maLop = maLop;
	}
}
