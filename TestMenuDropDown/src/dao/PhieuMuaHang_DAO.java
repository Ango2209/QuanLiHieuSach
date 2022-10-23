package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietPhieuMuaHang;
import entity.PhieuMuaHang;

public class PhieuMuaHang_DAO {
	public ArrayList<PhieuMuaHang> getAllPMH() throws SQLException {
		ArrayList<PhieuMuaHang> dsPhieuMH = new ArrayList<PhieuMuaHang>();
		String sql = "Select * from PhieuMuaHang";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maPhieu = rs.getString(1);
					String maKhachHang = rs.getString(2);
					String maNhanVien = rs.getString(3);
					String ngayLapPhieu=rs.getString(4);
					
					PhieuMuaHang pmh=new PhieuMuaHang(maPhieu, maKhachHang, maNhanVien,LocalDate.parse(ngayLapPhieu,DateTimeFormatter.ISO_LOCAL_DATE));
					dsPhieuMH.add(pmh);
				}
			}

			return dsPhieuMH;

		}
	}
	
//public String getMaPhieuMuaHangHienTai(String maKH) throws SQLException {
//	
//		String sql="select maPhieu from PhieuMuaHang where maKhachHang="+"'"+maKH"'";
//		try (Connection conn = ConnectDB.getConnection()) {
//			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
//				rs.next();
//				rs.getString(1);
//				System.out.println(rs.getString(1));
//				if(rs.getString(1)==null) {
//					return "PH001";
//				}				
//				
//				else {					
//					long id=Long.parseLong(rs.getString(1).substring(2,rs.getString(1).trim().length()));
//					id++; 
//					return "PM"+ String.format("%03d", id);					
//				}															
//			}		
//		}
//}
	
	public boolean deletePhieuMuaHang (String maPMH) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from PhieuMuaHang where maPhieu=?");
			stmt.setString(1, maPMH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	
	
	private void close(PreparedStatement stmt) {
				if(stmt!=null)
				try {
					stmt.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
public String getMaxID() throws SQLException {
		
		String sql="select MAX(maPhieu) from PhieuMuaHang";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				System.out.println(rs.getString(1));
				if(rs.getString(1)==null) {
					return "PH001";
				}				
				
				else {					
					long id=Long.parseLong(rs.getString(1).substring(2,rs.getString(1).trim().length()));
					id++; 
					return "PM"+ String.format("%03d", id);					
				}															
			}		
		}
}

public boolean addPMH(PhieuMuaHang PMH) throws SQLException {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt = null;
	int n = 0;
	try {
		stmt = con.prepareStatement("insert into" + " PhieuMuaHang values(?,?,?,?)");
		stmt.setString(1,PMH.getCtPhieuMh());
		stmt.setString(2, PMH.getMaKhachHang());
		stmt.setString(3, PMH.getMaNhanVien());
		stmt.setString(4, PMH.getNgayLapPhieu().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
		
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
}
