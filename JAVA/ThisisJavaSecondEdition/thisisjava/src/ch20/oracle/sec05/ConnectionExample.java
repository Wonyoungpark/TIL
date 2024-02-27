package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB","scott","TIGER")){
				System.out.println("연결 성공");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("연결 끊김");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}