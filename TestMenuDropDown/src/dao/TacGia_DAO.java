package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.Sach;
import entity.TacGia;
import entity.tour;

public class TacGia_DAO {
	public ArrayList<TacGia> getAllTacGia() throws SQLException {
		ArrayList<TacGia> dsSach = new ArrayList<TacGia>();
		String sql = "Select * from TacGia";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				while (rs.next()) {
					String maTacGia = rs.getString(1);
					String tenTacGia = rs.getString(2);
					
					TacGia kh = new TacGia(maTacGia,tenTacGia);
					dsSach.add(kh);
				}
			}

			return dsSach;

		}
	}
	public List<TacGia> timTacGia(String name)
	{
		ResultSet rs = null ;
		java.sql.Statement sttm = null;
		List<TacGia> ls = new ArrayList<>();
		try {
			String sql = "select * from TacGia  where tenTacGia like '%" + name + "%'";
			Connection con = ConnectDB.getConnection();
			sttm =con.createStatement();
			rs = sttm.executeQuery(sql);
			while(rs.next())
			{
				String maTacGia = rs.getString(1);
				String tenTacGia = rs.getString(2);
				
				TacGia x = new TacGia(maTacGia,tenTacGia);
				ls.add(x);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls ;
	}
	
	public String getMaxID() throws SQLException {
		
		String sql="select MAX(maTacGia) from TacGia";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				System.out.println(rs.getString(1));
				if(rs.getString(1)==null) {
					return "TG001";
				}				
				else {					
					long id=Long.parseLong(rs.getString(1).substring(2,rs.getString(1).trim().length()));
					id++; 
					return "TG"+ String.format("%03d", id);					
				}															
			}		
		}
		
	}
	
	public boolean deleteTacGia (String maTacGia) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TacGia where maTacGia=?");
			stmt.setString(1, maTacGia);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	
	public boolean addTacGia(TacGia tacGia) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " TacGia values(?,?)");
			stmt.setString(1,tacGia.getMaTacGia() );
			stmt.setString(2,tacGia.getTenTacGia());
			
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
