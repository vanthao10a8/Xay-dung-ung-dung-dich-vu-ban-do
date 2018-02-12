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
	
	private String hoKhach;
	private String tenKhach;
	
	

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
	public KhachHang(String maKH, String hoKhach, String tenKhach, String diaChiKH, String emailKH, String tkKhach1) {
		this.maKH = maKH;
		this.diaChiKH = diaChiKH;
		this.emailKH = emailKH;
		this.tkKhach = tkKhach1;
		this.hoKhach = hoKhach;
		this.tenKhach = tenKhach;
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
	public void setTkKhach(String tkKhach) {
		this.tkKhach = tkKhach;
	}
	
	public String getHoKhach() {
		return hoKhach;
	}

	public void setHoKhach(String hoKhach) {
		this.hoKhach = hoKhach;
	}

	public String getTenKhach() {
		return tenKhach;
	}

	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}
	
	@Override
	public String toString() {
		return maKH + hoKhach + tenKhach ;
	}
	
}
