package Container;

import java.util.Scanner;
import java.sql.*;
import Service.ArticleService;
import Service.MemberService;
import Session.Session;
import dao.ArticleDao;
import dao.MemberDao;

public class Container {

	public static Scanner sc;
	public static MemberDao memberDao;
	public static MemberService memberService;
	public static Session session;
	public static ArticleService articleService;
	public static ArticleDao articleDao;
	String driver = "org.mariadb.jdbc.Driver";
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		sc = new Scanner(System.in);
		session = new Session();
		
		memberDao = new MemberDao();
		memberService = new MemberService();
		
		articleDao = new ArticleDao();
		articleService = new ArticleService();
		
	}
	
}
