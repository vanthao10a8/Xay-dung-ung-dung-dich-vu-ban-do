package com.entity;

public class ViewOfShop {
	
	private String describe;
	private String url;
	private boolean hasTank;
	private boolean hasManyView;
	
	public ViewOfShop(String describe, String url, boolean hasTank, boolean hasManyView) {
		this.describe = describe;
		this.url = url;
		this.hasTank = hasTank;
		this.hasManyView = hasManyView;
	}
	public ViewOfShop() {}
	
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isHasTank() {
		return hasTank;
	}
	public void setHasTank(boolean hasTank) {
		this.hasTank = hasTank;
	}
	public boolean isHasManyView() {
		return hasManyView;
	}
	public void setHasManyView(boolean hasManyView) {
		this.hasManyView = hasManyView;
	}
	@Override
	public String toString() {
		return "ViewOfShop [describe=" + describe + ", url=" + url + ", hasTank=" + hasTank + ", hasManyView="
				+ hasManyView + "]";
	}
	
	
}
