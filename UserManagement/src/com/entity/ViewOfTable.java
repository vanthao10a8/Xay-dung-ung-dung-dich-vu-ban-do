package com.entity;

public class ViewOfTable {
	
	private String describe;
	private String url;
	
	public ViewOfTable(String describe, String url) {
		this.describe = describe;
		this.url = url;
	}
	
	public ViewOfTable() {}
	
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
	
	@Override
	public String toString() {
		String s = "View of table : \n" + "Describe: " + describe + "\n"+"UrlImage: " + url; 
		return s;
	}
	
}
