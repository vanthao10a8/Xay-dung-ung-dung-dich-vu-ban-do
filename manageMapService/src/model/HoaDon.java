package model;

import java.util.List;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin hoa don mua ban
 */

public class HoaDon {
	private String maHD;
	/**
	 * Khach hang mua hoa don nay
	 */
	private String maKH;
	/**
	 * Nhan vien tao ra hoa don
	 */
	private String maNV;
	/**
	 * Danh sach do uong khach mua
	 */
	private List<DoUong> listDoUong;
	/**
	 * constructor
	 * @param maKH
	 * @param maNV
	 * @param listDoUong
	 */
	public HoaDon(String maHD, String maKH, String maNV, List<DoUong> listDoUong) {
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.listDoUong = listDoUong;
	}
	/**
	 * default constructor
	 */
	public HoaDon() {}
	/**
	 * Tra ve ma khach hang
	 * @return {String} maKH
	 */
	public String getMaKH() {
		return maKH;
	}
	/**
	 * dat khach hang cho hoa don
	 * @param khachHang
	 */
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	/**
	 * lay danh sach do uong khach goi
	 * @return {List<DoUong>} listDoUong
	 */
	public List<DoUong> getListDoUong() {
		return listDoUong;
	}
	/**
	 * Dat danh sach do uong.
	 * @param {List<DoUong>} listDoUong
	 */
	public void setListDoUong(List<DoUong> listDoUong) {
		this.listDoUong = listDoUong;
	}
	/**
	 * Lay nhan vien ban hang
	 * @return {NhanVien} nhanVienBanHang
	 */
	public String getMaNV() {
		return maNV;
	}
	/**
	 * Dat nhan vien ban hang 
	 * @param {NhanVien} nhanVienBanHang
	 */
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	
}
