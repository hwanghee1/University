package UserGUI;

import java.awt.*;
import java.lang.String;
import java.awt.event.*;
import javax.swing.*;
import org.omg.CORBA.Current;

import Admin.Admin_home;
import DBtask.insertTask;
import LoginUserOrAdmin.LoginTask;
import UserTask.User;
import UserTask.UserManage;

public class login extends JFrame {
	public static void main(String[] args) {
		new login();
	}

	public login() {
		JLabel label1, label2;
		JTextField field1;
		JPasswordField field2;
		JButton Addbutton0, Addbutton1, Addbutton2, Addbutton3,sqlPasswdButton;
		
		JFrame login = new JFrame();
		JPanel panel = new JPanel();
		ImageIcon logo = new ImageIcon("C:/images/Home_Logo.png");
		JLabel image = new JLabel(logo);

		CurFrame.login_frame = login;
		login.add(panel);
		panel.setLayout(null);

		label1 = new JLabel("��  ��  �� ");
		label2 = new JLabel("�� �� �� ȣ");

		field1 = new JTextField(15);
		field2 = new JPasswordField(15);

		Addbutton0 = new JButton("�α���");
		Addbutton0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = field1.getText();
				String passwd = field2.getText();

				try {
					if (id.equals("") || passwd.equals("")) {
						JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� ��� �Է��Ͻʽÿ�.", "�α���", 0);
					} else {
						if (LoginTask.userExist(id)) { // userDB�� ���̵� ��й�ȣ�� ������ ���
							try {
								User try_user = LoginTask.userLogIn(id, passwd);
								try_user.getID();
								new User_Home(try_user);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.", "�α���", 0);
							}

						} else if (LoginTask.adminExist(id)) { // adminDB�� ���̵� ��й�ȣ�� ������ ���
							try {
								if (LoginTask.adminLogInOut(id, passwd)) {
									new Admin_home();
								} else {
									JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.", "�α���", 0);
								}
							} catch (Exception e2) {
							}
						} else {
							JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.", "�α���", 0);
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.", "�α���", 0);
				}
			}
		});

		Addbutton1 = new JButton("ȸ������");
		Addbutton1.addActionListener(new User_sign_up());

		Addbutton2 = new JButton("���̵� ã��");
		Addbutton2.addActionListener(new find_id_gui());

		Addbutton3 = new JButton("��й�ȣ ã��");
		Addbutton3.addActionListener(new find_pw_gui());

		sqlPasswdButton = new JButton("MySQL ����");
		sqlPasswdButton.addActionListener(new change_sql_passwd());
		
		image.setBounds(50, 35, 400, 200);
		label1.setBounds(50, 250, 80, 40);
		label2.setBounds(50, 310, 80, 40);
		field1.setBounds(130, 250, 200, 40);
		field2.setBounds(130, 310, 200, 40);
		Addbutton0.setBounds(350, 250, 80, 80);
		Addbutton1.setBounds(40, 400, 120, 40);
		Addbutton2.setBounds(190, 400, 120, 40);
		Addbutton3.setBounds(340, 400, 120, 40);
		sqlPasswdButton.setBounds(340, 10, 120, 30);
		
		sqlPasswdButton.setContentAreaFilled(false);

		panel.add(image);
		panel.add(label1);
		panel.add(field1);
		panel.add(Addbutton0);
		panel.add(label2);
		panel.add(field2);

		panel.add(Addbutton1);
		panel.add(Addbutton2);
		panel.add(Addbutton3);
		panel.add(sqlPasswdButton);

		login.setLocation(800, 350);
		login.setSize(500, 500);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setTitle("�α���");
		login.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "\"MySQL����\" ��ư�� Ŭ���Ͽ� DB������ �����Ͻʽÿ�.", "DB����", 0);
	}
}

