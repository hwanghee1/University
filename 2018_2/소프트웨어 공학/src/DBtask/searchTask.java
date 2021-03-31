package DBtask;

import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import UserGUI.CurFrame;

public class searchTask {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public searchTask() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/library_system?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", CurFrame.getSqlPasswd());
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> �ε� fail");
		} catch (SQLException e) {
			System.out.println(e + "=> ���� fail");
		}
	}

	public void AdminBookSearch(DefaultTableModel dt, JComboBox combo, JTextField field) {
		String comboName, word;

		comboName = combo.getSelectedItem().toString();

		if (comboName.trim().equals("å�̸�")) {
			comboName = "bookname";
		} else if (comboName.trim().equals("����")) {
			comboName = "author";
		}

		word = field.getText();

		String sql = "SELECT * FROM bookdb WHERE " + comboName.trim() + " LIKE '%" + word.trim() + "%'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// DefaultTableModel�� �ִ� ���� ������ �����
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11) };

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
		}

	}// getUserSearch()

	public void AdminUserSearch(DefaultTableModel dt, JComboBox combo, JTextField field) {
		String comboName, word;

		comboName = combo.getSelectedItem().toString();

		if (comboName.trim().equals("�й�")) {
			comboName = "studentnum";
		} else if (comboName.trim().equals("�̸�")) {
			comboName = "name";
		}

		word = field.getText();

		String sql = "SELECT * FROM userdb WHERE " + comboName.trim() + " LIKE '%" + word.trim() + "%'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// DefaultTableModel�� �ִ� ���� ������ �����
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7) };

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
		}

	}// getUserSearch()

	public void UserBookSearch(DefaultTableModel dt, JComboBox combo, JTextField field) {
		String comboName, word;

		comboName = combo.getSelectedItem().toString();

		if (comboName.trim().equals("������")) {
			comboName = "bookname";
		} else if (comboName.trim().equals("����")) {
			comboName = "author";
		}

		word = field.getText();

		String sql = "SELECT * FROM bookdb WHERE " + comboName.trim() + " LIKE '%" + word.trim() + "%'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// DefaultTableModel�� �ִ� ���� ������ �����
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6),
						rs.getString(8) };
				if (data[5].equals("true")) {
					data[5] = "����";
				} else {
					data[5] = "�Ұ���";
				}

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
		}

	}// getUserSearch()

}// Ŭ������