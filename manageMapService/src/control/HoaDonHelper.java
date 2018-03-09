package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DoUong;
import model.Order;

public class HoaDonHelper {

	private static final String tenBang = "HoaDon";
	private Connection con;
	private Statement stmt;
	
	public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
		//Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbm = con.getMetaData();
			// Kiem tra bang "TaiKhoan" co ton tai khong
			ResultSet tables = dbm.getTables(null, null, HoaDonHelper.tenBang, null);
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
	public void taoBang() throws SQLException {
		//Statement stmt = null;
		//Connection con = null;
		try {
			//Kien tra bang co chua
			if(kiemTraTonTaiBang(HoaDonHelper.tenBang) == true) {
				return;
			}
			//Neu chua co thi se tao moi
			else{
				con = ConnectionUtils.getConnection();
				stmt = con.createStatement();
				String sql = "CREATE TABLE "+ HoaDonHelper.tenBang + " ("
						+ "MaHD varchar(15) not null," 
						+ "MaNV varchar(15) not null,"
						+ "MaKH varchar(15) not null,"
						+ "NgayBan varchar(50) null,"
						+ "TongTien float not null,"
						+ "PRIMARY KEY (MaHD)"
						+");";
				stmt.executeUpdate(sql);
				sql = "CREATE TABLE " + "ChiTietHoaDon" + "( "
						+ "MaHD varchar(15) not null, "
						+ "MaDoUong varchar(50) not null, "
						+ "SoLuong int, "
						+ "DonGia float, "
						+ "ThanhTien AS (SoLuong * DonGia),"
						+ "PRIMARY KEY(MaHD,MaDoUong));";
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

	public float tinhTongTien(List<Order> dsOrder) {
		float sum = 0;
		for (Order order : dsOrder) {
			sum += order.getSoLuong() * order.getDu().getGiaDoUong();
		}
		return sum;
	}

	public void themHoaDon(String maHD, String maNV, String maKH, 
			String ngayBan  ,List<Order> dsOrder) throws SQLException {
		con = ConnectionUtils.getConnection();
		stmt = con.createStatement();
		try {
			if(!kiemTraTonTaiBang(HoaDonHelper.tenBang)) {
				taoBang();
				String sql = "INSERT INTO " + HoaDonHelper.tenBang 
						+ "(MaHD, MaNV, MaKH, NgayBan,TongTien) "
						+ "VALUES( '" + maHD + "', '"
						+ maNV + "', '"
						+ maKH + "','"
						+ ngayBan + "',"
						+ tinhTongTien(dsOrder) + ");";
				stmt.executeUpdate(sql);
				for (Order order : dsOrder) {
					sql = "INSERT INTO " + "ChiTietHoaDon"
							+ "(MaHD, MaDoUong, SoLuong, DonGia) "
							+ "VALUES( '" + maHD + "', '"
							+ order.getDu().getMaDoUong() + "',"
							+ order.getSoLuong() + ","
							+ order.getDu().getGiaDoUong() + ");";
					stmt.executeUpdate(sql);
				}
			} else {
				String sql = "INSERT INTO " + HoaDonHelper.tenBang 
						+ "(MaHD, MaNV, MaKH, NgayBan,TongTien) "
						+ "VALUES( '" + maHD + "', '"
						+ maNV + "', '"
						+ maKH + "','"
						+ ngayBan + "',"
						+ tinhTongTien(dsOrder) + ");";
				stmt.executeUpdate(sql);
				for (Order order : dsOrder) {
					sql = "INSERT INTO " + "ChiTietHoaDon"
							+ "(MaHD, MaDoUong, SoLuong, DonGia) "
							+ "VALUES( '" + maHD + "', '"
							+ order.getDu().getMaDoUong() + "',"
							+ order.getSoLuong() + ","
							+ order.getDu().getGiaDoUong() + ");";
					stmt.executeUpdate(sql);
				}
			}
		} catch (Exception e) {
			System.out.println("Duplicate id line order");
		}

	}
	
	
	
	


	public static void main(String[] args) throws SQLException {
		HoaDonHelper dh = new HoaDonHelper();
		dh.taoBang();
		ArrayList<Order> dsOrder = new ArrayList<>();
		Order od = new Order(new DoUong("DU01", "CHanh", "Da", 15000), 2);
		Order od2 = new Order(new DoUong("DU02", "Muon", "Nong", 8000), 1);
		dsOrder.add(od);
		dsOrder.add(od2);
		dh.themHoaDon("HD001", "NV01", "KH01", "2018-10-2", dsOrder);

	}


}
