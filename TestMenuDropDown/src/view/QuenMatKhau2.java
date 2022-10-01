package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class QuenMatKhau2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtNhapMatKhauMoi;
	private JPasswordField txtXacNhanMatKhauMoi;

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
	public QuenMatKhau2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mật khẩu mới");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(142, 52, 126, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Xác nhận mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(128, 131, 152, 19);
		contentPane.add(lblNewLabel_1);
		
		JButton btnThayDoi = new JButton("Thay đổi");
		btnThayDoi.setBackground(new Color(0, 255, 0));
		btnThayDoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThayDoi.setBounds(152, 199, 105, 36);
		contentPane.add(btnThayDoi);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 450, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("KHÔI PHỤC TÀI KHOẢN");
		lblNewLabel_2.setBounds(44, 10, 172, 17);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_2);
		
		txtNhapMatKhauMoi = new JPasswordField();
		txtNhapMatKhauMoi.setBounds(91, 87, 230, 25);
		contentPane.add(txtNhapMatKhauMoi);
		
		txtXacNhanMatKhauMoi = new JPasswordField();
		txtXacNhanMatKhauMoi.setBounds(91, 160, 230, 28);
		contentPane.add(txtXacNhanMatKhauMoi);
	}
}
