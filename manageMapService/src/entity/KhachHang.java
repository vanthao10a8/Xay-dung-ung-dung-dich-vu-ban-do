package entity;

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
	private TaiKhoan tkKhach;
	
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
	public KhachHang(String maKH, String diaChiKH, String emailKH, TaiKhoan tkKhach) {
		this.maKH = maKH;
		this.diaChiKH = diaChiKH;
		this.emailKH = emailKH;
		this.tkKhach = tkKhach;
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
	public TaiKhoan getTkKhach() {
		return tkKhach;
	}
	/**
	 * Dat tai khoan khach
	 * @param tkKhach
	 */
	public void setTkKhach(TaiKhoan tkKhach) {
		this.tkKhach = tkKhach;
	}
}
