package entity;

import java.time.LocalDate;

public class PhieuMuaHang {
 private String maCTPhieuMh;
 private String maKhachHang;
 private String maNhanVien;
 private LocalDate ngayLapPhieu;
 
public PhieuMuaHang() {
	super();
	// TODO Auto-generated constructor stub
}
public PhieuMuaHang(String maCTPhieuMh, String maKhachHang, String maNhanVien, LocalDate ngayLapPhieu) {
	super();
	this.maCTPhieuMh = maCTPhieuMh;
	this.maKhachHang = maKhachHang;
	this.maNhanVien = maNhanVien;
	this.ngayLapPhieu = ngayLapPhieu;
}
@Override
public String toString() {
	return "PhieuMuaHang [ctPhieuMh=" + maCTPhieuMh + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
			+ ", ngayLapPhieu=" + ngayLapPhieu + "]";
}
public String getCtPhieuMh() {
	return maCTPhieuMh;
}
public void setCtPhieuMh(String ctPhieuMh) {
	this.maCTPhieuMh = ctPhieuMh;
}
public String getMaKhachHang() {
	return maKhachHang;
}
public void setMaKhachHang(String maKhachHang) {
	this.maKhachHang = maKhachHang;
}
public String getMaNhanVien() {
	return maNhanVien;
}
public void setMaNhanVien(String maNhanVien) {
	this.maNhanVien = maNhanVien;
}
public LocalDate getNgayLapPhieu() {
	return ngayLapPhieu;
}
public void setNgayLapPhieu(LocalDate ngayLapPhieu) {
	this.ngayLapPhieu = ngayLapPhieu;
}
 
}
