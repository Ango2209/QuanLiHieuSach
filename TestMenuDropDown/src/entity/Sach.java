package entity;

public class Sach {
  private String maSach;
  private String maNhaXB;
  private String maTacGia;
  private String tenSach;
  private float donGia;
  private String tenLoaiSach;
  private float soLuong;
  
  
public Sach() {
	super();
	// TODO Auto-generated constructor stub
}
public Sach(String maSach, String maNhaXB, String maTacGia, String tenSach, float donGia, String tenLoaiSach,
		float soLuong) {
	super();
	this.maSach = maSach;
	this.maNhaXB = maNhaXB;
	this.maTacGia = maTacGia;
	this.tenSach = tenSach;
	this.donGia = donGia;
	this.tenLoaiSach = tenLoaiSach;
	this.soLuong = soLuong;
}
@Override
public String toString() {
	return "Sach [maSach=" + maSach + ", nhaXB=" + maNhaXB + ", tacGia=" + maTacGia + ", tenSach=" + tenSach + ", donGia="
			+ donGia + ", tenLoaiSach=" + tenLoaiSach + ", soLuong=" + soLuong + "]";
}
public String getMaSach() {
	return maSach;
}
public void setMaSach(String maSach) {
	this.maSach = maSach;
}
public String getNhaXB() {
	return maNhaXB;
}
public void setNhaXB(String nhaXB) {
	this.maNhaXB = maNhaXB;
}
public String getTacGia() {
	return maTacGia;
}
public void setTacGia(String maTacGia) {
	this.maTacGia = maTacGia;
}
public String getTenSach() {
	return tenSach;
}
public void setTenSach(String tenSach) {
	this.tenSach = tenSach;
}
public float getDonGia() {
	return donGia;
}
public void setDonGia(float donGia) {
	this.donGia = donGia;
}
public String getTenLoaiSach() {
	return tenLoaiSach;
}
public void setTenLoaiSach(String tenLoaiSach) {
	this.tenLoaiSach = tenLoaiSach;
}
public float getSoLuong() {
	return soLuong;
}
public void setSoLuong(float soLuong) {
	this.soLuong = soLuong;
}
  
}
