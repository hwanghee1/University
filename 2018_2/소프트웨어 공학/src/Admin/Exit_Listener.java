package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//�ݱ��ư
public class Exit_Listener implements ActionListener {

	JFrame f = new JFrame();

	public Exit_Listener(JFrame f) {
		this.f = f;
	}

	public void actionPerformed(ActionEvent e) {
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(false);
	}
}
