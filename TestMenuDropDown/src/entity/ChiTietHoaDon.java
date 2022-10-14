package entity;

public class ChiTietHoaDon {
  private HoaDon hoaDon;
  private String maSach;
  private int soLuong;
  private float donGia;
  private float tongDonGia;
  
public ChiTietHoaDon() {
	super();
	// TODO Auto-generated constructor stub
}
public ChiTietHoaDon(HoaDon hoaDon, String maSach, int soLuong, float donGia, float tongDonGia) {
	super();
	this.hoaDon = hoaDon;
	this.maSach = maSach;
	this.soLuong = soLuong;
	this.donGia = donGia;
	this.tongDonGia = tongDonGia;
}
@Override
public String toString() {
	return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sach=" + maSach + ", soLuong=" + soLuong + ", donGia=" + donGia
			+ ", tongDonGia=" + tongDonGia + "]";
}
public HoaDon getHoaDon() {
	return hoaDon;
}
public void setHoaDon(HoaDon hoaDon) {
	this.hoaDon = hoaDon;
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
public float getDonGia() {
	return donGia;
}
public void setDonGia(float donGia) {
	this.donGia = donGia;
}
public float getTongDonGia() {
	return tongDonGia;
}
public void setTongDonGia(float tongDonGia) {
	this.tongDonGia = tongDonGia;
}
  
}
