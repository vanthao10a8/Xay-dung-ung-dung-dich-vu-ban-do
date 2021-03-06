package model;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin ban
 */

public class Ban {
	//Ma ban
	private String maBan;
	//Loai ban
	private String loaiBan;
	//Trang thai dat ban
	private boolean trangThaiBan;
	//Dem thoi gian dat ban neu co
	private String thoiGianDat;
	//Khach hang dang dat ban
	private String maKhachDatBan;
	
	/**
	 * constructor
	 * @param maBan
	 * @param loaiBan
	 * @param trangThaiBan
	 * @param thoiGianDat
	 * @param maKhachDatBan
	 */
	public Ban(String maBan, String loaiBan, boolean trangThaiBan, String thoiGianDat, String maKhachDatBan) {
		super();
		this.maBan = maBan;
		this.loaiBan = loaiBan;
		this.trangThaiBan = trangThaiBan;
		this.thoiGianDat = thoiGianDat;
		this.maKhachDatBan = maKhachDatBan;
	}
	
	/**
	 * Lay ma so cua ban
	 * @return {String} maBan
	 */
	public String getMaBan() {
		return maBan;
	}
	/**
	 * Dat ma so cho ban
	 * @param maBan
	 */
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	/**
	 * Lay ra loai ban
	 * @return {String} loaiBan
	 */
	public String getLoaiBan() {
		return loaiBan;
	}
	/**
	 * Dat loai cho ban
	 * @param {String} loaiBan
	 */
	public void setLoaiBan(String loaiBan) {
		this.loaiBan = loaiBan;
	}
	/**
	 * Kiem tra ban da duoc dat chua
	 * @return True : da dat roi, False : chua dat
	 */
	public boolean isTrangThaiBan() {
		return trangThaiBan;
	}
	/**
	 * Dat trang thai cho ban
	 * @param {boolean} trangThaiBan
	 */
	public void setTrangThaiBan(boolean trangThaiBan) {
		this.trangThaiBan = trangThaiBan;
	}
	/**
	 * Lay bo dem nguoc thoi gian cho viec dat ban
	 * @return {Timer} thoiGianDatConLai
	 */
	public String getThoiGianDat() {
		return thoiGianDat;
	}
	/**
	 * Dat bo dem nguoc thoi gian cho viec dat ban
	 * @param {Timer} thoiGianDatConLai
	 */
	public void setThoiGianDat(String thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}
	/**
	 * Lay ma so cua khach dat hang
	 * @return {String} maKhachDatHang
	 */
	public String getMaKhachDatBan() {
		return maKhachDatBan;
	}
	/**
	 * Dat ma so cua khach dat ban
	 * @param maKhachDatHang
	 */
	public void setMaKhachDatBan(String maKhachDatBan) {
		this.maKhachDatBan = maKhachDatBan;
	}
	
	@Override
	public String toString() {
		String s = "Mã bàn : " + maBan + "\n"
				+ "Loại bàn : " + loaiBan + " Người"+ "\n" 
				+ "Bàn Đang được đặt : " + trangThaiBan + "\n"
				+ "Thời gian đặt : " + thoiGianDat + "\n"
				+ "Mã khách đặt bàn : " + maKhachDatBan + "\n";
		return s;
	}
	
	
}
