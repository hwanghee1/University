package Admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DBtask.*;
import UserGUI.CurFrame;
import UserGUI.Logout_Listener;

import UserGUI.login;

class CurTable {
	static DefaultTableModel curdt;
	static JTable curjt;
	static JTextField Bname, authour, publisher, major, picture, genre;
	static String combogengre;
	public static String combomajor;
	
 }

public class Admin_home {
	public Admin_home() {
		CurFrame.login_frame.setVisible(false);

		selectTask seltask = new selectTask();
		// 관리자 페이지
		JFrame f = new JFrame();
		
		CurFrame.admin_frame = f;

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);

		JButton button1 = new JButton("회원가입 승인");
		JButton button2 = new JButton("회원정보 확인");
		JButton button3 = new JButton("책 현황");

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);

		button1.setBounds(70, 20, 155, 30);
		button2.setBounds(70, 75, 155, 30);
		button3.setBounds(70, 130, 155, 30);

		button1.addActionListener(new User_Signup_Listener());
		button2.addActionListener(new User_Show_Listener());
		button3.addActionListener(new Book_Show_Listener());
		
		ActionListener listener= new Admin_Logout_Refuse_Listener();
		
		//로그아웃
	      JButton button4 = new JButton("로그아웃");
	      panel1.add(button4);
	      button4.setBounds(100, 180, 95, 20);   
	      button4.addActionListener(listener);

		f.setSize(300, 250);
		f.setLocation(800, 350);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("관리자");
		f.add(panel1);
		f.setVisible(true);

		if (seltask.existSignUpDB() != null) {
			JFrame Exists = new JFrame(""); // Fail프레임을 생성
			Exists.setPreferredSize(new Dimension(250, 110));// 크기지정
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("회원가입승인이 필요한 회원이 있습니다."));

			JButton button11 = new JButton("확인");
			pp.add(button11);
			button11.addActionListener(new Exit_Listener(Exists));
			Exists.add(p, "Center");
			Exists.add(pp, "South");
			Exists.pack(); // 프레임을 보여준다
			Exists.setLocation(830, 400);
			Exists.setVisible(true); // 패널들을 보여준다

		}
	}
}


class Admin_Logout_Refuse_Listener implements ActionListener {
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
         button1.addActionListener(new Admin_Logout_Listener(Fail));
         button2.addActionListener(new Exit_Listener(Fail));
         Fail.add(p,"Center");
         Fail.add(pp,"South");
         Fail.pack();                     //프레임을 보여준다
         Fail.setVisible(true);           //패널들을 보여준다      
   }
}
class Admin_Logout_Listener implements ActionListener {
   JFrame f = new JFrame();

   public Admin_Logout_Listener(JFrame f) {
      this.f = f;
   }

   public void actionPerformed(ActionEvent e) {
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.setVisible(false);

      try {
         CurFrame.admin_frame.setVisible(false);
      } catch (Exception exception) {
      }
   
      new login();
   }

}