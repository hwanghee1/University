package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AdminTask.User_book;
import DBtask.insertTask;

class Interest_Listener implements ActionListener {
	int book_id;
	String book_name;
	JFrame before_frame;

	public Interest_Listener(int id, String name, JFrame before_frame) {
		this.book_id = id;
		this.book_name = name;
		this.before_frame = before_frame;
	}

	public Interest_Listener(User_book user_book) {
		this.book_id = user_book.getID();
		this.book_name = user_book.getName();
	}

	public void actionPerformed(ActionEvent arg0) {
		JFrame Fail = new JFrame(""); // Fail프레임을 생성
		Fail.setLocation(1000, 500); // 위치지정
		Fail.setPreferredSize(new Dimension(250, 125)); // 크기지정
		JPanel p = new JPanel();
		JPanel pp = new JPanel();

		insertTask.insertZZimDB(CurFrame.curr_user.getID(), CurFrame.curr_user.getName(), book_id, book_name);

		p.add(new JLabel("찜이 완료되었습니다."));
		p.add(new JLabel("관심목록으로 이동하시겠습니까?")); // 관심목록으로 이동할 수 있을 시 사용

		JButton button1 = new JButton("확인");
		JButton button2 = new JButton("취소");
		pp.add(button1);
		pp.add(button2);

		button1.addActionListener(new User_my_page());
		button1.addActionListener(new Exit_Listener(Fail));
		button1.addActionListener(new Exit_Listener(before_frame));
		button2.addActionListener(new Exit_Listener(Fail));
		Fail.add(p, "Center");
		Fail.add(pp, "South");
		Fail.pack(); // 프레임을 보여준다
		Fail.setVisible(true); // 패널들을 보여준다
	}
}