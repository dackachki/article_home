package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDao {
	private List<Member> members;
	private int member_Index;

	public MemberDao() {
		members = new ArrayList<>();
		member_Index = 0;
		join("aaa","aaa","aaa");
		join("bbb","bbb","bbb");
	}

	public int join(String name, String loginId, String passwd) {
		Member member = new Member();
		member.loginId = loginId;
		member.memberIndex = member_Index + 1;
		member.name = name;
		member.passwd = passwd;
		member_Index = member.memberIndex;
		members.add(member);
		System.out.println(members);
		return member_Index;

	}

	

	public Member isMemberExist(String inputid) {
		for(Member member :members) {
			if(member.loginId.equals(inputid))
				return member;
		}
		return null;
	}
	public List<Member> getMembers() {
		return members;
	}

	public String getWriterName(int i) {
		for(Member member : members) {
			if(member.memberIndex == i) {
				return member.loginId;
			}
		}
		return null;
	}
	
}