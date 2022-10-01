package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class NhapHoaDon extends JPanel {
	private JTextField txtMaKhachHang;
	private JTextField txtThanhTien;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTable tbDanhSachMua;
	private JTable tbDanhSachSach;

	/**
	 * Create the panel.
	 */
	public NhapHoaDon() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1291, 36);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHẬP HÓA ĐƠN");
		lblNewLabel.setBackground(new Color(128, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 223, 36);
		panel_1.add(lblNewLabel);
		
		JButton btnThemHoaDon = new JButton("Thêm hóa đơn");
		btnThemHoaDon.setIcon(new ImageIcon(NhapHoaDon.class.getResource("/view/plus.png")));
		btnThemHoaDon.setBackground(new Color(0, 255, 0));
		btnThemHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemHoaDon.setBounds(507, 136, 179, 42);
		panel.add(btnThemHoaDon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 188, 591, 29);
		panel.add(panel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Danh s\u00E1ch s\u00E1ch");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(615, 188, 676, 29);
		panel.add(panel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Danh s\u00E1ch mua");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_6);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(10, 216, 581, 464);
		panel.add(scrollPane);
		
		tbDanhSachSach = new JTable();
		tbDanhSachSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sách", "Tên sách", "Đơn giá", "Tên loại sách", "Số lượng" ,"Tên nhà xuất bản","Tên tác giả"
			}
		));
		scrollPane.setViewportView(tbDanhSachSach);
		
		
		
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane1.setBounds(615, 216, 664, 464);
		panel.add(scrollPane1);
		
		tbDanhSachMua = new JTable();
		tbDanhSachMua.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã sách", "Tên sách", "Đơn giá", "Tên loại sách", "Số lượng" ,"Tên nhà xuất bản","Tên tác giả"
			}
		));
		scrollPane1.setViewportView(tbDanhSachMua);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 73, 1291, 42);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1.setBounds(10, 10, 85, 16);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(117, 0, 129, 42);
		panel_4.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tên khách hàng");
		lblNewLabel_3.setBounds(277, 0, 102, 42);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(389, 0, 235, 42);
		panel_4.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(782, 0, 129, 42);
		panel_4.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBounds(1043, 0, 166, 42);
		panel_4.add(txtThanhTien);
		txtThanhTien.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Số điện thoại");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(663, -2, 109, 42);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("T\u1ED5ng th\u00E0nh ti\u1EC1n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(921, -2, 112, 42);
		panel_4.add(lblNewLabel_4);
		
		
		
		
		
		
		setLayout(groupLayout);

	}

}
