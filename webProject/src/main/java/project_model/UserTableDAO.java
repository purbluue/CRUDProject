package project_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project_DTO.UserTableVO;
import project_util.DBUtil;

public class UserTableDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int resultCount;

	public int insertUserTable(UserTableVO user) {
		String sql = "insert into UserTable(user_no,user_id, user_name, user_password, user_phone, user_email) values(UserTable_SEQ.NEXTVAL,?, ?, ?, ?, ?)";
		// UserTable_SEQ.NEXTVAL
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getUser_name());
			pst.setString(3, user.getUser_password());
			pst.setString(4, user.getUser_phone());
			pst.setString(5, user.getUser_email());
			//rs = pst.executeQuery(); // executeQuery pst.를 실행시켜라 sql에rs로 받아와라
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return resultCount;
	}

	public UserTableVO getUpdateUser(String user_id, String reuser_id, String reuser_name, String reuser_password,
			String reuser_phone, String reuser_email) {
		String sql = "UPDATE UserTable SET user_id = ?, user_password = ? ,user_name = ?,user_phone =? ,user_email = ?WHERE  user_id = ?";
		UserTableVO user = new UserTableVO();
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, reuser_id);
			pst.setString(2, reuser_password);
			pst.setString(4, reuser_phone);
			pst.setString(5, reuser_email);
			pst.setString(6, user_id);
			pst.setString(3, reuser_name);
			rs = pst.executeQuery();
			while (rs.next()) {
				user.setUser_email(rs.getString("user_email"));
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_phone(rs.getString("user_phone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return user;
	}

	public UserTableVO logincheck(String user_id, String user_password) {

		UserTableVO user = null;
		String sql = "select * from UserTable where user_id = ? and user_password = ? ";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			pst.setString(2, user_password);
			rs = pst.executeQuery();
			if (rs.next()) {

				user = makeUser(rs);
				// reset에서 읽어서 VO만들기

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return user;
	}

	public int userdelete(String user_id) { // 기능구현자리
		UserTableVO user = null;
		String sql = "DELETE FROM UserTable WHERE user_id = ? ";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = makeUser(rs);
				// reset에서 읽어서 VO만들기
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return resultCount;
	}

	private UserTableVO makeUser(ResultSet rs) throws SQLException {
		UserTableVO userInfo = new UserTableVO();
		userInfo.setUser_id(rs.getString("user_id"));
		userInfo.setUser_name(rs.getString("user_name"));
		userInfo.setUser_password(rs.getString("user_password"));
		userInfo.setUser_phone(rs.getString("user_phone"));
		userInfo.setUser_email(rs.getString("user_email"));
		return userInfo;
	}

	public UserTableVO getMyUserInfo(String user_id) {
		UserTableVO user = new UserTableVO();
		String sql = "SELECT * FROM UserTable WHERE user_id = ? ";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				user.setUser_no(rs.getInt("user_no"));
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_email(rs.getString("user_email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int login(String user_id, String user_password) {
		String sql = "select user_password from UserTable where user_id =? ";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			rs = pst.executeQuery();
			while (rs.next()) { // next 처음부터 순차적으로 확인 (?)
				if (rs.getString("user_password").equals(user_password)) { // if는 참일때 실행
					resultCount = 1;
				} else {
					resultCount = 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return resultCount;
	}

}
