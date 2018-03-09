package model;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin khach hang
 */

public class KhachHang {
	/**
	 * Ma so cua khach hang
	 */
	private String maKH;
	
	private String hoTenKhach;
	private String soDienThoai;
	
	

	/**
	 * Dia chi cua khach hang
	 */
	private String diaChiKH;
	/**
	 * Email cua khach hang
	 */
	private String emailKH;
	/**
	 * Thong tin tai khoan khach
	 */
	private String tkKhach;
	
	/**
	 * Default constructor
	 */
	public KhachHang() {}
	
	/**
	 * Constructor
	 * @param maKH
	 * @param diaChiKH
	 * @param emailKH
	 * @param tkKhach
	 */
	public KhachHang(String maKH, String hoTenKhach, String soDienThoai, String diaChiKH, String emailKH, String tkKhach1) {
		this.maKH = maKH;
		this.diaChiKH = diaChiKH;
		this.emailKH = emailKH;
		this.tkKhach = tkKhach1;
		this.hoTenKhach = hoTenKhach;
		this.soDienThoai = soDienThoai;
	}
	
	/**
	 * Lay khach hang
	 * @return {String} maKH
	 */
	public String getMaKH() {
		return maKH;
	}
	/**
	 * Dat ma khach hang
	 * @param {String} maKH
	 */
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	/**
	 * Lay dia chi khach hang
	 * @return {String} diaChiKH
	 */
	public String getDiaChiKH() {
		return diaChiKH;
	}
	/**
	 * Dat dia chi khach hang
	 * @param {String} diaChiKH
	 */
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	/**
	 * Lay email khach hang
	 * @return {String} emailKH
	 */
	public String getEmailKH() {
		return emailKH;
	}
	/**
	 * Dat email khach hang
	 * @param {String} emailKH
	 */
	public void setEmailKH(String emailKH) {
		this.emailKH = emailKH;
	}
	/**
	 * Tai khoan khach
	 * @return {TaiKhoan} tkKhach
	 */
	public String getTkKhach() {
		return tkKhach;
	}
	/**
	 * Dat tai khoan khach
	 * @param tkKhach
	 */
	
	@Override
	public String toString() {
		return maKH + hoTenKhach + soDienThoai ;
	}

	public String getHoTenKhach() {
		return hoTenKhach;
	}

	public void setHoTenKhach(String hoTenKhach) {
		this.hoTenKhach = hoTenKhach;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public void setTkKhach(String tkKhach) {
		this.tkKhach = tkKhach;
	}
	
}
