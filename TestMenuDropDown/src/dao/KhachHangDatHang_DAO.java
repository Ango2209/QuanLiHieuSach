package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.KhachHangDatHang;


public class KhachHangDatHang_DAO {
	public ArrayList<KhachHangDatHang> getAllDatHang(String maPhieuMH) throws SQLException {
		ArrayList<KhachHangDatHang> dskhdt = new ArrayList<KhachHangDatHang>();
		String sql = "select pmh.maPhieu, kh.maKhachHang,s.maSach,s.tenSach,ctpmh.tongTien,s.tenLoaiSach,ctpmh.soLuong,tg.tenTacGia,nxb.tenNhaXuatBan,pmh.ngayLapPhieu,ctpmh.tongTien,ctpmh.maChiTietPhieuMua from KhachHang kh \r\n"
				+ "inner join PhieuMuaHang pmh on kh.maKhachHang = pmh.maKhachHang \r\n"
				+ "inner join ChiTietPhieuMuaHang ctpmh on pmh.maPhieu= ctpmh.maPhieu \r\n"
				+ "inner join Sach s on s.maSach=ctpmh.maSach\r\n"
				+ "inner join TacGia tg on tg.maTacGia=s.maTacGia\r\n"
				+ "inner join NhaXuatBan nxb on nxb.maNhaXuatBan=s.maNhaXuatBan\r\n"
				+ "where ctpmh.maPhieu="+"'"+maPhieuMH+"'";
				
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maPhieu=rs.getString(1);
				    String maKhachHang=rs.getString(2);
				     String maSach=rs.getString(3);
				    String tenSach=rs.getString(4);
				     String donGia=rs.getString(5);
				    String tenLoaiSach=rs.getString(6);
				    int soLuong=rs.getInt(7);
				    String tenTacGia=rs.getString(8);
				    String tenNXB=rs.getString(9);
				    LocalDate ngayLapPhieu;
			         if(rs.getDate(10)==null) {
			        	 ngayLapPhieu=null;
			         }
			         else {
			        	 ngayLapPhieu=rs.getDate(10).toLocalDate();
			         }
				    double tongTien=rs.getDouble(11);
				    String maCTPMH=rs.getString(12);
				    KhachHangDatHang khdh=new KhachHangDatHang(maPhieu, maKhachHang, maSach, tenSach, donGia, tenLoaiSach, soLuong, tenTacGia, tenNXB, ngayLapPhieu, tongTien,maCTPMH);
				    dskhdt.add(khdh);
				}
			}

			return dskhdt;
		}
	}
	
}
