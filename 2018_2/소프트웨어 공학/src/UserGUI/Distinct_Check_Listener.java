package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Admin.Exit_Listener;
import UserTask.UserManage;

public class Distinct_Check_Listener implements ActionListener {
	JTextField id = null;
	
	Distinct_Check_Listener(JTextField id){
		this.id = id;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(UserManage.distinctCheck(id.getText())) {
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("�ߺ�Ȯ�� �Ǿ����ϴ�."));
			
			CurFrame.distinct_check = true;
			id.setEnabled(false);
			
			JButton button1 = new JButton("Ȯ��");
			pp.add(button1);
			button1.addActionListener(new Exit_Listener(Fail));
			Fail.add(p, "Center");
			Fail.add(pp, "South");
			Fail.pack(); // �������� �����ش�
			Fail.setVisible(true); // �гε��� �����ش�
		}
		else {
			JFrame Fail = new JFrame(""); // Fail�������� ����
			Fail.setLocation(1000, 500); // ��ġ����
			Fail.setPreferredSize(new Dimension(250, 110));// ũ������
			JPanel p = new JPanel();
			JPanel pp = new JPanel();
			p.add(new JLabel("������ ���̵� �����մϴ�."));

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