class find_id_gui implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JFrame findid = new JFrame();
		JPanel panel = new JPanel();
		JButton Addbutton0;
		JButton Closebutton = new JButton("�ݱ�");

		findid.add(panel);
		panel.setLayout(null);

		JLabel label1 = new JLabel("��   ��");
		JLabel label2 = new JLabel("��   ��");
		Addbutton0 = new JButton("Ȯ ��");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);

		label1.setBounds(50, 50, 80, 40);
		label2.setBounds(50, 90, 80, 40);
		field1.setBounds(130, 50, 200, 40);
		field2.setBounds(130, 90, 200, 40);
		Addbutton0.setBounds(350, 50, 80, 40);
		Closebutton.setBounds(350, 90, 80, 40);

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(Addbutton0);
		panel.add(Closebutton);

		Addbutton0.addActionListener(new find_id_message(field1, field2));
		Closebutton.addActionListener(new Exit_Listener(findid));

		findid.setLocation(800, 350);
		findid.setSize(500, 200);
		findid.setTitle("���̵� ã��");
		findid.setVisible(true);
	}
}

class find_id_message implements ActionListener {
	JTextField name, st_id;

	find_id_message(JTextField name, JTextField st_id) {
		this.name = name;
		this.st_id = st_id;
	}

	public void actionPerformed(ActionEvent e) {
		String name_c = name.getText();
		String st_id_c = st_id.getText();
		if (name_c.equals("") || st_id_c.equals("")) {
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("��� ������ �Է����ּ���."));

			JButton button1 = new JButton("�ݱ�");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // �������� �����ش�
			Fail.setVisible(true);
		} else {
			// �˻��Լ����� if������ ������
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			String found_id = null;

			try {
				found_id = UserManage.findID(name_c, Integer.parseInt(st_id_c));
				p.add(new JLabel(name_c + "���� ID : " + found_id));

				JButton button1 = new JButton("�ݱ�");
				pp.add(button1);
				button1.addActionListener(new Exit_Listener(Fail));
				Fail.add(p, "Center");
				Fail.add(pp, "South");
				Fail.pack(); // �������� �����ش�
				Fail.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "�Էµ� ������ ��ġ�ϴ� ���̵� �������� �ʽ��ϴ�.", "���̵� ã��", 0);
			}
		}
	}
}

class find_pw_gui implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JFrame findpw = new JFrame();
		JPanel panel = new JPanel();
		JButton Closebutton = new JButton("�ݱ�");

		findpw.add(panel);
		panel.setLayout(null);

		JLabel label1 = new JLabel("�� �� ��");
		JLabel label2 = new JLabel("��     ��");
		JLabel label3 = new JLabel("��     ��");

		JButton Addbutton0 = new JButton("Ȯ ��");

		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JTextField field3 = new JTextField(15);

		label1.setBounds(50, 50, 80, 40);
		label2.setBounds(50, 90, 80, 40);
		label3.setBounds(50, 130, 80, 40);
		field1.setBounds(130, 50, 200, 40);
		field2.setBounds(130, 90, 200, 40);
		field3.setBounds(130, 130, 200, 40);
		Addbutton0.setBounds(350, 50, 80, 40);
		Closebutton.setBounds(350, 90, 80, 40);

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(Addbutton0);
		panel.add(Closebutton);

		Addbutton0.addActionListener(new find_pw_message(field1, field2, field3));
		Closebutton.addActionListener(new Exit_Listener(findpw));

		findpw.setLocation(800, 350);
		findpw.setSize(500, 300);
		findpw.setTitle("��й�ȣ ã��");
		findpw.setVisible(true);
	}
}

class find_pw_message implements ActionListener {
	JTextField id, name, st_id;

	find_pw_message(JTextField id, JTextField name, JTextField st_id) {
		this.id = id;
		this.name = name;
		this.st_id = st_id;
	}

