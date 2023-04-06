package Tuan03_01_DanhSachPhongBanJTree;

import java.util.ArrayList;

public class DanhSachPhongBan {
	private ArrayList<PhongBan> listPhongBan;

	public DanhSachPhongBan() {
		super();
		listPhongBan = new ArrayList<PhongBan>();
	}

	public DanhSachPhongBan(ArrayList<PhongBan> list) {
		super();
		this.listPhongBan = list;
	}
	
	public boolean addPhongBan(PhongBan x) {
		if(listPhongBan.contains(x)) {
			return false;
		}else
			return listPhongBan.add(x);
	}
	
	public boolean deletePhongBan(PhongBan pb) {
		if(!listPhongBan.contains(pb))
			return false;
		else
			return listPhongBan.remove(pb);
	}
	
	public ArrayList<PhongBan> getListPb() {
		return listPhongBan;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
