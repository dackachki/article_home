package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class ConnectDB {
    String driver = "org.mariadb.jdbc.Driver";
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt;
 
    public ConnectDB() {
         try {
            Class.forName(driver);
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/a2",
                    "sbsst",
                    "sbs123414");

            //DB와 연결된 conn 객체로부터 Statement 객체 획득.
            stmt = con.createStatement();
 
           String sql = ("select * from article limit 1;");
            //query문 날리기
            stmt.execute(sql);
            rs = stmt.executequery(sql);
            
            System.out.println(stmt);
            
            if( con != null ) {
                System.out.println("DB 접속 성공");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
    	ConnectDB connectDB    = new ConnectDB();
    }
}
