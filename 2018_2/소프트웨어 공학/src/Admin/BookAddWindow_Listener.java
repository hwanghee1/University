package Admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//å�߰�
class BookAddWindow_Listener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		JFrame f = new JFrame();
		JPanel panel = new JPanel();
		f.add(panel);

		String[] gengre = { "����", "�ڱ���", "����", "����", "IT" };
		String[] major = { " �濵���� ", " �������� ", " �������� ", " �̼����� ", " ���Ǵ��� " };

		JLabel label1 = new JLabel("å   ��   ��");
		JLabel label2 = new JLabel("��        ��");
		JLabel label3 = new JLabel("��   ��  ��");
		JLabel label4 = new JLabel("��        ��");
		JLabel label5 = new JLabel("�� �� �� ��");
		JLabel label6 = new JLabel("å   ��  ũ");

		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JTextField field3 = new JTextField(15);
		JTextField field5 = new JTextField(15);
		JTextField field6 = new JTextField(15);

		JComboBox combo = new JComboBox(gengre);
		combo.setPreferredSize(new Dimension(170, 30));
		JComboBox majorcombo = new JComboBox(major);
		majorcombo.setPreferredSize(new Dimension(170, 30));

		JButton Addbutton = new JButton("�߰�");
		JButton Closebutton = new JButton("�ݱ�");
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(label4);
		panel.add(combo);
		panel.add(label5);
		panel.add(majorcombo);
		panel.add(label6);
		panel.add(field6);

		panel.add(Addbutton);
		panel.add(Closebutton);

		// Dimension���� ��Ȯ�� ���� ��ġ �����ϰ� CurTable�Լ��� ComboBox�� String���� �޾ƿ;���

		CurTable.Bname = field1;
		CurTable.authour = field2;
		CurTable.publisher = field3;
		CurTable.combogengre = combo.getSelectedItem().toString();
		CurTable.combomajor = majorcombo.getSelectedItem().toString();
		CurTable.picture = field6;

		Addbutton.addActionListener(new BookAdd_Listener());
		Closebutton.addActionListener(new Exit_Listener(f));
		f.setSize(300, 300);
		f.setLocation(800, 350);
		f.setTitle("å �߰�");
		f.setVisible(true);

	}
}