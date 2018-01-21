package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaiKhoanHelper {
	
	public static String tenBang = "TaiKhoan";
	private Statement stmt = null;
	private Connection con = null;
	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	
	
	public boolean dangKiTaiKhoan(String userName, String passWords) throws SQLException {
		//Statement stmt = null;
		//Connection con = null;
		try {
			if ( kiemTraTonTaiBang(tenBang) == false ) {
				//Tao bang moi
				taoBang();
				//Them account moi cho khach hang
				//Kiem tra ten dang nhap, mat khau
				if( kiemTraTenDangNhap(userName, passWords) ) {
					// insert vao csdl
					con = ConnectionUtils.getConnection();
					stmt = con.createStatement();
					String sql = "INSERT INTO "+ TaiKhoanHelper.tenBang 
							+ "(TenDangNhap, MatKhau, TinhTrangDangNhap) "
							+ "VALUES ('"+userName+"', '"+passWords+"',0)";
					//INSERT INTO TaiKhoan (TenDangNhap, MatKhau, TinhTrangDangNhap) 
					//VALUES ('mkong34','123456',1);
					
					
					stmt.executeUpdate(sql);
					return true;
					
				} else {
					//ten dang nhap sai pattern
					System.out.println("Tai Khoan hoac Mat khau sai pattern");
					return false;
				}
				
			} else {
				//Truong hop ban co roi
				if( kiemTraTenDangNhap(userName, passWords) ) {
					// insert vao csdl
					con = ConnectionUtils.getConnection();
					stmt = con.createStatement();
					String sql = "INSERT INTO "+ TaiKhoanHelper.tenBang 
							+ "( TenDangNhap, MatKhau, TinhTrangDangNhap  )"
							+ "VALUES ("+userName+", "+passWords+")";
					stmt.executeUpdate(sql);
				}
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Loi ket noi" + e.getMessage());
		} finally {
			//con.close();
			//stmt.close();
		}
		
		return false;
	}
	
	private boolean kiemTraTenDangNhap(String userName, String passWords) {
		/*	+ Tai khoan va mat khau phai nhieu hon 3 ki tu
		 *  + Tai khoan va mat khau phai khong duoc bao gom ki tu @
		 *  + Tai khoan va mat khau phai it hon 15 ki tu
		 * */
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Matcher userNameMatcher = pattern.matcher(userName);
		Matcher passWordsMatcher = pattern.matcher(passWords);
		//check
		if(userNameMatcher.matches() && passWordsMatcher.matches())
			return true;
		return false;
	}
	/**
	 * Kiem tra trong database co bang nay chua
	 * @param {String} tenBang
	 * @return true : co roi, false : khong co
	 * @throws SQLException 
	 */
	public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
		//Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbm = con.getMetaData();
			// Kiem tra bang "TaiKhoan" co ton tai khong
			ResultSet tables = dbm.getTables(null, null, TaiKhoanHelper.tenBang, null);
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
			if(kiemTraTonTaiBang(TaiKhoanHelper.tenBang) == true) {
				return;
			}
			//Neu chua co thi se tao moi
			else{
				con = ConnectionUtils.getConnection();
				stmt = con.createStatement();
				String sql = "CREATE TABLE "+ TaiKhoanHelper.tenBang + " ("
						+ "TenDangNhap varchar(15) not null," 
						+ "MatKhau varchar(15) not null,"
						+ "TinhTrangDangNhap bit not null DEFAULT 0,"
						+ "PRIMARY KEY (TenDangNhap)"
						+")";
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

	public static void main(String[] args) throws Exception {
		TaiKhoanHelper tk = new TaiKhoanHelper();
		System.out.println(tk.kiemTraTonTaiBang("TaiKhoan"));
		System.out.println(tk.dangKiTaiKhoan("mkyong34", "1245632"));
	}
}