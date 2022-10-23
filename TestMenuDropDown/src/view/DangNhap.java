package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.KhachHang;
import entity.NguoiDangNhap;
import entity.NhanVien;
import entity.TaiKhoan;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private ArrayList<TaiKhoan> lsTk;
	private TaiKhoan_DAO tk_dao;
	private NguoiDangNhap nDN;
	private NhanVien_DAO nv_DAO;
	private KhachHang_DAO kh_DAO;
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
		
		tk_dao=new TaiKhoan_DAO();
		nv_DAO=new NhanVien_DAO();
		kh_DAO=new KhachHang_DAO();
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
		
		 btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(0, 255, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangNhap.setBounds(169, 219, 130, 37);
		contentPane.add(btnDangNhap);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Nhân Viên");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(138, 184, 93, 28);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Đăng Ký");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangKy gddk = new DangKy();
				gddk.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(420, 219, 118, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quên Mật Khẩu");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuenMatKhau1 qmk1=new QuenMatKhau1();
				qmk1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton_1.setBounds(338, 321, 157, 23);
		contentPane.add(btnNewButton_1);
		
		btnDangNhap.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String userName = txtTaiKhoan.getText().trim();
				char[] passWord = txtMatKhau.getPassword();
				
				String pass = String.valueOf(passWord);
				if(userName.equals("")) {
				
					JOptionPane.showMessageDialog(null, "Nhập Vào Tên Đăng Nhập");
				}else if(pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập Vào Mật Khẩu");
				}else if(ktraTaiKhoan()){
					lsTk = new ArrayList<TaiKhoan>();
					lsTk = tk_dao.getDsTaiKhoan();
					int flag = 0;
					String maKh="";
					
					for (TaiKhoan tk : lsTk) {
						
					
					
						if(tk.getTenTaiKhoan().trim().equalsIgnoreCase(userName) && tk.getMatKhau().trim().equalsIgnoreCase(pass)) {
							
							flag = 1;
							if(tk.getLoaiTaiKhoan().equals("khachHang")) {
								JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công");
								dispose();
								GiaoDienKhachHang gd = null;
								ArrayList<KhachHang> kh= new ArrayList<>();
								try {
									kh=kh_DAO.getAllKH();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								for(KhachHang k : kh) {
									if(k.getTenTaiKhoan()==tk.getTenTaiKhoan()) {
										nDN=new NguoiDangNhap(tk.getTenTaiKhoan(),k.getMaKhachHang(),k.getTenKhachHang());
									}
								}

								gd = new GiaoDienKhachHang();
								gd.setVisible(true);							
							}if(chckbxNewCheckBox.isSelected()&&tk.getLoaiTaiKhoan().equals("NhanVien")) {
								
								JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công Dưới Quyền Nhân Viên");
								dispose();
								ArrayList<NhanVien> nv=new ArrayList<>();
								try {
									nv=nv_DAO.getAllNV();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								for(NhanVien n:nv) {
									if(n.getTenTaiKhoan()==tk.getTenTaiKhoan()) {
										nDN=new NguoiDangNhap(n.getTenTaiKhoan(), n.getMaNhanVien(), n.getTenNhanVien());
									}
								}
								GiaoDienNhanVien gdNV = new GiaoDienNhanVien();
								gdNV.setVisible(true);
							}												
						}
					}
					if(flag ==0) {
						JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng");
					}
				}
			}
			});
	}
			
	private boolean ktraTaiKhoan() {
		String userName = txtTaiKhoan.getText().trim();
		char[] passWord = txtMatKhau.getPassword();
		String pass = String.valueOf(passWord);
		
		if(!(userName.length()>0 && userName.matches("^[a-zA-Z0-9._-]{3,}"))) {
			thongBao("Eror : Tên Đăng Nhập Theo Định dạng ^[a-zA-Z0-9._-]{3,}$", txtTaiKhoan);
			return false;
		}
		
		if(!(pass.length()>0 && pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,32}$"))) {
			thongBao("Eror : Mật Khẩu phải có từ 6-32 ký tự, bao gồm số chữ thường, chữ in và ký tự đặc biệt", txtMatKhau);
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

