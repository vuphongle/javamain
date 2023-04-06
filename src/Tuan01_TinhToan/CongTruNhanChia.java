package Tuan01_TinhToan;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CongTruNhanChia extends JFrame implements ActionListener {
//	private JTextField txtTieuDe;
	private JButton btnGiai, btnXoa, btnThoat;
	private JTextField txtA, txtB, txtKQ;
	private JRadioButton rdobtnPhepCong, rdobtnPhepNhan, rdobtnPhepTru, rdobtnPhepChia;

	public CongTruNhanChia() {
		// TODO Auto-generated constructor stub
		setTitle("Cộng trừ nhân chia");
		setSize(500, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel panelTieuDe;
		add(panelTieuDe = new JPanel(), BorderLayout.NORTH);
		JLabel jlbTieuDe;
		panelTieuDe.add(jlbTieuDe = new JLabel("Cộng trừ nhân chia"));
		jlbTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		jlbTieuDe.setForeground(new Color(0, 40, 255));

		JPanel panelWest;
		add(panelWest = new JPanel(), BorderLayout.WEST);
		panelWest.setBackground(new Color(192, 192, 192));
		panelWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		JPanel panelTacVu;
		panelWest.add(panelTacVu = new JPanel());
		panelTacVu.setLayout(new GridLayout(8, 1));
		panelTacVu.setBackground(new Color(192, 192, 192));
		panelTacVu.add(btnGiai = new JButton("Giải"));
		panelTacVu.add(btnXoa = new JButton("Xóa"));
		panelTacVu.add(btnThoat = new JButton("Thoát"));

		JPanel panelSouth;
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(248, 174, 174));
		panelSouth.setPreferredSize(new Dimension(panelWest.getPreferredSize().width, 40));

		JLabel blackRect1 = new JLabel();
		blackRect1.setOpaque(true);
		blackRect1.setBackground(new Color(63, 78, 208));
		blackRect1.setPreferredSize(new Dimension(20, 20));
		panelSouth.add(blackRect1);

		JLabel blackRect2 = new JLabel();
		blackRect2.setOpaque(true);
		blackRect2.setBackground(new Color(225, 17, 29));
		blackRect2.setPreferredSize(new Dimension(20, 20));
		panelSouth.add(blackRect2);

		JLabel blackRect3 = new JLabel();
		blackRect3.setOpaque(true);
		blackRect3.setBackground(new Color(254, 240, 0));
		blackRect3.setPreferredSize(new Dimension(20, 20));
		panelSouth.add(blackRect3);

		JPanel jpanelCenter;
		add(jpanelCenter = new JPanel(), BorderLayout.CENTER);
		jpanelCenter.setLayout(null);
		jpanelCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));

		JLabel lblNhapA, lblNhapB, lblKetQua;
		jpanelCenter.add(lblNhapA = new JLabel("Nhập a: "));
		lblNhapA.setBounds(70, 20, 100, 20);
		jpanelCenter.add(txtA = new JTextField());
		txtA.setBounds(130, 20, 210, 20);

		jpanelCenter.add(lblNhapB = new JLabel("Nhập b: "));
		lblNhapB.setBounds(70, 50, 100, 20);
		jpanelCenter.add(txtB = new JTextField());
		txtB.setBounds(130, 50, 210, 20);

		JPanel jpanelPhepToan;
		jpanelCenter.add(jpanelPhepToan = new JPanel());
		jpanelPhepToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		jpanelPhepToan.setBounds(130, 70, 210, 100);

		jpanelPhepToan.setLayout(new GridLayout(2, 2));

		jpanelPhepToan.add(rdobtnPhepCong = new JRadioButton("Cộng", true));
		jpanelPhepToan.add(rdobtnPhepTru = new JRadioButton("Trừ"));
		jpanelPhepToan.add(rdobtnPhepNhan = new JRadioButton("Nhân"));
		jpanelPhepToan.add(rdobtnPhepChia = new JRadioButton("Chia"));

		jpanelCenter.add(lblKetQua = new JLabel("Kết quả: "));
		lblKetQua.setBounds(70, 190, 100, 20);
		jpanelCenter.add(txtKQ = new JTextField());
		txtKQ.setBounds(130, 190, 210, 20);
		txtKQ.setEditable(false);

		ButtonGroup group = new ButtonGroup();
		group.add(rdobtnPhepCong);
		group.add(rdobtnPhepTru);
		group.add(rdobtnPhepNhan);
		group.add(rdobtnPhepChia);

		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		rdobtnPhepCong.addActionListener(this);
		rdobtnPhepTru.addActionListener(this);
		rdobtnPhepNhan.addActionListener(this);
		rdobtnPhepChia.addActionListener(this);
	}

	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Object o = e.getSource();
			if (o.equals(btnThoat))
				System.exit(0);
			else if (o.equals(btnXoa)) {
				txtA.setText("");
				txtB.setText("");
				txtKQ.setText("");
				txtA.requestFocus();
			} else if (o.equals(btnGiai)) {
				double a = Double.parseDouble(txtA.getText());
				double b = Double.parseDouble(txtB.getText());
				if (rdobtnPhepCong.isSelected()) {
					txtKQ.setText("A + B = " + (a + b));
				} else if (rdobtnPhepTru.isSelected()) {
					txtKQ.setText("A - B = " + (a - b));
				} else if (rdobtnPhepNhan.isSelected()) {
					txtKQ.setText("A x B = " + (a * b));
				} else if (rdobtnPhepChia.isSelected()) {
					if (b == 0) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập liệu!!");
					}
					txtKQ.setText("A / B = " + (a / b));
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu!!");
		}
	}

}
