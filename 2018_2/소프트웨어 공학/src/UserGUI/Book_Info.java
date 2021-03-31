package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AdminTask.User_book;
import DBtask.selectTask;

class Book_Info implements ActionListener {

	int id;
	String name = null;
	DefaultTableModel model = null;
	JTable t = null;
	Book_Info(JTable t, DefaultTableModel model) {
		this.t = t;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			 
			 
			int row = t.getSelectedRow();
			this.id = Integer.parseInt(t.getValueAt(row, 0).toString());
			this.name = t.getValueAt(row, 1).toString();

			selectTask seltask = new selectTask();

			JFrame f = new JFrame();
			JPanel panel = new JPanel();

			panel.setLayout(null);

			JButton borrow = new JButton("대출");
			JButton interest = new JButton("찜");
			
			setButtonEnable(id, borrow, interest);
			
			if(interest.getText().equals("찜 완료")) {
				CurSearchTable.setFrame(2);
			}else{
				CurSearchTable.setFrame(1);
			}
			
			
			seltask.UserBookSelectInfo(t, model);

			ImageIcon image = new ImageIcon("C:/images/Logo.png");
			JLabel labelImage = new JLabel(image);
			ImageIcon book_photo = new ImageIcon(seltask.getBookpicture());
			JLabel photo = new JLabel(book_photo);

			borrow.addActionListener(new Borrow_Listener(id, name, f, t, model));
			interest.addActionListener(new Interest_Listener(id, name, f));

			panel.add(labelImage);
			panel.add(borrow);
			panel.add(interest);
			panel.add(photo);
			photo.setBounds(10, 45, 200, 200);
			labelImage.setBounds(10, 10, 100, 30);
			borrow.setBounds(80, 260, 110, 30);
			interest.setBounds(260, 260, 110, 30);

			String book_title = seltask.getBookname();

			JLabel title = new JLabel(" 제목 ");
			JLabel writer = new JLabel(" 저자 ");
			JLabel company = new JLabel(" 출판사 ");
			JLabel genre = new JLabel(" 장르 ");
			JLabel title1 = new JLabel(book_title);
			JLabel title2 = new JLabel("");
			JLabel title3 = new JLabel("");
			JLabel writer1 = new JLabel(seltask.getBookauthor());
			JLabel company1 = new JLabel(seltask.getBookpublisher());
			JLabel genre1 = new JLabel(seltask.getBookgengre());

			if (book_title.length() > 12) {
				if (book_title.length() > 24) {
					title2 = new JLabel(book_title.substring(12, 24));
					title3 = new JLabel(book_title.substring(24));
					title1 = new JLabel(book_title.substring(0, 12));
				} else {
					title2 = new JLabel(book_title.substring(12));
					title1 = new JLabel(book_title.substring(0, 12));
				}
			}

			panel.add(title);
			panel.add(writer);
			panel.add(company);
			panel.add(genre);
			panel.add(title1);
			panel.add(title2);
			panel.add(title3);
			panel.add(writer1);
			panel.add(company1);
			panel.add(genre1);

			title.setBounds(200, 40, 50, 80);
			writer.setBounds(200, 130, 50, 30);
			company.setBounds(200, 170, 50, 30);
			genre.setBounds(200, 210, 50, 30);
			title1.setBounds(250, 40, 180, 30);
			title2.setBounds(250, 70, 180, 30);
			title3.setBounds(250, 100, 180, 30);
			writer1.setBounds(250, 130, 100, 30);
			company1.setBounds(250, 170, 100, 30);
			genre1.setBounds(250, 210, 100, 30);

			f.setSize(450, 340);
			f.setLocation(950, 350);
			f.setTitle("도서정보");
			f.add(panel);
			f.setVisible(true);

		} catch (Exception e2) {
			if (id == -1) {
				JFrame Fail = new JFrame(""); // Fail프레임을 생성
				Fail.setLocation(1000, 500); // 위치지정
				Fail.setPreferredSize(new Dimension(250, 110));// 크기지정
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("도서를 선택 해주시길 바랍니다."));

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

	private void setButtonEnable(int book_id, JButton borrow, JButton interest) {
		if (!selectTask.checkRentPossible(book_id)) {
			borrow.setEnabled(false);
			borrow.setText("대출 중");
		} else {
			borrow.setEnabled(true);
			borrow.setText("대출");
		}
		if (selectTask.checkHadZZim(CurFrame.curr_user.getID(), book_id)) {
			interest.setEnabled(false);
			interest.setText("찜 완료");
		} else {
			interest.setEnabled(true);
			interest.setText("찜");
		}

	}

}