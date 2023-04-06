package Tuan03_01_DanhSachPhongBanJTree;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachNhanVien implements Serializable{
	ArrayList<NhanVien> lstNhanVien;

	public DanhSachNhanVien() {
		lstNhanVien = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getLstNhanVien() {
		return lstNhanVien;
	}

	public void setLstNhanVien(ArrayList<NhanVien> lstNhanVien) {
		this.lstNhanVien = lstNhanVien;
	}
	
	public boolean addNhanVien(NhanVien item) {
		if(lstNhanVien.contains(item))
			return false;
		lstNhanVien.add(item);
		return true;
	}
	
	public void replaceID(NhanVien e)
	{
		lstNhanVien.set(lstNhanVien.indexOf(e),e);
	}
	
	public boolean capNhatNhapVien(NhanVien item) {
		int index = lstNhanVien.indexOf(item);
		if (index > 0) {
			lstNhanVien.set(index, item);
			return true;
		}
		return false;
	}
		
	public boolean xoaNhanVien(NhanVien item) {
		lstNhanVien.remove(item);
		return true;
	}
	
	public int size() {
		return lstNhanVien.size();
	}
	
	public ArrayList<NhanVien> timID(String id) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		for (NhanVien item : lstNhanVien) {
			if(item.getMaNV().contains(id)) {
				ds.add(item);
			}
		}
		return ds;
	}
}

