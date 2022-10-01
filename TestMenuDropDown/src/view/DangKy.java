package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class DangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenTaiKhoan;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtNhapLaiMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
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
	public DangKy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(110, 46, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(110, 64, 308, 30);
		contentPane.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(110, 118, 308, 30);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(110, 158, 86, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(110, 104, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập Lại Mật Khẩu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(110, 224, 161, 25);
		contentPane.add(lblNewLabel_4);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(110, 184, 308, 30);
		contentPane.add(txtPassword);
		
		txtNhapLaiMatKhau = new JPasswordField();
		txtNhapLaiMatKhau.setBounds(110, 247, 308, 32);
		contentPane.add(txtNhapLaiMatKhau);
		
		JButton btnDangKy = new JButton("Đăng Ký");
		btnDangKy.setBackground(new Color(0, 255, 0));
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangKy.setBounds(203, 295, 121, 34);
		contentPane.add(btnDangKy);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 553, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÝ");
		lblNewLabel.setBounds(38, 0, 110, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	}
}
