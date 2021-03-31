package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AdminTask.User_book;
import DBtask.insertTask;

class Borrow_Listener implements ActionListener {
	int book_id;
	String book_name;

	JFrame before_frame;
	DefaultTableModel model = null;
	JTable t;

	public Borrow_Listener(int id, String name, JFrame before_frame, JTable t, DefaultTableModel model) {
		this.book_id = id;
		this.book_name = name;
		this.before_frame = before_frame;
		this.t = t;
		this.model = model;
	}

	public Borrow_Listener(User_book user_book) {
		this.book_id = user_book.getID();
		this.book_name = user_book.getName();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (CurFrame.curr_user.getRentCount() > 0) {
			JFrame Fail = new JFrame(""); // Fail프레임을 생성
			Fail.setLocation(1000, 500); // 위치지정
			Fail.setPreferredSize(new Dimension(250, 110)); // 크기지정
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("정말 대출하시겠습니까?"));

			JButton button1 = new JButton("확인");
			JButton button2 = new JButton("취소");

			pp.add(button1);
			pp.add(button2);

			button1.addActionListener(new Borrow_OK_Listener(book_id, book_name, t, model));
			button1.addActionListener(new Exit_Listener(Fail));
			button1.addActionListener(new Exit_Listener(before_frame));
			button2.addActionListener(new Exit_Listener(Fail));

			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // 프레임을 보여준다
			Fail.setVisible(true); // 패널들을 보여준다
		} else {
			JFrame Fail = new JFrame(""); // Fail프레임을 생성
			Fail.setLocation(1000, 500); // 위치지정
			Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("대출 가능횟수를 초과하셨습니다."));

			JButton button1 = new JButton("확인");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // 프레임을 보여준다
			Fail.setVisible(true); // 패널들을 보여준다
		}
	}
}