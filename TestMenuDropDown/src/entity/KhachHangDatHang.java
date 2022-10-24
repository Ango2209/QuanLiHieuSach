package entity;

import java.time.LocalDate;

public class KhachHangDatHang {
	
    private String maPhieu;
    private String maKhachHang;
    private String maSach;
    private String tenSach;
    private String donGia;
    private String tenLoaiSach;
    private int soLuong;
    private String tenTacGia;
    private String tenNXB;
    private LocalDate ngayLap;
    private double tongTien;
    private String maCTPMH;
    
	@Override
	public String toString() {
		return "KhachHangDatHang [maPhieu=" + maPhieu + ", maKhachHang=" + maKhachHang + ", maSach=" + maSach
				+ ", tenSach=" + tenSach + ", donGia=" + donGia + ", tenLoaiSach=" + tenLoaiSach + ", soLuong="
				+ soLuong + ", tenTacGia=" + tenTacGia + ", tenNXB=" + tenNXB + ", ngayLap=" + ngayLap + ", tongTien="
				+ tongTien + "]";
	}

	public KhachHangDatHang(String maPhieu, String maKhachHang, String maSach, String tenSach, String donGia,
			String tenLoaiSach, int soLuong, String tenTacGia, String tenNXB, LocalDate ngayLap, double tongTien,
			String maCTPMH) {
		super();
		this.maPhieu = maPhieu;
		this.maKhachHang = maKhachHang;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.tenLoaiSach = tenLoaiSach;
		this.soLuong = soLuong;
		this.tenTacGia = tenTacGia;
		this.tenNXB = tenNXB;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.maCTPMH = maCTPMH;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

	public String getTenLoaiSach() {
		return tenLoaiSach;
	}

	public void setTenLoaiSach(String tenLoaiSach) {
		this.tenLoaiSach = tenLoaiSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getMaCTPMH() {
		return maCTPMH;
	}

	public void setMaCTPMH(String maCTPMH) {
		this.maCTPMH = maCTPMH;
	}
	
   
}
