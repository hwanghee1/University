package AdminTask;

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

//회원가입 거절
class Signup_refuse_Listener implements ActionListener {
	String id = null, name = null;
	DefaultTableModel dt = new DefaultTableModel();
	JTable t = new JTable();

	Signup_refuse_Listener(JTable t, DefaultTableModel dt) {
		this.t = t;
		this.dt = dt;
	}

	public void actionPerformed(ActionEvent e) {

		try {
			int row = t.getSelectedRow();
			id = t.getValueAt(row, 0).toString();
			name = t.getValueAt(row, 2).toString();

			deleteTask deltask = new deleteTask();
			selectTask seltask = new selectTask();

			deltask.deleteSignUpDB(id, name);
			seltask.selectSignUpDB(dt);
		} catch (Exception e1) {
			if (id == null) {
				JFrame Fail = new JFrame(""); // Fail프레임을 생성
				Fail.setLocation(1000, 500); // 위치지정
				Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("회원을 선택 해주시길 바랍니다."));

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
}