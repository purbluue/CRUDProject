package project_test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project_util.DBUtil;

public class DBConnectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// DB 연결
			conn = DBUtil.getConnection();

			// 쿼리 실행을 위한 Statement 생성
			stmt = conn.createStatement();

			// 간단한 테스트 쿼리 실행
			String query = "SELECT 'Hello, World!' AS test_message FROM dual";
			rs = stmt.executeQuery(query);

			// 결과 출력
			if (rs.next()) {
				String message = rs.getString("test_message");
				System.out.println("DB 연결 성공: " + message);
			} else {
				System.out.println("DB 연결 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			DBUtil.dbDisconnect(conn, stmt, rs);
		}
	}
}