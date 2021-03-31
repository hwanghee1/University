package Admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DBtask.*;

//ȸ������ ����
class Signup_agree_Listener implements ActionListener {
	String id = null, name = null;
	DefaultTableModel dt = new DefaultTableModel();
	JTable t = new JTable();

	Signup_agree_Listener(JTable t, DefaultTableModel dt) {
		this.t = t;
		this.dt = dt;
	}

	public void actionPerformed(ActionEvent arg0) {

		try {
			int row = t.getSelectedRow();
			id = t.getValueAt(row, 0).toString();
			name = t.getValueAt(row, 2).toString();

			insertTask instask = new insertTask();
			deleteTask deltask = new deleteTask();
			selectTask seltask = new selectTask();

			instask.insertUserDB(id, name);
			deltask.deleteSignUpDB(id, name);
			seltask.selectSignUpDB(dt);
		} catch (Exception e) {
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
