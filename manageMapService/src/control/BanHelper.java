package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Ban;

public class BanHelper {
	public static String tenBang = "Ban";
	private Statement stmt = null;
	private Connection con = null;
	
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
						+ "ThoiGianDat varchar(15) null,"
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
	
	public boolean themBan(Ban b) {
		try {
			if(!kiemTraTonTaiBang(BanHelper.tenBang)) {
				taoBang();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int i = 0;
		if(b.isTrangThaiBan())
			i = 1;
		String sql = "INSERT INTO " + BanHelper.tenBang + " VALUES('"
				+ b.getMaBan()+"','"
				+ b.getLoaiBan() + "', '"  
				+ b.getMaKhachDatBan() + "', '" 
				+ b.getThoiGianDat() + "',"
				+ i 
				+ ")";
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			//System.out.println(sql);
			stmt.executeUpdate(
					sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaBan(String maBan) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE"
					+ " FROM " + BanHelper.tenBang + " WHERE MaBan='"+maBan+"';";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean capNhatBan(String maBan,String loaiBan, String maKhachDatBan,
			String thoiGianDat, int trangThaiDat) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE " + BanHelper.tenBang + " SET "
					+ "LoaiBan='" + loaiBan + "',"
					+ "MaKhachDatBan='" + maKhachDatBan +"',"
					+ "ThoiGianDat='" + thoiGianDat +"',"
					+ "TrangThaiBan=" + trangThaiDat 
					+ " WHERE MaBan='"+maBan+"';";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean layTinhTrangDatBan(String maBan) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT [TrangThaiBan] FROM " + BanHelper.tenBang
					+ " WHERE [MaBan]='" + maBan + "'";
			ResultSet rs = stmt.executeQuery(sql);
			int flag = 0;
			while(rs.next()) {
				String data = rs.getString("TrangThaiBan");
				flag = Integer.parseInt(data);
			}
			if(flag == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Ban layThongTinBan(String maBan) {
		try {
			//Ban ban = new Ban(maBan, loaiBan, trangThaiBan, thoiGianDat, maKhachDatBan)
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM " + BanHelper.tenBang
					+ " WHERE [MaBan]='" + maBan + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maBan1 = rs.getString("MaBan");
				String LoaiBan1 = rs.getString("LoaiBan");
				String thoiGianDat1 = rs.getString("thoiGianDat");
				int flag = rs.getInt("TrangThaiBan");
				boolean trangThai = false;
				if(flag==1) trangThai = true;
				String maKhach = rs.getString("MaKhachDatBan");
				Ban ban = new Ban(maBan1, LoaiBan1, trangThai, thoiGianDat1, maKhach);
				return ban;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean datBan(String maBan, String maKH) {
		try {
			//Ban ban = new Ban(maBan, loaiBan, trangThaiBan, thoiGianDat, maKhachDatBan)
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
			String s = sf.format(new Date().getTime());
			String sql = "UPDATE " + BanHelper.tenBang
					+ " SET [TrangThaiBan]=" + 1 + ", "
					+ "[MaKhachDatBan]='" + maKH + "', "
					+ "[ThoiGianDat] ='" + s + "' "
					+ "WHERE [MaBan] = '" + maBan + "'";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean huyDatBan(String maBan) {
		try {
			//Ban ban = new Ban(maBan, loaiBan, trangThaiBan, thoiGianDat, maKhachDatBan)
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			//SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
			//String s = sf.format(new Date().getTime());
			String sql = "UPDATE " + BanHelper.tenBang
					+ " SET [TrangThaiBan]=" + 0 + ", "
					+ "[MaKhachDatBan]='" + "NULL" + "', "
					+ "[ThoiGianDat] ='" + "NULL" + "' "
					+ "WHERE [MaBan] = '" + maBan + "'";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) throws SQLException {
		BanHelper bh = new BanHelper();
		/*bh.taoBang();
		if(bh.kiemTraTonTaiBang(KhachHangHelper.tenBang)) {
			bh.themKhoa();
		}*/
		//SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
		//String s = sf.format(new Date().getTime());
		//System.out.println(s);
		//bh.themBan(new Ban("Ban1", "Ban6Nguoi", true, s , ""));
		//bh.xoaBan("Ban1");
		//bh.capNhatBan("Ban1", "Ban3Nguoi", "", s, 0);
		//System.out.println(bh.layTinhTrangDatBan("Ban1"));
		 //bh.huyDatBan("Ban1", "KH103630");
		bh.datBan("Ban2", "KH103630");
	}
	
}
