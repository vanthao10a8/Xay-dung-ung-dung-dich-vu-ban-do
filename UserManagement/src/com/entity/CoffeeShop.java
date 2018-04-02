package com.entity;

import java.util.ArrayList;


public class CoffeeShop {

	private String id;
	private String lat;
	private String lng;
	private String name;
	private String address;
	private ArrayList<Table> lstTable;
	private ArrayList<ViewOfShop> lstViewOfShop;

	public CoffeeShop() {
	}
	public CoffeeShop(String id) {
		this.id = id;
	}
	public CoffeeShop(String id, String lat, String lng, String name, String address) {
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.address = address;
	}
	public CoffeeShop(String id, String lat, String lng, String name, String address, ArrayList<Table> lstTable,
			ArrayList<ViewOfShop> lstViewOfShop) {
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.address = address;
		this.lstTable = lstTable;
		this.lstViewOfShop = lstViewOfShop;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
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
	public ArrayList<Table> getLstTable() {
		return lstTable;
	}
	public void setLstTable(ArrayList<Table> lstTable) {
		this.lstTable = lstTable;
	}
	public ArrayList<ViewOfShop> getLstViewOfShop() {
		return lstViewOfShop;
	}
	public void setLstViewOfShop(ArrayList<ViewOfShop> lstViewOfShop) {
		this.lstViewOfShop = lstViewOfShop;
	}
	@Override
	public String toString() {
		return "CoffeeShop [id=" + id + ", lat=" + lat + ", lng=" + lng + ", name=" + name + ", address=" + address
				+ ", lstTable=" + lstTable + ", lstViewOfShop=" + lstViewOfShop + "]";
	}	
}
