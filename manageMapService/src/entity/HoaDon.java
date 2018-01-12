package entity;

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
	
	
	
}
