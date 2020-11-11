package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Article;

public class ConnectDB {
	String driver = "org.mariadb.jdbc.Driver";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	ArticleDao articleDao;
	Article article = new Article();
	
	public ConnectDB() {
		ArrayList<Article> articles = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/a1", "namsw", "ska78");

			// DB와 연결된 conn 객체로부터 Statement 객체 획득.
			stmt = con.createStatement();

			String sql = ("select * from article;");
			// query문 날리기
			pstmt = con.prepareStatement(sql.toString());
			stmt.execute(sql);
			rs =pstmt.executeQuery();
			
			
				System.out.println("번호/           날짜         / 작성자 /    제목    /조회수");
			while (rs.next()) {
				int index = 1;
				int id = rs.getInt(index++);
				String date = rs.getString(index++);
				String writer = rs.getString(index++);
				String title = rs.getString(index++);
				int hit = rs.getInt(index++);
				System.out.printf("%d / %s / %s / %s / %d\n",id,date,writer,title,hit);
				id = article.article_Index;
				date = article.date;
				writer = article.write;
				title = article.title;
				hit = article.hit;
				articles.add(article);
			}
			
			
			
			
			
			
			
			
			
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패"+e);
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
	}

}
