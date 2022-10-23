package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import dao.TaiKhoan_DAO;
import entity.TaiKhoan;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;

public class DangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenTaiKhoan;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtNhapLaiMatKhau;
	private JButton btnDangKy;
	private ArrayList<TaiKhoan> lsTk;
	private TaiKhoan_DAO tk_dao;
	private JCheckBox checkNhanVien;

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
		tk_dao = new TaiKhoan_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(213, 53, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(201, 77, 308, 30);
		contentPane.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(201, 142, 308, 30);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(211, 174, 86, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(211, 118, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập Lại Mật Khẩu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(211, 235, 161, 25);
		contentPane.add(lblNewLabel_4);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(201, 199, 308, 30);
		contentPane.add(txtPassword);
		
		txtNhapLaiMatKhau = new JPasswordField();
		txtNhapLaiMatKhau.setBounds(201, 265, 308, 32);
		contentPane.add(txtNhapLaiMatKhau);
		
	  btnDangKy = new JButton("Đăng Ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ktraTaiKhoan()) {
					lsTk = new ArrayList<TaiKhoan>();
//					lsTk = tk_dao.getDsTaiKhoan();
					String username = txtTenTaiKhoan.getText().trim();
					
					int flag = 0;
					for (TaiKhoan taiKhoan : lsTk) {
						if(username.equals(taiKhoan.getTenTaiKhoan())){
							thongBao("Tên đăng nhập đã tồn tại",txtTenTaiKhoan);
							flag = 1;
						}
					}
					
					if(flag==0) {
						char[] passWord = txtPassword.getPassword();
						String pass = String.valueOf(passWord);
						String email=txtEmail.getText();
						Calendar c;
						
						c = Calendar.getInstance();
						String maKh = "KH" + (c.get(Calendar.YEAR)-2000)+c.get(Calendar.MONTH)+c.get(Calendar.DAY_OF_MONTH);
						String loaiTk ="";
						if(checkNhanVien.isSelected()) {
							loaiTk = "khachHang";
							
						}else {
							loaiTk = "NhanVien";
						}
																																										
						TaiKhoan tk1 = new TaiKhoan(maKh,loaiTk,username,pass,email);
						try {
							tk_dao.addTK(tk1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công");
						dispose();
						
//						(String maTaiKhoan, String loaiTaiKhoan, String tenTaiKhoan, String matKhau, String email) {
						DangNhap gddn=new DangNhap();
						gddn.setVisible(true);
					}
					
				}
				
			}
		});
		btnDangKy.setBackground(new Color(0, 255, 0));
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangKy.setBounds(297, 366, 121, 34);
		contentPane.add(btnDangKy);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 677, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÝ");
		lblNewLabel.setBounds(27, 0, 110, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		 checkNhanVien = new JCheckBox("Nhân Viên");
		checkNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkNhanVien.setBounds(195, 323, 97, 23);
		contentPane.add(checkNhanVien);
		
		JButton btnNewButton = new JButton("Quay Lại");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(0, 43, 121, 32);
		contentPane.add(btnNewButton);
	}
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o.equals(btnDangKy)) {

			
		}
	}
	private boolean ktraTaiKhoan() {
		String userName = txtTenTaiKhoan.getText().trim();
		char[] passWord = txtPassword.getPassword();
		String pass = String.valueOf(passWord);
		char[] repeatPassWord = txtNhapLaiMatKhau.getPassword();
		String repeatPass = String.valueOf(repeatPassWord);
		
		if(!(userName.length()>0 && userName.matches("^[a-zA-Z0-9._-]{3,}"))) {
			thongBao("Error : Tên Đăng Nhập Theo Định dạng ^[a-zA-Z0-9._-]{3,}$", txtTenTaiKhoan);
			return false;
		}
		
		if(!(pass.length()>0 && pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,32}$"))) {
			thongBao("Error : Mật Khẩu phải có từ 6-32 ký tự, bao gồm số chữ thường, chữ in và ký tự đặc biệt", txtPassword);
			return false;
		}
		
		if(!(repeatPass.equals(pass))) {
			thongBao("Error : Mật khẩu không trung khớp", txtNhapLaiMatKhau);
			return false;
		}
		
		
		return true;
	}
	public void thongBao(String er , JTextField txt) {
		JOptionPane.showMessageDialog(null, er);
		txt.selectAll();
		txt.requestFocus();
	}
}
