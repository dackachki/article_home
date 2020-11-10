package dto;

public class Article {
	public int article_Index;
	public String title;
	public String body;
	public int boardId;
	public int writerId;
	@Override
	public String toString() {
		return "Article [article_Index=" + article_Index + ", title=" + title + ", body=" + body + ", boardId="
				+ boardId + ", writerId=" + writerId + "]";
	}
}
