package entity;

public class Sach {
	private String maSach;
	private String maNhaXB;
	private String maTacGia;
	private String tenSach;
	private double donGia;
	private String tenLoaiSach;
	private int soLuong;
	private int soLuongDaBan;

	private NhaXuatBan nhaXuatBan;
	private TacGia tacGia;


	public Sach(String maSach, String tenSach, double donGia, String tenLoaiSach, int soLuong, NhaXuatBan nhaXuatBan,
			TacGia tacGia) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.tenLoaiSach = tenLoaiSach;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
		this.tacGia = tacGia;
	}

	public Sach(String maSach, String maNhaXB, String maTacGia, String tenSach, double donGia, String tenLoaiSach,
			int soLuong, int soLuongDaBan) {
		super();
		this.maSach = maSach;
		this.maNhaXB = maNhaXB;
		this.maTacGia = maTacGia;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.tenLoaiSach = tenLoaiSach;
		this.soLuong = soLuong;
		this.soLuongDaBan = soLuongDaBan;
	}

	public Sach(String tenSach, double donGia) {
		super();
		this.tenSach = tenSach;
		this.donGia = donGia;
	}

	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}

	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", nhaXB=" + maNhaXB + ", tacGia=" + maTacGia + ", tenSach=" + tenSach
				+ ", donGia=" + donGia + ", tenLoaiSach=" + tenLoaiSach + ", soLuong=" + soLuong + "]";
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

	public TacGia getTacGia() {
		return tacGia;
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

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
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

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public Sach(String tenSach, double donGia, String tenLoaiSach, int soLuong, NhaXuatBan nhaXuatBan, TacGia tacGia) {
		super();
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.tenLoaiSach = tenLoaiSach;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
		this.tacGia = tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public String getMaNhaXB() {
		return maNhaXB;
	}

	public void setMaNhaXB(String maNhaXB) {
		this.maNhaXB = maNhaXB;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

}
