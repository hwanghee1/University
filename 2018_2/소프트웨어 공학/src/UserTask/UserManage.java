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
			throw new Exception("�Էµ� ������ ��ġ�ϴ� ���̵� �������� �ʽ��ϴ�.");
		} else {
			return curr_user.getID();
		}
	}

	public static String findPW(String ID, String name, int studentNum) throws Exception {
		String sql = "select * from userdb where id = " + "'" + ID + "'" + " && name = " + "'" + name + "'"
				+ " && studentNum = " + "'" + studentNum + "'";
		User curr_user = selectTask.selectUserDB(sql);

		if (curr_user == null) {
			throw new Exception("�Էµ� ������ ��ġ�ϴ� ��й�ȣ�� �������� �ʽ��ϴ�.");
		} else {
			return curr_user.getPasswd();
		}
	}

	public static void changePW(User curr_user, String checkPW, String newPW) throws Exception {
		if (curr_user.getPasswd().equals(checkPW)) {
			updateTask.updatePasswd(curr_user.getID(), newPW);
			System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�.");
		} else {
			throw new Exception("���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
