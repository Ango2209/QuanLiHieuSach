package entity;

public class TaiKhoan {
private String maTaiKhoan;
private String loaiTaiKhoan;
private String tenTaiKhoan;
private String matKhau;
private String email;
public TaiKhoan() {
	super();
	// TODO Auto-generated constructor stub
}
public TaiKhoan(String maTaiKhoan, String loaiTaiKhoan, String tenTaiKhoan, String matKhau, String email) {
	super();
	this.maTaiKhoan = maTaiKhoan;
	this.loaiTaiKhoan = loaiTaiKhoan;
	this.tenTaiKhoan = tenTaiKhoan;
	this.matKhau = matKhau;
	this.email = email;
}
@Override
public String toString() {
	return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", loaiTaiKhoan=" + loaiTaiKhoan + ", tenTaiKhoan=" + tenTaiKhoan
			+ ", matKhau=" + matKhau + ", email=" + email + "]";
}
public String getMaTaiKhoan() {
	return maTaiKhoan;
}
public void setMaTaiKhoan(String maTaiKhoan) {
	this.maTaiKhoan = maTaiKhoan;
}
public String getLoaiTaiKhoan() {
	return loaiTaiKhoan;
}
public void setLoaiTaiKhoan(String loaiTaiKhoan) {
	this.loaiTaiKhoan = loaiTaiKhoan;
}
public String getTenTaiKhoan() {
	return tenTaiKhoan;
}
public void setTenTaiKhoan(String tenTaiKhoan) {
	this.tenTaiKhoan = tenTaiKhoan;
}
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
