package project_model;

import project_DTO.UserTableVO;

public class UserTableService {
	UserTableDAO udao = new UserTableDAO();
	
	
	public UserTableVO getMyUserInfo(String user_id) {
		return udao.getMyUserInfo(user_id);
	}

	public UserTableVO logincheck(String userid, String user_password) {
		return udao.logincheck(userid, user_password);
		
	}
	public int insertUser(UserTableVO user) {
		return udao.insertUserTable(user);
	}
	
	public int userdelete(String user_id) {
		return udao.userdelete(user_id);
		
	}

	public UserTableVO getUpdateUser(String user_id,String reuser_id, String reuser_name,String reuser_password, String reuser_phone, String reuser_email) {
		 return udao.getUpdateUser(user_id, reuser_id, reuser_name,reuser_password, reuser_phone, reuser_email);
	}

	public int login(String user_id, String user_password) {
		return udao.login(user_id, user_password);
	}

}
