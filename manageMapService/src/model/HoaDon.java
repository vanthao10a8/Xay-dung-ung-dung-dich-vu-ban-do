package model;

import java.util.List;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin hoa don mua ban
 */

public class HoaDon {
	/**
	 * Ma so cua hoa don
	 */
	private String maHoaDon;
	/**
	 * Khach hang mua hoa don nay
	 */
	private KhachHang khachHang;
	/**
	 * Danh sach do uong khach mua
	 */
	private List<DoUong> listDoUong;
	/**
	 * Nhan vien tao ra hoa don
	 */
	private NhanVien nhanVienBanHang;
	
	/**
	 * constructor
	 * @param maHoaDon
	 * @param khachHang
	 * @param listDoUong
	 * @param nhanVienBanHang
	 */
	public HoaDon(String maHoaDon, KhachHang khachHang, List<DoUong> listDoUong, NhanVien nhanVienBanHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.listDoUong = listDoUong;
		this.nhanVienBanHang = nhanVienBanHang;
	}
	
	/**
	 * default constructor
	 */
	public HoaDon() {
		
	}
	
	/**
	 * Lay ma hoa don
	 * @return {String} maHoaDon
	 */
	public String getMaHoaDon() {
		return maHoaDon;
	}
	/**
	 * Dat ma cho hoa don
	 * @param maHoaDon
	 */
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	/**
	 * Tra ve khach hang
	 * @return {KhachHang} khachHang
	 */
	public KhachHang getKhachHang() {
		return khachHang;
	}
	/**
	 * dat khach hang cho hoa don
	 * @param khachHang
	 */
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
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
	public NhanVien getNhanVienBanHang() {
		return nhanVienBanHang;
	}
	/**
	 * Dat nhan vien ban hang 
	 * @param {NhanVien} nhanVienBanHang
	 */
	public void setNhanVienBanHang(NhanVien nhanVienBanHang) {
		this.nhanVienBanHang = nhanVienBanHang;
	}
	
}
