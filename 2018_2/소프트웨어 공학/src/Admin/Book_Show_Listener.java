package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBtask.selectTask;

//도서현황
class Book_Show_Listener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		selectTask seltask = new selectTask();
		JFrame f = new JFrame();
		String[] name = { "id", "책이름", "저자", "대출여부", "대출 빈도", "대출일", "반납일" };

		DefaultTableModel dt = new DefaultTableModel(name, 0);
		JTable jt = new JTable(dt);
		JScrollPane jsp = new JScrollPane(jt);

		JButton button1 = new JButton("삭제");
		JButton button2 = new JButton("추가");
		JLabel label = new JLabel("도서현황");

		JPanel p = new JPanel();
		p.add(button1);
		p.add(button2);

		button1.addActionListener(new Book_Refusewindow());
		button2.addActionListener(new BookAddWindow_Listener());
		seltask.AdminselectBookDB(dt);

		JPanel pp = new JPanel();
		String[] comboName = { "책이름 ", "저자" };

		JComboBox combo = new JComboBox(comboName);
		JTextField jtf = new JTextField(20);
		JButton search = new JButton("검색");

		search.addActionListener(new AdminSearch_Book_Listener(dt, combo, jtf));

		pp.add(combo);
		pp.add(jtf);
		pp.add(search);

		CurTable.curdt = dt;
		CurTable.curjt = jt;

		f.setSize(900, 400);
		f.setLocation(800, 350);
		f.setTitle("도서현황");
		f.add(label, "North");
		f.add(jsp, "Center");
		f.add(p, "East");
		f.add(pp, "South");
		f.setVisible(true);
	}
}