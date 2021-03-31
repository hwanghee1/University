package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBtask.searchTask;

class AdminSearch_Book_Listener implements ActionListener {
	DefaultTableModel dt;
	JComboBox combo;
	JTextField field;

	AdminSearch_Book_Listener(DefaultTableModel dt, JComboBox combo, JTextField field) {
		this.dt = dt;
		this.combo = combo;
		this.field = field;
	}

	public void actionPerformed(ActionEvent arg0) {
		searchTask sertask = new searchTask();
		sertask.AdminBookSearch(dt, combo, field);
	}

}