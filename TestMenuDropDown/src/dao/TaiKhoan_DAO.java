package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public ArrayList<TaiKhoan> getDsTaiKhoan() {
		ArrayList<TaiKhoan> lsTaiKhoan  = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maTk = rs.getString(1);
				String loaiTK = rs.getString(2);
				String tenTK = rs.getString(3);
				String matKhau = rs.getString(4);
				String email = rs.getString(5);
				TaiKhoan tk = new TaiKhoan(maTk,loaiTK,tenTK, matKhau, email);
				
				lsTaiKhoan.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsTaiKhoan;
	}
	
	public boolean addTK(TaiKhoan tk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " TaiKhoan values(?,?,?,?,?)");
			stmt.setString(1, tk.getMaTaiKhoan());
			stmt.setString(2, tk.getLoaiTaiKhoan());
			stmt.setString(3, tk.getTenTaiKhoan());
			stmt.setString(4, tk.getMatKhau());
			stmt.setString(5, tk.getEmail());
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
	public boolean doiMK(String matkhaumoi , String email) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where email=?");
			stmt.setString(1, matkhaumoi);
			stmt.setString(2, email);
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
