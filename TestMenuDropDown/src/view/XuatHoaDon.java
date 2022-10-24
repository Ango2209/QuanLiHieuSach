package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Sach;

import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class XuatHoaDon extends JPanel {
	private DefaultTableModel dataModelHoaDon;
	private HoaDon_DAO hdDao = new HoaDon_DAO();
	private JTextField txtTenKhachHang;
	private JTextField txtsdt;
	private JTable tblHoaDon;
	private JTextField txtMaHoaDon;
	private HoaDon hd = new HoaDon();
	private ChiTietHoaDon_DAO cthdDao = new ChiTietHoaDon_DAO();

	/**
	 * Create the panel.
	 */
	public XuatHoaDon() {

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1290, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE));
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

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(128, 128, 255)));
		scrollPane1.setBounds(35, 232, 1221, 421);
		panel.add(scrollPane1);

		tblHoaDon = new JTable();
		tblHoaDon.setModel(dataModelHoaDon = new DefaultTableModel(new Object[][] {}, new String[] { "Mã hóa đơn",
				"Tên khách hàng", "số điện thoại khách hàng", "Tên nhân viên", "Ngày lập hóa đơn" }));
		DocDuLieuVaoBang();
		scrollPane1.setViewportView(tblHoaDon);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Xu\u1EA5t h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(128, 128, 255)));
		panel_3.setBounds(10, 44, 1192, 161);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnXuatHoaDon = new JButton("Xuất hóa đơn");
		btnXuatHoaDon.setBounds(425, 94, 165, 41);
		panel_3.add(btnXuatHoaDon);
		btnXuatHoaDon.setIcon(new ImageIcon(XuatHoaDon.class.getResource("/img/bill-icon.png")));
		btnXuatHoaDon.setBackground(new Color(172, 175, 213));
		btnXuatHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(706, 94, 129, 41);
		panel_3.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(XuatHoaDon.class.getResource("/img/refresh-page-option.png")));
		btnLamMoi.setBackground(new Color(172, 175, 213));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBounds(167, 95, 152, 39);
		panel_3.add(btnTimKiem);
		btnTimKiem.setBackground(new Color(172, 175, 213));
		btnTimKiem.setIcon(new ImageIcon("/img/Search-icon.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setBounds(66, 26, 91, 21);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(167, 22, 119, 34);
		panel_3.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
		lblNewLabel_2.setBounds(339, 19, 119, 34);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(491, 22, 242, 33);
		panel_3.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setBounds(766, 23, 103, 27);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtsdt = new JTextField();
		txtsdt.setBounds(905, 22, 222, 34);
		panel_3.add(txtsdt);
		txtsdt.setColumns(10);

		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				timTheoSDTKH();
				// timTheoTenKH();
			}
		});

		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnLamMoi)) {
					xoatrang();
					hdDao.xoaHetDanhSach();
					XoaHetDuLieuTable();
					DocDuLieuVaoBang();
				}
			}
		});
		btnXuatHoaDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				GiaoDienChiTietHoaDon gdcthd = new GiaoDienChiTietHoaDon();
