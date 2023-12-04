package dBcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {

	public static Connection getConnection() {
//		InputStream();
		Connection connection = null;

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버 로드
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // DB 연결
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException 오류");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DBcon");
		return connection;
	}

	public static void main(String[] args) {
		getConnection();
	}
}
