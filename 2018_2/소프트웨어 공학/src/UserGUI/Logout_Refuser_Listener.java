package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//정말 로그아웃 하시겠습니까?
class Logout_Refuse_Listener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
	   	JFrame Fail = new JFrame("");        //Fail프레임을 생성      
	   	Fail.setLocation(1000, 500);         //위치지정
	   	Fail.setPreferredSize(new Dimension(250,110)); //크기지정
	   	JPanel p=new JPanel();
	   	JPanel pp=new JPanel();
	   	p.add(new JLabel("정말 로그아웃 하시겟습니까?"));
	   	
	   	JButton button1 = new JButton("확인");
	   	JButton button2 = new JButton("취소");
	   	pp.add(button1);
	   	pp.add(button2);
	   	button1.addActionListener(new Logout_Listener(Fail));
	   	button2.addActionListener(new Exit_Listener(Fail));
	   	Fail.add(p,"Center");
	   	Fail.add(pp,"South");
	   	Fail.pack();                     //프레임을 보여준다
	   	Fail.setVisible(true);           //패널들을 보여준다      
	}
}

