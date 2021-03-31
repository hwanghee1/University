package UserGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DBtask.searchTask;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class CurSearchTable{
	private static JComboBox com;
	private static JTextField text;
	private static int current_frame;
	private static int current_zzim_frame=0;
	
	public static void setzzimFrame(int num) {
		current_zzim_frame = num;
	}
	public static int getzzimFrame() {
		return current_zzim_frame;
	}
	
	public static JComboBox getCombo() {
		return com;
	}
	public static JTextField getText() {
		return text;
	}
	public static int getFrame() {
		return current_frame;
	}
	public static void setCombo(JComboBox combo) {
		com = combo;
	}
	public static void setText(JTextField textfield) {
		text = textfield;
	}
	public static void setFrame(int num) {
		current_frame = num;
	}
}
public class Change_UserBooksearch_Window implements ActionListener {
	   JFrame f;
	   JPanel p1;
	   JPanel p2;
	   JPanel p3;
	   DefaultTableModel dt;
	   JTable jt;
	   JScrollPane jsp;
	   JButton button2=null;


	   Change_UserBooksearch_Window(JFrame f, JPanel p1, JPanel p2,JPanel p3,   DefaultTableModel dt,   JTable jt,JScrollPane jsp, JButton button2,JComboBox com, JTextField text) {
		  CurSearchTable.setFrame(1);
	      this.f = f;
	      this.p1 = p1;
	      this.p2 = p2;
	      this.p3=p3;
	      this.dt =dt;
	      this.jt=jt;
	      this.jsp=jsp;
	      CurSearchTable.setCombo(com);
	      CurSearchTable.setText(text);
	      this.button2=button2;
	   }

	   public void actionPerformed(ActionEvent arg0) {
	      f.remove(p1);
	      f.remove(p2);
	      f.remove(p3);
	      f.remove(jt);
	      f.remove(jsp);
	      f.remove(button2);
	      
	      CurSearchTable.setFrame(1);
	      
	      searchTask serTask = new searchTask();
	      serTask.UserBookSearch(dt, CurSearchTable.getCombo(), CurSearchTable.getText());
	      
	      
	      
	      f.add(jsp, "Center");
	      f.add(p3, "East");
	      f.setVisible(true);

	   }

	}