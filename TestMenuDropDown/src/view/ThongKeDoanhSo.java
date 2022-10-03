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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ThongKeDoanhSo extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ThongKeDoanhSo() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1295, 48);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u1ED0NG K\u00CA DOANH S\u1ED0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 224, 48);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(129, 101, 1074, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("S\u00E1ch b\u00E1n ch\u1EA1y nh\u1EA5t");
		btnNewButton.setBackground(new Color(176, 172, 213));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(0, 10, 152, 38);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("S\u00E1ch b\u00E1n \u00EDt nh\u1EA5t");
		btnNewButton_1.setBackground(new Color(176, 172, 213));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(328, 10, 152, 38);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("th\u1ED1ng k\u00EA s\u00E1ch b\u00E1n h\u1EBFt");
		btnNewButton_2.setIcon(new ImageIcon(ThongKeDoanhSo.class.getResource("/img/analytics.png")));
		btnNewButton_2.setBackground(new Color(176, 172, 213));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(612, 10, 198, 38);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("In báo cáo");
		btnNewButton_4.setIcon(new ImageIcon(ThongKeDoanhSo.class.getResource("/img/printer.png")));
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.setBounds(890, 11, 152, 38);
		panel_2.add(btnNewButton_4);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(112, 200, 1106, 491);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sách", "Tên sách", "Đơn giá", "Số lượng đã bán" ,"số lượng còn"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 159, 1295, 41);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u1ED1ng k\u00EA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Từ ngày");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(184, 58, 67, 32);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(271, 58, 166, 28);
		panel.add(textField);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(ThongKeDoanhSo.class.getResource("/img/calendar.png")));
		btnNewButton_3.setBounds(449, 58, 42, 34);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Đến ngày");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(586, 58, 82, 32);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(678, 58, 166, 33);
		panel.add(textField_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(ThongKeDoanhSo.class.getResource("/img/calendar.png")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(854, 59, 47, 32);
		panel.add(btnNewButton_1_1);
		setLayout(groupLayout);

	}
}
