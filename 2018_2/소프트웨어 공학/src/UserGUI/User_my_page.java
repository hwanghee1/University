package UserGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DBtask.selectTask;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class User_my_page extends JFrame implements ActionListener {
	public JPanel01 jpanel01 = null;
	public JPanel02 jpanel02 = null;
	public JPanel03 jpanel03 = null;
	
	public User_my_page() {
		CurSearchTable.setFrame(2);
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		User_my_page win = new User_my_page();
		win.setTitle("마이페이지");

		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.jpanel03 = new JPanel03(win);

		win.add(win.jpanel01);

		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(500, 430);
		win.setVisible(true);

	}

	// 프레임바뀌는 함수
	public void change(String panelName) {
		if (panelName.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		} else if (panelName.equals("panel02")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		} else {
			getContentPane().removeAll();
			getContentPane().add(jpanel03);
			revalidate();
			repaint();
		}
	}
}

//회원정보 프레임
class JPanel01 extends JPanel {
	private JLabel labelImage;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label_name;
	private JLabel label_ID;
	private JLabel label_stuID;
	private JLabel label_phone;
	private JLabel label_genre;
	private JLabel label_major;

	private User_my_page win;

	public JPanel01(User_my_page win) {
		this.win = win;
		win.setLocation(800, 350);
		setLayout(null);

		ImageIcon image = new ImageIcon("C:/images/Logo.png");
		labelImage = new JLabel(image);
		label_ID = new JLabel(" 아이디 ");
		label_name = new JLabel(" 이 름 ");
		label_stuID = new JLabel(" 학 번 ");
		label_phone = new JLabel("휴대폰번호");
		label_genre = new JLabel("선호장르");
		label_major = new JLabel(" 전 공 ");

		JLabel label_User_ID = new JLabel(CurFrame.curr_user.getID());
		JLabel label_User_name = new JLabel(CurFrame.curr_user.getName());
		JLabel label_User_stuID = new JLabel(String.valueOf(CurFrame.curr_user.getstudentNum()));
		JLabel label_User_phone = new JLabel(CurFrame.curr_user.getPhoneNum());
		JLabel label_User_genre = new JLabel(CurFrame.curr_user.getPreferGenre());
		JLabel label_User_major = new JLabel(CurFrame.curr_user.getMajor());

		button1 = new JButton("회원정보 보기");
		button1.setSize(150, 30);
		button1.setLocation(10, 80);
		button2 = new JButton("대출현황 보기");
		button2.setSize(150, 30);
		button2.setLocation(160, 80);
		button3 = new JButton("찜현황 보기");
		button3.setSize(150, 30);
		button3.setLocation(310, 80);

		add(labelImage);
		add(label_ID);
		add(label_name);
		add(label_stuID);
		add(label_phone);
		add(label_genre);
		add(label_major);
		add(label_User_ID);
		add(label_User_name);
		add(label_User_stuID);
		add(label_User_phone);
		add(label_User_genre);
		add(label_User_major);
		add(button1);
		add(button2);
		add(button3);

		labelImage.setBounds(160, 5, 150, 70);

		label_ID.setBounds(30, 140, 150, 30);
		label_name.setBounds(30, 180, 150, 30);
		label_stuID.setBounds(30, 220, 150, 30);
		label_phone.setBounds(30, 260, 150, 30);
		label_genre.setBounds(30, 300, 150, 30);
		label_major.setBounds(30, 340, 150, 30);

		label_User_ID.setBounds(150, 140, 150, 30);
		label_User_name.setBounds(150, 180, 150, 30);
		label_User_stuID.setBounds(150, 220, 150, 30);
		label_User_phone.setBounds(150, 260, 150, 30);
		label_User_genre.setBounds(150, 300, 150, 30);
		label_User_major.setBounds(150, 340, 150, 30);

		button2.addActionListener(new MyActionListener2());
		button3.addActionListener(new MyActionListener3());

	}

