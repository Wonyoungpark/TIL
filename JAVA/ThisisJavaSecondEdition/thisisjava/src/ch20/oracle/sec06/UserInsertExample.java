package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB","scott","TIGER");
			System.out.println("연결 성공");
			
			//DB작업
			String sql = "insert into users values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
				}
				System.out.println("연결 끊김");
			}
		}
	}
}
