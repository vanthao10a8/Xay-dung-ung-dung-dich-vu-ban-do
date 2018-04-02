package com.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.entity.CoffeeShop;
import com.entity.Table;
import com.entity.ViewOfShop;
import com.entity.ViewOfTable;
import com.google.gson.Gson;
import com.mongodb.client.model.Filters;

public class CRUD {

	//insert shop to database
	public void createCoffeeShop(CoffeeShop cf) {
		//Create connect
		DbUltis db = new DbUltis();
		Gson gson = new Gson();
		//Querry
		try {
			db.getColl().insertOne(gson.fromJson(gson.toJson(cf), Document.class));
		} catch (Exception e) {
			System.out.println("Error when insert data to database : " + e.getMessage());
		} finally {
			db.closeConnect();
		}
	}

	//read data from database
	public CoffeeShop getCoffeeShopData(String id) {
		//Create connect
		DbUltis db = new DbUltis();
		CoffeeShop cf = new CoffeeShop();
		//Query
		try {

			List<Document> lstCoffeeShop = (List<Document>) db.getColl().find(Filters.eq("id", id)).into(
					new ArrayList<Document>());
			for(Document coffeeShop : lstCoffeeShop){
				// add attribute
				cf.setId(coffeeShop.getString("id"));
				cf.setLat(coffeeShop.getString("lat"));
				cf.setLng(coffeeShop.getString("lng"));
				cf.setName(coffeeShop.getString("name"));
				cf.setAddress(coffeeShop.getString("address"));

				//add list table 
				@SuppressWarnings("unchecked")
				List<Document> lstTable = (List<Document>) coffeeShop.get("lstTable");
				ArrayList<Table> lstTableShop = new ArrayList<>();
				for (Document table : lstTable) {
					Table tbl = new Table();
					tbl.setNumTable(table.getString("numTable"));
					tbl.setStatus(table.getString("status"));
					@SuppressWarnings("unchecked")
					List<Document> lstView = (List<Document>) table.get("lstView");
					ArrayList<ViewOfTable> lstViewOfTable = new ArrayList<>();
					for (Document lsView : lstView) {
						ViewOfTable vot = new ViewOfTable();
						vot.setDescribe(lsView.getString("describe"));
						vot.setUrl(lsView.getString("url"));
						lstViewOfTable.add(vot);
					}
					tbl.setLstView(lstViewOfTable);
					lstTableShop.add(tbl);
				}
				cf.setLstTable(lstTableShop);

				//add list view of shop
				@SuppressWarnings("unchecked")
				List<Document> lstVOS = (List<Document>) coffeeShop.get("lstViewOfShop");
				ArrayList<ViewOfShop> listViewOfShop = new ArrayList<>();
				for (Document vofs : lstVOS) {
					ViewOfShop vos = new ViewOfShop();
					vos.setDescribe(vofs.getString("describe"));
					vos.setUrl(vofs.getString("url"));
					vos.setHasTank(vofs.getBoolean("hasTank",false));
					vos.setHasManyView(vofs.getBoolean("hasManyView",false));
					listViewOfShop.add(vos);
				}
				cf.setLstViewOfShop(listViewOfShop);
			}
		} catch (Exception e) {
			System.out.println("Error when insert data to database : " + e.getMessage());
		} finally {
			db.closeConnect();
		}
		return cf;
	}

	//delete one document
	public void deleteCoffeeShop(String id) {
		//Create connect
		DbUltis db = new DbUltis();
		//Querry
		try {
			db.getColl().deleteOne(Filters.eq("id", id)); 

		} catch (Exception e) {
			System.out.println("system error cannot delete document" + e.getMessage());
		} 
		finally {
			db.closeConnect();
		}
	}

	//update document
	public void updateCoffeeShop(String id, String key, String value) {
		//Create connect
		DbUltis db = new DbUltis();
		//Querry
		try {
			Bson filter = new Document("id", id);
			Bson newValue = new Document(key, value);
			Bson updateOperationDocument = new Document("$set", newValue);
			db.getColl().updateOne(filter, updateOperationDocument);
		} catch (Exception e) {
			System.out.println("system error cannot update document " + e.getMessage());
		} 
		finally {
			db.closeConnect();
		}
	}

	//get all data
	public ArrayList<CoffeeShop> getAllDocument(){
		//Create connect
		DbUltis db = new DbUltis();
		ArrayList<CoffeeShop> lstCfShop = new ArrayList<>();
		//Querry
		List<Document> documents = (List<Document>) db.getColl().find().into(
				new ArrayList<Document>());
		for(Document document : documents){
			String id = document.getString("id");
			lstCfShop.add(getCoffeeShopData(id));
		}
		return lstCfShop;
	}
	
