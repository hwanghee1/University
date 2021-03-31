package DBtask;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import UserTask.User;

public class selectTask {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾고자 하는 회원의 이름을 입력하십시오 : ");
		String search_text = sc.nextLine();
		
		selectUserDB(search_text);
	}
	public static User selectUserDB(String searchname) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		User curr_user = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			stmt = conn.createStatement();
			String sql = "select * from userdb where name = " + "'" + searchname + "'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String ID = rs.getString(1);
				String passwd = rs.getString(2);
				String name = rs.getString(3);
				int studentNum = rs.getInt(4);
				int grades = rs.getInt(5);
				String major = rs.getString(6);
				String phoneNum = rs.getString(7);
				String preferGenre = rs.getString(8);
				int rent_count = rs.getInt(9);
				int is_login = rs.getInt(10);
				
				curr_user = new User(ID,passwd,name,studentNum,grades,major,phoneNum,preferGenre,rent_count,is_login);
				return curr_user;
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
		catch(SQLException e) {
			System.out.println("에러 : " + e);
		}
		finally {
			try {
				
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return curr_user;
	}
	public static String seletForLogin(String ID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String correct_passwd = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			stmt = conn.createStatement();
			String sql = "select passwd from userdb where name = " + "'" + ID + "'";
			
			rs = stmt.executeQuery(sql);
			
			correct_passwd = rs.getString(1);
			
			return correct_passwd;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return correct_passwd;
	}
}
