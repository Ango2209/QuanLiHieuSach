package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaXuatBan;
import entity.Sach;

public class NhaXuatBan_DAO {
	public ArrayList<NhaXuatBan> getAllNXB() throws SQLException {
		ArrayList<NhaXuatBan> dsNXB = new ArrayList<NhaXuatBan>();
		String sql = "Select * from NhaXuatBan";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					
					String maNXB = rs.getString(1);
					String tenNXB = rs.getString(2);
					String diaChi = rs.getString(3);
					
					
					NhaXuatBan nxb = new NhaXuatBan(maNXB,tenNXB,diaChi);
					dsNXB.add(nxb);
				}
			}

			return dsNXB;

		}
	}

public String getMaxID() throws SQLException {
	
	String sql="select MAX(maNhaXuatBan) from NhaXuatBan";
	try (Connection conn = ConnectDB.getConnection()) {
		try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
			rs.next();
			rs.getString(1);
			System.out.println(rs.getString(1));
			if(rs.getString(1)==null) {
				return "XB001";
			}				
			else {					
				long id=Long.parseLong(rs.getString(1).substring(2,rs.getString(1).trim().length()));
				id++; 
				return "XB"+ String.format("%03d", id);					
			}															
		}		
	}
	
}
	public boolean deleteNXB (String maNhaXuatBan) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaXuatBan where maNhaXuatBan=?");
			stmt.setString(1, maNhaXuatBan);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	
	
	public boolean addNXB(NhaXuatBan nxb) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " NhaXuatBan values(?,?,?)");
			stmt.setString(1,nxb.getMaNhaXuatBan().trim() );
			stmt.setString(2, nxb.getTenNXB().trim());
			stmt.setString(3, nxb.getDiaChi().trim());
			
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
