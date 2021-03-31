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

//회원가입승인현황
class User_Signup_Listener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		selectTask seltask = new selectTask();

		JFrame f = new JFrame();
		String[] name = { "id", "passwd", "이름", "학번", "학년", "전공", "핸드폰번호", "선호장르" };

		DefaultTableModel dt = new DefaultTableModel(name, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);

		JLabel label = new JLabel("회원가입 신청현황");

		JButton button1 = new JButton("수락");
		JButton button2 = new JButton("거절");

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
		f.setTitle("회원가입 신청 현황");
		f.add(label, "North");
		f.add(jsp, "Center");
		f.add(p, "East");
		f.setVisible(true);

	}

}