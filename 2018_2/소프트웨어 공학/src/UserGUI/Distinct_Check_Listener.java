package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Admin.Exit_Listener;
import UserTask.UserManage;

public class Distinct_Check_Listener implements ActionListener {
	JTextField id = null;
	
	Distinct_Check_Listener(JTextField id){
		this.id = id;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(UserManage.distinctCheck(id.getText())) {
			JFrame Fail = new JFrame(""); // Fail프레임을 생성
			Fail.setLocation(1000, 500); // 위치지정
			Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("중복확인 되었습니다."));
			
			CurFrame.distinct_check = true;
			id.setEnabled(false);
			
			JButton button1 = new JButton("확인");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // 프레임을 보여준다
			Fail.setVisible(true); // 패널들을 보여준다
		}
		else {
			JFrame Fail = new JFrame(""); // Fail프레임을 생성
			Fail.setLocation(1000, 500); // 위치지정
			Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("동일한 아이디가 존재합니다."));

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
