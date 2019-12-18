package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		Boolean result = insert("도", "우넛", "donut@gmail.com");
		System.out.println(result);
		
		result = insert("또", "치", "ddochi@gmail.com");
		System.out.println(result);
	}	
	
	public static Boolean insert(String firstName, String lastName, String email) {
		Boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			//1. JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
	
			//3. Statement 객체 생성
			stmt = conn.createStatement();			
		
			//4. SQL문 실행
			String sql = 
				" insert" + 
				"   into emaillist" +
				" values (null, '"+ firstName + "', '" + lastName + "', '" + email + "')"; 
			
			int count = stmt.executeUpdate(sql);
			result = (count == 1);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}