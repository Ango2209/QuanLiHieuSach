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
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;
import entity.TacGia;
import view.Main;

public class HoaDon_DAO {
	private ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
	private HoaDon hd = new HoaDon();
	private Sach s = new Sach();

//	public ArrayList<HoaDon> getAllDSHD(){
////		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
////			SELECT HoaDon.maHoaDon , NhanVien.tenNhanVien, KhachHang.tenKhachHang, KhachHang.sdtKhachHang , HoaDon.ngayLapHoaDon
////			FROM HoaDon
////			INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang 
////			INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien ;
////			String sql ="SELECT HoaDon.maHoaDon ,  KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien";
//			String sql ="SELECT HoaDon.maHoaDon ,  KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon,ChiTietHoaDon.tongDonGia FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien INNER JOIN ChiTietHoaDon ON HoaDon.maHoaDon=ChiTietHoaDon.maHoaDon";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//
//			while(rs.next() ) {
//				String maHoaDon = rs.getString(1);
//				String maKhachHang= rs.getString(2);
//				String tenKhachHang =rs.getString(3);
//				String sdtKhachHang = rs.getString(4);
//				String tenNhanVien= rs.getString(5);
//				LocalDate ngayLapHoaDon = rs.getDate(6).toLocalDate();
//				Double tongDonGia = rs.getDouble(7);
////				HoaDon hdbs = new HoaDon(maHoaDon, new KhachHang(tenKhachHang,sdtKhachHang), new NhanVien(tenNhanVien), ngayLapHoaDon);
//				HoaDon hdbs = new HoaDon(maHoaDon, new KhachHang(tenKhachHang,sdtKhachHang), new NhanVien(tenNhanVien), ngayLapHoaDon, new ChiTietHoaDon(tongDonGia));
//				dsHD.add(hdbs);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsHD;
//	}
//	
	public ArrayList<HoaDon> getAllDSHD() {
//		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			SELECT HoaDon.maHoaDon , NhanVien.tenNhanVien, KhachHang.tenKhachHang, KhachHang.sdtKhachHang , HoaDon.ngayLapHoaDon
//			FROM HoaDon
//			INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang 
//			INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien ;
//			String sql ="SELECT HoaDon.maHoaDon ,  KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien";
			String sql = "SELECT HoaDon.maHoaDon ,  KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String tenKhachHang = rs.getString(3);
				String sdtKhachHang = rs.getString(4);
				String tenNhanVien = rs.getString(5);
				LocalDate ngayLapHoaDon = rs.getDate(6).toLocalDate();
//				HoaDon hdbs = new HoaDon(maHoaDon, new KhachHang(tenKhachHang,sdtKhachHang), new NhanVien(tenNhanVien), ngayLapHoaDon);
				HoaDon hdbs = new HoaDon(maHoaDon, new KhachHang(tenKhachHang, sdtKhachHang), new NhanVien(tenNhanVien),
						ngayLapHoaDon);
				dsHD.add(hdbs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

//	SELECT HoaDon.maHoaDon ,  KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon,ChiTietHoaDon.tongDonGia FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien INNER JOIN ChiTietHoaDon ON HoaDon.maHoaDon=ChiTietHoaDon.maHoaDon where sdtKhachHang = '0958512656'

	public ArrayList<HoaDon> timHoaDontheoSdt(String sdtKh) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT HoaDon.maHoaDon ,  KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien where sdtKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdtKh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String tenKhachHang = rs.getString(3);
				String sdtKhachHang = rs.getString(4);
				String tenNhanVien = rs.getString(5);
				LocalDate ngayLapHoaDon = rs.getDate(6).toLocalDate();
				HoaDon hdbs = new HoaDon(maHoaDon, new KhachHang(tenKhachHang, sdtKhachHang), new NhanVien(tenNhanVien),
						ngayLapHoaDon);
				dsHD.add(hdbs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public ArrayList<HoaDon> timHoaDonTheoTen(String tenKH) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT HoaDon.maHoaDon , KhachHang.maKhachHang,KhachHang.tenKhachHang, KhachHang.sdtKhachHang , NhanVien.tenNhanVien, HoaDon.ngayLapHoaDon FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang=KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien=NhanVien.maNhanVien where sdtKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenKH);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maKhachHang = rs.getString(2);
				String tenKhachHang = rs.getString(3);
				String sdtKhachHang = rs.getString(4);
				String tenNhanVien = rs.getString(5);
				LocalDate ngayLapHoaDon = rs.getDate(6).toLocalDate();
				HoaDon hdbs = new HoaDon(maHoaDon, new KhachHang(tenKhachHang, sdtKhachHang), new NhanVien(tenNhanVien),
						ngayLapHoaDon);
				dsHD.add(hdbs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public HoaDon xuatChiTietHoaDon(String maHD) {
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
				HoaDon hd = new HoaDon(maHoaDon, new KhachHang(tenKhachHang, sdtKhachHang), new NhanVien(tenNhanVien),
						ngayLapHoaDon, new ChiTietHoaDon(new Sach(tenSach, donGia), soLuong, tongDonGia));
				// HoaDon hd1 = new HoaDon(maHoaDon, new KhachHang(tenKhachHang,sdtKhachHang),
				// new NhanVien(tenNhanVien), ngayLapHoaDon, new ChiTietHoaDon( soLuong,
				// tongDonGia, new Sach(tenSach, donGia)));
				return hd;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}

	public ArrayList<Sach> dsNhapHoaDon() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT Sach.maSach ,Sach.tenSach , TacGia.tenTacGia,NhaXuatBan.tenNhaXuatBan ,Sach.tenLoaiSach,Sach.soLuong,Sach.donGia FROM Sach INNER JOIN TacGia ON Sach.maTacGia=TacGia.maTacGia INNER JOIN NhaXuatBan ON Sach.maNhaXuatBan = NhaXuatBan.maNhaXuatBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maSach = rs.getString(1);
				String tenSach = rs.getString(2);
				String tenTacGia = rs.getString(3);
				String tenNhaXuatBan = rs.getString(4);
				String tenLoaiSach = rs.getString(5);
				int soLuong = rs.getInt(6);
				Double donGia = rs.getDouble(7);
//				Sach s = new Sach(tenSach, donGia, tenLoaiSach, soLuong, new NhaXuatBan(tenNhaXuatBan), new NhaXuatBan(tenNhaXuatBan));
				Sach s = new Sach(maSach, tenSach, donGia, tenLoaiSach, soLuong, new NhaXuatBan(tenNhaXuatBan),
						new TacGia(tenTacGia));
				dsSach.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	public boolean create(HoaDon hd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into HoaDon values(?,?,?,?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getKhachHang().getMaKhachHang());
			stmt.setString(3, hd.getNhanVien().getMaNhanVien());
			stmt.setDate(4, Date.valueOf(hd.getNgayLapHoaDon()));
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	

	public String getMaxID() throws SQLException {

		String sql = "select MAX(maHoaDon) from HoaDon";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				System.out.println(rs.getString(1));
				if (rs.getString(1) == null) {
					return "HD001";
				} else {
					long id = Long.parseLong(rs.getString(1).substring(2, rs.getString(1).trim().length()));
					id++;
					return "HD" + String.format("%03d", id);
				}
			}
		}

	}

	public ArrayList<NhanVien> getTenNV() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select Distinct tenNhanVien from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ten = rs.getString("tenNhanVien");
				NhanVien nv = new NhanVien(ten);
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public void xoaHetDanhSach() {
		dsHD.clear();
	}

	public ArrayList<KhachHang> getCboThongTinKH() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select tenKhachHang, sdtKhachHang from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ten = rs.getString("tenKhachHang");
				String dc = rs.getString("sdtKhachHang");
				KhachHang kh = new KhachHang(ten, dc);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}

//	public ArrayList<KhachHang> getMaTuTenKH(String ten) throws SQLException {
//		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		Statement stm = null;
//		String sql = "Select maKhachHang from KhachHang where tenKhachHang LIKE N'%" + ten + "%'";
//		try {
//			stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while (rs.next()) {
//				String ma = rs.getString("maKhachHang");
//				KhachHang kh = new KhachHang(ma, "", "");
//				dsKH.add(kh);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stm.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return dsKH;
//	}
	
	public ArrayList<KhachHang> getMaTuTenKH(String tenKhachHang) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "Select maKhachHang from KhachHang where tenKhachHang LIKE '%" + tenKhachHang + "%'";
//			String sql = "Select maNV from NhanVien where hoTenNV LIKE N'%" + tenKhachHang +"%'";
//			Select maKH from KhachHang where hoTenKH LIKE N'%" + ten +"%'
//			String sql = "Select maKhachHang from KhachHang where tenKhachHang ";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenKhachHang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				KhachHang kh = new KhachHang(maKhachHang, "", "");
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}

	public ArrayList<NhanVien> getMaTuTenNV(String ten) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "Select maNhanVien from NhanVien where tenNhanVien LIKE N'%" + ten + "%'";
//			"select * from TacGia  where tenTacGia like '%" + name + "%'"
			stmt = con.prepareStatement(sql);
//			stmt.setString(1, ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("maNhanVien");
				NhanVien nv = new NhanVien(ma, "");
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}

}
