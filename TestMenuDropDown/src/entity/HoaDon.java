package entity;

import java.sql.Date;
import java.time.LocalDate;

public class HoaDon {
	private String maHoaDon;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private LocalDate ngayLapHoaDon;
    private ChiTietHoaDon ctHoaDon;
    
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon getCtHoaDon() {
		return ctHoaDon;
	}
	public void setCtHoaDon(ChiTietHoaDon ctHoaDon) {
		this.ctHoaDon = ctHoaDon;
	}


	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}


	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}


	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, LocalDate ngayLapHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	
	
	
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ",  khachHang=" + khachHang.getTenKhachHang() +", khachHang ="+ khachHang.getSdtKhachHang() + ", nhanVien="
				+ nhanVien.getTenNhanVien() + ", ngayLapHoaDon=" + ngayLapHoaDon + "]";
	}

public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, LocalDate ngayLapHoaDon, ChiTietHoaDon ctHoaDon) {
	super();
	this.maHoaDon = maHoaDon;
	this.khachHang = khachHang;
	this.nhanVien = nhanVien;
	this.ngayLapHoaDon = ngayLapHoaDon;
	this.ctHoaDon = ctHoaDon;
}

public HoaDon(String maHoaDon) {
	super();
	this.maHoaDon = maHoaDon;
}


	
	





	
	
    
    
}
