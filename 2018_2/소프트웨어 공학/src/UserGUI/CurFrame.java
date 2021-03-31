package UserGUI;

import javax.swing.JButton;
import javax.swing.JFrame;

import UserTask.User;

public class CurFrame {
	static User curr_user;
	public static JFrame login_frame;
	static JFrame Home_frame;
	static JFrame search_frame;
	static JFrame genre_frame;
	static JFrame major_frame;
	static JFrame popular_frame;
	static JFrame sign_up_frame;
	static JButton logo;
	public static JFrame admin_frame;
	static boolean distinct_check;
	private static String Sql_Passwd;
	public static void setSqlPasswd(String passwd) {
		Sql_Passwd = passwd;
	}
	public static String getSqlPasswd() {
		return Sql_Passwd;
	}
}