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

//책추가
class BookAddWindow_Listener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		JFrame f = new JFrame();
		JPanel panel = new JPanel();
		f.add(panel);

		String[] gengre = { "문학", "자기계발", "예술", "경제", "IT" };
		String[] major = { " 경영대학 ", " 공과대학 ", " 문과대학 ", " 미술대학 ", " 음악대학 " };

		JLabel label1 = new JLabel("책   이   름");
		JLabel label2 = new JLabel("저        자");
		JLabel label3 = new JLabel("출   판  사");
		JLabel label4 = new JLabel("장        르");
		JLabel label5 = new JLabel("전 공 대 학");
		JLabel label6 = new JLabel("책   링  크");

		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JTextField field3 = new JTextField(15);
		JTextField field5 = new JTextField(15);
		JTextField field6 = new JTextField(15);

		JComboBox combo = new JComboBox(gengre);
		combo.setPreferredSize(new Dimension(170, 30));
		JComboBox majorcombo = new JComboBox(major);
		majorcombo.setPreferredSize(new Dimension(170, 30));

		JButton Addbutton = new JButton("추가");
		JButton Closebutton = new JButton("닫기");
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

		// Dimension에서 정확한 세로 위치 설정하고 CurTable함수로 ComboBox를 String으로 받아와야함

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
		f.setTitle("책 추가");
		f.setVisible(true);

	}
}