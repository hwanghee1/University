package UserGUI;

import javax.swing.*;

import AdminTask.User_book;
import DBtask.selectTask;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List; 

public class Recomm_Major extends JFrame implements ActionListener {
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		CurSearchTable.setFrame(3);
		
		List<User_book> list = new ArrayList<User_book>();
		selectTask seltask = new selectTask();
		list = seltask.RecomMajorBorrowBook(CurFrame.curr_user);

		User_book user_book1 = list.get(0);
		User_book user_book2 = list.get(1);
		User_book user_book3 = list.get(2);

		JFrame frame = new JFrame();
		CurFrame.genre_frame = frame;
		CurFrame.genre_frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JButton button1 = new JButton("책 정보");
		JButton button3 = new JButton("책 정보");
		JButton button5 = new JButton("책 정보");
		ImageIcon popular1 = new ImageIcon(user_book1.getPicture());
		JLabel imageLabel1 = new JLabel(popular1);
		ImageIcon popular2 = new ImageIcon(user_book2.getPicture());
		JLabel imageLabel2 = new JLabel(popular2);
		ImageIcon popular3 = new ImageIcon(user_book3.getPicture());
		JLabel imageLabel3 = new JLabel(popular3);

		ImageIcon logo = new ImageIcon("C:/images/Logo.png");
		JButton logobutton = new JButton(logo);
		CurFrame.logo = logobutton;
		logobutton.addActionListener(new Logo_action());
		panel.add(logobutton);
		logobutton.setBounds(4, 4, 100, 30);

		// 책이름
		JLabel bookName1 = new JLabel("책이름 :");
		panel.add(bookName1);
		bookName1.setBounds(40, 250, 50, 30);
		JLabel bookName1_1 = new JLabel(user_book1.getName());
		panel.add(bookName1_1);
		bookName1_1.setBounds(90, 250, 110, 30);

		JLabel bookName2 = new JLabel("책이름 :");
		panel.add(bookName2);
		bookName2.setBounds(270, 250, 50, 30);
		JLabel bookName2_1 = new JLabel(user_book2.getName());
		panel.add(bookName2_1);
		bookName2_1.setBounds(320, 250, 110, 30);

		JLabel bookName3 = new JLabel("책이름 :");
		panel.add(bookName3);
		bookName3.setBounds(500, 250, 50, 30);
		JLabel bookName3_1 = new JLabel(user_book3.getName());
		panel.add(bookName3_1);
		bookName3_1.setBounds(550, 250, 110, 30);

		JLabel bookAuthor1 = new JLabel("저자명 :");
		panel.add(bookAuthor1);
		bookAuthor1.setBounds(40, 280, 50, 30);
		JLabel bookAuthor1_1 = new JLabel(user_book1.getAuthor());
		panel.add(bookAuthor1_1);
		bookAuthor1_1.setBounds(90, 280, 110, 30);

		JLabel bookAuthor2 = new JLabel("저자명 :");
		panel.add(bookAuthor2);
		bookAuthor2.setBounds(270, 280, 50, 30);
		JLabel bookAuthor2_1 = new JLabel(user_book2.getAuthor());
		panel.add(bookAuthor2_1);
		bookAuthor2_1.setBounds(320, 280, 110, 30);

		JLabel bookAuthor3 = new JLabel("저자명 :");
		panel.add(bookAuthor3);
		bookAuthor3.setBounds(500, 280, 50, 30);
		JLabel bookAuthor3_1 = new JLabel(user_book3.getAuthor());
		panel.add(bookAuthor3_1);
		bookAuthor3_1.setBounds(550, 280, 110, 30);

		button1.addActionListener(new Recommend_Book_Info(user_book1));
		button3.addActionListener(new Recommend_Book_Info(user_book2));
		button5.addActionListener(new Recommend_Book_Info(user_book3));
		
		panel.add(button1);
		panel.add(button3);
		panel.add(button5);

		panel.add(imageLabel1);
		panel.add(imageLabel2);
		panel.add(imageLabel3);

		button1.setBounds(65, 320, 100, 30);
		button3.setBounds(295, 320, 100, 30);
		button5.setBounds(525, 320, 100, 30);

		imageLabel1.setBounds(50, 40, 128, 190);
		imageLabel2.setBounds(280, 40, 128, 190);
		imageLabel3.setBounds(510, 40, 128, 190);

		frame.setTitle("전공별 도서추천");
		frame.setSize(720, 420);
		frame.setLocation(800, 350);
		frame.add(panel);
		frame.setVisible(true);

		
	}
}

