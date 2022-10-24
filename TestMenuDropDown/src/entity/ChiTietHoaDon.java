package entity;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
  private Sach sach;
//	ArrayList<Sach> sachs;
	private int soLuong;
	private float donGia;
	private double tongDonGia;
//	public ArrayList<Sach> sachs;
//
//	public ArrayList<Sach> getSachs() {
//		return sachs;
//	}
//
//	public void setSachs(ArrayList<Sach> sachs) {
//		this.sachs = sachs;
//	}

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public double getTongDonGia() {
		return tongDonGia;
	}

	public void setTongDonGia(double tongDonGia) {
		this.tongDonGia = tongDonGia;
	}

	public ChiTietHoaDon(double tongDonGia) {
		super();
		this.tongDonGia = tongDonGia;
	}


//
//	public ChiTietHoaDon(HoaDon hoaDon, ArrayList<Sach> sachs, int soLuong, float donGia, double tongDonGia) {
//		super();
//		this.hoaDon = hoaDon;
//		this.sachs = sachs;
//		this.soLuong = soLuong;
//		this.donGia = donGia;
//		this.tongDonGia = tongDonGia;
//	}
//
//	public ChiTietHoaDon(ArrayList<Sach> sachs, int soLuong, double tongDonGia) {
//		super();
//		this.sachs = sachs;
//		this.soLuong = soLuong;
//		this.tongDonGia = tongDonGia;
//	}

//	@Override
//	public String toString() {
//		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sachs=" + sachs + ", soLuong=" + soLuong + ", donGia=" + donGia
//				+ ", tongDonGia=" + tongDonGia + "]";
//	}
	
	
	

	public ChiTietHoaDon(HoaDon hoaDon, Sach sach, int soLuong, float donGia, double tongDonGia) {
		super();
		this.hoaDon = hoaDon;
		this.sach = sach;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tongDonGia = tongDonGia;
	}
//	public ChiTietHoaDon(HoaDon hoaDon, int soLuong, float donGia, double tongDonGia, ArrayList<Sach> sachs) {
//	super();
//	this.hoaDon = hoaDon;
//	this.soLuong = soLuong;
//	this.donGia = donGia;
//	this.tongDonGia = tongDonGia;
//	this.sachs = sachs;
//}

	public ChiTietHoaDon(Sach sach, int soLuong, double tongDonGia) {
		super();
		this.sach = sach;
		this.soLuong = soLuong;
		this.tongDonGia = tongDonGia;
	}

	public ChiTietHoaDon(HoaDon hoaDon, Sach sach, int soLuong, double tongDonGia) {
		super();
		this.hoaDon = hoaDon;
		this.sach = sach;
		this.soLuong = soLuong;
		this.tongDonGia = tongDonGia;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sach=" + sach + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ ", tongDonGia=" + tongDonGia + "]";
	}
}
