package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.TaiKhoan;

public class TaiKhoanHelper {
	
	public static String tenBang = "TaiKhoan";
	private Statement stmt = null;
	private Connection con = null;
	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	
	/**
	 * 
	 * @param userName
	 * @param passWords
	 * @return
	 * @throws SQLException
	 */
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
							+ " VALUES ('"+userName+"', '"+passWords+"', 'false')";
					stmt.executeUpdate(sql);
				}
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Trung ten tai khoan.");
			return false;
		} finally {
			con.close();
			stmt.close();
		}
	}
	/**
	 * 
	 * @param userName
	 * @param passWords
	 * @return
	 */
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
				String sql = "CREATE TABLE "+ TaiKhoanHelper.tenBang + " ("
						+ "TenDangNhap varchar(15) not null," 
						+ "MatKhau varchar(15) not null,"
						+ "TinhTrangDangNhap bit null DEFAULT 0,"
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
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public boolean xoaTaiKhoan(String userName) throws SQLException {	
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			//DELETE FROM [dbo].[TaiKhoan] WHERE [TenDangNhap] = 'mkyong30';
			String sql = "DELETE FROM "+ TaiKhoanHelper.tenBang 
					+ " WHERE [TenDangNhap] = '"+userName+"';";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return false;
	}
	
	public TaiKhoan layThongTinTaiKhoan(String userName, String passWords) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM " + TaiKhoanHelper.tenBang + " WHERE TenDangNhap = '" + userName
					+"' MatKhau = '" + passWords + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String userName1 = rs.getString(0);
				String passWords1 = rs.getString(1);
				int status = rs.getInt(2);
				boolean flag = false;
				if(status == 1) flag = true;
				TaiKhoan tk = new TaiKhoan(userName1, passWords1, flag);
				return tk;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
/*	public static void main(String[] args) throws Exception {
		TaiKhoanHelper tk = new TaiKhoanHelper();
		System.out.println(tk.kiemTraTonTaiBang("TaiKhoan"));
		System.out.println(tk.dangKiTaiKhoan("mkyong33", "123456"));
		tk.xoaTaiKhoan("mkong37");
		System.out.println(	"DELETE FROM "+ TaiKhoanHelper.tenBang + " WHERE [TenDangNhap] = '"+"mykong31"+"';");
	}*/
}
