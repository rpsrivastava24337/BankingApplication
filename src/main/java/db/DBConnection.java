package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con;

	static {

		try {
			Class.forName(DBInfo.DRIVER);
			con = DriverManager.getConnection(DBInfo.DBURL, DBInfo.USERNAME, DBInfo.PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private DBConnection() {
	}

	public static Connection getCon() {
		return con;

	}

}
