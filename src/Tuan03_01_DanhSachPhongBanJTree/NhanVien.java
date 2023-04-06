package Tuan03_01_DanhSachPhongBanJTree;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String maNV, ho, ten, phai, mapb;
	private int tuoi;
	private double tienLuong;

	public NhanVien(String maNV, String ho, String ten, String phai, int tuoi, double tienLuong) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}

	public NhanVien(String maNV, String mapb, String ho, String ten, String phai, int tuoi, double tienLuong) {
		super();
		this.maNV = maNV;
		this.mapb = mapb;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object[] getObjectNv() {
		Object[] obj = { getMaNV(), getTen(), getHo(), getPhai(), getTuoi(), getTienLuong() };
		return obj;
	}

	public NhanVien(String maNV) {
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
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

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return getHo() + " " +getTen();
	}

}
