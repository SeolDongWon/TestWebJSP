package DBcon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBcon {
	public static Connection getConnection() {
		Connection connection = null;

		FileInputStream fileInputStream = null;
		Properties properties = new Properties();
		try {
//			fileInputStream = new FileInputStream("db.properties"); //경로챶기 웨안뒘???
//			properties.load(fileInputStream);
////			==========================================================================경로찾기 실패로 작동 안함
//			String driver = properties.getProperty("driver"); // 드라이버 클래스 경로
//			String url = properties.getProperty("url"); // 아이피 포트번호
//			String username = properties.getProperty("username");
//			String password = properties.getProperty("password");
//			Class.forName(driver); // JDBC 드라이버 로드
//			connection = DriverManager.getConnection(url, username, password); // DB 연결
//			==========================================================================경로찾기 실패로 작동 안함	
			Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버 로드
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // DB 연결

//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("FileNotFoundException 오류");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("IOException 오류");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException 오류");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		}
		return connection;
	}

	public static void main(String[] args) {
		getConnection();
	}
}
