package model;

public class Order {
	private DoUong du;
	private int soLuong;
	
	public Order(DoUong du, int soLuong) {
		this.du = du;
		this.soLuong = soLuong;
	}

	public DoUong getDu() {
		return du;
	}

	public void setDu(DoUong du) {
		this.du = du;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	@Override
	public String toString() {
		return "Order [du=" + du + ", soLuong=" + soLuong + "]";
	}
	
}
