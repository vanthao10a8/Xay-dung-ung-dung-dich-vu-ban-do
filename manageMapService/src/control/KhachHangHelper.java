package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangHelper {

	public static final String tenBang = "KhachHang";
	private Statement stmt = null;
	private Connection con = null;
	
	public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
		//Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbm = con.getMetaData();
			// Kiem tra bang "TaiKhoan" co ton tai khong
			ResultSet tables = dbm.getTables(null, null, KhachHangHelper.tenBang, null);
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
			if(kiemTraTonTaiBang(KhachHangHelper.tenBang) == true) {
				return;
			}
			//Neu chua co thi se tao moi
			else{
				con = ConnectionUtils.getConnection();
				stmt = con.createStatement();
				String sql = "CREATE TABLE "+ KhachHangHelper.tenBang + " ("
						+ "MaKH varchar(15) not null," 
						+ "HoTen varchar(50) not null,"
						+ "SoDienThoai varchar(50) not null,"
						+ "Email varchar(50) not null,"
						+ "DiaChi varchar(50) not null,"
						+ "TaiKhoanKhach varchar(15) not null,"
						+ "PRIMARY KEY (MaKH)"
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
	
	public void themKhoa() throws SQLException {
		con = ConnectionUtils.getConnection();
		stmt = con.createStatement();
		String sql = "ALTER TABLE KhachHang ADD FOREIGN KEY (TaiKhoanKhach) REFERENCES TaiKhoan([TenDangNhap]);";
		stmt.executeUpdate(sql);
	}
	
	public boolean themKhachHang(KhachHang kh) {
		try {
			if(!kiemTraTonTaiBang(KhachHangHelper.tenBang))
				taoBang();
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO " + KhachHangHelper.tenBang + " VALUES("
					+"'" + kh.getMaKH() + "',"
					+"'" + kh.getHoTenKhach() + "',"
					+"'" + kh.getSoDienThoai() + "',"
					+"'" + kh.getEmailKH() + "',"
					+"'" + kh.getDiaChiKH() + "',"
					+"'" + kh.getTkKhach()+ "'"
					+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean capNhatKhachHang(String maKH, String hoKH, String tenKH,
			String emmailKH, String diaChiKH, String tkKhach) {
		try {
			if(!kiemTraTonTaiBang(KhachHangHelper.tenBang))
				taoBang();
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE " + KhachHangHelper.tenBang + " SET "
					+"HoTen='" + hoKH + "',"
					+"SoDienThoai='" + tenKH + "',"
					+"Email='" + emmailKH + "',"
					+"DiaChi='" + diaChiKH + "',"
					+"TaiKhoanKhach='" + tkKhach + "'"
					+" WHERE MaKH='" + maKH +"';";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<KhachHang> layTatCaKH(){
		ArrayList<KhachHang> list = null;
		try {
			list = new ArrayList<KhachHang>();
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM " + KhachHangHelper.tenBang + ";";
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maKH = rs.getString("MaKH");
				String hoKH = rs.getString("HoTen");
				String tenKH = rs.getString("SoDienThoai");
				String emailKH = rs.getString("Email");
				String diaChiKH = rs.getString("DiaChi");
				String tkKhach = rs.getString("TaiKhoanKhach");
				//System.out.println(maKH + hoKH + tenKH + emailKH + diaChiKH);
				KhachHang kh = new KhachHang(maKH, hoKH, tenKH, diaChiKH, emailKH, tkKhach);
				list.add(kh);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) throws SQLException {
		KhachHangHelper kh = new KhachHangHelper();
		kh.taoBang();
		kh.themKhoa();
		//+ "FOREIGN KEY (TaiKhoanKhach) REFERENCES " + TaiKhoanHelper.tenBang +  "([TenDangNhap])"
		//kh.themKhachHang(new KhachHang("KH01", "Nguyen", "Van Thao", "HCM", "vanthao@gmail.com", new TaiKhoan("mkyong30", "877215",false)));
		//kh.capNhatKhachHang("KH01", "Tran", "VanThao", "vanthao", "HN", "mkyong31");
		ArrayList<KhachHang> list = kh.layTatCaKH();
		//System.out.println(list);
		for (KhachHang khachHang : list) {
			System.out.println(khachHang);
		}
	}
	
}
