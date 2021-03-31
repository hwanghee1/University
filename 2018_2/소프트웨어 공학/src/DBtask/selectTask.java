package DBtask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Exit_Listener;
import AdminTask.*;
import UserGUI.CurFrame;
import UserTask.User;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectTask {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	static int BookID;
	private String bookname;
	private String bookauthor;
	private String bookpublisher;
	private String bookgengre;
	private String bookpicture;


	public int getBookID() {
		return BookID;
	}

	public String getBookname() {
		return bookname;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public String getBookpublisher() {
		return bookpublisher;
	}

	public String getBookgengre() {
		return bookgengre;
	}

	public String getBookpicture() {
		return bookpicture;
	}

	public selectTask() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> 로드 fail");
		} catch (SQLException e) {
			System.out.println(e + "=> 연결 fail");
		}
	}

	public static boolean checkHadZZim(String user_id, int book_id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean check = false;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();

			String sql = "select bookNum from zzimdb where id = " + "'" + user_id + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (rs.getInt(1) == book_id) {
					check = true;
				} else {
				}
			}

		} catch (SQLException e) {
			return false;
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return check;
	}

	public static User selectUserDB(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		User curr_user;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			rs.next();

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

			curr_user = new User(ID, passwd, name, studentNum, grades, major, phoneNum, preferGenre, rent_count,
					is_login);

			return curr_user;

		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	public void AdminselectUserDB(DefaultTableModel model) {

		try {
			stmt = conn.createStatement();
			String sql = "select * from userDB ";
			rs = stmt.executeQuery(sql);

			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}

			while (rs.next()) {

				Object data[] = { rs.getString(1), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7) };

				model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void AdminselectBorrowUserDB(JTable t, DefaultTableModel model) {

		try {
			int row = t.getSelectedRow();
			String id = t.getValueAt(row, 0).toString();

			stmt = conn.createStatement();
			String sql = "select * from BorrowDB where id=" + "'" + id + "'";
			rs = stmt.executeQuery(sql);

			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = { rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) };
				model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void AdminselectBookDB(DefaultTableModel model) {
		String status = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from bookdb ";
			rs = stmt.executeQuery(sql);

			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}

			while (rs.next()) {
				if (rs.getBoolean(8)) {
					status = "가능";
				} else {
					status = "불가능";
				}

				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), status, rs.getString(9),
						rs.getString(10), rs.getString(11) };

				model.addRow(data);

				BookID = rs.getInt(1);

			}
			if (BookID == 0) {
				BookID = 11110;
			}

			BookID++;
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String existSignUpDB() {
		String data = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from sign_up order by id";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				data = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return data;
	}

	public void selectSignUpDB(DefaultTableModel model) {

		try {
			stmt = conn.createStatement();
			String sql = "select * from sign_up order by id";
			rs = stmt.executeQuery(sql);

			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}

			while (rs.next()) {

				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8) };

				model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static String seletForLogin(String ID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String correct_passwd = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/world?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();
			String sql = "select passwd from userdb where name = " + "'" + ID + "'";

			rs = stmt.executeQuery(sql);

			correct_passwd = rs.getString(1);

			return correct_passwd;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return correct_passwd;
	}

	public static String selectAdminPasswd(String ID) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String correct_passwd = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();

			String sql = "select passwd from admindb where id = " + "'" + ID + "'";

			rs = stmt.executeQuery(sql);

			rs.next();

			correct_passwd = rs.getString(1);
			return correct_passwd;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			throw new Exception("아이디가 존재하지 않습니다.");
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return correct_passwd;
	}

	public static void selectBorrowDB(String id, DefaultTableModel model) throws ParseException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();

			String sql = "select * from BorrowDB where id =" + "'" + id + "'";
			rs = stmt.executeQuery(sql);

			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = { rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) };
				String day = rs.getString(6);
				Date currentdate = new Date();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
				Date returnday = new SimpleDateFormat("yyyy-MM-dd").parse(day);

				if (returnday.before(currentdate)) {// 반납기한이 지낫을때
					JFrame Exists = new JFrame(""); // Fail프레임을 생성
					Exists.setPreferredSize(new Dimension(350, 150));// 크기지정
					JPanel p = new JPanel();
					JPanel pp = new JPanel();
					JPanel ppp = new JPanel();
					ppp.add(new JLabel("경고  " + rs.getString(4)));
					p.add(new JLabel("도서의  반납기한이 지났습니다."));

					JButton button11 = new JButton("확인");
					pp.add(button11);
					button11.addActionListener(new Exit_Listener(Exists));
					Exists.add(ppp, "North");
					Exists.add(p, "Center");
					Exists.add(pp, "South");
					Exists.pack(); // 프레임을 보여준다
					Exists.setLocation(830, 400);
					Exists.setAlwaysOnTop(true);
					Exists.setVisible(true); // 패널들을 보여준다
					model.addRow(data);

				} else {// 반납기한이 남앗을때
					model.addRow(data);
				}

			}

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void selectZZimDB(String id, DefaultTableModel model) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();

			String sql = "select * from zzimdb where id =" + "'" + id + "'";
			rs = stmt.executeQuery(sql);

			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = { rs.getString(3), rs.getString(4) };
				model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<User_book> RecomGenreBorrowBook(User user) {
		List<User_book> list = new ArrayList<User_book>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from BookDB where genre =" + "'" + user.getPreferGenre() + "'"
					+ " order by rand() limit 3";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new User_book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getBoolean(8), rs.getInt(9), rs.getString(7), rs.getString(6)));
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<User_book> RecomPopularBorrowBook(User user) {
		List<User_book> list = new ArrayList<User_book>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from BookDB order by rentfreq desc limit 3";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new User_book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getBoolean(8), rs.getInt(9), rs.getString(7), rs.getString(6)));
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	

	public List<User_book> RecomMajorBorrowBook(User user) {
		List<User_book> list = new ArrayList<User_book>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from BookDB where major = " + "'" + user.getMajor().trim() + "'"
					+ " order by rand() limit 3";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new User_book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getBoolean(8), rs.getInt(9), rs.getString(7), rs.getString(6)));
			}
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	
	public static boolean checkRentPossible(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());

			stmt = conn.createStatement();
			String sql = "select BorrowTF from bookdb where id = " + id;
			rs = stmt.executeQuery(sql);
			rs.next();

			if (rs.getBoolean(1)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void UserBookSelectInfo(JTable t, DefaultTableModel model) {
		try {
			int row = t.getSelectedRow();
			String bookname = t.getValueAt(row, 1).toString();

			stmt = conn.createStatement();
			String sql = "select * from BookDB where bookname= " + "'" + bookname + "'";
			rs = stmt.executeQuery(sql);
			rs.next();

			this.bookpicture = rs.getString(4);
			this.bookname = rs.getString(2);
			this.bookauthor = rs.getString(3);
			this.bookpublisher = rs.getString(5);
			this.bookgengre = rs.getString(6);

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void RecomMaxRentBorrowBook(User user, int rank) {// 랭크에는 1,2,3 중에 들어가야함
		try {
			int booknum;
			String bookname;

			stmt = conn.createStatement();
			String sql = "select * from BookDB order by rentFreq desc limit 3";
			rs = stmt.executeQuery(sql);
			for (int i = 0; i < rank; i++) {
				rs.next();
			}

			booknum = rs.getInt(1);
			bookname = rs.getString(2);

			if (rs.getString(8).trim().equals("true")) {
				// 이제 BookDb에 잇는 대출여부를 false로 바꿔주셈
				// 자신의 랜트 카운트 하나 내림
				// 최대 대출 횟수를 1개 늘려줌
				if (user.getRentCount() > 0) {
					insertTask.insertBorrowDB(user.getID(), user.getName(), booknum, bookname);

					JFrame Exists = new JFrame(""); // Fail프레임을 생성
					Exists.setPreferredSize(new Dimension(250, 110));// 크기지정
					JPanel p = new JPanel();
					JPanel pp = new JPanel();
					p.add(new JLabel("대출이 완료되었습니다."));

					JButton button11 = new JButton("확인");
					pp.add(button11);
					button11.addActionListener(new Exit_Listener(Exists));
					Exists.add(p, "Center");
					Exists.add(pp, "South");
					Exists.pack(); // 프레임을 보여준다
					Exists.setLocation(830, 400);
					Exists.setVisible(true); // 패널들을 보여준다

				} else {
					JFrame Exists = new JFrame(""); // Fail프레임을 생성
					Exists.setPreferredSize(new Dimension(250, 110));// 크기지정
					JPanel p = new JPanel();
					JPanel pp = new JPanel();
					p.add(new JLabel("잔여 대출 횟수가 부족합니다."));

					JButton button11 = new JButton("확인");
					pp.add(button11);
					button11.addActionListener(new Exit_Listener(Exists));
					Exists.add(p, "Center");
					Exists.add(pp, "South");
					Exists.pack(); // 프레임을 보여준다
					Exists.setLocation(830, 400);
					Exists.setVisible(true); // 패널들을 보여준다
				}
			} else {
				JFrame Exists = new JFrame(""); // Fail프레임을 생성
				Exists.setPreferredSize(new Dimension(250, 110));// 크기지정
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("이미 대출중인 도서 입니다."));

				JButton button11 = new JButton("확인");
				pp.add(button11);
				button11.addActionListener(new Exit_Listener(Exists));
				Exists.add(p, "Center");
				Exists.add(pp, "South");
				Exists.pack(); // 프레임을 보여준다
				Exists.setLocation(830, 400);
				Exists.setVisible(true); // 패널들을 보여준다
			}

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int selectRentFreq(int book_id) {
		int rent_freq = -1;
		try {
			stmt = conn.createStatement();
			String sql = "select rentFreq from BookDB where id = " + "'" + book_id + "'";
			rs = stmt.executeQuery(sql);

			rs.next();
			rent_freq = rs.getInt(1);

			return rent_freq;
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rent_freq;
	}
}