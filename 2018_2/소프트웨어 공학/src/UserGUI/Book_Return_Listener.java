package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Exit_Listener;
import DBtask.deleteTask;
import DBtask.selectTask;
import DBtask.updateTask;
import UserTask.UserManage;

public class Book_Return_Listener implements ActionListener {
	private JTable jt ;
	private DefaultTableModel model ;
	
	public Book_Return_Listener(JTable jt, DefaultTableModel dt) {
		this.jt = jt;
		this.model = dt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String id = null;
		int book_num;
		try {
			int row = jt.getSelectedRow();
			id = CurFrame.curr_user.getID();
			book_num = Integer.parseInt(jt.getValueAt(row, 0).toString());

			deleteTask.deleteBorrowDB(id, book_num);
			
			int rent_count = CurFrame.curr_user.getRentCount();
			rent_count++;
			CurFrame.curr_user.setRentCount(rent_count);
			
			updateTask.setRentCount(id, rent_count);
			updateTask.updateBookReturn(book_num);
			selectTask.selectBorrowDB(id, model);
			JPanel02.set_rent_count_label();
			
		} catch (Exception e) {
			
		}
	}
}
