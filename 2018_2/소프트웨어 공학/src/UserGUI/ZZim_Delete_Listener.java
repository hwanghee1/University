package UserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBtask.deleteTask;
import DBtask.selectTask;
import DBtask.updateTask;

public class ZZim_Delete_Listener implements ActionListener {
	private JTable jt;
	private DefaultTableModel model;

	public ZZim_Delete_Listener(JTable jt, DefaultTableModel dt) {
		this.jt = jt;
		this.model = dt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int row = jt.getSelectedRow();
			int book_num = Integer.parseInt(jt.getValueAt(row, 0).toString());

			deleteTask.deleteZZimDB(CurFrame.curr_user.getID(), book_num);
			selectTask.selectZZimDB(CurFrame.curr_user.getID(), model);
		} catch (Exception e2) {

		}
	}

}
