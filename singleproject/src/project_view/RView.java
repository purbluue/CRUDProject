package project_view;

import java.util.List;

import project_DTO.PerformanceVO;
import project_DTO.UserTableVO;

public class RView {    //(같은 메서드 이름인데 ()안이 다르면 오버로딩)
	
		public static void print(int count) {
			System.out.println(count);		
		}

		
	    public static void print(String message) {
	        System.out.println("--------------------");
	        System.out.println(message);
	        System.out.println("--------------------");
		}
	    /*
	    public static void print(List<PerformanceVO> performances) {
	        for (PerformanceVO performance : performances) {
	            System.out.println(performance.toString()); // PerformanceVO의 toString 메서드 활용
	        }*/
	    
		public static void print(UserTableVO user) {
			System.out.println("-------------------");
			System.out.println(user);
			System.out.println("-------------------");
		}
		
		public static <T> void print(List<T> items) {
		    for (T item : items) {
		        System.out.println(item.toString());
		    }
		}
		/*
		public static void print(List<UserTableVO> Userlist) {
			System.out.println("-------dept(여러건)-------");
			Userlist.stream().forEach(user->{
				System.out.println(user);
			});
			System.out.println("--------------");
		} */
}
