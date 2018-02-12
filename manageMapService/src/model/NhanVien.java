package model;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin nhan vien
 */

public class NhanVien {
	/**
	 * Ma so cua nhan vien
	 */
	private String maSoNV;
	/**
	 * Ho ten cua nhan vien
	 */
	private String hoTenNV;
	/**
	 * Gioi tinh cua nhan vien
	 */
	private String gioiTinh;
	/**
	 * Ngay sinh cua nhan vien
	 */
	private String ngaySinh;
	/**
	 * Dia chi cua nhan vien
	 */
	private String diaChi;
	/**
	 * Chuc vu cua nhan vien
	 */
	private String chucVu;
	/**
	 * Muc luong cua nhan vien
	 */
	private double mucLuong;
	/**
	 * So ngay lam cua nhan vien
	 */
	private int soNgayLam;
	
	/**
	 * Defaul constructor
	 */
	public NhanVien() {
	}
	/**
	 * Constructor
	 * @param maSoNV
	 * @param hoTenNV
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param diaChi
	 * @param chucVu
	 * @param mucLuong
	 * @param soNgayLam
	 */
	public NhanVien(String maSoNV, String hoTenNV, String gioiTinh, String ngaySinh, String diaChi, String chucVu,
			double mucLuong, int soNgayLam) {
		this.maSoNV = maSoNV;
		this.hoTenNV = hoTenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.mucLuong = mucLuong;
		this.soNgayLam = soNgayLam;
	}
	/**
	 * Lay ma so nhan vien
	 * @return {String} maSoNV
	 */
	public String getMaSoNV() {
		return maSoNV;
	}
	/**
	 * Dat ma so nhan vien
	 * @param {String} maSoNV
	 */
	public void setMaSoNV(String maSoNV) {
		this.maSoNV = maSoNV;
	}
	/**
	 * Lay ho ten nhan vien
	 * @return {String} hoTenNV
	 */
	public String getHoTenNV() {
		return hoTenNV;
	}
	/**
	 * Dat ho nhan nhan vien
	 * @param {String} hoTenNV
	 */
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	/**
	 * Lay gioi tinh nhan vien
	 * @return {String} gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}
	/**
	 * Dat gioi tinh cho nhan vien
	 * @param {String} gioiTinh
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * Lay ngay sinh cho nhan vien
	 * @return {java.sql.Date} ngaySinh
	 */
	public String getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * Dat ngay sinh cho nhan vien
	 * @param {java.sql.Date} ngaySinh
	 */
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	/**
	 * Lay dia chi nhan vien
	 * @return {String} diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * Dat dia chi nhan vien
	 * @param {String} diaChi
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * Lay chuc vu nhan vien
	 * @return {String} chucVu
	 */
	public String getChucVu() {
		return chucVu;
	}
	/**
	 * Dat chuc vu cho nhan vien
	 * @param {String} chucVu
	 */
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	/**
	 * Lay muc luong cua nhan vien
	 * @return {double} mucLuong
	 */
	public double getMucLuong() {
		return mucLuong;
	}
	/**
	 * Dat muc luong cho nhan vien
	 * @param {double} mucLuong
	 */
	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}
	/**
	 * Lay so ngay lam cua nhan vien
	 * @return {int} soNgayLam
	 */
	public int getSoNgayLam() {
		return soNgayLam;
	}
	/**
	 * Dat so ngay lam cho nhan vien
	 * @param {int} soNgayLam
	 */
	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	@Override
	public String toString() {
		return maSoNV + " " + hoTenNV + " " + ngaySinh + " " + mucLuong ;
	}
	
}
