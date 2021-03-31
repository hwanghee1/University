package LoginUserOrAdmin;

import javax.swing.JOptionPane;

import Admin.Admin_home;
import DBtask.selectTask;
import DBtask.updateTask;
import UserGUI.User_Home;
import UserTask.User;

public class LoginTask {
	public static boolean userExist(String ID) {
		User exist_user = null;

		String sql = "select * from userdb where id = " + "'" + ID + "'";
		exist_user = selectTask.selectUserDB(sql);

		try {
			exist_user.getID();
			return true;
		} catch (NullPointerException e) {
			return false;
		}

	}

	public static boolean adminExist(String ID) {
		String correct_passwd = null;

		try {
			correct_passwd = selectTask.selectAdminPasswd(ID);
		} catch (Exception e) {
			return false;
		}
		if (correct_passwd != null) {
			return true;
		} else {
			return false;
		}
	}

	public static User userLogIn(String ID, String passwd) throws Exception {
		String correct_passwd = null;
		User curr_user = null;
		String sql = "select * from userdb where id = " + "'" + ID + "'";

		curr_user = selectTask.selectUserDB(sql);

		correct_passwd = curr_user.getPasswd();

		if (correct_passwd.equals(passwd)) {
			updateTask.setLogin(curr_user);
			System.out.println("로그인되었습니다.");
			return curr_user;
		} else {
			throw new Exception();
		}
	}

	public static void userLogOut(User curr_user) {
		updateTask.setLogOut(curr_user);
		System.out.println("로그아웃 되었습니다.");
	}

	public static boolean adminLogInOut(String ID, String passwd) throws Exception {
		String correct_passwd = null;

		try {
			correct_passwd = selectTask.selectAdminPasswd(ID);
			if (passwd.equals(correct_passwd)) {
				System.out.println("로그인 되었습니다."); // 관리자 홈화면으로 이동
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
