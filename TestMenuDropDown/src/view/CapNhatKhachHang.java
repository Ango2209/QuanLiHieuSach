package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CapNhatKhachHang extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tbDanhSachKhachHang;

	/**
	 * Create the panel.
	 */
	public CapNhatKhachHang() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1348, 41);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập Nhật Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 0, 224, 41);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 64, 1273, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(0, 10, 102, 38);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(112, 11, 134, 38);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(299, 10, 124, 38);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(418, 12, 209, 38);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(656, 10, 105, 38);
		panel_2.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(771, 11, 163, 38);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(963, 10, 78, 38);
		panel_2.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1012, 10, 209, 38);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 138, 1273, 41);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("C\u1EADp nh\u1EADt ");
		btnNewButton.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/view/updated.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(176, 172, 213));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(159, 0, 140, 41);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm");
		btnNewButton_1.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/view/plus (1).png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(176, 172, 213));
		btnNewButton_1.setBounds(432, 0, 140, 41);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X\u00F3a");
		btnNewButton_2.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/view/delete.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(176, 172, 213));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(672, 0, 140, 41);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("L\u00E0m m\u1EDBi");
		btnNewButton_3.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/view/refresh-page-option.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(176, 172, 213));
		btnNewButton_3.setBounds(921, 0, 140, 41);
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 189, 1273, 41);
		panel.add(panel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Danh s\u00E1ch kh\u00E1ch h\u00E0ng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_5);
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(130, 252, 1053, 437);
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
		
		
		setLayout(groupLayout);

	}

}
