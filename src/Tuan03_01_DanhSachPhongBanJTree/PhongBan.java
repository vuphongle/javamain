package Tuan03_01_DanhSachPhongBanJTree;

import java.util.Objects;


public class PhongBan {
	private String maPB, tenPB;
	private DanhSachNhanVien listNV;

	
	public PhongBan() {
		super();
		listNV = new DanhSachNhanVien();
	}
	
	public PhongBan(String maPB, String tenPB) {
		super();
		try {
			setMaPB(maPB);
			setTenPB(tenPB);
			listNV = new DanhSachNhanVien();
		} catch (Exception e) {
			System.err.println("Lỗi");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(maPB, other.maPB);
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) throws Exception {
		if(maPB.trim().length() > 0)
			this.maPB = maPB;
		else
			throw new Exception("Mã Phòng ban không được rỗng!!");
	}

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) throws Exception {
		if(tenPB.trim().length() > 0)
			this.tenPB = tenPB;
		else
			throw new Exception("Tên Phòng ban không được rỗng!!");
	}

	public DanhSachNhanVien getListNV() {
		return listNV;
	}

	public void setListNV(DanhSachNhanVien listNV) {
		this.listNV = listNV;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tenPB;
	}
}
