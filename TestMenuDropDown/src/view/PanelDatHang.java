package view;

import javax.swing.JPanel;
import javax.naming.CompoundName;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietPhieuMua_DAO;
import dao.KhachHangDatHang_DAO;
import dao.PhieuMuaHang_DAO;
import dao.Sach_DAO;
import entity.ChiTietPhieuMuaHang;
import entity.KhachHangDatHang;
import entity.PhieuMuaHang;
import entity.Sach;
import entity.TacGia;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelDatHang extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	private PhieuMuaHang_DAO pmh_DAO;
   private Sach_DAO sach_DAO;
	private DefaultTableModel tableModel;
	private KhachHangDatHang_DAO KhachHangDatHang_DAO;
    private ChiTietPhieuMua_DAO ctpmh_DAO;
	private JLabel lbTongTien;
private ArrayList<KhachHangDatHang> dsKHDH;
	private PhieuMuaHang pmh;
	public PanelDatHang() throws SQLException {
		KhachHangDatHang_DAO=new KhachHangDatHang_DAO();
		pmh_DAO=new PhieuMuaHang_DAO();
		ctpmh_DAO=new ChiTietPhieuMua_DAO();
		dsKHDH=new ArrayList<>(); 
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1252, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 192));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/img/Money-icon.png")));
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row>=0)
				{				
					
					String ma = (String)table.getValueAt(row,0);
					int show = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa",ma, JOptionPane.YES_NO_OPTION);
					 if(show==JOptionPane.YES_OPTION)
						 
						try {
							if(ctpmh_DAO.deleteChiTietPhieuMuaHang(ma))
							{
								tableModel.removeRow(row);						
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}else {
					JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Dòng Cần Xóa");
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(176, 172, 213));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("Mua Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				panel.removeAll();
//		    	try {
//					panel.add(new PanelXemSach());
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//		    	panel.repaint();
//		    	panel.revalidate();	
//				
			}
		});
		btnNewButton_1.setBackground(new Color(176, 172, 213));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel_1)
					.addGap(236)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(163)
					.addComponent(btnNewButton_1)
					.addContainerGap(360, Short.MAX_VALUE))
				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addGap(43)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		tableModel=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã Phiếu","Mã Sách", "Tên Sách", "Đơn Giá", "Tên Tác Giả", "Loại Sách", "Số Lượng", "Tên NXB"
				}
			);
		table.setModel(tableModel);
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng Tiền:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton_2 = new JButton("Đặt Hàng");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				JOptionPane.showConfirmDialog(btnNewButton_2, e)
				try {
					
					if(pmh==null||dsKHDH.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sách để mua");
						return;
					}
					pmh_DAO.datHang(pmh.getMaPhieuMh(),"KH001" );
					JOptionPane.showMessageDialog(null, "Đặt hàng thành công");
					while (table.getRowCount() != 0) {
						tableModel.removeRow(0);
					}
					lbTongTien.setText("0 VNĐ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		 lbTongTien = new JLabel("0 VNĐ");
		lbTongTien.setForeground(new Color(255, 0, 0));
		lbTongTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(150)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbTongTien, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(155)
					.addComponent(btnNewButton_2)
					.addContainerGap(508, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(128)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbTongTien, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(159, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Đặt Hàng");
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(992, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		loadDatHang();
	}
	
	
	public void loadDatHang() throws SQLException {
		while (table.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
		 pmh=pmh_DAO.getPhieuMH(false, "KH001");
	
	if(pmh==null) {
		return;
	}
	
	dsKHDH=KhachHangDatHang_DAO.getAllDatHang(pmh.getMaPhieuMh());
	
	System.out.println(dsKHDH);
	float tongTien=0;
	for (KhachHangDatHang k : dsKHDH) {

		tableModel.addRow(new Object[] {k.getMaCTPMH(),k.getMaSach(),k.getTenSach(),k.getDonGia(),k.getTenTacGia(),k.getTenLoaiSach(),k.getSoLuong(),k.getTenNXB()});
		tongTien+=Float.parseFloat(k.getDonGia());
		
	}
	
	lbTongTien.setText(tongTien+ "VNĐ");
	}
}
