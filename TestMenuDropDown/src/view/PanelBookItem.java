package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import dao.ChiTietPhieuMua_DAO;
import dao.PhieuMuaHang_DAO;
import entity.ChiTietPhieuMuaHang;
import entity.NguoiDangNhap;
import entity.PhieuMuaHang;
import entity.Sach;

import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelBookItem extends JPanel {

	/**
	 * Create the panel.
	 */
    private NguoiDangNhap ndn;
	private ChiTietPhieuMua_DAO ctPMH_DAO;
	private PhieuMuaHang_DAO pmh_DAO;
	private PhieuMuaHang pmhHienTai;
	
	
	public PanelBookItem(Sach sach) throws SQLException {
		ctPMH_DAO=new ChiTietPhieuMua_DAO();
		pmh_DAO=new PhieuMuaHang_DAO();
		setBackground(new Color(203, 146, 187));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:/Users/Admin/git/QuanLiHieuSach/TestMenuDropDown/src/img/Book-icon-item.png"));
		lblNewLabel.setBackground(new Color(203, 146, 187));
		 setPhieuMuaHang();

		JButton btnNewButton = new JButton("Mua ");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			
			String soLuongMuonMua=JOptionPane.showInputDialog("Vui lòng nhập số lượng mà bạn muốn mua (Chỉ nhập số)");
			
			if(!(soLuongMuonMua.length()>0&& (soLuongMuonMua.matches("[0-9]+") )&&Integer.parseInt(soLuongMuonMua)< sach.getSoLuong() )) {
				JOptionPane.showMessageDialog(null,"Số lượng sách phải là số và nhỏ hơn số lượng đang còn trong kho");
				
			}
			try{
				System.out.println();
				String maCTPMH=ctPMH_DAO.getMaxID();
				ChiTietPhieuMuaHang ct=new ChiTietPhieuMuaHang(maCTPMH,pmhHienTai.getMaPhieuMh(),sach.getMaSach(),Integer.parseInt(soLuongMuonMua),Integer.parseInt(soLuongMuonMua)*sach.getDonGia());
				ctPMH_DAO.addCTPMH(ct);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}		
				
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(203, 146, 187));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lblNewLabel)
							.addGap(25))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(25))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(5))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 4, 46, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giá:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 36, 46, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số Lượng:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 68, 59, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lbTen = new JLabel(sach.getTenSach());
		lbTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbTen.setBounds(71, 4, 158, 18);
		panel.add(lbTen);
		
		JLabel lbGia = new JLabel(sach.getDonGia()+"");
		lbGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbGia.setBounds(71, 36, 158, 21);
		panel.add(lbGia);
		
		JLabel lbSoLuong = new JLabel(sach.getSoLuong()+"");
		lbSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbSoLuong.setBounds(71, 68, 158, 20);
		panel.add(lbSoLuong);
		setLayout(groupLayout);

	}
	public void setPhieuMuaHang() throws SQLException {
		
		
			
		
		 pmhHienTai=pmh_DAO.getPhieuMH(false,"KH001");
		
			// TODO Auto-generated catch block


//		String maPhieuMh, String maKhachHang, String maNhanVien, LocalDate ngayLapPhieu
		if(pmhHienTai==null) {
			
			String maPhieu=pmh_DAO.getMaxID();
			pmhHienTai=new PhieuMuaHang(maPhieu,"KH001",null,false);
			pmh_DAO.addPMH(pmhHienTai);
			System.out.println(pmhHienTai);
		}


	}
}
