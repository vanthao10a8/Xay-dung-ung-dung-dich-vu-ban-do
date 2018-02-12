package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.NhanVien;

public class NhanVienHelper {
	public static final String tenBang = "NhanVien";
	private Statement stmt = null;
	private Connection con = null;

	public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
		//Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbm = con.getMetaData();
			// Kiem tra bang "TaiKhoan" co ton tai khong
			ResultSet tables = dbm.getTables(null, null, NhanVienHelper.tenBang, null);
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
			if(kiemTraTonTaiBang(NhanVienHelper.tenBang) == true) {
				return;
			}
			//Neu chua co thi se tao moi
			else{
				con = ConnectionUtils.getConnection();
				stmt = con.createStatement();
				String sql = "CREATE TABLE "+ NhanVienHelper.tenBang + " ("
						+ "MaNV varchar(15) not null," 
						+ "HoTen varchar(50) not null,"
						+ "NgaySinh varchar(50) not null,"
						+ "DiaChi varchar(50) not null,"
						+ "GioiTinh varchar(50) not null,"
						+ "ChucVu varchar(50) not null,"
						+ "MucLuong float not null,"
						+ "SoNgayLam int not null,"
						+ "PRIMARY KEY (MaNV)"
						+");";
				System.out.println(sql);
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
	
	public boolean xoaNhanVien(String MaNV) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM "+ NhanVienHelper.tenBang + " WHERE MaNV = '" + MaNV +"';";
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<NhanVien> layTatCaNhanVien(){
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM " + NhanVienHelper.tenBang;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String MaNV = rs.getString("MaNV");
				String Hoten = rs.getString("HoTen");
				String NgaySinh = rs.getString("NgaySinh");
				String DiaChi = rs.getString("DiaChi");
				String GioiTinh = rs.getString("GioiTinh");
				String ChucVu = rs.getString("ChucVu");
				Double MucLuong = rs.getDouble("MucLuong");
				int SoNgayLam = rs.getInt("SoNgayLam");
				NhanVien nv = new NhanVien(MaNV, Hoten, GioiTinh, NgaySinh, DiaChi, ChucVu, MucLuong, SoNgayLam);
				list.add(nv);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean capNhatNhanVien(String MaNV, String hoTen, String ngaySinh, String gioiTinh,
			String diaChi, String chucVu, double mucLuong, int soNgayLam) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE " + NhanVienHelper.tenBang + " SET " 
					+ "HoTen='" + hoTen + "',"
					+ "NgaySinh='" + ngaySinh + "',"
					+ "DiaChi='" + diaChi + "',"
					+ "GioiTinh='" + gioiTinh + "',"
					+ "ChucVu='" + chucVu + "',"
					+ "MucLuong=" + mucLuong +","
					+ "SoNgayLam=" + soNgayLam + " WHERE MaNV='" + MaNV +"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		NhanVienHelper nvh = new NhanVienHelper();
		try {
			//nvh.taoBang();
			//Date date = new Date();
			//SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			//df.format(date);
			//String date = "7-10-2013";
			//System.out.println(df.format(date));
			//NhanVien nvx = new NhanVien("NV1", "ThaoNguyen", "Nam",date , "HCM", "PhaChe", 15.5, 6);
			//nvh.themNhanVien(nvx);
			//ArrayList<NhanVien> list = nvh.layTatCaNhanVien();
			//for (NhanVien nhanVien : list) {
			//	System.out.println(nhanVien);
			//}
			nvh.capNhatNhanVien("NV2", "Thao", "2-10-1995", "Nam", "HCM", "Boss", 20, 1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean themNhanVien(NhanVien nv) {
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO " + NhanVienHelper.tenBang + " VALUES("
					+ "'" + nv.getMaSoNV() + "',"
					+ "'" + nv.getHoTenNV() + "',"
					+ "'" + nv.getNgaySinh() + "',"
					+ "'" + nv.getDiaChi() + "',"
					+ "'" + nv.getGioiTinh() + "',"
					+ "'" + nv.getChucVu() + "',"
					+ nv.getMucLuong() + ","
					+ nv.getSoNgayLam() 
					+ ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
