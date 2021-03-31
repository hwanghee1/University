package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBtask.selectTask;

//ȸ����Ȳ
class User_Show_Listener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		selectTask seltask = new selectTask();
		JFrame f = new JFrame();
		String[] name = { "id", "�̸�", "�й�", "�г�", "����", "�ڵ��� ��ȣ" };

		DefaultTableModel dt = new DefaultTableModel(name, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);

		JButton button1 = new JButton("������Ȯ��");
		JButton button2 = new JButton("�ݱ�");
		JLabel label = new JLabel("ȸ�� ���� Ȯ��");

		JPanel p = new JPanel();
		p.add(button1);
		p.add(button2);

		button1.addActionListener(new User_BorrowState_Listener(jt, dt));

		button2.addActionListener(new Exit_Listener(f));

		JPanel pp = new JPanel();
		String[] comboName = { " ID  ", " �й� ", "�̸�" };

		JComboBox combo = new JComboBox(comboName);
		JTextField jtf = new JTextField(20);
		JButton search = new JButton("�˻�");

		search.addActionListener(new AdminSearch_User_Listener(dt, combo, jtf));

		pp.add(combo);
		pp.add(jtf);
		pp.add(search);

		seltask.AdminselectUserDB(dt);

		f.setSize(900, 400);
		f.setLocation(800, 350);
		f.setTitle("������Ȳ");
		f.add(label, "North");
		f.add(jsp, "Center");
		f.add(p, "East");
		f.add(pp, "South");
		f.setVisible(true);
	}
}