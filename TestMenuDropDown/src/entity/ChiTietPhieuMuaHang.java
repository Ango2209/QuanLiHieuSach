package entity;

public class ChiTietPhieuMuaHang {
  private PhieuMuaHang phieuMuaHang;
  private String maSach;
  private int soLuong;
  private float tongTien;
  
public ChiTietPhieuMuaHang() {
	super();
	// TODO Auto-generated constructor stub
}
public ChiTietPhieuMuaHang(PhieuMuaHang phieuMuaHang, String maSach, int soLuong, float tongTien) {
	super();
	this.phieuMuaHang = phieuMuaHang;
	this.maSach = maSach;
	this.soLuong = soLuong;
	this.tongTien = tongTien;
}
@Override
public String toString() {
	return "ChiTietPhieuMuaHang [phieuMuaHang=" + phieuMuaHang + ", sach=" + maSach + ", soLuong=" + soLuong
			+ ", tongTien=" + tongTien + "]";
}
public PhieuMuaHang getPhieuMuaHang() {
	return phieuMuaHang;
}
public void setPhieuMuaHang(PhieuMuaHang phieuMuaHang) {
	this.phieuMuaHang = phieuMuaHang;
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
public float getTongTien() {
	return tongTien;
}
public void setTongTien(float tongTien) {
	this.tongTien = tongTien;
}
  
}
