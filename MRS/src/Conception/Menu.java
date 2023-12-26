package Conception;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Promt pt = new Promt();

	public void start() {

		pt.Menu_pt();

		int select = sc.nextInt();

		switch (select) {
		case 1:
			go_member();

			break;
		case 2:

			break;
		case 3:

			break;

		default:
			break;
		}
	}

	public void go_member() {
		Member mb = new Member();
		System.out.println("메뉴 출력");
		loop: while (true) {
			
			String num = sc.nextLine();
			switch (num) {
			case "1":// 회원 가입
				System.out.println("회원 가입");
				mb.sign_Up();
				break;
			case "2":// 회원 탈퇴
				System.out.println("탈퇴");
				String id = sc.nextLine();
				String pw = sc.nextLine();
				mb.Del_id(id, pw);
				break;
			case "3":// 회원 정보 찾기 및 변경
				System.out.println("찾기 변경");
				String menu_num = sc.nextLine();
				switch (menu_num) {
				case "1": {// 아이디 찾기
					System.out.println("id찾기 ");
					String name = sc.nextLine();
					String phone = sc.nextLine();
					mb.Find_id(name, phone);
					break;
				}
				case "2": {// pw 찾기
					System.out.println("pw찾기 ");
					String find_id = sc.nextLine();
					String phone = sc.nextLine();
					mb.Find_PW(find_id, phone);
					break;
				}
				case "3": {// 탈퇴
					System.out.println("탈퇴");
					String del_id = sc.nextLine();
					String del_pw = sc.nextLine();
					mb.Del_id(del_id, del_pw);
					break;
				}
				case "4": {// pw 변경
					System.out.println("pw 변경");
					String ch_id = sc.nextLine();
					String ch_pw = sc.nextLine();
					mb.Change_PW(ch_id, ch_pw);
				}

				}
			}
		}

	}

	public void go_admin() {
		Admin ad = new Admin();
	}

	public void go_book() {
		Book bk = new Book();
	}
}
