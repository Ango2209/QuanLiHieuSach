package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNV() throws SQLException {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		String sql = "Select * from NhanVien";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maNV = rs.getString(1);
					String tenNV = rs.getString(2);
					String ngaySinh = rs.getString(3);
					String gioiTinh = rs.getString(4);
					String diaChi = rs.getString(5);
				    int soDTNV=rs.getInt(6);
				    String  email=rs.getString(7);
				    String tenTaiKhoan=rs.getString(8);
				     NhanVien nv=new NhanVien(maNV, tenNV,LocalDate.parse(ngaySinh,DateTimeFormatter.ISO_LOCAL_DATE), gioiTinh, diaChi, soDTNV, email,tenTaiKhoan);
					dsNV.add(nv);
				}
			}

			return dsNV;

		}
	}
//	public boolean deleteKhachHang (String maKH) throws SQLException
//	{
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("delete from KhachHang where maKhachHang=?");
//			stmt.setString(1, maKH);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			stmt.close();
//		}
//		return n>0;
//	}
//	
//	
//	public boolean addKhachHang(KhachHang kh) throws SQLException {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("insert into" + " KhachHang values(?,?,?,?,?)");
//			stmt.setString(1,kh.getMaKhachHang() );
//			stmt.setString(2, kh.getTenKhachHang());
//			stmt.setInt(3, kh.getSdtKhachHang());
//			stmt.setString(4, kh.getEmail());
//			stmt.setString(5, kh.getGioiTinh());
//			stmt.setString(6, kh.getTenTaiKhoan());
//			n= stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return n>0;
//	}
}
