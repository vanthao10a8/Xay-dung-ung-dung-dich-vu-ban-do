package com.entity;

import java.util.ArrayList;

public class Table {
	//Index of table in shop
	private String numTable;
	private ArrayList<ViewOfTable> lstView;
	private String status;  //busy or free to book
	
	public Table(String numTable, ArrayList<ViewOfTable> lstView, String status) {
		this.numTable = numTable;
		this.lstView = lstView;
		this.status = status;
	}
	
	public Table() {}

	public String getNumTable() {
		return numTable;
	}
	public void setNumTable(String numTable) {
		this.numTable = numTable;
	}
	public ArrayList<ViewOfTable> getLstView() {
		return lstView;
	}
	public void setLstView(ArrayList<ViewOfTable> lstView) {
		this.lstView = lstView;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Table [numTable=" + numTable + ", lstView=" + lstView + "]";
	}
	
	
	
	
}
