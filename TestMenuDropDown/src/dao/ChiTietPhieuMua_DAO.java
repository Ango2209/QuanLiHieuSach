package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietPhieuMuaHang;
import entity.Sach;

public class ChiTietPhieuMua_DAO {
	public ArrayList<ChiTietPhieuMuaHang> getAllSach() throws SQLException {
		ArrayList<ChiTietPhieuMuaHang> dsCTPhieuMH = new ArrayList<ChiTietPhieuMuaHang>();
		String sql = "Select * from ChiTietPhieuMuaHang";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maCTPMH=rs.getString(1);
					String maPhieu = rs.getString(2);
					String maSach = rs.getString(3);
					int soLuong = rs.getInt(4);
					double soTien = rs.getDouble(5);
					
					ChiTietPhieuMuaHang ctpmh=new ChiTietPhieuMuaHang(maCTPMH,maPhieu,maSach,soLuong,soTien);
					dsCTPhieuMH.add(ctpmh);
				}
			}

			return dsCTPhieuMH;

		}
	}
	
	
	
	public boolean deleteChiTietPhieuMuaHang (String maCTPMH) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietPhieuMuaHang where maChiTietPhieuMua=?");
			stmt.setString(1, maCTPMH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	

	
	
public String getMaxID() throws SQLException {
		
		String sql="select MAX(maChiTietPhieuMua) from ChiTietPhieuMuaHang";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				System.out.println(rs.getString(1));
				if(rs.getString(1)==null) {
					return "CTPM001";
				}				
				else {					
					long id=Long.parseLong(rs.getString(1).substring(4,rs.getString(1).trim().length()));
					id++; 
					return "CTPM"+ String.format("%03d", id);					
				}															
			}		
		}
		
	}


	public boolean addCTPMH(ChiTietPhieuMuaHang ctPMH) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " ChiTietPhieuMuaHang values(?,?,?,?,?)");
			stmt.setString(1, ctPMH.getMaCTPMH());
			stmt.setString(2,ctPMH.getMaPhieuMuaHang());
			stmt.setString(3, ctPMH.getMaSach());
			stmt.setInt(4, ctPMH.getSoLuong());
			stmt.setDouble(5, ctPMH.getTongTien());
			
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
	private void close(PreparedStatement stmt) {
		if(stmt!=null)
		try {
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
