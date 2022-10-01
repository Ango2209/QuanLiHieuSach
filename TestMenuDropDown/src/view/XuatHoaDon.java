package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class XuatHoaDon extends JPanel {
	private JTextField textField_1;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel modelThongKe;
	private JTable table_3;
	private JTable table_4;
	/**
	 * Create the panel.
	 */
	public XuatHoaDon() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1290, 34);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("XU\u1EA4T H\u00D3A \u0110\u01A0N");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(21, 0, 192, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(123, 60, 119, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(651, 67, 103, 27);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Xuất hóa đơn");
		btnNewButton.setIcon(new ImageIcon(XuatHoaDon.class.getResource("bill-icon.png")));
		btnNewButton.setBackground(new Color(172, 175, 213));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(497, 149, 207, 37);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(298, 61, 304, 33);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(770, 60, 251, 34);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 223, 1290, 37);
		panel.add(panel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Hóa đơn");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel_6);
		
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane1.setBounds(40, 311, 1221, 421);
		panel.add(scrollPane1);
		
		table_4 = new JTable();
		table_4.setModel(modelThongKe = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Tên khách hàng", "số điện thoại khách hàng","Ngày lập hóa đơn","Tổng thanh toán"
			}
		));
		scrollPane1.setViewportView(table_4);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon(XuatHoaDon.class.getResource("refresh-page-option.png")));
		btnNewButton_1.setBackground(new Color(172, 175, 213));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(799, 149, 162, 37);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tìm Kiếm");
		btnNewButton_2.setBackground(new Color(172, 175, 213));
		btnNewButton_2.setIcon(new ImageIcon("E:\\Homeworks\\OOP\\20115331_NguyenVanNgo\\TestMenuDropDown\\src\\view\\Search-icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(213, 147, 152, 39);
		panel.add(btnNewButton_2);
		
		
		setLayout(groupLayout);

	}
}
