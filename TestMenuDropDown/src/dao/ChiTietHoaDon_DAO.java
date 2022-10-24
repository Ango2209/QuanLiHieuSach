package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;

public class ChiTietHoaDon_DAO {
	private ArrayList<ChiTietHoaDon> dscthd;

	public ChiTietHoaDon_DAO() {
		dscthd = new ArrayList<ChiTietHoaDon>();
	}

//	public List<ChiTietHoaDon> timCT(String maHD) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();	
//		PreparedStatement stmt = null;
//		try {
//			String sql = "Select * from ChiTietHoaDon where maHoaDon = ? ";
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maHD);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maHoaDon = rs.getString(2);
//				String maSach = rs.getString(3);
//				int soLuong = rs.getInt(4);
//				Float donGia = rs.getFloat(5);
//				Float tongDonGia = rs.getFloat(6);
//				ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(maHoaDon), new Sach(maSach), soLuong, donGia, tongDonGia);
//				dsspmua.add(cthd);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dsspmua;
//	}
	public List<ChiTietHoaDon> timCT(String maHD) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "Select * from ChiTietHoaDon where maHoaDon = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maSach = rs.getString(2);
				int soLuong = rs.getInt(3);
				Float donGia = rs.getFloat(4);
				Float tongDonGia = rs.getFloat(5);
				ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(maHoaDon), new Sach(maSach), soLuong, donGia,
						tongDonGia);
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}

	public ArrayList<ChiTietHoaDon> xuatChiTietHoaDon(String maHD) {
		ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			// SELECT HoaDon.maHoaDon, KhachHang.tenKhachHang, KhachHang.sdtKhachHang ,
			// NhanVien.tenNhanVien,
			// HoaDon.ngayLapHoaDon,Sach.tenSach,ChiTietHoaDon.soLuong,Sach.donGia,ChiTietHoaDon.tongDonGia
			// FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang
			// INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien INNER JOIN
			// ChiTietHoaDon ON HoaDon.maHoaDon=ChiTietHoaDon.maHoaDon INNER JOIN Sach ON
			// ChiTietHoaDon.maSach=Sach.maSach where Hoadon.maHoaDon='HD001'
			String sql = "SELECT HoaDon.maHoaDon, KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon,Sach.tenSach,ChiTietHoaDon.soLuong,Sach.donGia,ChiTietHoaDon.tongDonGia FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien INNER JOIN ChiTietHoaDon ON HoaDon.maHoaDon=ChiTietHoaDon.maHoaDon INNER JOIN Sach ON ChiTietHoaDon.maSach=Sach.maSach where Hoadon.maHoaDon= ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String sdtKhachHang = rs.getString(3);
				String tenNhanVien = rs.getString(4);
				LocalDate ngayLapHoaDon = rs.getDate(5).toLocalDate();
				String tenSach = rs.getString(6);
				int soLuong = rs.getInt(7);
				Float donGia = rs.getFloat(8);
				Double tongDonGia = rs.getDouble(9);
				ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(maHoaDon, new KhachHang(tenKhachHang, sdtKhachHang),
						new NhanVien(tenNhanVien), ngayLapHoaDon), new Sach(tenSach, donGia), soLuong, tongDonGia);
				// HoaDon hd1 = new HoaDon(maHoaDon, new KhachHang(tenKhachHang,sdtKhachHang),
				// new NhanVien(tenNhanVien), ngayLapHoaDon, new ChiTietHoaDon( soLuong,
				// tongDonGia, new Sach(tenSach, donGia)));
				dscthd.add(cthd);
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}
//
//	public boolean create(ChiTietHoaDon cthd) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("insert into ChiTietHoaDon values(?,?,?,?,?)");
//			stmt.setString(1, cthd.getHoaDon().getMaHoaDon());
//			stmt.setString(2, cthd.getSach().getMaSach());
//			stmt.setInt(3, cthd.getSoLuong());
//			stmt.setDouble(4, cthd.getSach().getDonGia());
//			stmt.setDouble(5, cthd.getTongDonGia());
//			n = stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return n > 0;
//	}
	public boolean create(ChiTietHoaDon cthd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into ChiTietHoaDon values(?,?,?,?,?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cthd.getHoaDon().getMaHoaDon());
			stmt.setString(2, cthd.getSach().getMaSach());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getSach().getDonGia());
			stmt.setDouble(5, cthd.getTongDonGia());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

}