//				gdcthd.setVisible(true);
				xuatHD();

			}
		});
		tblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblHoaDon.getSelectedRow();
				txtMaHoaDon.setText(dataModelHoaDon.getValueAt(row, 0).toString());
				txtTenKhachHang.setText(dataModelHoaDon.getValueAt(row, 1).toString());
				txtsdt.setText(dataModelHoaDon.getValueAt(row, 2).toString());
			}
		});
		setLayout(groupLayout);
		ConnectDB.getInstance();
	}

	public void DocDuLieuVaoBang() {
		List<HoaDon> dshd = hdDao.getAllDSHD();
//		DecimalFormat dt = new DecimalFormat("###, ### VND");
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (HoaDon hd : dshd) {
			dataModelHoaDon.addRow(new Object[] { hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(),
					hd.getKhachHang().getSdtKhachHang(), hd.getNhanVien().getTenNhanVien(),
					formatter.format(hd.getNgayLapHoaDon()) });
		}
	}

	private void timTheoSDTKH() {
		String sdtKh = txtsdt.getText();

		if (sdtKh.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập số điện thoại khách hàng!");

		} else {
			ArrayList<HoaDon> dshd = hdDao.timHoaDontheoSdt(sdtKh);
			hdDao.xoaHetDanhSach();
			XoaHetDuLieuTable();
			DecimalFormat dt = new DecimalFormat("###, ### VND");
			LocalDate localDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			for (HoaDon hd : dshd) {
				dataModelHoaDon.addRow(new Object[] { hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(),
						hd.getKhachHang().getSdtKhachHang(), hd.getNhanVien().getTenNhanVien(),
						formatter.format(hd.getNgayLapHoaDon()) });
			}
		}

	}

	private void timTheoTenKH() {
		String tenKh = txtTenKhachHang.getText();

		if (tenKh.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên khách hàng!");

		} else {
			ArrayList<HoaDon> dshd = hdDao.timHoaDontheoSdt(tenKh);
			hdDao.xoaHetDanhSach();
			XoaHetDuLieuTable();
			DecimalFormat dt = new DecimalFormat("###, ### VND");
			LocalDate localDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			for (HoaDon hd : dshd) {
				dataModelHoaDon.addRow(new Object[] { hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(),
						hd.getKhachHang().getSdtKhachHang(), hd.getNhanVien().getTenNhanVien(),
						formatter.format(hd.getNgayLapHoaDon()) });
			}
		}
	}
//	public void xuatHD() {
//		String maHd = txtMaHoaDon.getText();
//		if (maHd.equals("")) {
//			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hóa đơn");
//		} else {
//
////			HoaDon hd = hdDao.xuatChiTietHoaDon(maHd);
//			GiaoDienChiTietHoaDon gdcthd = new GiaoDienChiTietHoaDon();
//			gdcthd.setVisible(true);
////			for (HoaDon hd : dshd) {
//			gdcthd.xuatHoaDonChiTiet(hd);
//			}
//		}

//	public void xuatHD() {
//		String maHd = txtMaHoaDon.getText();
//		List<ChiTietHoaDon> dssp = cthdDao.timCT(maHd);
//		if (maHd.equals("")) {
//			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hóa đơn");
//		} else {
//			for (ChiTietHoaDon sp : dssp) {
////				gdcthd.hienTableDonHang(sp);
//				GiaoDienChiTietHoaDon gdcthd = new GiaoDienChiTietHoaDon();
//				gdcthd.setVisible(true);
////				txtsdt.setText(sp.getHoaDon());
//
//			}
////			HoaDon hd = hdDao.xuatChiTietHoaDon(maHd);
////			ChiTietHoaDon cthd = cthdDao.xuatChiTietHoaDon();
////			GiaoDienChiTietHoaDon gdcthd = new GiaoDienChiTietHoaDon();
////			gdcthd.setVisible(true);
////			gdcthd.xuatHoaDonChiTiet(hd);
//		}
//	}

	public void xuatHD() {
		String maHd = txtMaHoaDon.getText();
		if (maHd.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hóa đơn");
		} else {
//			HoaDon hd = hdDao.xuatChiTietHoaDon(maHd);
			ArrayList<ChiTietHoaDon> cthd = cthdDao.xuatChiTietHoaDon(maHd);
			GiaoDienChiTietHoaDon gdcthd = new GiaoDienChiTietHoaDon();
//			ChiTietHoaDon ct = new ChiTietHoaDon();
			gdcthd.setVisible(true);
			for(ChiTietHoaDon ct : cthd) {
//				txtsdt.setText(ct.getHoaDon().getNhanVien().getTenNhanVien());
				gdcthd.xuatHoaDonChiTiet(ct);
			}
		}
	}

	public void xoatrang() {
		txtMaHoaDon.setText("");
		txtTenKhachHang.setText("");
		txtsdt.setText("");
	}

	private void XoaHetDuLieuTable() {
		DefaultTableModel dtm = (DefaultTableModel) tblHoaDon.getModel();
		dtm.setRowCount(0);
	}
}
