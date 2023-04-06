package Tuan02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener, MouseListener, WindowListener {
	private JTable table;
	private DefaultTableModel model;
	private JButton btnTim, btnThem, btnXoaTrang, btnXoa, btnLuu, btnQuayLai;
	private JTextField txtTim;
	private JTextField txtMaNV, txtHo, txtTenNV, txtTuoi, txtTienLuong;
	private JRadioButton rdobtnNam, rdobtnNu;
	private ButtonGroup btngrPhai;
	private DanhSachNhanVien lstNhanVien = new DanhSachNhanVien();
	private JComboBox cboset;
	private String[] cols = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
	private JButton btnSua;
	private StoredData stData = new StoredData();

	public GUI() {
		setTitle("Thông tin nhân viên");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 590);
		setLocationRelativeTo(null);
		setResizable(false);

		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		Font fontsouth = new Font("Time New Roman", Font.BOLD, 14);

		JPanel pnNorth;
		add(pnNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;
		pnNorth.add(lblTieuDe = new JLabel("Thông tin nhân viên"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		lblTieuDe.setForeground(new Color(0, 40, 255));

		JPanel pnCenter;
		add(pnCenter = new JPanel(), BorderLayout.CENTER);
		pnCenter.setLayout(null);
		pnCenter.setBorder(BorderFactory.createLoweredBevelBorder());

		JLabel lblMaNV, lblHo, lblTuoi, lblTienLuong, lblTenNV, lblPhai, lblNam, lblNu;
		pnCenter.add(lblMaNV = new JLabel("Mã nhân viên:"));
		int x = 30, y = 10, width = 100, height = 30;
		lblMaNV.setBounds(x, y, width, height);
		lblMaNV.setFont(font);

		pnCenter.add(lblHo = new JLabel("Họ:"));
		y += 40;
		lblHo.setBounds(x, y, width, height);
		lblHo.setFont(font);

		pnCenter.add(lblTuoi = new JLabel("Tuổi:"));
		y += 40;
		lblTuoi.setBounds(x, y, width, height);
		lblTuoi.setFont(font);

		pnCenter.add(lblTienLuong = new JLabel("Tiền lương:"));
		y += 40;
		lblTienLuong.setBounds(x, y, width, height);
		lblTienLuong.setFont(font);

		pnCenter.add(txtMaNV = new JTextField());
		x += 120;
		y = 10;
		width += 550;
		txtMaNV.setBounds(x, y, width, height);
		txtMaNV.setFont(font);

		pnCenter.add(txtHo = new JTextField());
		y += 40;
		txtHo.setBounds(x, y, 250, height);
		txtHo.setFont(font);

		pnCenter.add(lblTenNV = new JLabel("Tên nhân viên:"));
		x += 270;
		lblTenNV.setBounds(x, y, 120, height);
		lblTenNV.setFont(font);

		pnCenter.add(txtTenNV = new JTextField());
		x += 120;
		txtTenNV.setBounds(x, y, 260, 30);
		txtTenNV.setFont(font);

		pnCenter.add(txtTuoi = new JTextField());
		x = 150;
		y += 40;
		txtTuoi.setBounds(x, y, 330, height);
		txtTuoi.setFont(font);

		pnCenter.add(lblPhai = new JLabel("Phái:"));
		lblPhai.setFont(font);
		lblPhai.setBounds(500, y, 50, height);

		pnCenter.add(lblNam = new JLabel("Nam"));
		pnCenter.add(lblNu = new JLabel("Nữ"));
		lblNam.setFont(font);
		lblNu.setFont(font);
		lblNam.setBounds(600, y, 50, height);
		lblNu.setBounds(730, y, 50, height);

		pnCenter.add(rdobtnNam = new JRadioButton());
		rdobtnNam.setBounds(570, y, 30, height);
		pnCenter.add(rdobtnNu = new JRadioButton());
		rdobtnNu.setBounds(700, y, 30, height);

		btngrPhai = new ButtonGroup();
		btngrPhai.add(rdobtnNu);
		btngrPhai.add(rdobtnNam);
		rdobtnNam.setSelected(true);

		pnCenter.add(txtTienLuong = new JTextField());
		y += 40;
		txtTienLuong.setBounds(150, y, width, height);
		txtTienLuong.setFont(font);

		cboset = new JComboBox();
		cboset.addItem("Nam");
		cboset.addItem("Nữ");

		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setBackground(Color.pink);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		DefaultCellEditor de = new DefaultCellEditor(cboset);
		table.getColumnModel().getColumn(3).setCellEditor(de);
		table.setRowHeight(20);
		pnCenter.add(pane);
		y += 40;
		pane.setBounds(5, y, 828, 270);

		// load data từ file và thêm data vào
		try {
			lstNhanVien = (DanhSachNhanVien) stData.read_NV("Data//EmployeeData.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadDataToTable(lstNhanVien.getLstNhanVien(), model);

		JPanel pnSouth;
		add(pnSouth = new JPanel(), BorderLayout.SOUTH);
		pnSouth.setBorder(BorderFactory.createLoweredBevelBorder());
		JPanel pnTim = new JPanel();
		pnTim.setBorder(BorderFactory.createLoweredBevelBorder());
		pnTim.setPreferredSize(new Dimension(350, 40));
		JLabel lblTim = new JLabel("Nhập mã cần tìm:");
		pnTim.add(lblTim);
		pnTim.add(txtTim = new JTextField(10));
		pnTim.add(btnTim = new JButton("Tìm"));
		pnSouth.add(pnTim);

		JPanel pnControl = new JPanel();
		pnControl.setPreferredSize(new Dimension(450, 40));
		pnControl.setBorder(BorderFactory.createLoweredBevelBorder());
		pnControl.add(btnThem = new JButton("Thêm"));
		pnControl.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnControl.add(btnXoa = new JButton("Xóa"));
		pnControl.add(btnSua = new JButton("Sửa"));
		pnControl.add(btnLuu = new JButton("Lưu"));
		pnControl.add(btnQuayLai = new JButton("Quay lại"));
		pnSouth.add(pnControl);

		lblTim.setFont(fontsouth);
		txtTim.setFont(fontsouth);

		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		addWindowListener(this);
		
		NhapCung();
	}

	public static void main(String[] args) {
		new GUI().setVisible(true);
	}

	public void loadDataToTable(ArrayList<NhanVien> lst, DefaultTableModel tblModel) {
		for (NhanVien item : lst) {
			Object[] obj = { item.getMaNV(), item.getHo(), item.getTen(), item.getPhai(), item.getTuoi(),
					item.getTienLuong() };
			tblModel.addRow(obj);
		}
	}

	public NhanVien createNewEmployee() {
		NhanVien item;
		String id, ho, ten, phai;
		double tienLuong = 0;
		int tuoi = 0;
		id = txtMaNV.getText();
		ho = txtHo.getText();
		ten = txtTenNV.getText();
		if (rdobtnNam.isSelected())
			phai = "Nam";
		else
			phai = "Nữ";
		try {
			tienLuong = Double.parseDouble(txtTienLuong.getText());
			if (tienLuong < 0) {
				JOptionPane.showMessageDialog(this, "Tiền lương không được bé hơn 0!!");
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Tiền lương không hợp lệ!!");
			return null;
		}
		try {
			tuoi = Integer.parseInt(txtTuoi.getText());
			if (tuoi < 0) {
				JOptionPane.showMessageDialog(this, "Tuổi không được bé hơn 0!!");
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ!!");
			return null;
		}
		item = new NhanVien(id, ho, ten, phai, tuoi, tienLuong);
		return item;
	}

	public void XoaTrang() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTenNV.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		rdobtnNam.setSelected(true);
		txtMaNV.requestFocus();
	}

	public void NhapCung() {
		txtMaNV.setText("NV123");
		txtHo.setText("Le");
		txtTenNV.setText("Vu Phong");
		txtTuoi.setText("21");
		txtTienLuong.setText("999999");
		rdobtnNam.setSelected(true);
	}
	
	public void loadDateToText(NhanVien item) {
		txtHo.setText(item.getHo());
		txtTenNV.setText(item.getTen());
		txtMaNV.setText(item.getMaNV());
		txtTuoi.setText(item.getTuoi() + "");
		txtTienLuong.setText(item.getTienLuong() + "");
		if (item.getPhai().equals("Nam"))
			rdobtnNam.setSelected(true);
		else
			rdobtnNu.setSelected(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(validData()) {	
				if (txtMaNV.getText().equals("") || txtHo.getText().equals("") || txtTenNV.getText().equals("")
						|| txtTienLuong.getText().equals("") || txtTuoi.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!!");
				} else {
					NhanVien employee = createNewEmployee();
					if (employee != null) {
						if (lstNhanVien.addNhanVien(employee)) {
							model.setRowCount(0); // Xoa cac row trong model
							loadDataToTable(lstNhanVien.getLstNhanVien(), model);
							JOptionPane.showMessageDialog(this, "Thêm thành công");
							XoaTrang();
							btnLuu.setEnabled(true);
							btnXoa.setEnabled(true);
							btnTim.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(this, "Trùng mã!");
						}
					}
				}
			}
		} else if (o.equals(btnXoaTrang)) {
			XoaTrang();
		} else if (o.equals(btnLuu)) {
			try {
				StoredData stDate = new StoredData();
				if (stDate.writeNV("Data//EmployeeData.txt", lstNhanVien)) {
					JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thành công!!!");
				} else {
					JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thất bại!!");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (o.equals(btnXoa)) {
			deleteManyRowsSelected();
			XoaTrang();
		} else if (o.equals(btnTim)) {
			if (txtTim.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên để tìm kiếm!!");
			} else {
				String ID = txtTim.getText();
				ArrayList<NhanVien> dsemploy = lstNhanVien.timID(ID);
				if (dsemploy.size()!= 0) {
					table.setModel(model = new DefaultTableModel(cols, 0));
					for(NhanVien employ : dsemploy) {
						Object[] ob = { employ.getMaNV(), employ.getHo(), employ.getTen(), employ.getPhai(),
								employ.getTuoi(), employ.getTienLuong() };
						model.addRow(ob);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã nhân viên!");
				}
			}
		} else if (o.equals(btnQuayLai)) {
			table.setModel(model = new DefaultTableModel(cols, 0));
			try {
				lstNhanVien = (DanhSachNhanVien) stData.read_NV("Data//EmployeeData.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			loadDataToTable(lstNhanVien.getLstNhanVien(), model);
		} else if (o.equals(btnSua)) {
			sua();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row != -1) {
			NhanVien ee = lstNhanVien.getLstNhanVien().get(row);
			loadDateToText(ee);
		}
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

	public void clearDataOnTable() {
		while (model.getRowCount() > 0)
			model.removeRow(0);
	}

	public void deleteManyRowsSelected() {
		String listMaNV = "";
		String maNV = "";

		if (table.getSelectedRowCount() == 0)
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào để xóa!!");
		else {
			int[] listIndex = table.getSelectedRows();
			listMaNV += table.getValueAt(listIndex[0], 0);
			for (int i = 1; i < table.getSelectedRowCount(); i++) {
				listMaNV += ", " + table.getValueAt(listIndex[i], 0);
			}

			if ((JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên " + listMaNV + "?", "Lựa chọn",
					JOptionPane.YES_NO_CANCEL_OPTION)) == JOptionPane.YES_OPTION) {
				try {
					for (int i = 0; i < table.getSelectedRowCount(); i++) {
						maNV = (String) table.getValueAt(listIndex[i], 0);
						if (!lstNhanVien.xoaNhanVien(new NhanVien(maNV))) {
							JOptionPane.showConfirmDialog(null, "Xóa thất bại. Đã xãy ra lỗi!");
							table.clearSelection();
						}
					}
					clearDataOnTable();
					loadDataToTable(lstNhanVien.getLstNhanVien(), model);
				} catch (Exception e) {
					clearDataOnTable();
					loadDataToTable(lstNhanVien.getLstNhanVien(), model);
					JOptionPane.showMessageDialog(this, "Xóa thất bại. Đã xãy ra lỗi !!");
					System.out.println(e);
				}
			}
		}
	}

	private boolean isNumber(String x) {
		try {
			Double.parseDouble(x);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void showErrorField(String x, JTextField txt) {
		JOptionPane.showMessageDialog(null, x);
		txt.requestFocus();
	}

	// Lấy dữ liệu xuống từ thành thuộc tính nhân viên và kiểm tra ràng buộc
	public NhanVien genarateOBJ() {
		NhanVien temp;
		if (txtMaNV.getText().trim().length() == 0) {
			showErrorField("Hãy nhập mã nhân viên.!", txtHo);
			return null;
		}
		String maNV = txtMaNV.getText();

		if (txtHo.getText().trim().length() == 0) {
			showErrorField("Hãy nhập họ nhân viên!!", txtHo);
			return null;
		}
		String hoNV = txtHo.getText();

		if (txtTenNV.getText().trim().length() == 0) {
			showErrorField("Hãy nhập tên nhân viên!!", txtTenNV);
			return null;
		}
		String tenNV = txtTenNV.getText();

		if (!isNumber(txtTuoi.getText())) {
			showErrorField("Tuổi nhập vào phải là 1 số hợp lệ!!", txtTuoi);
			return null;
		}
		int tuoi = Integer.parseInt(txtTuoi.getText());

		if (!isNumber(txtTienLuong.getText())) {
			showErrorField("Tiền lượng nhập vào phải là một số hợp lệ!!", txtTienLuong);
			return null;
		}
		double tienLuong = Double.parseDouble(txtTienLuong.getText());

		String sex;
		if (rdobtnNu.isSelected())
			sex = "Nữ";
		else
			sex = "Nam";

		try {
			temp = new NhanVien(maNV, hoNV, tenNV, sex, tuoi, tienLuong);
			return temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public void sua() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn dòng nào!");
			return;
		}
		if (table.getSelectedRow() > 1) {
			JOptionPane.showMessageDialog(this, "Chỉ sửa được một dòng");
		}
		NhanVien e = genarateOBJ();
		if (e == null) {
			return;
		}
		
		try {
			lstNhanVien.replaceID(e);
			model.removeRow(table.getSelectedRow());
			model.insertRow(table.getSelectedRow(), e.getObjectNv());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Lỗi không xác định vui lòng kiểm tra lại!!");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		StoredData stDate = new StoredData();
		try {
			stDate.writeNV("Data//EmployeeData.txt", lstNhanVien);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean validData() {
		String maNV = txtMaNV.getText().trim();
		String ho = txtHo.getText().trim();
		String ten = txtTenNV.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		
		if(!(maNV.length() > 0 && maNV.matches("(NV)\\d{3}"))) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên theo mẫu: NV + 3 số");
			return false;
		}
		
		if(!(ho.length() > 0 && ho.matches("^[A-Z][a-z]+$"))) {
			JOptionPane.showMessageDialog(this, "Họ phải là một từ và viết hoa chữ đầu");
			return false;
		}
		if(!(ten.length() > 0 && ten.matches("^[A-Z][a-z]+\\s([A-Z][a-z]+)*"))){
			JOptionPane.showMessageDialog(this, "Tên phải là một hoặc nhiều từ và viết hoa chữ đầu và ngăn cách nhau bởi dấu cách");
			return false;
		}
		if(!(tuoi >= 18 && tuoi <=60)) {
			JOptionPane.showMessageDialog(this, "Tuổi phải từ 18 đến 60");
			return false;
		}
		return true;
	}
}