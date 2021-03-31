package DBtask;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import UserGUI.CurFrame;
import UserTask.User;

public class updateTask {
	public static void main(String[] args) {

	}

	public static void updatePasswd(String id, String newPW) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			String sql = "update userdb set passwd = ? where id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newPW);
			pstmt.setString(2, id);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setLogin(User curr_user) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			String sql = "update userdb set islogin = ? where id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, 1);
			curr_user.setLogIn();
			pstmt.setString(2, curr_user.getID());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setLogOut(User curr_user) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			String sql = "update userdb set islogin = ? where id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, 0);
			curr_user.setLogOut();
			pstmt.setString(2, curr_user.getID());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setRentCount(String ID, int rent_count) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			String sql = "update userdb set rentcount = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rent_count);
			pstmt.setString(2, ID);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void updateBookBorrow(int book_id, Calendar today, Calendar due) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		selectTask selTask = new selectTask();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			//System.out.println(book_id);
			String sql = "update bookdb set BorrowTF = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "false");
			pstmt.setString(2, String.valueOf(book_id));
			
			pstmt.executeUpdate();

			sql = "update bookdb set rentDate = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, format.format(today.getTime()));
			pstmt.setInt(2, book_id);

			pstmt.executeUpdate();

			sql = "update bookdb set dueDate = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, format.format(due.getTime()));
			pstmt.setInt(2, book_id);

			pstmt.executeUpdate();

			int rent_freq = selTask.selectRentFreq(book_id);
			rent_freq++;

			sql = "update bookdb set rentFreq = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rent_freq);
			pstmt.setInt(2, book_id);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void updateBookReturn(int book_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			String sql = "update bookdb set BorrowTF = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "true");
			pstmt.setInt(2, book_id);

			pstmt.executeUpdate();

			sql = "update bookdb set rentDate = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setInt(2, book_id);

			pstmt.executeUpdate();

			sql = "update bookdb set dueDate = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setInt(2, book_id);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
