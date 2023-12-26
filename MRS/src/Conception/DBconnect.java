package Conception;

import java.sql.*;


public class DBconnect { // db 연결

	// final 상수
	private static final String URL = "jdbc:mysql://localhost:3306/MRS?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	// DB 접근 변수
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	DBconnect() {
		conn = getConnection();
	}

	protected Connection getConnection() { // DB 접속
		Connection conn = null;

		try {
			// 1. 드라이버 세팅
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 획득
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			System.out.println("DB 작업중 문제 발생 : " + e.getMessage());
		}
		return conn;
	}

	public void DbUpdate(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("DB작업중 문제발생: " + e.getMessage());
			e.printStackTrace();

		}

	}
	public ResultSet Dblistup(String sql) {
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
			return null;
		}
		

	}
}
