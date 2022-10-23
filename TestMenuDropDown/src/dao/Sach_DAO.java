package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.Sach;
import entity.TacGia;


public class Sach_DAO {
	public ArrayList<Sach> getAllSach() throws SQLException {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		String sql = "Select * from Sach";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maSach = rs.getString(1);
					String maNXB = rs.getString(2);
					String maTacGia = rs.getString(3);
					String tenSach = rs.getString(4);
					float donGia = rs.getFloat(5);
					String tenLoaiSach = rs.getString(6);
					int soLuong=rs.getInt(7);
					int soLuongDaBan=rs.getInt(8);
					Sach kh = new Sach(maSach,maNXB,maTacGia,tenSach,donGia,tenLoaiSach,soLuong,soLuongDaBan);
					dsSach.add(kh);
				}
			}

			return dsSach;

		}
	}
	
	public List<TacGia> timTacGia(String name,String donGia,String tenTacGia,String tenNXB )
	{
		ResultSet rs = null ;
		java.sql.Statement sttm = null;
		List<TacGia> ls = new ArrayList<>();
		try {
			String sql = "select * from TacGia  where tenTacGia like '%" + name + "%'";
//			if()
		
			Connection con = ConnectDB.getConnection();
			sttm =con.createStatement();
			rs = sttm.executeQuery(sql);
			while(rs.next())
			{
//				String maTacGia = rs.getString(1);
//				String tenTacGia = rs.getString(2);
//				
//				TacGia x = new TacGia(maTacGia,tenTacGia);
//				ls.add(x);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls ;
	}
	
	public boolean deleteSach (String maSach) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Sach where maSach=?");
			stmt.setString(1, maSach);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	public boolean updateSach (Sach sach ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update Sach set maNhaXuatBan=?,maTacGia=?,tenSach=?,donGia=?,tenLoaiSach=?,soLuong=? where maSach=?");
			
			stmt.setString(1,sach.getNhaXB());
			stmt.setString(2, sach.getTacGia());
			stmt.setString(3, sach.getTenSach());
			stmt.setDouble(4, sach.getDonGia());
			stmt.setString(5, sach.getTenLoaiSach());
            stmt.setInt(6, sach.getSoLuong());
			stmt.setString(7, sach.getMaSach());
			
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return n > 0;
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
		
		String sql="select MAX(maSach) from Sach";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				System.out.println(rs.getString(1));
				if(rs.getString(1)==null) {
					return "SA001";
				}				
				else {					
					long id=Long.parseLong(rs.getString(1).substring(2,rs.getString(1).trim().length()));
					id++; 
					return "S"+ String.format("%03d", id);					
				}															
			}		
		}
		
	}

	public boolean addSach(Sach sach) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " Sach values(?,?,?,?,?,?,?,?)");
			stmt.setString(1,sach.getMaSach() );
			stmt.setString(2, sach.getNhaXB());
			stmt.setString(3, sach.getTacGia());
			stmt.setString(4, sach.getTenSach());
			stmt.setDouble(5, sach.getDonGia());
			stmt.setString(6, sach.getTenLoaiSach());
			stmt.setInt(7, sach.getSoLuong());
			stmt.setInt(8, sach.getSoLuongDaBan());
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
