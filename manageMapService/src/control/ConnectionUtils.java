package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static Connection con = null;
	
	private ConnectionUtils() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver"
											+ "://localhost:1433;databasename=appCoffee",
											  "sa", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(con == null)
			new ConnectionUtils();
		return con;
	}
	
	public void closeConnect() throws SQLException {
		if(con!=null)
			con.close();
	}
	
	/*public static void main(String[] args) {
		Connection con = new ConnectionUtils().getConnection();
		if(con!=null) {
			System.out.println("oke");
		}
	}*/
	
	
	
}
