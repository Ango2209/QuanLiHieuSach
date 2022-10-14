package entity;

public class KhachHang {
 private String maKhachHang;
 private String tenKhachHang;
 private int sdtKhachHang;
 private String email;
 private String gioiTinh;
public KhachHang() {
	super();
	// TODO Auto-generated constructor stub
}
public KhachHang(String maKhachHang, String tenKhachHang, int sdtKhachHang, String email, String gioiTinh) {
	super();
	this.maKhachHang = maKhachHang;
	this.tenKhachHang = tenKhachHang;
	this.sdtKhachHang = sdtKhachHang;
	this.email = email;
	this.gioiTinh = gioiTinh;
}
@Override
public String toString() {
	return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", sdtKhachHang=" + sdtKhachHang
			+ ", email=" + email + ", gioiTinh=" + gioiTinh + "]";
}
public String getMaKhachHang() {
	return maKhachHang;
}
public void setMaKhachHang(String maKhachHang) {
	this.maKhachHang = maKhachHang;
}
public String getTenKhachHang() {
	return tenKhachHang;
}
public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}
public int getSdtKhachHang() {
	return sdtKhachHang;
}
public void setSdtKhachHang(int sdtKhachHang) {
	this.sdtKhachHang = sdtKhachHang;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}
}
