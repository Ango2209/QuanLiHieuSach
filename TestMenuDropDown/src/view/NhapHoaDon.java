package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class NhapHoaDon extends JPanel implements ActionListener, MouseListener {

	private DefaultTableModel dataModelSach;
	private DefaultTableModel dataModelDonHang;
	private HoaDon_DAO hdDao = new HoaDon_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private Sach_DAO sDao = new Sach_DAO();
	private JTable table;
	private JTable tblDsMua;
	private JTable tblDsSach;
	private JTextField txtSoDienThoai;
	private static String idS;
	private JPanel pnlCTHD;
	private List<ChiTietHoaDon> dsDonHang = new ArrayList<ChiTietHoaDon>();
	private Sach s = new Sach();
	private JTextField txtTongThanhTien;

	/**
	 * Create the panel.
	 */
	public NhapHoaDon() {

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 5, 1295, 60);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("NHẬP HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 10, 196, 40);
		panel_1.add(lblNewLabel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1277, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(1)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(new TitledBorder(null, "Danh s\u00E1ch mua", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(128, 128, 255)));
		scrollPane1.setBounds(735, 192, 505, 410);
		panel.add(scrollPane1);

		tblDsMua = new JTable();
		tblDsMua.setModel(dataModelDonHang = new DefaultTableModel(new Object[][] {},
				new String[] { "Tên sách", "Đơn giá", "số lượng mua", "tổng tiền", }));
		scrollPane1.setViewportView(tblDsMua);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 255)));
		scrollPane.setBounds(44, 192, 659, 410);
		panel.add(scrollPane);

		tblDsSach = new JTable();
		tblDsSach.setModel(dataModelSach = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Sách",
				"Tên sách", "Tên tác giả", "Tên nhà xuất bản", "Thể loại", "Đơn giá", "Số lượng" }));
		scrollPane.setViewportView(tblDsSach);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(128, 128, 255));
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"nh\u1EADp h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(128, 128, 255)));
		panel_2.setBounds(31, 75, 1209, 113);
		panel.add(panel_2);
		panel_2.setLayout(null);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(587, 10, 203, 35);
		panel_2.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1.setBounds(54, 9, 104, 35);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setBounds(488, 9, 85, 35);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnLapHoaDon = new JButton("Lập Hóa Đơn");
		btnLapHoaDon.setBounds(868, 10, 147, 35);
		panel_2.add(btnLapHoaDon);

		JLabel lblNewLabel_4 = new JLabel("Nhân Viên");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(54, 61, 104, 35);
		panel_2.add(lblNewLabel_4);

		JComboBox<String> cboTenNhanVien = new JComboBox<String>();
		cboTenNhanVien.setBounds(165, 61, 247, 35);
