package Tuan01_TinhToan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Scrollable;

public class SoNguyenTo extends JFrame{

	private JTextField txtTN;
	private JButton btnGrenerate;
	private JTextArea taPrimes;
	
	public SoNguyenTo() {
		// TODO Auto-generated constructor stub
		setTitle("So nguyen to");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		creatGUI();
	}
	
	private void creatGUI() {
		// TODO Auto-generated method stub
		setLayout(null);
		add(txtTN = new JTextField());
		txtTN.setBounds(50, 30, 400, 30);
		txtTN.setToolTipText("Nhap so luong so nguyen to can hien thi.");
		
		add(btnGrenerate = new JButton("Grenerate"));
		btnGrenerate.setBounds(450, 30, 100, 30);
		
		JScrollPane scroll;
		add(scroll = new JScrollPane(taPrimes = new JTextArea()));
		scroll.setBounds(50, 70, 500, 270);
		taPrimes.setToolTipText("Danh sach cac so nguyen to");
		taPrimes.setEditable(false);
		
		btnGrenerate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taPrimes.setText("");
				try {
					int n = Integer.parseInt(txtTN.getText());
					if(n > 0) {
						for(int i = 3; i < Integer.MAX_VALUE; i++) {
							if(isPrime(i)) {
								n--;
								taPrimes.append(i + "\n");
							}
							if(n ==0)
								break;
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Loi nhap lieu!");
					}
				} catch (NumberFormatException ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Nhap so nguyen duong");
				}
			}
		});
	}

	public static void main(String[] args) {
		new SoNguyenTo().setVisible(true);
	}
	
	public void focus() {
		txtTN.selectAll();
		txtTN.requestFocus();
	}
	
	public boolean isPrime(int n) {
		for(int i = 2; i <= n/2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
