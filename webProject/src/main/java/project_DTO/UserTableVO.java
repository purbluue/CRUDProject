package project_DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserTableVO {    //클래스 안에는 변수,생성자,메소드 필요
		
	private int user_no;
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_phone;
	private String user_email;


	public UserTableVO(String user_id, String user_name, String user_password, String user_phone,
			String user_email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_phone = user_phone;
		this.user_email = user_email;
	}
	
	@Override
	public String toString() {
		return "UserTableVO [user_no="+ user_no+",user_id=" + user_id + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_phone=" + user_phone + ", user_email=" + user_email
				+ "]";
	}

}
