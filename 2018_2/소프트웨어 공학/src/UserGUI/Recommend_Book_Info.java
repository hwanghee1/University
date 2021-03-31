package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AdminTask.User_book;
import DBtask.selectTask;

class Recommend_Book_Info implements ActionListener {

	User_book user_book;

	public Recommend_Book_Info(User_book user_book) {
		this.user_book = user_book;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			CurSearchTable.setFrame(3);
			
			JFrame f = new JFrame();
			JLabel label = new JLabel("��������");
			JPanel panel = new JPanel();

			panel.setLayout(null);

			ImageIcon image = new ImageIcon("C:/images/Logo.png");
			JLabel labelImage = new JLabel(image);
			ImageIcon book_photo = new ImageIcon(user_book.getPicture());
			JLabel photo = new JLabel(book_photo);
			JButton borrow = new JButton("����");
			JButton interest = new JButton("��");

			setButtonEnable(user_book.getID(), borrow, interest);

			borrow.addActionListener(new Borrow_Listener(user_book));
			interest.addActionListener(new Interest_Listener(user_book));

			panel.add(labelImage);
			panel.add(borrow);
			panel.add(interest);
			panel.add(photo);
			photo.setBounds(10, 45, 200, 200);
			labelImage.setBounds(10, 10, 100, 30);
			borrow.setBounds(80, 260, 110, 30);
			interest.setBounds(260, 260, 110, 30);

			String book_title = user_book.getName();

			JLabel title = new JLabel(" ���� ");
			JLabel writer = new JLabel(" ���� ");
			JLabel company = new JLabel(" ���ǻ� ");
			JLabel genre = new JLabel(" �帣 ");
			JLabel title1 = new JLabel(book_title);
			JLabel title2 = new JLabel("");
			JLabel title3 = new JLabel("");
			JLabel writer1 = new JLabel(user_book.getAuthor());
			JLabel company1 = new JLabel(user_book.getCompany());
			JLabel genre1 = new JLabel(user_book.getGenre());

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
			f.setTitle("��������");
			f.add(panel);
			f.setVisible(true);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private void setButtonEnable(int book_id, JButton borrow, JButton interest) {
		if (!selectTask.checkRentPossible(book_id)) {
			borrow.setEnabled(false);
			borrow.setText("���� ��");
		} else {
			borrow.setEnabled(true);
			borrow.setText("����");
		}
		if (selectTask.checkHadZZim(CurFrame.curr_user.getID(), book_id)) {
			interest.setEnabled(false);
			interest.setText("�� �Ϸ�");
		} else {
			interest.setEnabled(true);
			interest.setText("��");
		}
	}

}