package Admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBtask.insertTask;
import DBtask.selectTask;

class BookAdd_Listener implements ActionListener {

	JTextField field1 = null, field2 = null, field3 = null, field4 = null, field5 = null, field6 = null;
	int id;
	String name, author, picture, publisher, genre, major;

	public void actionPerformed(ActionEvent e) {
		selectTask seltask = new selectTask();
		insertTask instask = new insertTask();

		name = CurTable.Bname.getText();
		author = CurTable.authour.getText();
		picture = CurTable.picture.getText();
		publisher = CurTable.publisher.getText();
		id = seltask.getBookID();

		instask.insertBookDB(id, name, author, picture, publisher, CurTable.combogengre, CurTable.combomajor);

		JFrame Success = new JFrame(""); // Fail프레임을 생성
		Success.setLocation(1000, 500); // 위치지정
		Success.setPreferredSize(new Dimension(250, 110));// 크기지정
		JPanel p = new JPanel();
		JPanel pp = new JPanel();
		p.add(new JLabel("정상적으로 추가 되었습니다."));

		seltask.AdminselectBookDB(CurTable.curdt);

		JButton button1 = new JButton("확인");
		pp.add(button1);

		button1.addActionListener(new Exit_Listener(Success));
		Success.add(p, "Center");
		Success.add(pp, "South");
		Success.pack(); // 프레임을 보여준다
		Success.setVisible(true); // 패널들을 보여준다

	}

}