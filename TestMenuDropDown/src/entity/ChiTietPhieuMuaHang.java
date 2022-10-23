package entity;

public class ChiTietPhieuMuaHang {
  private String maPhieuMuaHang;
  private String maSach;
  private int soLuong;
  private double tongTien;
  
public ChiTietPhieuMuaHang() {
	super();
	// TODO Auto-generated constructor stub
}
public ChiTietPhieuMuaHang(String maphieuMuaHang, String maSach, int soLuong, double tongTien) {
	super();
	this.maPhieuMuaHang = maPhieuMuaHang;
	this.maSach = maSach;
	this.soLuong = soLuong;
	this.tongTien = tongTien;
}
@Override
public String toString() {
	return "ChiTietPhieuMuaHang [phieuMuaHang=" + maPhieuMuaHang + ", sach=" + maSach + ", soLuong=" + soLuong
			+ ", tongTien=" + tongTien + "]";
}
public String getMaPhieuMuaHang() {
	return maPhieuMuaHang;
}

public void setMaPhieuMuaHang(String maPhieuMuaHang) {
	this.maPhieuMuaHang = maPhieuMuaHang;
}
public String getMaSach() {
	return maSach;
}
public void setMaSach(String maSach) {
	this.maSach = maSach;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public double getTongTien() {
	return tongTien;
}
public void setTongTien(double tongTien) {
	this.tongTien = tongTien;
}
  
}
