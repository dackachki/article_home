package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Container.Container;
import dto.Article;

public class ConnectDB {
	String driver = "org.mariadb.jdbc.Driver";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	
	Scanner sc;
	
	
	public ConnectDB() {
	
				
		try {
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/a2", "sbsst", "sbs123414");

			
			stmt = con.createStatement();

			String sql = ("select * from article limit 3;");
			
			pstmt = con.prepareStatement(sql.toString());
			stmt.execute(sql);
			rs =pstmt.executeQuery();
			
			
			while (rs.next()) {
				int index = 1;
				int id = rs.getInt(index++);
				String date = rs.getString(index++);
				String writer = rs.getString(index++);
				String title = rs.getString(index++);
				String body = rs.getString(index++);
				int hit = rs.getInt(index++);
				System.out.printf("%d / %s / %s / %s / %s  / %d\n",id,date,writer,body,title,hit);
			
			}
			
			
			
			
			
			
			
			
			
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("�뱶�씪�씠踰� 濡쒕뱶 �떎�뙣"+e);
		} catch (SQLException e) {
			System.out.println("DB �젒�냽 �떎�뙣");
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
		
	}

}
