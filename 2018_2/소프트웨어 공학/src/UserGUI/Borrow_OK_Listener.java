package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Exit_Listener;
import DBtask.insertTask;
import DBtask.searchTask;
import DBtask.updateTask;

public class Borrow_OK_Listener implements ActionListener {
	int book_id;
	String book_name;
	DefaultTableModel model = null;
	JTable t;

	public Borrow_OK_Listener(int book_id, String book_name, JTable t, DefaultTableModel model) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.t = t;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		Calendar today = Calendar.getInstance();
		Calendar due = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일");

		due.add(Calendar.DAY_OF_MONTH, 5);

		JFrame Fail = new JFrame(""); // Fail프레임을 생성
		Fail.setLocation(1000, 500); // 위치지정
		Fail.setPreferredSize(new Dimension(250, 150));// 크기지정
		JPanel p = new JPanel();
		JPanel pp = new JPanel();
		p.add(new JLabel("대출이 완료되었습니다."));
		p.add(new JLabel("반납 예정일은 " + format.format(due.getTime()) + "입니다."));

		insertTask.insertBorrowDB(CurFrame.curr_user.getID(), CurFrame.curr_user.getName(), book_id, book_name);
		updateTask.setRentCount(CurFrame.curr_user.getID(), CurFrame.curr_user.getRentCount() - 1);
		updateTask.updateBookBorrow(book_id, today, due);

		CurFrame.curr_user.setRentCount(CurFrame.curr_user.getRentCount() - 1);

		JButton button1 = new JButton("확인");
		pp.add(button1);
		

		 if ( CurSearchTable.getFrame() == 1 )
           {
			searchTask sertask = new searchTask();
			sertask.UserBookSearch(model, CurSearchTable.getCombo(), CurSearchTable.getText());
			button1.addActionListener(new Exit_Listener(Fail));

		}else if (CurSearchTable.getFrame() == 2 ) {
			button1.addActionListener(new ZZim_Delete_Listener(t, model));
			button1.addActionListener(new Exit_Listener(Fail));
			

		} 
		 
		 else if(CurSearchTable.getFrame() == 3 ){
			button1.addActionListener(new Exit_Listener(Fail));
		}
		System.out.println(CurSearchTable.getFrame());
		
		Fail.add(p, "Center");
		Fail.add(pp, "South");
		Fail.pack(); // 프레임을 보여준다
		Fail.setVisible(true); // 패널들을 보여준다

	}

}
