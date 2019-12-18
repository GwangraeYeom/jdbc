package test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			//1. JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기
			String url ="";
			DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패:" + e);
		} catch (SQLException e) {
			System.out.println("에러");
		}
		
	}

}
