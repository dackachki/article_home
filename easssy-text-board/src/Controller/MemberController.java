package Controller;

import java.util.Scanner;

import Container.Container;
import Service.MemberService;
import dto.Member;

public class MemberController {
	MemberService memberService;

	public MemberController() {
		memberService = Container.memberService;
	}

	public void run(Scanner sc, String cmd) {

		if (cmd.equals("member join")) {
			System.out.println("== 회원 생성 ==");
			System.out.printf("이름 입력 : ");
			String name = sc.nextLine();
			System.out.printf("생성할 아이디 입력 : ");
			String loginId = sc.nextLine();
			System.out.printf("비밀번호 입력 : ");
			String passwd = sc.nextLine();

			memberService.join(name, loginId, passwd);
		}
		if (cmd.equals("member login")) {
			System.out.printf("로그인 아이디 : ");
			String inputid = sc.nextLine();
			Member tryMember = memberService.isMemberExist(inputid);
			if (tryMember == null) {
				System.out.println("존재하지 않는 아이디 입니다.");
				return;
			}
			System.out.println("비밀번호 입력 : ");
			String passwd = sc.nextLine();
			if (tryMember.passwd.equals(passwd)) {
				System.out.printf("%s님 환영합니다.\n", tryMember.name);
				Container.session.loginedMember = tryMember;
				Container.session.loginedMemberid = tryMember.memberIndex;
			}
			if (tryMember.passwd.equals(passwd) == false) {
				System.out.println("비밀번호가 틀립니다 다시 시도하세요.");
				return;
			}

		}

	}

}
