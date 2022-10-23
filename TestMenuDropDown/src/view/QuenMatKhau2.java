package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JPasswordField;
import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
public class QuenMatKhau2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtNhapMatKhauMoi;
	private JPasswordField txtXacNhanMatKhauMoi;
	private TaiKhoan_DAO tk_dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhau2 frame = new QuenMatKhau2();
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
	public QuenMatKhau2(String email) {
		tk_dao=new TaiKhoan_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mật khẩu mới");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(168, 58, 126, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Xác nhận mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(168, 142, 152, 19);
		contentPane.add(lblNewLabel_1);
		
		JButton btnThayDoi = new JButton("Thay Đổi");
		btnThayDoi.addActionListener(new ActionListener() {
			
			@Override
			
			
			
			public void actionPerformed(ActionEvent e) {
				char[] matKhau = txtNhapMatKhauMoi.getPassword();
				String matKhauMoi = String.valueOf(matKhau);
				char[] matkhau2 = txtXacNhanMatKhauMoi.getPassword();
				String matKhauMoi2 = String.valueOf(matkhau2);
				System.out.println(matKhauMoi);
				System.out.println(matKhauMoi2);
				if(matKhauMoi.equals(matKhauMoi2)) {
					try {
						
						
						tk_dao.doiMK(matKhauMoi,email);
						JOptionPane.showMessageDialog(null, "Mật khẩu mới của bạn đã được cập nhật");
						dispose();
						DangNhap dn=new DangNhap();
						dn.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("ok");
				}else {
					JOptionPane.showMessageDialog(null, "Mật khẩu không đúng");
				}
		
			}
		});
		btnThayDoi.setBackground(new Color(0, 255, 0));
		btnThayDoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThayDoi.setBounds(235, 249, 133, 36);
		contentPane.add(btnThayDoi);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 732, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("KHÔI PHỤC TÀI KHOẢN");
		lblNewLabel_2.setBounds(44, 10, 172, 17);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_2);
		
		txtNhapMatKhauMoi = new JPasswordField();
		txtNhapMatKhauMoi.setBounds(168, 94, 270, 25);
		contentPane.add(txtNhapMatKhauMoi);
		
		txtXacNhanMatKhauMoi = new JPasswordField();
		txtXacNhanMatKhauMoi.setBounds(168, 172, 270, 28);
		contentPane.add(txtXacNhanMatKhauMoi);
		
		JButton btnNewButton = new JButton("Quay Lại");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(0, 53, 113, 31);
		contentPane.add(btnNewButton);
	}
}