	//get search by attribute
	public ArrayList<CoffeeShop> getCoffeeShopByAttr(boolean isTank, boolean isManyView){
		CRUD cr =  new CRUD(); 
		ArrayList<CoffeeShop> lstCf = new ArrayList<>();
		ArrayList<CoffeeShop> result = new ArrayList<>();
		ArrayList<ViewOfShop> vos = new ArrayList<>();
		lstCf = cr.getAllDocument();
		for (CoffeeShop coffeeShop : lstCf) {
			vos = coffeeShop.getLstViewOfShop();
			for (ViewOfShop viewOfShop : vos) {
				if(viewOfShop.isHasManyView() && viewOfShop.isHasTank()) {
					result.add(coffeeShop);
				}
			}
		}
		return lstCf;
	}
	
	//check status of seat
	public ArrayList<CoffeeShop> getCfFreekSeat() {
		CRUD cr =  new CRUD(); 
		ArrayList<CoffeeShop> lstCF = new ArrayList<>();
		ArrayList<CoffeeShop> lstCf = new ArrayList<>();
		ArrayList<Table> lstTable = new ArrayList<>();
		lstCf = cr.getAllDocument();
		for (CoffeeShop cf : lstCf) {
			lstTable = cf.getLstTable();
			for (Table table : lstTable) {
				if(table.getStatus().equalsIgnoreCase("free")) {
					lstCF.add(cf);
				}
			}
		}
		return lstCF;
	}
	
	public static void main(String[] args) {
		CRUD cr =  new CRUD(); 
		//cr.updateCoffeeShop("CF001","name","googlemapvlue");
		//System.out.println(cr.getCfFreekSeat());
		CoffeeShop cf0 = new CoffeeShop();
		cf0.setId("CF0004");
		cf0.setLat("10.823249");//10.823249, 106.687666
		cf0.setLng("106.687666");
		cf0.setAddress("Sạp 11 chợ Gò Vấp, Gò Vấp, Hồ Chí Minh, Việt Nam");
		cf0.setName("Pia coffee");
		ArrayList<Table> lstTable = new ArrayList<>();
		ArrayList<ViewOfShop> lstViewOfShop = new ArrayList<>();
		ArrayList<ViewOfTable> lstViewOfTable = new ArrayList<>();
		ViewOfTable view0 = new ViewOfTable("left", "C:\\Users\\vanth\\Desktop\\CoffeeShop\\Table\\table_0_after.jpg");
		ViewOfTable view1 = new ViewOfTable("left", "C:\\Users\\vanth\\Desktop\\CoffeeShop\\Table\\table_0_before.jpg");
		ViewOfTable view2 = new ViewOfTable("left", "C:\\Users\\vanth\\Desktop\\CoffeeShop\\Table\\table_0_left.jpg");
		ViewOfTable view3 = new ViewOfTable("left", "C:\\Users\\vanth\\Desktop\\CoffeeShop\\Table\\table_0_right.jpg");
		lstViewOfTable.add(view0);
		lstViewOfTable.add(view1);
		lstViewOfTable.add(view2);
		lstViewOfTable.add(view3);
		Table tbl = new Table("1", lstViewOfTable, "free");
		lstTable.add(tbl);
		cf0.setLstTable(lstTable);
//		ViewOfShop vos0 = new ViewOfShop("middle view",
//				"C:\\Users\\vanth\\Desktop\\CoffeeShop\\ViewOfShop\\view0.jpg",
//				true,
//				true);
//		ViewOfShop vos1 = new ViewOfShop("middle view",
//				"C:\\Users\\vanth\\Desktop\\CoffeeShop\\ViewOfShop\\view1.jpg",
//				true,
//				true);
//		ViewOfShop vos2 = new ViewOfShop("middle view",
//				"C:\\Users\\vanth\\Desktop\\CoffeeShop\\ViewOfShop\\view2.jpg",
//				true,
//				true);
		ViewOfShop vos3 = new ViewOfShop("middle view",
				"C:\\Users\\vanth\\Desktop\\CoffeeShop\\ViewOfShop\\view3.jpg",
				false,
				false);
//		lstViewOfShop.add(vos0);
//		lstViewOfShop.add(vos1);
//		lstViewOfShop.add(vos2);
		lstViewOfShop.add(vos3);
		cf0.setLstViewOfShop(lstViewOfShop);
		
		cr.createCoffeeShop(cf0);

	}
}



