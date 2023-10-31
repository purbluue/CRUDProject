package project_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	// DB 연결
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "ut", password = "1234";
		Connection conn = null; // 연결

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// ClassNotFoundException 처리
		} catch (SQLException e) {
			e.printStackTrace();
			// SQLException 처리
		}
		return conn;
	}

	// 자원 반환 (DB 연결 해제, statement 해제, ResultSet 해제)
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// SQLException 처리
		}
	}
}