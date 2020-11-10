package Service;

import java.util.List;

import Container.Container;
import dao.ArticleDao;
import dto.Article;
import dto.Board;

public class ArticleService {
	ArticleDao articleDao;
	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int add(String title, String body) {
		return articleDao.add(title,body);
	}

	public int make(String boardName) {
		return articleDao.make(boardName);
		
	}

	public boolean isNameOk(String inputName) {
		return articleDao.isNameOK(inputName);
	}

	public int getBoard(String inputName) {
		return articleDao.getBoard(inputName);
	}

	public int getArticleSize() {
		return articleDao.getArticleSize();
	}

	public String getArticle(int i) {
		return articleDao.getArticle(i);
		}

	public String getBoardName(int i) {
		return articleDao.getBoardName(i);
	}

	public List<Article> getArticlesByBoardId(int boardid) {
		return articleDao.getArticlesByBoardId(boardid);
	}
	public List<Article> selectedArticles(){
		return articleDao.articlesByBoard;
	}

	

}
