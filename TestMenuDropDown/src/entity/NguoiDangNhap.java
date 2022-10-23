package entity;

public class NguoiDangNhap {
	private String tenTaiKhoan;
    public NguoiDangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguoiDangNhap(String tenTaiKhoan, String maNguoiDangNhap, String tenNguoiDangNhap) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.maNguoiDangNhap = maNguoiDangNhap;
		this.tenNguoiDangNhap = tenNguoiDangNhap;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMaNguoiDangNhap() {
		return maNguoiDangNhap;
	}
	public void setMaNguoiDangNhap(String maNguoiDangNhap) {
		this.maNguoiDangNhap = maNguoiDangNhap;
	}
	public String getTenNguoiDangNhap() {
		return tenNguoiDangNhap;
	}
	public void setTenNguoiDangNhap(String tenNguoiDangNhap) {
		this.tenNguoiDangNhap = tenNguoiDangNhap;
	}
	private String maNguoiDangNhap;
    private String tenNguoiDangNhap;
    
}
