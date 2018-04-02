package com.entity;

public class MarkerInfo {
	private double lat;
	private double lng;
	private String info;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		String s = lat + "," + lng + "," + info;
		return s; 
	}
	public MarkerInfo(double lat, double lng, String info) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.info = info;
	}
	
	
	
}
