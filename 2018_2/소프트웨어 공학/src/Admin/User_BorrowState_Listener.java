package Admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBtask.selectTask;

//�ش� ������ ������Ȳ�� ���ִ� �Լ�
class User_BorrowState_Listener implements ActionListener {
	String id = null;
	DefaultTableModel dt;
	JTable t;

	User_BorrowState_Listener(JTable t, DefaultTableModel dt) {
		this.t = t;
		this.dt = dt;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int row = t.getSelectedRow();
			id = t.getValueAt(row, 0).toString();

			selectTask seltask = new selectTask();

			JFrame f = new JFrame();
			String[] name = { "å��ȣ", "����å", "���� ��¥", "�ݳ� ����" };
			DefaultTableModel dt = new DefaultTableModel(name, 0);
			JTable jt = new JTable(dt);
			JScrollPane jsp = new JScrollPane(jt);

			JLabel label = new JLabel("���� ����");
			JButton button1 = new JButton("�ݱ�");

			button1.addActionListener(new Exit_Listener(f));

			seltask.AdminselectBorrowUserDB(t, dt);

			JPanel p = new JPanel();
			p.add(button1);

			f.setSize(900, 300);
			f.setLocation(800, 350);
			f.setTitle("�������� Ȯ��");
			f.add(label, "North");
			f.add(jsp, "Center");
			f.add(p, "South");
			f.setVisible(true);
		} catch (Exception e2) {
			if (id == null) {
				JFrame Fail = new JFrame(""); // Fail�������� ����
				Fail.setLocation(1000, 500); // ��ġ����
				Fail.setPreferredSize(new Dimension(250, 110));// ũ������
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("ȸ���� ���� ���ֽñ� �ٶ��ϴ�."));

				JButton button1 = new JButton("Ȯ��");
				pp.add(button1);
				button1.addActionListener(new Exit_Listener(Fail));
				Fail.add(p, "Center");
				Fail.add(pp, "South");
				Fail.pack(); // �������� �����ش�
				Fail.setVisible(true); // �гε��� �����ش�
			}
		}
	}
}