package Conception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import Generate.G_Member;

public class Member {
	DBconnect db = new DBconnect();
	ArrayList<G_Member> list = new ArrayList<G_Member>();
	Scanner sc = new Scanner(System.in);

	public void sign_Up() { // 가입
		String id;
		while (true) {
			System.out.print("ID: ");
			id = sc.nextLine();
			if (dup_check(id) != false) {
				break;
			}
		}
		System.out.print("PW: ");
		String pw = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("번호: ");
		String phone = sc.nextLine();

		String sql = "insert into member(m_id,m_pw,m_name,m_phone) values ('" + id + "','" + pw + "','" + name + "','"
				+ phone + "')";
		db.DbUpdate(sql);
	}

	public boolean dup_check(String id) { // 중복 체크
		String sql = "select * from member where m_id='" + id + "'";
		try {
			db.rs = db.Dblistup(sql);
			if (db.rs.next()) {
				System.out.println("중복입니다.");
				return false;
				
				
			} else {
				System.out.println("통과");
				return true;
				
			}
		} catch (Exception e) {
			System.out.println("db연결 실패");
			e.printStackTrace();
			return false;
		}
		

	}

	public ArrayList<G_Member> Search_Member(String sql) { // DB에서 정보 조회(중복 방지용)

		try {
			db.rs = db.Dblistup(sql);
			if (db.rs.next()==false) {
				System.out.println("틀린 정보입니다. 다시 입력해 주세요");
				return list;
			}
			db.rs.beforeFirst();
			while (db.rs.next()) {
				String phone = db.rs.getString("m_phone");
				String m_pw = db.rs.getString("m_pw");
				String name = db.rs.getString("m_name");
				String m_id = db.rs.getString("m_id");
				G_Member mb = new G_Member(phone, m_pw, name, m_id);
				list.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db연결 실패");
		}
		return list;

	}

	public G_Member Sign_in(String id, String pw) { // 로그인 -> DB
		String sql = "select * from member where m_id = '" + id + "' and m_pw = '" + pw + "'";
		list = Search_Member(sql);
		if (list == null) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public void Del_id(String id, String pw) { // 탈퇴 -> DB
		G_Member mb = Sign_in(id, pw);
		if (mb == null) {
			System.out.println("불일치");
		} else {
			String sql = "delete from member where m_phone ='" + mb.getM_phone() + "'";
			System.out.println("탈퇴가 완료되었습니다.");
			db.DbUpdate(sql);
		}

	}

	public void Find_id(String name, String phone) { // 아이디/비밀번호 찾기 -> DB
		String sql = "select * from member where m_name = '" + name + "' and m_phone = '" + phone + "'";
		G_Member mb = null;
		try {
			db.rs = db.Dblistup(sql);
			if (db.rs.next()) {
				String m_pw = db.rs.getString("m_pw");
				String m_id = db.rs.getString("m_id");
				mb = new G_Member(phone, m_pw, name, m_id);
				System.out.print("ID: "+mb.getM_id()+"\n");
			} else {
				System.out.println("정보를 찾을수 없습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db연결 실패");
		}
	}

	public void Find_PW(String id, String phone) { // 아이디/비밀번호 찾기 -> DB
		String sql = "select * from member where m_id = '" + id + "' and m_phone = '" + phone + "'";
		G_Member mb = null;
		try {
			db.rs = db.Dblistup(sql);
			if (db.rs.next()) {
				String name = db.rs.getString("m_name");
				String m_pw = db.rs.getString("m_pw");
				mb = new G_Member(phone, m_pw, name, id);
				System.out.print("PW: "+mb.getM_pw()+"\n");
			}else {
				System.out.println("정보를 찾을수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db연결 실패");
		}

	}

	public void Change_PW(String id, String pw) { // 비밀번호 변경 -> DB
		G_Member mb = Sign_in(id, pw);
		if (mb == null) {
			System.out.println("불일치");
		} else {
			System.out.print("새로운 비밀번호 입력: ");
			String newPw = sc.nextLine();
			String sql = "update member set m_pw ='" + newPw + "' where m_phone='" + mb.getM_phone() + "'";
			db.DbUpdate(sql);

		}
	}
}
