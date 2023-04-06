package Tuan01_TinhToan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GiaiPTB2 extends JFrame implements ActionListener {

	private JButton buttonGiai, buttonRong, buttonThoat;
	private JTextField txtA, txtB, txtC, txtKQ;

	public GiaiPTB2() {
		setTitle("^_^");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
	}

	private void createGUI() {
		JPanel panelNorth;
		add(panelNorth = new JPanel(), BorderLayout.NORTH);
		panelNorth.setBackground(Color.cyan);
		JLabel jblTieuDe;
		jblTieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		jblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		panelNorth.add(jblTieuDe);

		JPanel panelCenter;
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		panelCenter.setLayout(null);

		JLabel lblNhapA, lblNhapB, lblNhapC, lblKetQua;
		panelCenter.add(lblNhapA = new JLabel("Nhập a:"));
		int x = 20, y = 40, width = 100, height = 30;
		lblNhapA.setBounds(x, y, width, height);

		panelCenter.add(lblNhapB = new JLabel("Nhập b:"));
		y += 50;
		lblNhapB.setBounds(x, y, width, height);

		panelCenter.add(lblNhapC = new JLabel("Nhập c:"));
		y += 50;
		lblNhapC.setBounds(x, y, width, height);

		panelCenter.add(lblKetQua = new JLabel("Kết quả: "));
		y += 50;
		lblKetQua.setBounds(x, y, width, height);

		panelCenter.add(txtA = new JTextField());
		x += 100;
		y = 40;
		width = 300;
		txtA.setBounds(x, y, width, height);

		panelCenter.add(txtB = new JTextField());
		y += 50;
		txtB.setBounds(x, y, width, height);

		panelCenter.add(txtC = new JTextField());
		y += 50;
		txtC.setBounds(x, y, width, height);

		panelCenter.add(txtKQ = new JTextField());
		y += 50;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);

		JPanel panelSouth;
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		panelSouth.add(buttonGiai = new JButton("Giải"));
		panelSouth.add(buttonRong = new JButton("Xóa rỗng"));
		panelSouth.add(buttonThoat = new JButton("Thoát"));
		
		buttonGiai.addActionListener(this);
		buttonRong.addActionListener(this);
		buttonThoat.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaiPTB2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(buttonThoat)) {
			System.exit(0);
		} else if (o.equals(buttonRong)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		} else if (o.equals(buttonGiai)) {
			if (!isInt(txtA)) {
				focus(txtA);
			} else if (!isInt(txtB)) {
				focus(txtB);
			} else if (!isInt(txtC)) {
				focus(txtC);
			} else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				int c = Integer.parseInt(txtC.getText());
				if (a == 0) {
					giaiPTB1(b, c);
				} else {
					float delta = b * b - 4 * a * c;
					if (delta < 0) {
						txtKQ.setText("Vô nghiệm");
					} else if (delta == 0) {
						txtKQ.setText("Nghiệm kép x1 = x2 = " + (-b / (2 * (float) a)));
					} else {
						txtKQ.setText("Có 2 nghiệm x1 = " + ((-b + Math.sqrt(delta)) / (2 * (float) a)) + "; x2 = "
								+ ((-b - Math.sqrt(delta)) / (2 * (float) a)));
					}

				}
			}

		}

	}

	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
			// TODO: handle exception
			result = false;
		}
		return result;
	}

	public void focus(JTextField txtA) {
		JOptionPane.showMessageDialog(txtA, "Lỗi nhập liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		txtA.requestFocusInWindow();
	}

	public void giaiPTB1(int a, int b) {
		if (a != 0) {
			txtKQ.setText("Nghiệm x = " + (-b / (float) a));
		} else if (b == 0) {
			txtKQ.setText("Vô số nghiệm.");
		} else {
			txtKQ.setText("Vô nghiệm.");
		}
	}
}
