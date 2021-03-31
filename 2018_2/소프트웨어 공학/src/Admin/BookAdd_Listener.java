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

		JFrame Success = new JFrame(""); // Fail�������� ����
		Success.setLocation(1000, 500); // ��ġ����
		Success.setPreferredSize(new Dimension(250, 110));// ũ������
		JPanel p = new JPanel();
		JPanel pp = new JPanel();
		p.add(new JLabel("���������� �߰� �Ǿ����ϴ�."));

		seltask.AdminselectBookDB(CurTable.curdt);

		JButton button1 = new JButton("Ȯ��");
		pp.add(button1);

		button1.addActionListener(new Exit_Listener(Success));
		Success.add(p, "Center");
		Success.add(pp, "South");
		Success.pack(); // �������� �����ش�
		Success.setVisible(true); // �гε��� �����ش�

	}

}