package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class QuenMatKhau1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNhapMaXacThuc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhau1 frame = new QuenMatKhau1();
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
	public QuenMatKhau1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 606, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("KHÔI PHỤC TÀI KHOẢN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(40, 10, 176, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Vui lòng nhập mã xác thực ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 99, 202, 26);
		contentPane.add(lblNewLabel);
		
		txtNhapMaXacThuc = new JTextField();
		txtNhapMaXacThuc.setBounds(22, 130, 316, 26);
		contentPane.add(txtNhapMaXacThuc);
		txtNhapMaXacThuc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Một mã xác thực vừa được gửi tới email của bạn,vui lòng nhập mã xác thực ở ô bên dưới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 49, 596, 51);
		contentPane.add(lblNewLabel_1);
		
		JButton btnXacThuc = new JButton("");
		btnXacThuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXacThuc.setIcon(new ImageIcon(QuenMatKhau1.class.getResource("/view/Ok-icon.png")));
		btnXacThuc.setBackground(new Color(255, 255, 255));
		btnXacThuc.setBounds(348, 124, 31, 32);
		contentPane.add(btnXacThuc);
	}
}
