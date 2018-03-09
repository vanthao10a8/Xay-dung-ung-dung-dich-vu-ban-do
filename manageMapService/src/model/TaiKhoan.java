package model;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin tai khoan khach hang
 */

public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private boolean trangThaiDangNhap;
	private String quyenHan;
	
	/**
	 * Constructor
	 * @param tenDangNhap
	 * @param matKhau
	 * @param trangThaiDangNhap
	 */
	public TaiKhoan(String tenDangNhap, String matKhau, boolean trangThaiDangNhap,String QuyenHan) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThaiDangNhap = trangThaiDangNhap;
		this.quyenHan = QuyenHan;
	}
	
	/**
	 * Lay ten dang nhap cua user
	 * @return
	 */
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	/**
	 * Dat ten dang nhan cho user
	 * @param tenDangNhap
	 */
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	/**
	 * Lay mat khau cua user
	 * @return
	 */
	public String getMatKhau() {
		return matKhau;
	}
	/**
	 * Dat mat khau cho user
	 * @param matKhau
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * kiem tra tinh trang dang nhap cua user
	 * @return {boolean} trangThaiDangNhap
	 */
	public boolean isTrangThaiDangNhap() {
		return trangThaiDangNhap;
	}
	/**
	 * Dat tinh trang dang nhap cho user
	 * @param {boolean} trangThaiDangNhap
	 */
	public void setTrangThaiDangNhap(boolean trangThaiDangNhap) {
		this.trangThaiDangNhap = trangThaiDangNhap;
	}

	public String getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}
	
	
	
}
