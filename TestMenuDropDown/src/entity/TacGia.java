package entity;

public class TacGia {
 private String maTacGia;
 private String tenTacGia;
 
public TacGia() {
	super();
	// TODO Auto-generated constructor stub
}
public TacGia(String maTacGia, String tenTacGia) {
	super();
	this.maTacGia = maTacGia;
	this.tenTacGia = tenTacGia;
}
@Override
public String toString() {
	return "TacGia [maTacGia=" + maTacGia + ", tenTacGia=" + tenTacGia + "]";
}
public String getMaTacGia() {
	return maTacGia;
}
public void setMaTacGia(String maTacGia) {
	this.maTacGia = maTacGia;
}
public String getTenTacGia() {
	return tenTacGia;
}
public void setTenTacGia(String tenTacGia) {
	this.tenTacGia = tenTacGia;
}
}
