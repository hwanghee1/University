package Admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBtask.deleteTask;
import DBtask.selectTask;

//��������
public class Book_del_Listener implements ActionListener {
	String id = null, name = null, borrowTF = null;
	DefaultTableModel dt = new DefaultTableModel();
	JTable t = new JTable();

	Book_del_Listener(JTable t, DefaultTableModel dt) {
		this.t = t;
		this.dt = dt;
	}

	public void actionPerformed(ActionEvent e) {

		try {
			int row = t.getSelectedRow();
			id = t.getValueAt(row, 0).toString();
			borrowTF = t.getValueAt(row, 3).toString();

			if (borrowTF.equals("false")) {
				JFrame Fail = new JFrame(""); // Fail�������� ����
				Fail.setLocation(1000, 500); // ��ġ����
				Fail.setPreferredSize(new Dimension(250, 110));// ũ������
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("�������� ������ ������ �Ұ��� �մϴ�."));

				JButton button1 = new JButton("Ȯ��");
				pp.add(button1);
				button1.addActionListener(new Exit_Listener(Fail));
				Fail.add(p, "Center");
				Fail.add(pp, "South");
				Fail.pack(); // �������� �����ش�
				Fail.setVisible(true); // �гε��� �����ش�

			} else {
				deleteTask deltask = new deleteTask();
				selectTask seltask = new selectTask();

				deltask.deleteBookDB(id);
				seltask.AdminselectBookDB(dt);
			}
		} catch (Exception e1) {
			if (id == null) {
				JFrame Fail = new JFrame(""); // Fail�������� ����
				Fail.setLocation(1000, 500); // ��ġ����
				Fail.setPreferredSize(new Dimension(250, 110));// ũ������
				JPanel p = new JPanel();
				JPanel pp = new JPanel();
				p.add(new JLabel("������ ���� ���ֽñ� �ٶ��ϴ�."));

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