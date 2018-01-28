package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DoUong;

public class DoUongHelper {
	
	public static String tenBang = "DoUong";
	private Statement stmt = null;
	private Connection con = null;
	
	/**
	 * 
	 * @param maDoUong
	 * @param tenDoUong
	 * @param loaiDoUong
	 * @param giaDoUong
	 * @throws SQLException
	 */
	public void themDoUong(String maDoUong, String tenDoUong, String loaiDoUong, 
			double giaDoUong) throws SQLException {
		con = ConnectionUtils.getConnection();
		stmt = con.createStatement();
		try {
			if(!kiemTraTonTaiBang(DoUongHelper.tenBang)) {
				taoBang();
				String sql = "INSERT INTO " + DoUongHelper.tenBang 
						+ "(MaDoUong, TenDoUong, LoaiDoUong, GiaDoUong) "
						+ "VALUES( '" + maDoUong + "', '"
						+ tenDoUong + "', '"
						+ loaiDoUong + "',"
						+ giaDoUong + ");";
				stmt.executeUpdate(sql);
			} else {
				String sql = "INSERT INTO " + DoUongHelper.tenBang 
						+ "(MaDoUong, TenDoUong, LoaiDoUong, GiaDoUong) "
						+ "VALUES( '" + maDoUong + "', '"
						+ tenDoUong + "', '"
						+ loaiDoUong + "',"
						+ giaDoUong + ");";
				stmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			System.out.println("Trung ma do uong");
		}
		
	}
	/**
	 * 
	 * @param maDoUong
	 * @return
	 * @throws SQLException
	 */
	public boolean xoaDoUong(String maDoUong) throws SQLException {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM "+ DoUongHelper.tenBang 
					+ " WHERE MaDoUong = '"+maDoUong+"';";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
	}
	
	/**
	 * 
	 * @param maDoUong
	 * @param tenDoUong
	 * @param loaiDoUong
	 * @param giaDoUong
	 * @return
	 * @throws SQLException
	 */
	public boolean capNhatDoUong(String maDoUong, String tenDoUong, String loaiDoUong, 
			double giaDoUong) throws SQLException {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE "+ DoUongHelper.tenBang 
					+ " SET TenDoUong = '"+tenDoUong+"',"
					+ "LoaiDoUong = '" + loaiDoUong + "',"
					+ "GiaDoUong = " + giaDoUong 
					+ "WHERE MaDoUong = '" + maDoUong
					+ "';";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			con.close();
		}
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public void taoBang() throws SQLException {
		//Statement stmt = null;
		//Connection con = null;
		try {
			//Kien tra bang co chua
			if(kiemTraTonTaiBang(TaiKhoanHelper.tenBang) == true) {
				return;
			}
			//Neu chua co thi se tao moi
			else{
				con = ConnectionUtils.getConnection();
				stmt = con.createStatement();
				String sql = "CREATE TABLE "+ DoUongHelper.tenBang + " ("
						+ "MaDoUong varchar(50) not null," 
						+ "TenDoUong varchar(50) not null,"
						+ "LoaiDoUong varchar(50) not null,"
						+ "GiaDoUong smallmoney not null,"
						+ "PRIMARY KEY (MaDoUong)"
						+");";
				stmt.executeUpdate(sql);
			}
		} catch(Exception e)
		{
			System.out.println("Khong ket noi duoc!" +  e.getMessage());
		} finally {
			//con.close();
			//stmt.close();
		}
	}
	/**
	 * 
	 * @param tenBang
	 * @return
	 * @throws SQLException
	 */
	public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
		//Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbm = con.getMetaData();
			// Kiem tra bang "TaiKhoan" co ton tai khong
			ResultSet tables = dbm.getTables(null, null, DoUongHelper.tenBang, null);
			if (tables.next()) {
				//Neu bang co ton tai
				return true;
			}
			else {
				//Neu bang khong ton tai
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//con.close();
		}
		return false;
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<DoUong> layDanhSachDoUong() throws SQLException{
		ArrayList<DoUong> dsDoUong = new ArrayList<DoUong>(); 
		
		con = ConnectionUtils.getConnection();
		stmt = con.createStatement();
		
		String sql = "SELECT * FROM " + DoUongHelper.tenBang + " ;";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			  String maDoUong = rs.getString("MaDoUong");
			  String tenDoUong = rs.getString("TenDoUong");
			  String loaiDoUong = rs.getString("LoaiDoUong");
			  double giaDoUong = rs.getDouble("GiaDoUong");
			  DoUong du = new DoUong(maDoUong, tenDoUong, loaiDoUong, giaDoUong);
			  dsDoUong.add(du);
			}
		return dsDoUong;
	}
	/**
	 * 
	 * @param maDoUong
	 * @return
	 * @throws SQLException
	 */
	public DoUong layThongTinDoUong(String maDoUong) throws SQLException{		
		con = ConnectionUtils.getConnection();
		stmt = con.createStatement();
		DoUong du = new DoUong();
		String sql = "SELECT * FROM " + DoUongHelper.tenBang + " WHERE MaDoUong = '"+maDoUong+"';";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			  String maDoUong1 = rs.getString("MaDoUong");
			  String tenDoUong = rs.getString("TenDoUong");
			  String loaiDoUong = rs.getString("LoaiDoUong");
			  double giaDoUong = rs.getDouble("GiaDoUong");
			  du.setMaDoUong(maDoUong1);
			  du.setTenDoUong(tenDoUong);
			  du.setLoaiDoUong(loaiDoUong);
			  du.setGiaDoUong(giaDoUong);
			}
		return du;
	}
	
	public static void main(String[] args) throws SQLException {
		DoUongHelper dv = new DoUongHelper();
		/*System.out.println(dv.kiemTraTonTaiBang(DoUongHelper.tenBang));
		dv.taoBang();
		System.out.println(dv.kiemTraTonTaiBang(DoUongHelper.tenBang));*/
		String maDoUong = "TD5";
		String tenDoUong = "thao duoc";
		String loaiDoUong = "nuoc";
		double giaDoUong = 150500;
		String sql = "INSERT INTO " + DoUongHelper.tenBang 
				+ "(MaDoUong, TenDoUong, LoaiDoUong, GiaDoUong) "
				+ "VALUES( '" + maDoUong + "', '"
				+ tenDoUong + "', '"
				+ loaiDoUong + "',"
				+ giaDoUong + ");";
		System.out.println(sql);
		System.out.println(giaDoUong);
		//dv.themDoUong(maDoUong, tenDoUong, loaiDoUong, giaDoUong);
		//dv.xoaDoUong(maDoUong);
		//dv.capNhatDoUong("TD129", "bucac", "concac", 15000);
		List<DoUong> dsDoUong;
		dsDoUong = dv.layDanhSachDoUong();
		for (DoUong doUong : dsDoUong) {
			System.out.println(doUong);
		}
		
		System.out.println("===========");
		System.out.println(dv.layThongTinDoUong("TD10"));
		
	}
	
}
