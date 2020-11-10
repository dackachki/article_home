package Service;

import Container.Container;
import dao.MemberDao;
import dto.Member;

public class MemberService {
	MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public int join(String name, String loginId, String passwd) {
		return memberDao.join(name, loginId, passwd);

	}

	public Member isMemberExist(String inputid) {
		return memberDao.isMemberExist(inputid);

	}

}
