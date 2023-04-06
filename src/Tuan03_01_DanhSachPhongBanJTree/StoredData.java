package Tuan03_01_DanhSachPhongBanJTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class StoredData {
	public boolean saveFile(Object obj, String path) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}

	public Object loadFile(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	public DanhSachNhanVien read_NV(String part) throws IOException {
		DanhSachNhanVien ds = new DanhSachNhanVien();
		File f = new File(part);
		if (f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split(";");
				NhanVien nv = new NhanVien(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
						Double.parseDouble(data[5]));
				ds.addNhanVien(nv);
			}
		} else {
			f.createNewFile();
		}
		return ds;
	}

	public boolean writeNV(String part, DanhSachNhanVien ds) throws FileNotFoundException {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(part), true)) {
			for (NhanVien nv : ds.getLstNhanVien()) {
				String data = nv.getMaNV() + ";" + nv.getTen() + ";" + nv.getHo() + ";" + nv.getPhai() + ";" + nv.getTuoi() + ";" + nv.getTienLuong();
				out.println(data);
			}
			return true;
		}
	}
}
