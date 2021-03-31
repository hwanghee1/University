package UserTask;

import AdminTask.Book;
import AdminTask.User_book;
import DBtask.insertTask;
import DBtask.updateTask;
import LoginUserOrAdmin.*;

public class UserBookTask {
	
	public static void addZZim(User curr_user,Book curr_book) {
		insertTask.insertZZimDB(curr_user.getID(),curr_user.getName(),curr_book.getID(),curr_book.getName());
	}
	public static void addBorrow(User curr_user,User_book curr_book) throws Exception {
		if(curr_user.getIsLogin() == 1) {
			if(curr_user.getRentCount() >0) {
				if(curr_book.getRentStatus()) {
					int rent_count = curr_user.getRentCount();
					insertTask.insertBorrowDB(curr_user.getID(), curr_user.getName(), curr_book.getID(), curr_book.getName());
					curr_book.setStatus();
					curr_book.increaseRentFreq();
					rent_count--;
					updateTask.setRentCount(curr_user.getID(), rent_count);
				}
				else {
					throw new Exception("������ �Ұ����մϴ�.");
				}
			}
			else {
				throw new Exception("�ܿ� ����Ƚ���� �����մϴ�.");
			}
		}
		else {
			throw new Exception("�α����� �ʿ��մϴ�.");
		}
	}
	public static void returnBook(String id, int book_num) {
		
	}

}
