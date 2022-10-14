package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CapNhatSach extends JPanel {
	private JTextField txtTenSach;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private JTable table;
	private JTextField txtLoaiSach;

	/**
	 * Create the panel.
	 */
	public CapNhatSach() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1282, 776);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1282, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CẬP NHẬT ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 0, 97, 35);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 45, 1272, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Sách");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(59, 26, 65, 23);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Đơn Giá\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(59, 60, 65, 23);
		panel_2.add(lblNewLabel_1_1_1);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(193, 28, 216, 23);
		panel_2.add(txtTenSach);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(193, 62, 216, 23);
		panel_2.add(txtDonGia);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại Sách");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(603, 26, 65, 23);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số Lượng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(603, 60, 65, 23);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("NXB");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(603, 94, 65, 23);
		panel_2.add(lblNewLabel_1_2_2);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(783, 62, 213, 23);
		panel_2.add(txtSoLuong);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tác Giả");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(59, 94, 76, 23);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		txtLoaiSach = new JTextField();
		txtLoaiSach.setColumns(10);
		txtLoaiSach.setBounds(783, 28, 216, 23);
		panel_2.add(txtLoaiSach);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(193, 96, 145, 22);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(783, 96, 189, 22);
		panel_2.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/add-1-icon.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(205, 267, 133, 35);
		panel.add(btnNewButton);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLu.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/disk-icon.png")));
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLu.setBounds(449, 267, 96, 35);
		panel.add(btnLu);
		
		JButton btnNewButton_1_1 = new JButton("Cập Nhật");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/Gear-icon.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(665, 267, 158, 35);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Xóa");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/Button-Delete-icon.png")));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1_1.setBounds(917, 267, 96, 35);
		panel.add(btnNewButton_1_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setBorder(new TitledBorder(null, "Danh S\u00E1ch C\u00E1c Lo\u1EA1i S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(36, 350, 1208, 415);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 1188, 389);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "\u0110\u01A1n Gi\u00E1", "T\u00EAn T\u00E1c Gi\u1EA3", "M\u00E3 T\u00E1c Gi\u1EA3", "Lo\u1EA1i S\u00E1ch", "S\u1ED1 L\u01B0\u1EE3ng", "T\u00EAn NXB", "M\u00E3 NXB", "Số lượng đã bán"
			}
		));
		scrollPane.setViewportView(table);

	}
}
