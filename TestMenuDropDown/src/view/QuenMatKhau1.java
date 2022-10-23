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
import javax.swing.JButton;
import java.awt.Color;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionEvent;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class QuenMatKhau1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNhapMaXacThuc;
	private JTextField txtNhapEmail;
	private 
	 final String username = "anhngole1105@gmail.com";
     final String password = "ylmgzjsaqsimotad";
    
     private TaiKhoan_DAO tk_dao;
     private ArrayList<TaiKhoan> lsTk;
     private String maXacThuc;
     private String email;
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
		
        tk_dao=new TaiKhoan_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 696, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("KHÔI PHỤC TÀI KHOẢN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(40, 10, 176, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Vui lòng nhập mã xác thực ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 172, 202, 26);
		contentPane.add(lblNewLabel);
		
		txtNhapMaXacThuc = new JTextField();
		txtNhapMaXacThuc.setBounds(23, 209, 316, 26);
		contentPane.add(txtNhapMaXacThuc);
		txtNhapMaXacThuc.setColumns(10);
		
		txtNhapEmail = new JTextField();
		txtNhapEmail.setColumns(10);
		txtNhapEmail.setBounds(23, 135, 316, 26);
		contentPane.add(txtNhapEmail);
		
		JLabel lblNhpEmail = new JLabel("Nhập email");
		lblNhpEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpEmail.setBounds(23, 98, 202, 26);
		contentPane.add(lblNhpEmail);
		
		JButton btnLayMa = new JButton("Lấy mã");
		btnLayMa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lsTk = new ArrayList<TaiKhoan>();
				lsTk = tk_dao.getDsTaiKhoan();
				String email=txtNhapEmail.getText().trim();
				int flag=0;
				for (TaiKhoan tk : lsTk) {
					
					
				if(tk.getEmail().trim().equals(email)) {
						guiMa();
						JOptionPane.showMessageDialog(null, "Đã gửi mã về email của bạn");
						flag=1;							
					}
				}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Email không tồn tại");
				
				
				
			}
		});
		
		btnLayMa.setBackground(new Color(128, 128, 255));
		btnLayMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLayMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLayMa.setBounds(391, 130, 108, 32);
		contentPane.add(btnLayMa);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ma=txtNhapMaXacThuc.getText();
				
				if(ma.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã xác thực");
				}
				else if(ma.equals(maXacThuc)) {
					dispose();
					QuenMatKhau2 qmk2=new QuenMatKhau2(email);
					qmk2.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Mã xác thực không đúng");
				}
				
			}
		});
		
		btnXacNhan.setBackground(new Color(0, 255, 0));
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXacNhan.setBounds(295, 265, 123, 36);
		contentPane.add(btnXacNhan);
		
		JButton btnNewButton = new JButton("Quay Lại");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 45, 123, 36);
		contentPane.add(btnNewButton);
	}
	public void guiMa() {
		maXacThuc="12345";
		email=txtNhapEmail.getText().trim();
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
     prop.put("mail.smtp.port", "587");
     prop.put("mail.smtp.auth", "true");
     prop.put("mail.smtp.starttls.enable", "true"); //TLS
     
     
     Session session = Session.getInstance(prop,
             new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() {
                     return new PasswordAuthentication(username, password);
                 }
             });

     try {

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("anhngole1105@gmail.com"));
         message.setRecipients(
                 Message.RecipientType.TO,
                 InternetAddress.parse(email)
         );
         message.setSubject("Testing Mail");
         message.setText("Mã Xác Thực Của Bạn Là :" + maXacThuc);

         Transport.send(message);

         System.out.println("Done");

     } catch (MessagingException e) {
         e.printStackTrace();
     }
	}
}
