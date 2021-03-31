package UserGUI;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Logo_action implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		try{CurFrame.Home_frame.setVisible(false);} catch(Exception e1) {}
		try {CurFrame.search_frame.setVisible(false);}catch (Exception exception) {}
		try {CurFrame.genre_frame.setVisible(false);}catch (Exception exception) {}
		try {CurFrame.major_frame.setVisible(false);}catch (Exception exception) {}
		try {CurFrame.popular_frame.setVisible(false);}catch (Exception exception) {}
		new User_Home(CurFrame.curr_user);
	}
}
