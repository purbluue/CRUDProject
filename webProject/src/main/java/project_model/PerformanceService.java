package project_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project_DTO.PerformanceVO;
import project_DTO.UserTableVO;
import project_util.DBUtil;

public class PerformanceService {

	PerformanceDAO dao = new PerformanceDAO(); // PerformanceDAO 객체 생성
	public List<PerformanceVO> getAllPerformances() {
		return dao.getAllPerformances();
	}

	public List<PerformanceVO> getPerformancesByStartDate() {
		return dao.getPerformancesByStartDate();
	}

	public List<PerformanceVO> searchPerformancesByName(String searchName) {
		return dao.searchPerformancesByName(searchName);
	}

	public List<PerformanceVO> searchPerformancesByDirector(String searchDirector) {
		return dao.searchPerformancesByDirector(searchDirector);
	}

	public PerformanceVO getPerformanceById(int performanceId) {
		return dao.getPerformanceById(performanceId);
	}
	

	


	
} 
