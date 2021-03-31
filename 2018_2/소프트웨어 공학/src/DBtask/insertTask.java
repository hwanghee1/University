package DBtask;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CancellationException;

import UserGUI.CurFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class insertTask {
	
	public static void insertSignUpDB(String ID, String passwd, String name, int studentNum, int grades, String major, String phoneNum, String preferGenre) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "insert into sign_up values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ID);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setInt(4, studentNum);
			pstmt.setInt(5, grades);
			pstmt.setString(6, major);
			pstmt.setString(7, phoneNum);
			pstmt.setString(8, preferGenre);
			
			pstmt.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
		catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertUserDB(String searchID, String searchName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			stmt = conn.createStatement();
			String sql = "select * from sign_up where name = " + "'" + searchName + "' && id = " + "'" + searchID + "'";
			
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
				
				sql = "insert into userdb values(?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, ID);
				pstmt.setString(2, passwd);
				pstmt.setString(3, name);
				pstmt.setInt(4, studentNum);
				pstmt.setInt(5, grades);
				pstmt.setString(6, major);
				pstmt.setString(7, phoneNum);
				pstmt.setString(8, preferGenre);
				pstmt.setInt(9, 5);
				pstmt.setInt(10, 0);
			}
				
			
			
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("데이터 입력 실패!");
			}
			else {
				System.out.println("데이터 입력 성공!");
			}
		}
		catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertBookDB(int ID, String name, String author, String picture, String publisher, String genre, String major) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "insert into bookdb values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setString(3, author);
			pstmt.setString(4, picture);
			pstmt.setString(5, publisher);
			pstmt.setString(6, genre);
			pstmt.setString(7, major);
			pstmt.setString(8,"true");
			pstmt.setInt(9, 0);
			pstmt.setNull(10, 0);
			pstmt.setNull(11, 0);
			
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("데이터 입력 실패!");
			}
			else {
				System.out.println("데이터 입력 성공!");
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
		catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertBorrowDB(String ID, String name, int bookNum, String bookName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Date today = new Date();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			cal.add(Calendar.DAY_OF_MONTH, 5);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "insert into borrowdb values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ID);
			pstmt.setString(2, name);
			pstmt.setInt(3, bookNum);
			pstmt.setString(4, bookName);
			pstmt.setString(5, format.format(today));
			pstmt.setString(6, format.format(cal.getTime()));
			
			pstmt.executeUpdate();
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
		catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertZZimDB(String user_id,String user_name, int book_id,String book_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "insert into zzimdb values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_name);
			pstmt.setInt(3, book_id);
			pstmt.setString(4, book_name);
			
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("데이터 입력 실패!");
			}
			else {
				System.out.println("데이터 입력 성공!");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
		catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
