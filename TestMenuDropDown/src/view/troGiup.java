package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class troGiup extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panel_datHang;
	private JPanel panel_thanhToan;
	private JPanel panel_xemLichSu;
	private JPanel panel_timKiem;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	public troGiup() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setBounds(100, 100, 1386, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 318, 790);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_datHang = new JButton("1.Cách đặt hàng như thế nào?");
		btn_datHang.setBackground(new Color(192, 192, 192));
		btn_datHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_datHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panel_datHang);
			}
		});
		btn_datHang.setBounds(0, 52, 318, 23);
		panel.add(btn_datHang);
		
		JButton btn_thanhToan = new JButton("2.Cách thanh toán như thế nào?");
		btn_thanhToan.setBackground(new Color(192, 192, 192));
		btn_thanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			switchPanel(panel_thanhToan );
			}
		});
		btn_thanhToan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_thanhToan.setBounds(0, 109, 318, 23);
		panel.add(btn_thanhToan);
		
		JButton btn_lichSu = new JButton("3.Cách xem lịch sử mua hàng như thế nào?");
		btn_lichSu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panel_xemLichSu);
			}
		});
		btn_lichSu.setBackground(new Color(192, 192, 192));
		btn_lichSu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_lichSu.setBounds(0, 164, 318, 23);
		panel.add(btn_lichSu);
		
		JButton btn_timKiem = new JButton("4.Cách tìm kiếm sách?");
		btn_timKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panel_timKiem);
			}
		});
		btn_timKiem.setBackground(new Color(192, 192, 192));
		btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_timKiem.setBounds(0, 226, 318, 23);
		panel.add(btn_timKiem);
		
		JLabel lblNewLabel_3 = new JLabel("Câu Hỏi Thường Gặp");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(28, 11, 188, 30);
		panel.add(lblNewLabel_3);
		
		 layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBounds(328, 0, 1042, 790);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		 panel_datHang = new JPanel();
		layeredPane.add(panel_datHang, "name_612293434515400");
		panel_datHang.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cách Đặt Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(376, 11, 199, 43);
		panel_datHang.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("1.Bấm vào nút Sách trên thanh menu ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(68, 76, 701, 25);
		panel_datHang.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("2.Chọn menu Đặt Hàng");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(68, 136, 701, 25);
		panel_datHang.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("3.Chọn sản phẩm muốn mua cùng số lượng sau đó nhấn nút Đặt Hàng");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1_1.setBounds(68, 188, 701, 25);
		panel_datHang.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("4.Xuất hiện thông báo đã thêm hàng vào phiếu mua hàng");
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1_2.setBounds(68, 251, 701, 25);
		panel_datHang.add(lblNewLabel_6_1_2);
		
		 panel_thanhToan = new JPanel();
		layeredPane.add(panel_thanhToan, "name_612302984411200");
		panel_thanhToan.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Cách Thanh Toán");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(362, 11, 151, 36);
		panel_thanhToan.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6_3 = new JLabel("1.Bấm vào nút phiếu mua hàng trên thanh menu");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_3.setBounds(64, 58, 701, 25);
		panel_thanhToan.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_1_3 = new JLabel("2.Chọn menu Thanh Toán");
		lblNewLabel_6_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1_3.setBounds(64, 117, 701, 25);
		panel_thanhToan.add(lblNewLabel_6_1_3);
		
		JLabel lblNewLabel_6_1_3_1 = new JLabel("3.Nhấn nút Thanh Toán Trên Giao Diện");
		lblNewLabel_6_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1_3_1.setBounds(64, 178, 701, 25);
		panel_thanhToan.add(lblNewLabel_6_1_3_1);
		
		JLabel lblNewLabel_6_1_3_1_1 = new JLabel("4.Xuất hiện thông báo thanh toán thành công");
		lblNewLabel_6_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1_3_1_1.setBounds(64, 248, 701, 25);
		panel_thanhToan.add(lblNewLabel_6_1_3_1_1);
		
	   panel_xemLichSu = new JPanel();
		layeredPane.add(panel_xemLichSu, "name_612305714936300");
		panel_xemLichSu.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Cách xem lịch sử mua hàng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(309, 11, 304, 31);
		panel_xemLichSu.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("1.Bấm vào nút phiếu mua hàng trên màn hình");
		lblNewLabel_6_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_3_1.setBounds(100, 65, 701, 25);
		panel_xemLichSu.add(lblNewLabel_6_3_1);
		
		JLabel lblNewLabel_6_3_2 = new JLabel("2.Bấm vào menu lịch sử mua hàng trên giao diện");
		lblNewLabel_6_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_3_2.setBounds(100, 126, 701, 25);
		panel_xemLichSu.add(lblNewLabel_6_3_2);
		
		JLabel lblNewLabel_6_3_3 = new JLabel("3.Xem lịch sử");
		lblNewLabel_6_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_3_3.setBounds(100, 190, 701, 25);
		panel_xemLichSu.add(lblNewLabel_6_3_3);
		
	   panel_timKiem = new JPanel();
		layeredPane.add(panel_timKiem, "name_612984852205600");
		panel_timKiem.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Cách tìm kiếm");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(382, 11, 313, 25);
		panel_timKiem.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6_2 = new JLabel("1.Bấm vào nút Sách trên thanh menu ");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_2.setBounds(88, 62, 701, 25);
		panel_timKiem.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_4 = new JLabel("2.Bấm vào menu tìm kiếm trên giao diện");
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_4.setBounds(88, 115, 701, 25);
		panel_timKiem.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("3.Nhập thông tin cuốn sách mà bạn cần tìm kiếm ");
		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_5.setBounds(88, 177, 701, 25);
		panel_timKiem.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_6_6 = new JLabel("4.Xuất hiện cuốn sách bạn cần tìm kiếm");
		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_6.setBounds(88, 247, 701, 25);
		panel_timKiem.add(lblNewLabel_6_6);
	}

}
