package UserTask;

import java.util.LinkedList;

import AdminTask.Book_borrowed;
import DBtask.*;

public class UserManage {
	public static void main(String[] args) {

	}

	public static String findID(String searchName, int studentNum) throws Exception {
		String sql = "select * from userdb where name = " + "'" + searchName + "' && studentNum =" + "'" + studentNum
				+ "'";
		User curr_user = selectTask.selectUserDB(sql);
		if (curr_user == null) {
			throw new Exception("입력된 전보와 일치하는 아이디가 존재하지 않습니다.");
		} else {
			return curr_user.getID();
		}
	}

	public static String findPW(String ID, String name, int studentNum) throws Exception {
		String sql = "select * from userdb where id = " + "'" + ID + "'" + " && name = " + "'" + name + "'"
				+ " && studentNum = " + "'" + studentNum + "'";
		User curr_user = selectTask.selectUserDB(sql);

		if (curr_user == null) {
			throw new Exception("입력된 정보와 일치하는 비밀번호가 존재하지 않습니다.");
		} else {
			return curr_user.getPasswd();
		}
	}

	public static void changePW(User curr_user, String checkPW, String newPW) throws Exception {
		if (curr_user.getPasswd().equals(checkPW)) {
			updateTask.updatePasswd(curr_user.getID(), newPW);
			System.out.println("비밀번호 변경이 완료되었습니다.");
		} else {
			throw new Exception("현재 비밀번호가 일치하지 않습니다.");
		}
	}

	public static boolean distinctCheck(String ID) {
		User curr_user = null;
		
		try {
			String sql = "select * from userdb where id = " + "'" + ID + "'";

			curr_user = selectTask.selectUserDB(sql);
		
			if(curr_user != null) {
				return false;
			}else {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
	}

}
