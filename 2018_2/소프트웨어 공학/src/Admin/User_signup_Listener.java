package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBtask.selectTask;

//ȸ�����Խ�����Ȳ
class User_Signup_Listener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		selectTask seltask = new selectTask();

		JFrame f = new JFrame();
		String[] name = { "id", "passwd", "�̸�", "�й�", "�г�", "����", "�ڵ�����ȣ", "��ȣ�帣" };

		DefaultTableModel dt = new DefaultTableModel(name, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);

		JLabel label = new JLabel("ȸ������ ��û��Ȳ");

		JButton button1 = new JButton("����");
		JButton button2 = new JButton("����");

		button1.addActionListener(new Signup_agree_Listener(jt, dt));
		button2.addActionListener(new singup_Refusewindow_Listener());
		seltask.selectSignUpDB(dt);

		JPanel p = new JPanel();
		p.add(button1);
		p.add(button2);

		CurTable.curjt = jt;
		CurTable.curdt = dt;

		f.setSize(900, 300);
		f.setLocation(800, 350);
		f.setTitle("ȸ������ ��û ��Ȳ");
		f.add(label, "North");
		f.add(jsp, "Center");
		f.add(p, "East");
		f.setVisible(true);

	}

}