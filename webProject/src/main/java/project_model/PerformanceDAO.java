package project_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_DTO.PerformanceVO;
import project_DTO.UserTableVO;
import project_util.DBUtil;

public class PerformanceDAO { // 기능을 구현하는데 DAO
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int resultCount;
	

	public List<PerformanceVO> getAllPerformances() {
		List<PerformanceVO> performance = new ArrayList<>();
		String sql = "select * from Performance";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				PerformanceVO pp = makePerformance(rs);
				performance.add(pp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return performance;
	}

	// 공연시작일이 빠른 순서로 나열
	public List<PerformanceVO> getPerformancesByStartDate() {
		List<PerformanceVO> performanceList = new ArrayList<>();  //배열,list,map 자료형
		String sql = "SELECT * FROM Performance ORDER BY p_sdate ASC"; // 시작일 오름차순 정렬
//order by 정렬해라
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {     //rs내용물이 있냐 없냐 있으면 반복문 돌아
				PerformanceVO performance = new PerformanceVO();
				// 필요한 데이터를 PerformanceVO 객체에 설정
				performance.setP_id(rs.getInt("p_id"));
				performance.setP_name(rs.getString("p_name"));
				performance.setP_sdate(rs.getString("p_sdate"));
				performance.setP_edate(rs.getString("p_edate"));
				performance.setP_director(rs.getString("p_director"));
				performance.setP_price(rs.getInt("p_price"));

				performanceList.add(performance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return performanceList;
	}

	public List<PerformanceVO> searchPerformancesByName(String searchName) {
		List<PerformanceVO> performanceList = new ArrayList<>();
		String sql = "SELECT * FROM Performance WHERE p_name LIKE ?"; // 부분 일치 검색
		// where : 조건
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, "%" + searchName + "%"); // 입력된 검색어와 부분 일치하는 데이터 검색

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					PerformanceVO performance = new PerformanceVO();
					// 필요한 데이터를 PerformanceVO 객체에 설정
					performance.setP_id(rs.getInt("p_id"));
					performance.setP_name(rs.getString("p_name"));
					performance.setP_sdate(rs.getString("p_sdate"));
					performance.setP_edate(rs.getString("p_edate"));
					performance.setP_director(rs.getString("p_director"));
					performance.setP_price(rs.getInt("p_price"));

					performanceList.add(performance);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return performanceList;
	}

	public List<PerformanceVO> searchPerformancesByDirector(String searchDirector) {
		List<PerformanceVO> performanceList = new ArrayList<>();
		String sql = "SELECT * FROM Performance WHERE p_director LIKE ?"; // 부분 일치 검색

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, "%" + searchDirector + "%"); // 입력된 감독 이름과 부분 일치하는 데이터 검색

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					PerformanceVO performance = new PerformanceVO();
					// 필요한 데이터를 PerformanceVO 객체에 설정
					performance.setP_id(rs.getInt("p_id"));
					performance.setP_name(rs.getString("p_name"));
					performance.setP_sdate(rs.getString("p_sdate"));
					performance.setP_edate(rs.getString("p_edate"));
					performance.setP_director(rs.getString("p_director"));
					performance.setP_price(rs.getInt("p_price"));

					performanceList.add(performance);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return performanceList;
	}

	public PerformanceVO getPerformanceById(int performanceId) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		PerformanceVO performance = null;

		try {
			conn = DBUtil.getConnection(); // 디비에 연결해
			String sql = "SELECT * FROM Performance WHERE p_id = ?"; // sql
			pst = conn.prepareStatement(sql);
			pst.setInt(1, performanceId);
			rs = pst.executeQuery();

			if (rs.next()) { // rs에 뭔가가 있으면 퍼포먼스에 담아
				performance = makePerformance(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return performance;
	}

	private PerformanceVO makePerformance(ResultSet rs) throws SQLException {
		PerformanceVO performance = new PerformanceVO();
		performance.setP_id(rs.getInt("p_id"));
		performance.setP_name(rs.getString("p_name"));
		performance.setP_sdate(rs.getString("p_sdate"));
		performance.setP_edate(rs.getString("p_edate"));
		performance.setP_director(rs.getString("p_director"));
		performance.setP_price(rs.getInt("p_price"));
		return performance;
	}





}