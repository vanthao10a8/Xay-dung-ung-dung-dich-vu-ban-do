package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * @author ThaoNguyen
 * @Description thong tin do uong
 */
public class DoUong {
	/**
	 * Ma so do uong.
	 */
	private String maDoUong;
	/**
	 * ten do uong.
	 */
	private String tenDoUong;
	/**
	 * loai do uong
	 */
	private String loaiDoUong;
	/**
	 * gia do uong
	 */
	private double giaDoUong;
	/**
	 * ngay tao
	 */
	private Date ngayTao;
	
	/**
	 * Default Constructor
	 */
	public DoUong() {
		//NOPROCESS
	}
	/**
	 * Constructor
 	 * @param {String} maDoUong
	 * @param {String} tenDoUong
	 * @param {String} loaiDoUong
	 * @param {double} giaDoUong
	 * @param {sql.Date} ngayTao
	 */
	public DoUong(String maDoUong, String tenDoUong, String loaiDoUong, 
			double giaDoUong,Date ngayTao  ) {
		this.maDoUong = maDoUong;
		this.tenDoUong = tenDoUong;
		this.loaiDoUong = loaiDoUong;
		this.giaDoUong = giaDoUong;
		this.ngayTao = ngayTao;
	}
	/**
	 * lay ma do uong
	 * @return {String} maDoUong
	 */
	public String getMaDoUong() {
		return maDoUong;
	}
	/**
	 * dat ma cho do uong
	 * @param {String} maDoUong
	 */
	public void setMaDoUong(String maDoUong) {
		this.maDoUong = maDoUong;
	}
	/**
	 * Lay ten do uong.
	 * @return {String} tenDoUong
	 */
	public String getTenDoUong() {
		return tenDoUong;
	}
	/**
	 * Dat ten do uong.
	 * @param {String}tenDoUong
	 */
	public void setTenDoUong(String tenDoUong) {
		this.tenDoUong = tenDoUong;
	}
	/**
	 * Lay loai do uong.
	 * @return {String} loaiDoUong
	 */
	public String getLoaiDoUong() {
		return loaiDoUong;
	}
	/**
	 * Dat loai cho do uong
	 * @param {String} loaiDoUong
	 */
	public void setLoaiDoUong(String loaiDoUong) {
		this.loaiDoUong = loaiDoUong;
	}
	/**
	 * Lay gia cua do uong
	 * @return {double} giaDoUong
	 */
	public double getGiaDoUong() {
		return giaDoUong;
	}
	/**
	 * dat gia cho do uong
	 * @param {double} giaDoUong
	 */
	public void setGiaDoUong(double giaDoUong) {
		this.giaDoUong = giaDoUong;
	}
	/**
	 * Lay ngay tao cua do uong
	 * @return {Date} giaDoUong
	 */
	public Date getDate() {
		return ngayTao;
	}
	/**
	 * dat ngay tao cho do uong
	 * @param {double} giaDoUong
	 */
	public void setDate(Date date) {
		this.ngayTao = date;
	}
	
	/**
	 * @return {String} thong tin cua class DoUong
	 */
	public String toString() {
		String s = "";
		SimpleDateFormat sf = new SimpleDateFormat("EEE, MMM d, ''yy");
		s+="Ma do uong: " + maDoUong + "\n" 
		 + "Ten do uong: " + tenDoUong + "\n"
		 + "Loai do uong: " + loaiDoUong + "\n"
		 + "Gia do uong: " + giaDoUong + "\n"
		 + "Ngay tao: " + sf.format(ngayTao) + "\n";
		return s;
	}
}
