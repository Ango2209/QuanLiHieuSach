package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimKiemKhachHang extends JPanel {
	private JTextField txtTimKiemMaKhachHang;
	private JTextField txtTimKiemTenKhachHang;
	private JTextField txtTimKiemSoDienThoaiKhachHang;
	private JTextField txtTimKiemEmailKhachHang;
	private JTable tbDanhSachKhachHang;

	/**
	 * Create the panel.
	 */
	public TimKiemKhachHang() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1290, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÌM KIẾM KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 249, 40);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 50, 96, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(285, 53, 110, 22);
		panel.add(lblNewLabel_2);
		
		txtTimKiemMaKhachHang = new JTextField();
		txtTimKiemMaKhachHang.setBounds(111, 50, 116, 31);
		panel.add(txtTimKiemMaKhachHang);
		txtTimKiemMaKhachHang.setColumns(10);
		
		txtTimKiemTenKhachHang = new JTextField();
		txtTimKiemTenKhachHang.setBounds(405, 50, 246, 31);
		panel.add(txtTimKiemTenKhachHang);
		txtTimKiemTenKhachHang.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(233, 60, 21, 21);
		panel.add(chckbxNewCheckBox);
		
		txtTimKiemSoDienThoaiKhachHang = new JTextField();
		txtTimKiemSoDienThoaiKhachHang.setBounds(791, 52, 177, 31);
		panel.add(txtTimKiemSoDienThoaiKhachHang);
		txtTimKiemSoDienThoaiKhachHang.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(685, 59, 96, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(1026, 51, 46, 28);
		panel.add(lblNewLabel_4);
		
		txtTimKiemEmailKhachHang = new JTextField();
		txtTimKiemEmailKhachHang.setBounds(1082, 50, 180, 31);
		panel.add(txtTimKiemEmailKhachHang);
		txtTimKiemEmailKhachHang.setColumns(10);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(974, 60, 25, 21);
		panel.add(chckbxNewCheckBox_2);
		
		JButton btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemKhachHang.setIcon(new ImageIcon(TimKiemKhachHang.class.getResource("/view/loupe (1).png")));
		btnTimKiemKhachHang.setBackground(new Color(0, 255, 0));
		btnTimKiemKhachHang.setBounds(574, 91, 138, 40);
		panel.add(btnTimKiemKhachHang);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(46, 182, 1200, 508);
		panel.add(scrollPane);
		
		tbDanhSachKhachHang = new JTable();
		tbDanhSachKhachHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã khách hàng", "Tên khách hàng ", "Số điện thoại", "Email"
			}
		));
		scrollPane.setViewportView(tbDanhSachKhachHang);
		
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 141, 1290, 31);
		panel.add(panel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Danh sách khách hàng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(654, 60, 25, 21);
		panel.add(chckbxNewCheckBox_1);
		setLayout(groupLayout);

	}
}
