package entity;

import java.time.LocalDate;

public class HoaDon {
    private ChiTietHoaDon ctHoaDon;
    private String maKhachHang;
    private NhanVien nhanVien;
    private LocalDate ngayLapHD;
    
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(ChiTietHoaDon ctHoaDon, String maKhachHang, NhanVien nhanVien, LocalDate ngayLapHD) {
		super();
		this.ctHoaDon = ctHoaDon;
		this.maKhachHang = maKhachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHD = ngayLapHD;
	}
	public ChiTietHoaDon getCtHoaDon() {
		return ctHoaDon;
	}
	public void setCtHoaDon(ChiTietHoaDon ctHoaDon) {
		this.ctHoaDon = ctHoaDon;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	@Override
	public String toString() {
		return "HoaDon [ctHoaDon=" + ctHoaDon + ", khachHang=" + maKhachHang + ", nhanVien=" + nhanVien + ", ngayLapHD="
				+ ngayLapHD + "]";
	}
    
    
}
