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
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��");

		due.add(Calendar.DAY_OF_MONTH, 5);

		JFrame Fail = new JFrame(""); // Fail�������� ����
		Fail.setLocation(1000, 500); // ��ġ����
		Fail.setPreferredSize(new Dimension(250, 150));// ũ������
		JPanel p = new JPanel();
		JPanel pp = new JPanel();
		p.add(new JLabel("������ �Ϸ�Ǿ����ϴ�."));
		p.add(new JLabel("�ݳ� �������� " + format.format(due.getTime()) + "�Դϴ�."));

		insertTask.insertBorrowDB(CurFrame.curr_user.getID(), CurFrame.curr_user.getName(), book_id, book_name);
		updateTask.setRentCount(CurFrame.curr_user.getID(), CurFrame.curr_user.getRentCount() - 1);
		updateTask.updateBookBorrow(book_id, today, due);

		CurFrame.curr_user.setRentCount(CurFrame.curr_user.getRentCount() - 1);

		JButton button1 = new JButton("Ȯ��");
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
		Fail.pack(); // �������� �����ش�
		Fail.setVisible(true); // �гε��� �����ش�

	}

}
