package entity;

import java.time.LocalDate;

public class PhieuMuaHang {
 private String maPhieuMh;
 private String maKhachHang;
 private String maNhanVien;
 private LocalDate ngayLapPhieu;
 
public PhieuMuaHang() {
	super();
	// TODO Auto-generated constructor stub
} 
public PhieuMuaHang(String maPhieuMh, String maKhachHang, String maNhanVien, LocalDate ngayLapPhieu) {
	super();
	this.maPhieuMh = maPhieuMh;
	this.maKhachHang = maKhachHang;
	this.maNhanVien = maNhanVien;
	this.ngayLapPhieu = ngayLapPhieu;
}
@Override
public String toString() {
	return "PhieuMuaHang [ctPhieuMh=" + maPhieuMh + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
			+ ", ngayLapPhieu=" + ngayLapPhieu + "]";
}
public String getMaPhieuMh() {
	return maPhieuMh;
}
public void setMaPhieuMh(String ctPhieuMh) {
	this.maPhieuMh = maPhieuMh;
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