	public void actionPerformed(ActionEvent e) {
		String id_c = id.getText();
		String name_c = name.getText();
		String st_id_c = st_id.getText();
		if (id_c.equals("") || name_c.equals("") || st_id_c.equals("")) {
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("��� ������ �Է����ּ���."));

			JButton button1 = new JButton("�ݱ�");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // �������� �����ش�
			Fail.setVisible(true);
		} else {
			// �˻��Լ����� if������ ������
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();

			String found_pw;
			try {
				found_pw = UserManage.findPW(id_c, name_c, Integer.parseInt(st_id_c));
				p.add(new JLabel(name_c + "���� ��й�ȣ  : " + found_pw));

				JButton button1 = new JButton("�ݱ�");
				pp.add(button1);
				button1.addActionListener(new Exit_Listener(Fail));
				Fail.add(p, "Center");
				Fail.add(pp, "South");
				Fail.pack(); // �������� �����ش�
				Fail.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "�Էµ� ������ ��ġ�ϴ� ��й�ȣ�� �������� �ʽ��ϴ�.", "���̵� ã��", 0);
			}
		}
	}
}

class User_sign_up implements ActionListener {
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
	JTextField field1, field4, field5, field6, field7, field8;
	JPasswordField field2, field3;

	public void actionPerformed(ActionEvent e) {

		CurFrame.distinct_check = false;

		JFrame signup = new JFrame();
		JPanel panel = new JPanel();
		JButton Closebutton = new JButton("�ݱ�");

		signup.add(panel);
		panel.setLayout(null);

		label1 = new JLabel("��   ��   ��");
		label2 = new JLabel("�� �� �� ȣ");
		label3 = new JLabel("��й�ȣȮ��");
		label4 = new JLabel("��        ��");
		label5 = new JLabel("��        ��");
		label6 = new JLabel("��        ��");
		label7 = new JLabel("��        ��");
		label8 = new JLabel("�޴��� ��ȣ");
		label9 = new JLabel("�� ȣ �� ��");

		JButton Addbutton0 = new JButton("Ȯ ��");
		JButton Distinct = new JButton("�ߺ�Ȯ��");

		JTextField field1 = new JTextField(15);
		JPasswordField field2 = new JPasswordField(15);
		JPasswordField field3 = new JPasswordField(15);
		JTextField field4 = new JTextField(15);
		JTextField field5 = new JTextField(15);
		String[] comboGrade = { "1", "2", "3", "4", "5", "6" };
		JComboBox field6 = new JComboBox(comboGrade);
		String[] comboName = { " �濵���� ", " �������� ", " �������� ", " �̼����� ", " ���Ǵ��� " };
		JComboBox field7 = new JComboBox(comboName);
		JTextField field8 = new JTextField(15);
		String[] combogenre = { "����", "�ڱ���", "����", "����", "IT" };
		JComboBox field9 = new JComboBox(combogenre);

		label1.setBounds(50, 20, 80, 30);
		label2.setBounds(50, 60, 80, 30);
		label3.setBounds(50, 100, 80, 30);
		label4.setBounds(50, 140, 80, 30);
		label5.setBounds(50, 180, 80, 30);
		label6.setBounds(50, 220, 80, 30);
		label7.setBounds(50, 260, 80, 30);
		label8.setBounds(50, 300, 80, 30);
		label9.setBounds(50, 340, 80, 30);
		field1.setBounds(130, 20, 200, 30);
		field2.setBounds(130, 60, 200, 30);
		field3.setBounds(130, 100, 200, 30);
		field4.setBounds(130, 140, 200, 30);
		field5.setBounds(130, 180, 200, 30);
		field6.setBounds(130, 220, 200, 30);
		field7.setBounds(130, 260, 200, 30);
		field8.setBounds(130, 300, 200, 30);
		field9.setBounds(130, 340, 200, 30);
		Distinct.setBounds(350, 20, 120, 30);
		Addbutton0.setBounds(350, 60, 120, 30);
		Closebutton.setBounds(350, 100, 120, 30);

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(label4);
		panel.add(field4);
		panel.add(label5);
		panel.add(field5);
		panel.add(label6);
		panel.add(field6);
		panel.add(label7);
		panel.add(field7);
		panel.add(label8);
		panel.add(field8);
		panel.add(label9);
		panel.add(field9);
		panel.add(Distinct);
		panel.add(Addbutton0);
		panel.add(Closebutton);

		Addbutton0.addActionListener(
				new Sign_up_message(field1, field2, field3, field4, field5, field6, field7, field8, field9, signup));
		Distinct.addActionListener(new Distinct_Check_Listener(field1));
		Closebutton.addActionListener(new Exit_Listener(signup));

		signup.setLocation(800, 350);
		signup.setSize(500, 450);
		signup.setTitle("ȸ������");
		signup.setVisible(true);
	}
}

