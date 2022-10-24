package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Sach;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class GiaoDienChiTietHoaDon extends JDialog {
	private DefaultTableModel dataModelHoaDon;

	private HoaDon_DAO hdDao = new HoaDon_DAO();
	private ChiTietHoaDon_DAO cthdDao = new ChiTietHoaDon_DAO();

	private final JPanel contentPanel = new JPanel();
	private JTable tblChiTietHoaDon;
	private JTextField txtMa;
	private JTextField txtTenNhanVien;
	private JTextField txtKhachHang;
	private JTextField txtSdt;
	private JTextField txtNgayDat;
	private JTextField txtTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GiaoDienChiTietHoaDon dialog = new GiaoDienChiTietHoaDon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GiaoDienChiTietHoaDon() {
		setBounds(100, 100, 476, 641);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 462, 439);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(38, 65, 81, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nhân viên bán");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(38, 106, 81, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(38, 146, 101, 31);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(38, 187, 90, 31);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Ngay đặt");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(38, 228, 81, 31);
			contentPanel.add(lblNewLabel_4);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 269, 442, 275);
		contentPanel.add(scrollPane);

		tblChiTietHoaDon = new JTable();
		tblChiTietHoaDon.setModel(dataModelHoaDon = new DefaultTableModel(new Object[][] {},
				new String[] { "Tên Sách", "Đơn giá", "Số lượng", "Tổng tiền" }));

		scrollPane.setViewportView(tblChiTietHoaDon);

		JLabel lblNewLabel_6 = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(163, 10, 289, 44);
		contentPanel.add(lblNewLabel_6);

		txtMa = new JTextField();
		txtMa.setBounds(186, 65, 222, 31);
		contentPanel.add(txtMa);
		txtMa.setColumns(10);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(185, 101, 222, 31);
		contentPanel.add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);

		txtKhachHang = new JTextField();
		txtKhachHang.setBounds(186, 146, 222, 31);
		contentPanel.add(txtKhachHang);
		txtKhachHang.setColumns(10);

		txtSdt = new JTextField();
		txtSdt.setBounds(186, 194, 222, 31);
		contentPanel.add(txtSdt);
		txtSdt.setColumns(10);

		txtNgayDat = new JTextField();
		txtNgayDat.setBounds(186, 235, 222, 31);
		contentPanel.add(txtNgayDat);
		txtNgayDat.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 559, 462, 35);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);

			JLabel lblNewLabel_5 = new JLabel("Tổng Tiền");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(10, 13, 68, 13);
			buttonPane.add(lblNewLabel_5);
			{
				JButton btnInHoaDon = new JButton("In hóa đơn");
				btnInHoaDon.setBounds(354, 5, 103, 25);
				btnInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnInHoaDon.setActionCommand("Cancel");
				buttonPane.add(btnInHoaDon);
			}

			txtTongTien = new JTextField();
			txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtTongTien.setBounds(91, 5, 179, 25);
			buttonPane.add(txtTongTien);
			txtTongTien.setColumns(10);
		}

	}


	public void xuatHoaDonChiTiet(ChiTietHoaDon cthd) {

		DecimalFormat dt = new DecimalFormat("###, ### VND");
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String maHd = cthd.getHoaDon().getMaHoaDon();
		ArrayList<ChiTietHoaDon> dscthd = cthdDao.xuatChiTietHoaDon(maHd);

		txtMa.setText(cthd.getHoaDon().getMaHoaDon());
		txtTenNhanVien.setText(cthd.getHoaDon().getNhanVien().getTenNhanVien());
		txtKhachHang.setText(cthd.getHoaDon().getKhachHang().getTenKhachHang());
		txtSdt.setText(cthd.getHoaDon().getKhachHang().getSdtKhachHang());
		txtNgayDat.setText(formatter.format(cthd.getHoaDon().getNgayLapHoaDon()));
		dataModelHoaDon.addRow(new Object[] { cthd.getSach().getTenSach(), cthd.getSach().getDonGia(),
				cthd.getSoLuong(), dt.format(cthd.getTongDonGia()) });
		txtTongTien.setText(dt.format(cthd.getTongDonGia()));

	}

}
