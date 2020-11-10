package Controller;

import java.util.List;
import java.util.Scanner;

import Container.Container;
import Service.ArticleService;
import dto.Article;
import dto.Board;

public class ArticleController {
	ArticleService articleService;

	public ArticleController() {
		articleService = Container.articleService;
	}

	public void run(Scanner sc, String cmd) {
		if (cmd.equals("article add")) {
			if (Container.session.loginedMember == null) {
				System.out.println("로그인 후 다시 시도하세요.");
				return;
			}
			if (Container.session.boardid == 0) {
				System.out.println("게시판 선택 후 다시 시도하세요");
			}

			System.out.println("== 게시물 생성 ==");
			System.out.println("제목 입력 : ");
			String title = sc.nextLine();
			System.out.println("내용 입력 : ");
			String body = sc.nextLine();
			articleService.add(title, body);
		} else if (cmd.equals("article makeboard")) {
			System.out.println("== 게시판 생성 ==");
			System.out.println("생성할 게시판 이름 입력 : ");
			String boardName = sc.nextLine();
			articleService.make(boardName);
		} else if (cmd.equals("article selectboard")) {
			System.out.println("선택할 게시판 이름 입력 : ");
			String inputName = sc.nextLine();
			if (getBoard(inputName) == 0) {
				System.out.println("존재하지 않는 게시판입니다.");
			}

			System.out.printf("%s 게시판으로 설정되었습니다.\n", inputName);
			Container.session.boardid = getBoard(inputName);

		} else if (cmd.equals("article list")) {
			
			System.out.println("== 게시물 리스트 == ");
			System.out.println("게시판이름  / 작성자 / 제목");
			
			for (int i = 0; i < articleService.getArticleSize(); i++) {
				System.out.println("aa");
				System.out.printf("%s  / %s   / %s\n", getBoardName(selectedArticles().get(i).boardId),getWriterName(selectedArticles().get(i).writerId), getArticle(selectedArticles().get(i).article_Index));
			}
		}

	}

	private String getBoardName(int i) {
		return articleService.getBoardName(i);
	}

	private String getWriterName(int i) {
		return Container.memberDao.getWriterName(i);
	}

	private int getBoard(String inputName) {
		return articleService.getBoard(inputName);

	}

	private String getArticle(int i) {
		return articleService.getArticle(i);
	}

	
	public List<Article> selectedArticles(){
		return articleService.selectedArticles();
	}

}
