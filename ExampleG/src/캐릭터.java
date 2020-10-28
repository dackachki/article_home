import java.util.Calendar;

public class 캐릭터 {
	int 번호;
	String 이름;
	String 직업;
	int 태어난해;
	void 자기소개() {
		System.out.println("== 자기소개 시작 ==");
		System.out.printf("번호 : %d\n",번호);
		System.out.printf("이름 : %s\n",이름);
		System.out.printf("직업 : %s\n",직업);
		System.out.printf("태어난 해 : %d\n",태어난해);
		System.out.printf("나이 : %d\n",나이계산());
	}
	int 나이계산() {
		int 올해 = Calendar.getInstance().get(Calendar.YEAR);
		return 올해 - 태어난해;
	}
}


class 의적 extends 캐릭터 {
	의적(){
		직업 = "의적";
	}
}
class 도적 extends 캐릭터 {
	도적(){
		직업 = "도적";
	}
}
class 상인 extends 캐릭터 {
	상인(){
		직업 = "상인";
	}
}