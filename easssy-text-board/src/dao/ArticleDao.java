package dao;

import java.util.ArrayList;
import java.util.List;

import Container.Container;
import dto.Article;
import dto.Board;

public class ArticleDao {
	private List<Article> articles;
	private List<Board> boards;
	private int article_Index;
	private int board_Index;
	public List<Article> articlesByBoard; 
	private int boardid;
	public ArticleDao(){
		articles = new ArrayList<>();
		boards = new ArrayList<>();
		article_Index = 0;
		board_Index = 0;
		articlesByBoard = new ArrayList<>();
		make("자유");
		make("공지");
		boardid = Container.session.boardid;
		
	}
	public int add(String title, String body) {
		Article article = new Article();
		article.title = title;
		article.body = body;
		article.article_Index = article_Index+ 1;
		article_Index = article.article_Index;
		article.writerId = Container.session.loginedMemberid;
		article.boardId = Container.session.boardid;
		articles.add(article);
		System.out.println(articles);
		return article_Index;
		
	}
	public int make(String boardName) {
		Board board = new Board();
		board.boardName = boardName;
		board.board_Index = board_Index + 1;
		boards.add(board);
		board_Index= board.board_Index;
		System.out.println(boards);
		return board_Index;
	}

	public boolean isNameOK(String inputName) {
		for(Board board : boards) {
			if(board.boardName.equals(inputName)) {
				return true;
			}
		
		}
		return false;
	}
	public int getBoard(String inputName) {
		for(Board board : boards) {
			if(board.boardName.equals(inputName)) {
				return board.board_Index;}
			}
		return 0;
}
	public int getArticleSize() {
		return articlesByBoard.size();
	}
	public String getArticle(int i) {
		for(Article article : articles) {
			if(article.article_Index == i) {
				return article.title;


			}
			
			
		}
		return null;
	}
	public List<Board> getBoards() {
		return boards;
	}
	public String getBoardName(int i) {
		for(Board board : boards) {
			if(board.board_Index == i){
				return board.boardName;
			}
		}
		return null;
	}
	public List<Article> getArticlesByBoardId(int boardid) {
		List<Article> articlesByBoard = new ArrayList<>();
		for(Article article : articles) {
			if(article.boardId == boardid) {
				articlesByBoard.add(article);
				
			}
		}
		
		return null;
	}
	
	
}