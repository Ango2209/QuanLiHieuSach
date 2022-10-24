package entity;

import java.time.LocalDate;

public class PhieuMuaHang {
 private String maPhieuMh;
 private String maKhachHang;
 private LocalDate ngayLapPhieu;
 private boolean datHang;
 
public PhieuMuaHang() {
	super();
	// TODO Auto-generated constructor stub
}

public String getMaPhieuMh() {
	return maPhieuMh;
}

public void setMaPhieuMh(String maPhieuMh) {
	this.maPhieuMh = maPhieuMh;
}

public String getMaKhachHang() {
	return maKhachHang;
}

public void setMaKhachHang(String maKhachHang) {
	this.maKhachHang = maKhachHang;
}

public LocalDate getNgayLapPhieu() {
	return ngayLapPhieu;
}

public void setNgayLapPhieu(LocalDate ngayLapPhieu) {
	this.ngayLapPhieu = ngayLapPhieu;
}

public boolean isDatHang() {
	return datHang;
}

public void setDatHang(boolean datHang) {
	this.datHang = datHang;
}

@Override
public String toString() {
	return "PhieuMuaHang [maPhieuMh=" + maPhieuMh + ", maKhachHang=" + maKhachHang + ", ngayLapPhieu=" + ngayLapPhieu
			+ ", datHang=" + datHang + "]";
}

public PhieuMuaHang(String maPhieuMh, String maKhachHang, LocalDate ngayLapPhieu, boolean datHang) {
	super();
	this.maPhieuMh = maPhieuMh;
	this.maKhachHang = maKhachHang;
	this.ngayLapPhieu = ngayLapPhieu;
	this.datHang = datHang;
} 

 
}