	class MyActionListener2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}

	class MyActionListener3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel03");
		}
	}
}

//대출현황 프레임
class JPanel02 extends JPanel {
	private JLabel labelImage;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button3_1;
	private JButton button3_2;
	private static JLabel remain_rent_count;
	private User_my_page win;

	public JPanel02(User_my_page win) {
		this.win = win;
		win.setLocation(800, 350);
		setLayout(null);

		String id = CurFrame.curr_user.getID();
		String[] name = { "책번호", "제목", "대출 날짜", "반납 기한" };
		DefaultTableModel dt = new DefaultTableModel(name, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);

		try {
			selectTask.selectBorrowDB(id, dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon image = new ImageIcon("C:/images/Logo.png");
		labelImage = new JLabel(image);

		button1 = new JButton("회원정보 보기");
		button1.setSize(150, 30);
		button1.setLocation(10, 80);
		button2 = new JButton("대출현황 보기");
		button2.setSize(150, 30);
		button2.setLocation(160, 80);
		button3 = new JButton("찜현황 보기");
		button3.setSize(150, 30);
		button3.setLocation(310, 80);
		remain_rent_count = new JLabel("남은 대출 횟수 :      " + CurFrame.curr_user.getRentCount() + " 회");
		remain_rent_count.setBounds(20, 290, 200, 20);
		jsp.setBounds(10, 130, 465, 150);

		add(labelImage);
		add(button1);
		add(button2);
		add(button3);
		add(remain_rent_count);
		add(jsp);

		labelImage.setBounds(160, 5, 150, 70);

		button3_1 = new JButton("반납");
		button3_1.setBounds(330, 290, 130, 20);
		add(button3_1);

		button1.addActionListener(new MyActionListener1());
		button3.addActionListener(new MyActionListener3());
		button3_1.addActionListener(new Return_Refuse_Listener(jt, dt));

	}
	public static void set_rent_count_label(){
		JPanel02.remain_rent_count.setText("남은 대출 횟수 :      " + CurFrame.curr_user.getRentCount() + " 회");
	}
	class MyActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}

	class MyActionListener3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel03");
		}
	}
}

//찜현황 프레임
class JPanel03 extends JPanel {
	private JLabel labelImage;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button3_1;
	private JButton button3_2;
	private User_my_page win;

	public JPanel03(User_my_page win) {
		this.win = win;
		win.setLocation(800, 350);
		setLayout(null);

		ImageIcon image = new ImageIcon("C:/images/Logo.png");
		labelImage = new JLabel(image);

		button1 = new JButton("회원정보 보기");
		button1.setSize(150, 30);
		button1.setLocation(10, 80);
		button2 = new JButton("대출현황 보기");
		button2.setSize(150, 30);
		button2.setLocation(160, 80);
		button3 = new JButton("찜현황 보기");
		button3.setSize(150, 30);
		button3.setLocation(310, 80);

		String id = CurFrame.curr_user.getID();
		String[] name = { "책번호", "제목" };
		DefaultTableModel dt = new DefaultTableModel(name, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);

		selectTask.selectZZimDB(id, dt);

		add(labelImage);
		add(button1);
		add(button2);
		add(button3);
		add(jsp);

		labelImage.setBounds(160, 5, 150, 70);
		jsp.setBounds(10, 130, 465, 150);

		button3_1 = new JButton("찜삭제");
		button3_2 = new JButton("책 정보");
		button3_1.setBounds(390, 290, 80, 20);
		button3_2.setBounds(300, 290, 80, 20);
		add(button3_1);
		add(button3_2);

		button1.addActionListener(new MyActionListener1());
		button2.addActionListener(new MyActionListener2());
		button3_1.addActionListener(new ZZim_Delete_Listener(jt, dt));
		button3_2.addActionListener(new Book_Info(jt, dt));

	}

	class MyActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}

	class MyActionListener2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
}
