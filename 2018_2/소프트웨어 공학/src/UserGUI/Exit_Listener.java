package UserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class Exit_Listener implements ActionListener {

	JFrame f = new JFrame();

	Exit_Listener(JFrame f) {
		this.f = f;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setVisible(false);
		} catch (Exception e1) {

		}
	}
}
