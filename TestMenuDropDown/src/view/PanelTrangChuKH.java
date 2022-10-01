package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class PanelTrangChuKH extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTrangChuKH() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Homeworks\\OOP\\20115331_NguyenVanNgo\\TestMenuDropDown\\src\\view\\hinh-nen.jpg"));
		lblNewLabel.setBounds(0, 104, 854, 572);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("XIN CHÀO NGUYỄN VĂN A");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(266, 11, 407, 92);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Đăng Xuất");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setIcon(new ImageIcon("E:\\Homeworks\\OOP\\20115331_NguyenVanNgo\\TestMenuDropDown\\src\\view\\Button-Log-Off-icon.png"));
		btnNewButton.setBounds(935, 700, 279, 81);
		panel.add(btnNewButton);
		setLayout(groupLayout);

	}
}
