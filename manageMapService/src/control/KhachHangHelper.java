package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
						+ "HoKhach varchar(50) not null,"
						+ "TenKhach varchar(50) not null,"
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
	
	public static void main(String[] args) throws SQLException {
		KhachHangHelper kh = new KhachHangHelper();
		kh.taoBang();
		kh.themKhoa();
		//+ "FOREIGN KEY (TaiKhoanKhach) REFERENCES " + TaiKhoanHelper.tenBang +  "([TenDangNhap])"
	}
	
}
