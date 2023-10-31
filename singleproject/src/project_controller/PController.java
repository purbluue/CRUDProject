package project_controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import project_DTO.PerformanceVO;
import project_DTO.UserTableVO;
import project_model.PerformanceService;
import project_model.UserTableService;
import project_util.DBUtil;
import project_view.RView;

public class PController {
	private static PerformanceService pservice = new PerformanceService();
	private static UserTableService uservice = new UserTableService(); 
	private static final String PHONEPATTERN = "^010-[0-9]{4}-[0-9]{4}$";
	private static String user_id = null; // 사용자 로그인 상태를 저장하는 변수
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isRun = true;

		a: while (isRun) {
			System.out.println();
			System.out.println("=========================");
			System.out.println("1.로그인 | 2.회원가입 | 3.종료");
			System.out.println("=========================");
			System.out.println("선택>>");
			int job = sc.nextInt();
			if (job == 3) {
				RView.print("프로그램을 종료합니다.");
				break;
			}
			switch (job) {
			// 로그인
			case 1: {
				if (login(sc) == 0)
					continue;
				else
					break;
			}
			// 회원가입
			case 2: {
				join(sc);
				continue;
			}
			
			default: {
				System.out.println("다시 선택하세요.");
				continue a;
			}
			}

			b: while (isRun) { // 로그인 상태인 경우
				System.out.println();
				System.out.println("========================================================");
				System.out.println("1.공연 정보 | 2.관심공연 등록 | 3.마이페이지 | 0.로그아웃 | 4.탈퇴 ");
				System.out.println("========================================================");
				System.out.println("선택>>");
				job = sc.nextInt();
				if (job == 0) { // 0.로그아웃
					user_id = null;
					System.out.println("로그아웃 되었습니다.");
					break;
				}
				if (job == 1) {
					System.out.println("공연 정보");
					System.out.println("=====================================================");
					System.out.println("1.전체 공연 조회 | 2.공연시작일 순으로 조회 | 3.검색 | 0.돌아가기");
					System.out.println("=====================================================");
					System.out.print("선택>> ");
					job = sc.nextInt();
					switch (job) {
					case 1: {
						System.out.println("전체 공연 조회");
						List<PerformanceVO> pList = pservice.getAllPerformances();
						RView.print(pList);
						break;
					}
					case 2: {
						System.out.println("공연시작일 순으로 조회");
						List<PerformanceVO> pListByStartDate = pservice.getPerformancesByStartDate();
						RView.print(pListByStartDate);
						break;
					}
					case 3: {
						System.out.println();
						System.out.println("검색 기능을 선택하세요.");
						System.out.println("==================================================");
						System.out.println("1. 공연 이름으로 검색 | 2. 연출가 이름으로 검색 | 0. 돌아가기");
						System.out.println("==================================================");
						System.out.print("선택>> ");
						int searchOption = sc.nextInt();

						switch (searchOption) {
						case 1: {
							System.out.println();
							System.out.print("검색할 공연 이름을 입력하세요: ");
							String searchName = sc.next();
							List<PerformanceVO> pListByName = pservice.searchPerformancesByName(searchName);
							RView.print(pListByName);
							break;
						}
						case 2: {
							System.out.println();
							System.out.print("검색할 연출가 이름을 입력하세요: ");
							String searchDirector = sc.next();
							List<PerformanceVO> pListByDirector = pservice.searchPerformancesByDirector(searchDirector);
							RView.print(pListByDirector);
							break;
						}
						case 0: {
							// 돌아가기
							break b;
						}
						default: {
							System.out.println("잘못된 선택입니다.");
							break;
						}
						}
						break;
					}
					}
			/*	} else if (job == 2) {
					// 2. 관심 공연 등록   */

				
				}else if (job == 3) {
					System.out.println("마이페이지");
					System.out.println("=====================================================");
					System.out.println("1.내 정보 조회 | 2.변경 | 3. | 0.돌아가기");
					System.out.println("=====================================================");
					System.out.print("선택>> ");
					job = sc.nextInt();
					switch (job) {
					case 1: {
						System.out.println(user_id);
						System.out.println("내 정보 조회");
						UserTableVO userInfo = uservice.getMyUserInfo(user_id);
						RView.print(userInfo);
						break;
						
					}case 2: {
						System.out.println("정보 변경");
						List<UserTableVO> ulist = uservice.getUpdateUser(user_id);
					}
						
					}
				
	}else if (job == 4) {
		int count = uservice.userdelete(user_id);
		RView.print(count > 0 ? "탈퇴가 완료되었습니다." : "탈퇴에 실패했습니다.");
		continue;
	}
	}
				
			
			}}

	// 로그인 메서드 구현
	private static int login(Scanner sc) {
		System.out.print("아이디를 입력하세요: ");
		String user_id = sc.next();
		System.out.print("비밀번호를 입력하세요: ");
		String user_password = sc.next();

		if (uservice.login(user_id, user_password) > 0) {
			System.out.println();
			System.out.print("로그인 성공");
			PController.user_id=user_id;
			return 1;
		} else {
			System.out.println();
			System.out.print("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
			return 0;
		}
	}

	private static void join(Scanner sc) {
		System.out.print("아이디를 입력하세요: ");
		String user_id = sc.next();
		System.out.print("이름을 입력하세요: ");
		String user_name = sc.next();
		System.out.print("비밀번호를 입력하세요: ");
		String user_password = sc.next();
		System.out.print("전화번호를 입력하세요: ");
		String user_phone = sc.next();
		System.out.print("이메일을 입력하세요: ");
		String user_email = sc.next();

		UserTableVO newUser = new UserTableVO(user_id, user_name, user_password, user_phone, user_email);
		int count = uservice.insertUser(newUser);
		RView.print(count > 0 ? "회원가입이 완료되었습니다." : "회원가입에 실패했습니다.");

	}
}