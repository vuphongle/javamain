package Tuan03_01_DanhSachPhongBanJTree;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GUI_DanhSachPhongBan extends JFrame implements MouseListener {
	public JTree tree;
	private DefaultMutableTreeNode root;
	private DanhSachPhongBan listPhongBan;

	public GUI_DanhSachPhongBan() throws Exception {
		super("Danh sách phòng ban");
		setResizable(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);

		root = new DefaultMutableTreeNode("Danh sách phòng ban");

		tree = new JTree(root);
		
		this.add(tree);

		khoiTaoDanhSach();

		for (PhongBan x : listPhongBan.getListPb()) {
			root.add(new DefaultMutableTreeNode(x));
		}

		for (int i = 0; i < root.getChildCount(); i++) {
			PhongBan temp = (PhongBan) ((DefaultMutableTreeNode) (root.getChildAt(i))).getUserObject();
			DanhSachNhanVien dsTemp = temp.getListNV();
			for (NhanVien x : dsTemp.getLstNhanVien()) {
				((DefaultMutableTreeNode) root.getChildAt(i)).add(new DefaultMutableTreeNode(x));
			}
		}

		// Xổ cây con ra
		tree.expandPath(new TreePath(tree.getModel().getRoot()));
		tree.addMouseListener(this);
	}

	public static void main(String[] args) throws Exception {
		new GUI_DanhSachPhongBan().setVisible(true);
	}

	public void khoiTaoDanhSach() throws Exception {
		
		listPhongBan = new DanhSachPhongBan();
		PhongBan pb1 = new PhongBan("001", "Phòng tổ chức");
		PhongBan pb2 = new PhongBan("002", "Phòng kỹ thuật");
		listPhongBan.addPhongBan(pb1);
		listPhongBan.addPhongBan(pb2);

		try {
			NhanVien nv1 = new NhanVien("001", "001", "Dương", "Bảo", "Nam", 20, 100000);
			NhanVien nv2 = new NhanVien("002", "001", "Dương", "Hà", "Nữ", 25, 150000);
			NhanVien nv3 = new NhanVien("003", "001", "Trần", "Hoa", "Nữ", 30, 3300000);
			NhanVien nv4 = new NhanVien("004", "002", "Phú", "Cường", "Nam", 50, 230000);
			NhanVien nv5 = new NhanVien("005", "002", "Lý", "Hà", "Nữ", 27, 100400);
			NhanVien nv6 = new NhanVien("006", "002", "Dương", "Chí", "Nam", 40, 130000);

			pb1.getListNV().addNhanVien(nv1);
			pb1.getListNV().addNhanVien(nv2);
			pb1.getListNV().addNhanVien(nv3);

			pb2.getListNV().addNhanVien(nv4);
			pb2.getListNV().addNhanVien(nv5);
			pb2.getListNV().addNhanVien(nv6);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) path.getLastPathComponent();
			if (e.getClickCount() == 2) {
				if (dmt.getLevel() == 1) {
					Object obj = tree.getSelectionPath().getLastPathComponent();
					new GUI_JTableNhanVien((PhongBan) (((DefaultMutableTreeNode) obj).getUserObject())).setVisible(true);
				}
			}
		}
//		Object obj = tree.getSelectionPath().getLastPathComponent();
//		DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) obj;
//		DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
//		if (e.getClickCount() == 2) {
//			if (dmt.getLevel() == 1) {
//				new GUI_JTableNhanVien((PhongBan) (((DefaultMutableTreeNode) obj).getUserObject())).setVisible(true);
//				new GUI_JTableNhanVien(null).setVisible(true);
//			}
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
