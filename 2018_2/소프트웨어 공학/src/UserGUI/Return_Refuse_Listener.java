package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Book_del_Listener;
import Admin.Exit_Listener;

public class Return_Refuse_Listener implements ActionListener {
	private JTable jt ;
	private DefaultTableModel dt ;
	private int row;
	private String id;
	
	public Return_Refuse_Listener(JTable jt, DefaultTableModel dt) {
		this.jt = jt;
		this.dt = dt;
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			row = jt.getSelectedRow();
			id = jt.getValueAt(row, 0).toString();
			
			JFrame Fail = new JFrame(""); // Fail프레임을 생성
			Fail.setLocation(1000, 500); // 위치지정
			Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("정말 반납 하시겟습니까?"));

			JButton button1 = new JButton("확인");
			JButton button2 = new JButton("취소");
			pp.add(button1);
			pp.add(button2);

			button1.addActionListener(new Book_Return_Listener(jt, dt));
			button1.addActionListener(new Exit_Listener(Fail));
			button2.addActionListener(new Exit_Listener(Fail));

			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // 프레임을 보여준다
			Fail.setVisible(true); // 패널들을 보여준다
		} catch (Exception e) {
			if (id == null) {
				JFrame Fail = new JFrame(""); // Fail프레임을 생성
				Fail.setLocation(1000, 500); // 위치지정
				Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("반납하실 책을 선택해주십시오."));

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