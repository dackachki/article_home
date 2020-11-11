package dto;

public class Article {
	public int article_Index;
	public String title;
	public String body;
	public String date;
	public String write;
	public int hit;
 
	public int boardId;
	public int writerId;
	
	public int getArticle_Index() {
		return article_Index;
	}
	public void setArticle_Index(int article_Index) {
		this.article_Index = article_Index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	
	@Override
	public String toString() {
		return "Article [article_Index=" + article_Index + ", title=" + title + ", body=" + body + ", boardId="
				+ boardId + ", writerId=" + writerId + "]";
	}
}
