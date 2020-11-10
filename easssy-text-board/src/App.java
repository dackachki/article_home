import java.util.Scanner;

import Container.Container;
import Controller.ArticleController;
import Controller.MemberController;

public class App {
	MemberController memberController;
	ArticleController articleController;

	public void run() {
		memberController = new MemberController();
		articleController = new ArticleController();
			Scanner sc = Container.sc;
			
			while (true) {
				System.out.printf("명령어 입력 : ");
				String cmd = sc.nextLine();
				
				if(cmd.startsWith("member")) {
					memberController.run(sc,cmd);
				}
				else if(cmd.startsWith("article")) {
					articleController.run(sc,cmd);
				}
				else if(cmd.equals("exit")) {
					System.out.println("프로그램 종료");
					break;
				}
			}
	sc.close();
	}
	

}
