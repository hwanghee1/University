package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class change_sql_passwd implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		JPanel panel = new JPanel();
		f.add(panel);
		
		JLabel label1 = new JLabel("MySQL root계정의 비밀번호를 입력하십시오.");

		JPasswordField field1 = new JPasswordField(15);
		JPanel panel1 = new JPanel();
		JButton Confirm = new JButton("확인");
		panel1.add(Confirm);
		panel.add(label1);
		panel.add(field1);
		

		panel.add(Confirm);

		Confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CurFrame.setSqlPasswd(field1.getText());	
			}
		});
		Confirm.addActionListener(new Exit_Listener(f));
		f.add(panel1,"South");
		f.setSize(300, 120);
		f.setLocation(800, 350);
		f.setTitle("DB 연동");
		f.setVisible(true);

	}

}
