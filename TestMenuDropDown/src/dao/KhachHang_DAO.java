package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.Sach;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKH() throws SQLException {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		String sql = "Select * from KhachHang";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maKH = rs.getString(1);
					String tenKhachHang = rs.getString(2);
					String sdtKH = rs.getString(3);
					String email = rs.getString(4);
					String gioiTinh = rs.getString(5);
				    String tenTaiKhoan=rs.getString(6);
					KhachHang kh = new KhachHang(maKH,tenKhachHang,sdtKH,email,gioiTinh,tenTaiKhoan);

					dsKH.add(kh);
				}
			}

			return dsKH;

		}
	}
	public boolean deleteKhachHang (String maKH) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKhachHang=?");
			stmt.setString(1, maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	
	public boolean addKhachHang(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " KhachHang values(?,?,?,?,?)");
			stmt.setString(1,kh.getMaKhachHang() );
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.getSdtKhachHang());
			stmt.setString(4, kh.getEmail());
			stmt.setString(5, kh.getGioiTinh());
			stmt.setString(6, kh.getTenTaiKhoan());
			n= stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public ArrayList<KhachHang> getMaTuTenKH(String tenKhachHang) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "Select maKhachHang from KhachHang where tenKhachHang LIKE N'%" + tenKhachHang + "%'";
//			String sql = "Select maNV from NhanVien where hoTenNV LIKE N'%" + tenKhachHang +"%'";
//			Select maKH from KhachHang where hoTenKH LIKE N'%" + ten +"%'
//			String sql = "Select maKhachHang from KhachHang where tenKhachHang ";
			
			stmt = con.prepareStatement(sql);
//			stmt.setString(1, tenKhachHang);
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
}
