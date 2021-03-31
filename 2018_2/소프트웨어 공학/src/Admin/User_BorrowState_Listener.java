package Admin;

import java.awt.Dimension;
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

//해당 유저의 대출현황을 봐주는 함수
class User_BorrowState_Listener implements ActionListener {
	String id = null;
	DefaultTableModel dt;
	JTable t;

	User_BorrowState_Listener(JTable t, DefaultTableModel dt) {
		this.t = t;
		this.dt = dt;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int row = t.getSelectedRow();
			id = t.getValueAt(row, 0).toString();

			selectTask seltask = new selectTask();

			JFrame f = new JFrame();
			String[] name = { "책번호", "빌린책", "대출 날짜", "반납 기한" };
			DefaultTableModel dt = new DefaultTableModel(name, 0);
			JTable jt = new JTable(dt);
			JScrollPane jsp = new JScrollPane(jt);

			JLabel label = new JLabel("대출 정보");
			JButton button1 = new JButton("닫기");

			button1.addActionListener(new Exit_Listener(f));

			seltask.AdminselectBorrowUserDB(t, dt);

			JPanel p = new JPanel();
			p.add(button1);

			f.setSize(900, 300);
			f.setLocation(800, 350);
			f.setTitle("대출정보 확인");
			f.add(label, "North");
			f.add(jsp, "Center");
			f.add(p, "South");
			f.setVisible(true);
		} catch (Exception e2) {
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