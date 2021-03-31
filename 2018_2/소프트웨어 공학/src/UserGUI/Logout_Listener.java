package UserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import LoginUserOrAdmin.LoginTask;

public class Logout_Listener implements ActionListener {
	JFrame f = new JFrame();

	public Logout_Listener(JFrame f) {
		this.f = f;
	}

	public void actionPerformed(ActionEvent e) {
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(false);

		try {
			CurFrame.Home_frame.setVisible(false);
		} catch (Exception exception) {
		}
		try {
			CurFrame.search_frame.setVisible(false);
		} catch (Exception exception) {
		}
		try {
			CurFrame.genre_frame.setVisible(false);
		} catch (Exception exception) {
		}
		try {
			CurFrame.major_frame.setVisible(false);
		} catch (Exception exception) {
		}
		try {
			CurFrame.popular_frame.setVisible(false);
		} catch (Exception exception) {
		}
		try {
			LoginTask.userLogOut(CurFrame.curr_user);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new login();
	}

}