//		cboTenNhanVien.setEditable(true);
		panel_2.add(cboTenNhanVien);
		ArrayList<NhanVien> listNV = hdDao.getTenNV();
		for (NhanVien nv : listNV) {
			cboTenNhanVien.addItem(nv.getTenNhanVien());
		}
		cboTenNhanVien.setSelectedItem("");

		JComboBox cboKhachHang = new JComboBox();
		cboKhachHang.setBounds(168, 10, 244, 35);
		cboKhachHang.setEditable(true);
		panel_2.add(cboKhachHang);
		ArrayList<KhachHang> listKH = hdDao.getCboThongTinKH();
		for (KhachHang kh : listKH) {
			cboKhachHang.addItem(kh.getTenKhachHang());
		}
		cboKhachHang.setSelectedItem("");

		JLabel lblNewLabel_3 = new JLabel("Tổng hóa đơn :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(889, 631, 143, 60);
		panel.add(lblNewLabel_3);

		txtTongThanhTien = new JTextField();
		txtTongThanhTien.setText("0 VND");
		txtTongThanhTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTongThanhTien.setBounds(1011, 640, 192, 47);
		panel.add(txtTongThanhTien);
		txtTongThanhTien.setColumns(10);

		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validData()) {
//					String sdtKhachHang = txtSoDienThoai.getText();
					String maKhachHang = null;
					String maNhanVien = null;
					String maHoaDon = null;
					LocalDate nlhd = LocalDate.now();
					try {
						maHoaDon = hdDao.getMaxID();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					String tenKhachHang = cboKhachHang.getSelectedItem().toString();
//						List<KhachHang> listLayMaTuTenKH = hdDao.getMaTuTenKH(tenKhachHang);
					List<KhachHang> listLayMaTuTenKH = kh_dao.getMaTuTenKH(tenKhachHang);
					for (KhachHang kh : listLayMaTuTenKH) {
						maKhachHang = kh.getMaKhachHang();
					}
//					KhachHang kh = new KhachHang();
//					maKhachHang = kh.getMaKhachHang();
//					
					String tenNV = cboTenNhanVien.getSelectedItem().toString();
					List<NhanVien> listLayMaTuTenNV = hdDao.getMaTuTenNV(tenNV);
					for (NhanVien nv : listLayMaTuTenNV) {
						maNhanVien = nv.getMaNhanVien();
					}
					HoaDon hd = new HoaDon(maHoaDon, new KhachHang(maKhachHang, "", ""), new NhanVien(maNhanVien, ""),
							nlhd);
					try {
						if (!hdDao.create(hd)) {
							JOptionPane.showMessageDialog(null, "MÃ£ hÃ³a Ä‘Æ¡n Ä‘Ã£ tá»“n táº¡i");

						} else
							JOptionPane.showMessageDialog(null, "Thêm thành công");
						hdDao.create(hd);
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				

			}
			public boolean validData() {
				String sdtKhachHang = txtSoDienThoai.getText().trim();	
				String tenKhachHang = cboKhachHang.getSelectedItem().toString();
				String tenNhanVien = cboTenNhanVien.getSelectedItem().toString();
			
				
				if(!(tenKhachHang.length() > 0)) {
					JOptionPane.showMessageDialog(null, "tên khách hàng ko được để trống");
					return false;
				}
				else if(!(sdtKhachHang.matches("^(0)[0-9]+"))) {
					JOptionPane.showMessageDialog(null, " số điện thoại phải bắt đầu bằng số 0");
					return false;
				}
					
				
				return true;
			}
			
		});
		tblDsSach.addMouseListener(this);

		DocDuLieuNhapHD();

		setLayout(groupLayout);

	}



	public void DocDuLieuNhapHD() {
		List<Sach> dss = hdDao.dsNhapHoaDon();
//		DecimalFormat dt = new DecimalFormat("###, ### VND");
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Sach s : dss) {
			dataModelSach.addRow(new Object[] { s.getMaSach(), s.getTenSach(), s.getTacGia().getTenTacGia(),
					s.getNhaXuatBan().getTenNXB(), s.getTenLoaiSach(), s.getDonGia(), s.getSoLuong() });
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if (src.equals(tblDsSach)) {
			int rowSanPham = tblDsSach.getSelectedRow();
			if (rowSanPham != -1) {
				String IDS = (String) tblDsSach.getValueAt(rowSanPham, 0);
				setIdS(IDS);
//		int row = tblDsSach.getSelectedRow();
//		txtMaHoaDon.setText(dataModelHoaDon.getValueAt(row, 0).toString());
//		txtTenKhachHang.setText(dataModelHoaDon.getValueAt(row, 1).toString());
//		txtsdt.setText(dataModelHoaDon.getValueAt(row, 2).toString());

				chonSanPham();

			}
		}

	}

	public static String getIdS() {
		return idS;
	}

	public static void setIdS(String idS) {
		NhapHoaDon.idS = idS;
	}

	private void chonSanPham() {
		SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 100000, 1);
		SpinnerNumberModel sModel2 = new SpinnerNumberModel(0, 0, 100, 1);

		pnlCTHD = new JPanel();
		pnlCTHD.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel jLabel = new JLabel("Số lượng: ");
		jLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlCTHD.add(jLabel);

		JSpinner spinner = new JSpinner(sModel);
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlCTHD.add(spinner);

		int option = JOptionPane.showOptionDialog(null, pnlCTHD, "Chi tiết đơn hàng", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);

		if (option == JOptionPane.CANCEL_OPTION) {

		} else if (option == JOptionPane.OK_OPTION) {
			DecimalFormat dt = new DecimalFormat("###, ### VND");
			LocalDate localDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Sach s = sDao.getSachTheoMaSach(NhapHoaDon.getIdS());
//			String maSach = s.getMaSach() ;
			String tenSach = s.getTenSach();
//			double donGia = sp.getDonGia();
			int soLuong = Integer.parseInt(spinner.getValue().toString());
//			int phanTramGam = Integer.parseInt(spinner1.getValue().toString());
			if (soLuong == 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
			} else {
//				System.out.println(s.getTenSach());
				ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(tenSach, null, null, localDate, null), s, soLuong,
						option, soLuong);
				String[] rowDonHang = { s.getTenSach(), dt.format(s.getDonGia()) + "", soLuong + "",
						dt.format(s.getDonGia() * soLuong) + "" };
				dataModelDonHang.addRow(rowDonHang);
				dsDonHang.add(cthd);
				String tongTT = dt.format(tinhTongThanhTien());
				txtTongThanhTien.setText(tongTT);
			}

		}
	}

	public double tinhTongThanhTien() {
		double thanhTien = 0;
		for (ChiTietHoaDon object : dsDonHang) {
			thanhTien = thanhTien + (object.getSoLuong() * object.getSach().getDonGia());
		}
		return thanhTien;
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
