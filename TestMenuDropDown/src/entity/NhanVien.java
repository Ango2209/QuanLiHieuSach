package entity;

import java.time.LocalDate;

public class NhanVien {
  private String maNhanVien;
  private String tenNhanVien;
  private LocalDate ngaySinh;
  private String gioiTinh;
  private String diaChi;
  private int sdtNhanVien;
  private String email;
  private String tenTaiKhoan;
public NhanVien() {
	super();
	// TODO Auto-generated constructor stub
}
public NhanVien(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, String gioiTinh, String diaChi,
		int sdtNhanVien, String email, String tenTaiKhoan) {
	super();
	this.maNhanVien = maNhanVien;
	this.tenNhanVien = tenNhanVien;
	this.ngaySinh = ngaySinh;
	this.gioiTinh = gioiTinh;
	this.diaChi = diaChi;
	this.sdtNhanVien = sdtNhanVien;
	this.email = email;
	this.tenTaiKhoan = tenTaiKhoan;
}
public String getMaNhanVien() {
	return maNhanVien;
}
public void setMaNhanVien(String maNhanVien) {
	this.maNhanVien = maNhanVien;
}
public String getTenNhanVien() {
	return tenNhanVien;
}
public void setTenNhanVien(String tenNhanVien) {
	this.tenNhanVien = tenNhanVien;
}
public LocalDate getNgaySinh() {
	return ngaySinh;
}
public void setNgaySinh(LocalDate ngaySinh) {
	this.ngaySinh = ngaySinh;
}
public String getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public int getSdtNhanVien() {
	return sdtNhanVien;
}
public void setSdtNhanVien(int sdtNhanVien) {
	this.sdtNhanVien = sdtNhanVien;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTenTaiKhoan() {
	return tenTaiKhoan;
}
public void setTenTaiKhoan(String tenTaiKhoan) {
	this.tenTaiKhoan = tenTaiKhoan;
}
public NhanVien(String tenNhanVien) {
	super();
	this.tenNhanVien = tenNhanVien;
}
public NhanVien(String maNhanVien, String tenNhanVien) {
	super();
	this.maNhanVien = maNhanVien;
	this.tenNhanVien = tenNhanVien;
}

  
}
