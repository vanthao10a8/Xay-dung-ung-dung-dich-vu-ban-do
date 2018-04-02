package com.mongodb.ws;

public class Location implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double x;
	private Double y;
	private String name;
	private String address;
	///////////////////////////////////////////////////
	public Location(){
		
	}
	public Location(Double x, Double y, String name, String address) {
		super();

		this.x = x;
		this.y = y;
		this.name = name;
		this.address = address;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + ", name=" + name + ", address=" + address + "]";
	}
}