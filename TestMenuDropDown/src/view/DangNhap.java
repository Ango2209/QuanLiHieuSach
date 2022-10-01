package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 633, 37);
		panel.setBackground(new Color(128, 128, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setBounds(30, 0, 107, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Tên Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(138, 68, 107, 19);
		contentPane.add(lblNewLabel_1);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(138, 86, 274, 27);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(138, 133, 60, 19);
		contentPane.add(lblNewLabel_2);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(138, 151, 274, 27);
		contentPane.add(txtMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(0, 255, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangNhap.setBounds(169, 219, 130, 37);
		contentPane.add(btnDangNhap);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Nhân Viên");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(138, 184, 93, 28);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Đăng Ký");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(420, 219, 118, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quên Mật Khẩu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton_1.setBounds(338, 321, 157, 23);
		contentPane.add(btnNewButton_1);
	}
}
