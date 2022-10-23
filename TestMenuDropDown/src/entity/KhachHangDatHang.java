package entity;

import java.time.LocalDate;

public class KhachHangDatHang {
    private String maKhachHang;
    private String maNhanVien;
    private String maSach;
    private String tenSach;
    private String donGia;
    private String tenTacGia;
    private String tenNXB;
    private String loaiSach;
    private int soLuong;
    private LocalDate ngayLap;
    private double tongTien;
	public KhachHangDatHang(String maKhachHang, String maNhanVien, String maSach, String tenSach, String donGia,
			String tenTacGia, String tenNXB, String loaiSach, int soLuong, LocalDate ngayLap, double tongTien) {
		super();
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.tenTacGia = tenTacGia;
		this.tenNXB = tenNXB;
		this.loaiSach = loaiSach;
		this.soLuong = soLuong;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
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
	public String getLoaiSach() {
		return loaiSach;
	}
	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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
	public KhachHangDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KhachHangDatHang [maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien + ", maSach=" + maSach
				+ ", tenSach=" + tenSach + ", donGia=" + donGia + ", tenTacGia=" + tenTacGia + ", tenNXB=" + tenNXB
				+ ", loaiSach=" + loaiSach + ", soLuong=" + soLuong + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien
				+ "]";
	}
   
}
