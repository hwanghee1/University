package UserGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AdminTask.User_book;
import DBtask.selectTask;
import UserTask.User;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class User_Home {
	User curr_user;

	public User_Home(User try_user) {
		this.curr_user = try_user;

		// 체크하는 함수가 들어가야함.
		CurFrame.login_frame.setVisible(false);
		CurFrame.curr_user = this.curr_user;

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		JPanel panel4 = new JPanel();
		String[] tablename = { "ID", "책이름", "저자", "출판사", "장르", "대출가능여부" };
		DefaultTableModel dt = new DefaultTableModel(tablename, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);
		JButton button11 = new JButton("책정보");
		panel4.add(button11);
		button11.addActionListener(new Book_Info(jt, dt));

		CurFrame.Home_frame = frame;
		CurFrame.Home_frame.setVisible(true);

		String name[] = { "도서명", "저자" }; // name에 목록저장
		JComboBox com = new JComboBox(name);
		JScrollPane scroll = new JScrollPane(com);
		JTextField text = new JTextField(20);
		JButton button = new JButton("검색");
		JButton button1 = new JButton("마이페이지");
		JButton button2 = new JButton("로그아웃");

		ImageIcon logo = new ImageIcon("C:/images/Logo.png");
		JButton logobutton = new JButton(logo);
		CurFrame.logo = logobutton;

		// 이미지,버튼설정
		
		List<User_book> list1 = new ArrayList<User_book>();
		List<User_book> list2 = new ArrayList<User_book>();
		List<User_book> list3 = new ArrayList<User_book>();
		
		selectTask seltask1 = new selectTask();
		selectTask seltask2 = new selectTask();
		selectTask seltask3 = new selectTask();
		list1 = seltask1.RecomPopularBorrowBook(CurFrame.curr_user);
		list2 = seltask2.RecomMajorBorrowBook(CurFrame.curr_user);
		list3 = seltask3.RecomGenreBorrowBook(CurFrame.curr_user);
		

		User_book user_book1 = list1.get(0);
		User_book user_book2 = list1.get(1);
		User_book user_book3 = list2.get(0);
		User_book user_book4 = list3.get(0);


		
		ImageIcon popular1 = new ImageIcon(user_book1.getPicture());
		JButton ImageButton1 = new JButton(popular1);
		ImageIcon popular2 = new ImageIcon(user_book2.getPicture());
		JButton ImageButton2 = new JButton(popular2);
		
		ImageIcon major1 = new ImageIcon(user_book3.getPicture());
		JButton ImageButton3 = new JButton(major1);

		
		ImageIcon genre1 = new ImageIcon(user_book4.getPicture());
		JButton ImageButton4 = new JButton(genre1);
		

		ImageButton1.setBorderPainted(false); ImageButton1.setContentAreaFilled(false);
		ImageButton2.setBorderPainted(false); ImageButton2.setContentAreaFilled(false);
		ImageButton3.setBorderPainted(false); ImageButton3.setContentAreaFilled(false);
		ImageButton4.setBorderPainted(false); ImageButton4.setContentAreaFilled(false);
		
		ImageButton1.addActionListener(new Recommend_Book_Info(user_book1));
		ImageButton2.addActionListener(new Recommend_Book_Info(user_book2));
		ImageButton3.addActionListener(new Recommend_Book_Info(user_book3));
		ImageButton4.addActionListener(new Recommend_Book_Info(user_book4));
		
		JButton btn1 = new JButton("인기도서추천");
		JButton btn2 = new JButton("전공별도서추천");
		JButton btn3 = new JButton("장르별도서추천");

		
		// button1.addActionListener(new User_Signup_Listener());
		button.addActionListener(
				new Change_UserBooksearch_Window(frame, panel2, panel3, panel4, dt, jt, jsp, button11, com, text));
		btn1.addActionListener(new Recomm_Popular());
		btn2.addActionListener(new Recomm_Major());
		btn3.addActionListener(new Recomm_Genre());
		button1.addActionListener(new User_my_page());
		button2.addActionListener(new Logout_Refuse_Listener());
		logobutton.addActionListener(new Logo_action());

		// 패널에 추가
		panel.add(logobutton);
		panel.add(scroll);
		panel.add(text);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(btn3);
		panel3.add(ImageButton1);
		panel3.add(ImageButton2);
		panel3.add(ImageButton3);
		panel3.add(ImageButton4);


		// 위치설정
		button.setPreferredSize(new Dimension(70, 30));
		logobutton.setPreferredSize(new Dimension(100, 30));
		button1.setPreferredSize(new Dimension(105, 15));
		button2.setPreferredSize(new Dimension(90, 15));
		scroll.setPreferredSize(new Dimension(75, 30));
		text.setPreferredSize(new Dimension(400, 30));
		btn1.setPreferredSize(new Dimension(130, 30));
		btn2.setPreferredSize(new Dimension(130, 30));
		btn3.setPreferredSize(new Dimension(130, 30));
		ImageButton1.setPreferredSize(new Dimension(150, 210));
		ImageButton2.setPreferredSize(new Dimension(150, 210));
		ImageButton3.setPreferredSize(new Dimension(150, 210));
		ImageButton4.setPreferredSize(new Dimension(150, 210));

		frame.setTitle("홈화면");
		frame.setSize(800, 345);
		frame.setLocation(800, 350);
		frame.add(panel, "North");
		frame.add(panel2, "Center");
		frame.add(panel3, "South");
		frame.setVisible(true);

	}
}
