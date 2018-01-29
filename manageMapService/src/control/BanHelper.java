package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BanHelper {
	public static String tenBang = "Ban";
	private Statement stmt = null;
	private Connection con = null;
	//Them ban
	//Xoa ban
	//Cap nhat ban
	//tim kiem ban
	
	public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
		//Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbm = con.getMetaData();
			// Kiem tra bang "TaiKhoan" co ton tai khong
			ResultSet tables = dbm.getTables(null, null, BanHelper.tenBang, null);
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
			if(kiemTraTonTaiBang(BanHelper.tenBang) == true) {
				return;
			}
			//Neu chua co thi se tao moi
			else{
				con = ConnectionUtils.getConnection();
				stmt = con.createStatement();
				String sql = "CREATE TABLE "+ BanHelper.tenBang + " ("
						+ "MaBan varchar(50) not null," 
						+ "LoaiBan varchar(50) not null,"
						+ "MaKhachDatBan varchar(15) null,"
						+ "ThoiGianConLai time null,"
						+ "TrangThaiBan bit null default 0 "
						+ "PRIMARY KEY (MaBan)"
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
		String sql = "ALTER TABLE Ban ADD FOREIGN KEY (MaKhachDatBan) REFERENCES KhachHang(MaKH);";
		stmt.executeUpdate(sql);
	}
	
	public static void main(String[] args) throws SQLException {
		BanHelper bh = new BanHelper();
		bh.taoBang();
		if(bh.kiemTraTonTaiBang(KhachHangHelper.tenBang)) {
			bh.themKhoa();
		}
			
		
	}
	
}
