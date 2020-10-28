import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			캐릭터[] 캐릭터s = new 캐릭터[n];
			
			for( int i = 0; i < n; i++) {
				int 번호 = i+1;
				System.out.printf("이름 입력 : ");
				String 이름 = sc.next();
				System.out.printf("출생년도 입력 : ");
				int 출생년도 = Integer.parseInt(sc.next().replace("년",""));
				 
				캐릭터 임시캐릭터 = null;
				System.out.printf("직업 입력:");
				String 직업 = sc.next();
				if(직업.equals("의적")) {
					임시캐릭터 = new 의적();
				}
				else if(직업.equals("도적")) {
					임시캐릭터 = new 도적();
				}
				else if(직업.equals("상인")) {
					임시캐릭터 = new 상인();
				}
				
				
				임시캐릭터.번호 = 번호;
				임시캐릭터.이름 = 이름;
				임시캐릭터.태어난해 = 출생년도;
				
				캐릭터s[i] = 임시캐릭터;
				
				
				
			}
			
			for(int i = 0; i < n; i++) {
			String 능력치값 = sc.nextLine();
			int 능력치[] 능력치들 = Integer.parseInt(능력치값.split(","));
			}
			
			
	}

}
