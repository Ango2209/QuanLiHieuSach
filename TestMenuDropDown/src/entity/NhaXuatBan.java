package entity;

public class NhaXuatBan {
   private String maNhaXuatBan;
   private String tenNXB;
   private String diaChi;
   
public NhaXuatBan() {
	super();
	// TODO Auto-generated constructor stub
}
public NhaXuatBan(String maNhaXuatBan, String tenNXB, String diaChi) {
	super();
	this.maNhaXuatBan = maNhaXuatBan;
	this.tenNXB = tenNXB;
	this.diaChi = diaChi;
}
@Override
public String toString() {
	return "NhaXuatBan [maNhaXuatBan=" + maNhaXuatBan + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + "]";
}
public String getMaNhaXuatBan() {
	return maNhaXuatBan;
}
public void setMaNhaXuatBan(String maNhaXuatBan) {
	this.maNhaXuatBan = maNhaXuatBan;
}
public String getTenNXB() {
	return tenNXB;
}
public void setTenNXB(String tenNXB) {
	this.tenNXB = tenNXB;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
   
}
