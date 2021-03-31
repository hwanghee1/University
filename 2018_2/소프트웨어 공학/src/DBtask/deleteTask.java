package DBtask;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException;

import UserGUI.CurFrame; 


public class deleteTask {
	
	public static void deleteBookDB(String bookID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "delete from bookdb where ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookID);
			
			pstmt.executeUpdate();
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
				if(pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void deleteSignUpDB(String ID, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "delete from sign_up where id = ? && name = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
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
				if(pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void deleteBorrowDB(String id, int book_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "delete from borrowdb where id = ? && BookNum = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2, book_num);
			
			pstmt.executeUpdate();
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
				if(pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void deleteZZimDB(String id, int book_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
			
			String sql = "delete from zzimdb where id = ? && BookNum = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2, book_num);
			
			pstmt.executeUpdate();
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
				if(pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