class Sign_up_message implements ActionListener {
	private JTextField id, pw, pw2, name, st_id, phone_num = null;
	private JComboBox major, grade, fav_genre = null;
	private JFrame signup;

	Sign_up_message(JTextField id, JTextField pw, JTextField pw2, JTextField name, JTextField st_id, JComboBox grade,
			JComboBox major, JTextField phone_num, JComboBox fav_gerne, JFrame signup) {
		this.id = id;
		this.pw = pw;
		this.pw2 = pw2;
		this.name = name;
		this.st_id = st_id;
		this.grade = grade;
		this.major = major;
		this.phone_num = phone_num;
		this.fav_genre = fav_gerne;
		this.signup = signup;
	}

	public void actionPerformed(ActionEvent arg0) {
		String id_c = id.getText();
		String pw_c = pw.getText();
		String pw2_c = pw2.getText();
		String name_c = name.getText();
		String st_id_c = st_id.getText();
		String grade_c = grade.getSelectedItem().toString();
		String major_c = major.getSelectedItem().toString();
		String phone_num_c = phone_num.getText();
		String fav_genre_c = fav_genre.getSelectedItem().toString();

		if (!id_c.equals("") && !pw_c.equals("") && !pw2_c.equals("") && !name_c.equals("") && !st_id_c.equals("")
				&& !grade_c.equals("") && !major_c.equals("") && !phone_num_c.equals("") && !fav_genre_c.equals("")
				&& pw_c.equals(pw2_c)) {
			if (CurFrame.distinct_check) {
				JFrame suc = new JFrame(""); // Fail�������� ����
				suc.setLocation(1000, 500); // ��ġ����
				suc.setPreferredSize(new Dimension(250, 110));// ũ������
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("ȸ�������� �Ϸ�Ǿ����ϴ�!"));

				insertTask.insertSignUpDB(id_c, pw_c, name_c, Integer.parseInt(st_id_c), Integer.parseInt(grade_c),
						major_c, phone_num_c, fav_genre_c);

				JButton button1 = new JButton("Ȯ��");
				pp.add(button1);
				button1.addActionListener(new Exit_Listener(suc));
				// ���⼭ �����ͺ��̽��� üũ�ϴ� ����� ������ ����ؾ��Ѵ�.
				suc.add(p, "Center");
				suc.add(pp, "South");
				suc.pack(); // �������� �����ش�
				suc.setVisible(true); // �гε��� �����ش�
				signup.setVisible(false);
			} else {
				JFrame Fail = new JFrame(""); // Fail�������� ����
				Fail.setLocation(1000, 500); // ��ġ����
				Fail.setPreferredSize(new Dimension(250, 110));// ũ������
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("���̵� �ߺ�Ȯ���� ���ֽʽÿ�."));

				JButton button1 = new JButton("�ݱ�");
				pp.add(button1);
				button1.addActionListener(new Exit_Listener(Fail));
				Fail.add(p, "Center");
				Fail.add(pp, "South");
				Fail.pack(); // �������� �����ش�
				Fail.setVisible(true);
			}
		} else if (!pw_c.equals("") && !pw2_c.equals("") && !pw_c.equals(pw2_c)) {
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("��й�ȣ�� �����ϰ� �ۼ����ּ���."));

			JButton button1 = new JButton("�ݱ�");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // �������� �����ش�
			Fail.setVisible(true);
		} else {
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("��� ������ �Է����ּ���."));

			JButton button1 = new JButton("�ݱ�");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // �������� �����ش�
			Fail.setVisible(true);
		}

	}
}
