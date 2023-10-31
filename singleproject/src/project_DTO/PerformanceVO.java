package project_DTO;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class PerformanceVO {
	private int p_id;
	private String p_name;
	private String p_sdate;
	private String p_edate;
	private String p_director;
	private int p_price;

}
