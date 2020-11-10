package dto;

public class Member {
	public int memberIndex;
	public String name;
	public String loginId;
	public String passwd;
	@Override
	public String toString() {
		return "Member [memberIndex=" + memberIndex + ", name=" + name + ", loginId=" + loginId + ", passwd=" + passwd
				+ "]";
	}
}
