import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel {
	private CardLayout card;
	private final Panel me;

	private JPanel Main_Panel = new JPanel();
	private JPanel CreateAcc_Panel = new JPanel();
	private JPanel Login_Panel = new JPanel();
	private JPanel Withdraw_Panel = new JPanel();
	private JPanel Deposit_Panel = new JPanel();
	private JPanel Remittance_Panel = new JPanel();
	private JPanel ShowInfo_PW_Panel = new JPanel();
	private JPanel ShowInfo_Panel = new JPanel();

	private JLabel Main_explain = new JLabel("���¹�ȣ : ");
	private JLabel Main_Label = new JLabel("�ȳ��Ͻʴϱ�. Ȳ���� ATM�Դϴ�.");
	private JTextField Main_AccInput_Text = new JTextField();// ���� �Է� �ʵ�
	private JButton Main_newAcc_Button = new JButton();// ���� ������ư
	private JButton Main_login_Button = new JButton();// �α��� ��ư
	private JButton Main_exit_Button = new JButton("����");

	private JLabel CP_Owner_Label = new JLabel("������ : ");
	private JLabel CP_AccNum_Label = new JLabel("���¹�ȣ : ");
	private JLabel CP_Passwd_Label = new JLabel("��й�ȣ : ");
	private JLabel CP_Valance_Label = new JLabel("�ʱ��ܾ� : ");
	private JTextField CP_Owner_Text = new JTextField();
	private JTextField CP_AccNum_Text = new JTextField();
	private JPasswordField CP_Passwd_Pass = new JPasswordField();
	private JTextField CP_Valance_Text = new JTextField();
	private JButton CP_Finish_Button = new JButton("�Ϸ�");

	private JLabel LP_Hello_Label = new JLabel("ȫ�浿�� �ݰ����ϴ�.");
	private JButton LP_Deposit_Button = new JButton("����");
	private JButton LP_Withdraw_Button = new JButton("���");
	private JButton LP_Remittance_Button = new JButton("�۱�");
	private JButton LP_ShowInfo_Button = new JButton("��ȸ");
	private JButton LP_Logout_Button = new JButton("�α׾ƿ�");

	private JLabel DP_Main_Label = new JLabel("�Ա�");
	private JLabel DP_Explain_Label = new JLabel("�Ա��� �ݾ� : ");
	private JTextField DP_Amount_Text = new JTextField();
	private JButton DP_Finish_Button = new JButton("�Ϸ�");

	private JLabel WP_Main_Label = new JLabel("���");
	private JLabel WP_Amount_Label = new JLabel("����� �ݾ� : ");
	private JLabel WP_PW_Label = new JLabel("��й�ȣ : ");
	private JTextField WP_Amount_Text = new JTextField();
	private JPasswordField WP_PW_PassField = new JPasswordField();
	private JButton WP_Finish_Button = new JButton("�Ϸ�");

	private JLabel RP_Main_Label = new JLabel("�۱�");
	private JLabel RP_Acc_Label = new JLabel("�۱��� ���¹�ȣ : ");
	private JLabel RP_Amount_Label = new JLabel("�۱��� �ݾ� : ");
	private JLabel RP_PW_Label = new JLabel("��й�ȣ : ");
	private JTextField RP_Acc_Text = new JTextField();
	private JTextField RP_Amount_Text = new JTextField();
	private JPasswordField RP_PW_PassField = new JPasswordField();
	private JButton RP_Finish_Button = new JButton("�Ϸ�");

	private JLabel SPP_Main_Label = new JLabel("��ȸ");
	private JLabel SPP_PW_Label = new JLabel("��й�ȣ : ");
	private JPasswordField SPP_PW_PassField = new JPasswordField();
	private JButton SPP_Confirm_Button = new JButton("Ȯ��");

	private JLabel SP_Main_Label = new JLabel("��ȸ");
	private JLabel SP_Name_Label = new JLabel("ȫ�浿 ���� ����");
	private JLabel SP_Acc_Label = new JLabel("���¹�ȣ : 111 - 222");
	private JLabel SP_Val_Label = new JLabel("�ܾ� : 320000");
	private JButton SP_Confirm_Button = new JButton("Ȯ��");

	public Panel() {
		me = this;
		card = new CardLayout(0, 0);

		setLayout(card);
		Main_Panel.setPreferredSize(new Dimension(500, 300));
		Main_Panel.setLayout(null);

		Main_Panel.add(Main_explain);
		Main_Panel.add(Main_Label);
		Main_Panel.add(Main_AccInput_Text);
		Main_Panel.add(Main_newAcc_Button);
		Main_Panel.add(Main_login_Button);
		Main_Panel.add(Main_exit_Button);

		Main_explain.setBounds(50, 130, 100, 30);
		Main_Label.setBounds(135, 50, 200, 40);
		Main_AccInput_Text.setBounds(130, 130, 200, 30);
		Main_login_Button.setBounds(350, 130, 80, 30);
		Main_login_Button.setText("�α���");
		Main_newAcc_Button.setBounds(180, 200, 100, 30);
		Main_newAcc_Button.setText("���� ����");
		Main_exit_Button.setBounds(350, 200, 80, 30);

		CreateAcc_Panel.setPreferredSize(new Dimension(500, 300));
		CreateAcc_Panel.setLayout(null);

		CreateAcc_Panel.add(CP_Owner_Label);
		CreateAcc_Panel.add(CP_Owner_Text);
		CreateAcc_Panel.add(CP_AccNum_Label);
		CreateAcc_Panel.add(CP_AccNum_Text);
		CreateAcc_Panel.add(CP_Passwd_Label);
		CreateAcc_Panel.add(CP_Passwd_Pass);
		CreateAcc_Panel.add(CP_Valance_Text);
		CreateAcc_Panel.add(CP_Valance_Label);
		CreateAcc_Panel.add(CP_Finish_Button);

		CP_Owner_Label.setBounds(40, 30, 50, 20);
		CP_Owner_Text.setBounds(95, 30, 150, 20);
		CP_AccNum_Label.setBounds(30, 70, 80, 20);
		CP_AccNum_Text.setBounds(95, 70, 150, 20);
		CP_Passwd_Label.setBounds(30, 110, 70, 20);
		CP_Passwd_Pass.setBounds(95, 110, 150, 20);
		CP_Valance_Label.setBounds(30, 150, 70, 20);
		CP_Valance_Text.setBounds(95, 150, 150, 20);
		CP_Finish_Button.setBounds(380, 200, 70, 40);

		Login_Panel.setPreferredSize(new Dimension(500, 300));
		Login_Panel.setLayout(null);

		Login_Panel.add(LP_Hello_Label);
		Login_Panel.add(LP_Deposit_Button);
		Login_Panel.add(LP_Logout_Button);
		Login_Panel.add(LP_Remittance_Button);
		Login_Panel.add(LP_ShowInfo_Button);
		Login_Panel.add(LP_Withdraw_Button);

		LP_Hello_Label.setBounds(190, 20, 150, 20);
		LP_Deposit_Button.setBounds(80, 60, 80, 40);
		LP_Withdraw_Button.setBounds(80, 120, 80, 40);
		LP_Remittance_Button.setBounds(340, 60, 80, 40);
		LP_ShowInfo_Button.setBounds(340, 120, 80, 40);
		LP_Logout_Button.setBounds(200, 190, 100, 40);

		Deposit_Panel.setPreferredSize(new Dimension(500, 300));
		Deposit_Panel.setLayout(null);

		Deposit_Panel.add(DP_Main_Label);
		Deposit_Panel.add(DP_Explain_Label);
		Deposit_Panel.add(DP_Amount_Text);
		Deposit_Panel.add(DP_Finish_Button);

		DP_Main_Label.setBounds(230, 30, 50, 40);
		DP_Main_Label.setFont(new Font("HY�߰��", 1, 18));
		DP_Explain_Label.setBounds(70, 100, 100, 30);
		DP_Amount_Text.setBounds(160, 100, 200, 30);
		DP_Finish_Button.setBounds(370, 180, 80, 40);

		Withdraw_Panel.setPreferredSize(new Dimension(500, 300));
		Withdraw_Panel.setLayout(null);

		Withdraw_Panel.add(WP_Amount_Label);
		Withdraw_Panel.add(WP_Amount_Text);
		Withdraw_Panel.add(WP_Finish_Button);
		Withdraw_Panel.add(WP_Main_Label);
		Withdraw_Panel.add(WP_PW_Label);
		Withdraw_Panel.add(WP_PW_PassField);

		WP_Main_Label.setBounds(230, 30, 50, 40);
		WP_Main_Label.setFont(new Font("HY�߰��", 1, 18));
		WP_Amount_Label.setBounds(70, 80, 100, 30);
		WP_Amount_Text.setBounds(160, 80, 200, 30);
		WP_PW_Label.setBounds(87, 130, 80, 30);
		WP_PW_PassField.setBounds(160, 130, 200, 30);
		WP_Finish_Button.setBounds(370, 180, 80, 40);

		Remittance_Panel.setPreferredSize(new Dimension(500, 300));
		Remittance_Panel.setLayout(null);

		Remittance_Panel.add(RP_Acc_Label);
		Remittance_Panel.add(RP_Acc_Text);
		Remittance_Panel.add(RP_Amount_Label);
		Remittance_Panel.add(RP_Amount_Text);
		Remittance_Panel.add(RP_Finish_Button);
		Remittance_Panel.add(RP_Main_Label);
		Remittance_Panel.add(RP_PW_Label);
		Remittance_Panel.add(RP_PW_PassField);

		RP_Main_Label.setBounds(230, 30, 50, 40);
		RP_Main_Label.setFont(new Font("HY�߰��", 1, 18));
		RP_Acc_Label.setBounds(55, 75, 150, 30);
		RP_Acc_Text.setBounds(160, 75, 200, 30);
		RP_Amount_Label.setBounds(80, 120, 100, 30);
		RP_Amount_Text.setBounds(160, 120, 200, 30);
		RP_PW_Label.setBounds(95, 160, 80, 30);
		RP_PW_PassField.setBounds(160, 160, 200, 30);
		RP_Finish_Button.setBounds(370, 200, 80, 40);

		ShowInfo_PW_Panel.setPreferredSize(new Dimension(500, 300));
		ShowInfo_PW_Panel.setLayout(null);

		ShowInfo_PW_Panel.add(SPP_Confirm_Button);
		ShowInfo_PW_Panel.add(SPP_Main_Label);
		ShowInfo_PW_Panel.add(SPP_PW_Label);
		ShowInfo_PW_Panel.add(SPP_PW_PassField);

		SPP_Main_Label.setBounds(230, 30, 50, 40);
		SPP_Main_Label.setFont(new Font("HY�߰��", 1, 18));
		SPP_PW_Label.setBounds(70, 100, 100, 30);
		SPP_PW_PassField.setBounds(160, 100, 200, 30);
		SPP_Confirm_Button.setBounds(370, 200, 80, 40);

		ShowInfo_Panel.setPreferredSize(new Dimension(500, 300));
		ShowInfo_Panel.setLayout(null);

		ShowInfo_Panel.add(SP_Main_Label);
		ShowInfo_Panel.add(SP_Confirm_Button);
		ShowInfo_Panel.add(SP_Name_Label);
		ShowInfo_Panel.add(SP_Acc_Label);
		ShowInfo_Panel.add(SP_Val_Label);

		SP_Main_Label.setBounds(230, 30, 50, 40);
		SP_Main_Label.setFont(new Font("HY�߰��", 1, 18));
		SP_Name_Label.setBounds(80, 70, 200, 30);
		SP_Acc_Label.setBounds(80, 110, 200, 30);
		SP_Val_Label.setBounds(80, 150, 200, 30);
		SP_Confirm_Button.setBounds(370, 200, 80, 40);

		add("MP", Main_Panel);
		add("CP", CreateAcc_Panel);
		add("LP", Login_Panel);
		add("DP", Deposit_Panel);
		add("WP", Withdraw_Panel);
		add("RP", Remittance_Panel);
		add("SPP", ShowInfo_PW_Panel);
		add("SP", ShowInfo_Panel);

		SwitchPanel sp = new SwitchPanel();

		Main_newAcc_Button.addActionListener(sp);
		Main_exit_Button.addActionListener(sp);
		Main_login_Button.addActionListener(sp);
		CP_Finish_Button.addActionListener(sp);
		LP_Logout_Button.addActionListener(sp);
		LP_Deposit_Button.addActionListener(sp);
		LP_Withdraw_Button.addActionListener(sp);
		LP_Remittance_Button.addActionListener(sp);
		LP_ShowInfo_Button.addActionListener(sp);
		DP_Finish_Button.addActionListener(sp);
		WP_Finish_Button.addActionListener(sp);
		RP_Finish_Button.addActionListener(sp);
		SPP_Confirm_Button.addActionListener(sp);
		SP_Confirm_Button.addActionListener(sp);
	}

	private class SwitchPanel extends Frame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String File = "Account.txt";
			ATM_FILE.FileCheck(File);

			Account user;
			Account[] acc = ATM_FILE.ReadFile(File);

			if (e.getSource() == Main_newAcc_Button) // ���������� ���»�����ư
				card.show(me, "CP");
			if (e.getSource() == CP_Finish_Button) { // ���»��������� �Ϸ��ư
				String owner = CP_Owner_Text.getText();
				String accNum = CP_AccNum_Text.getText();
				String passwd = CP_Passwd_Pass.getText();
				String bal = CP_Valance_Text.getText();
				try {
					ATM_FILE.AppendFile(new Account(accNum, owner, passwd, Integer.parseInt(bal)), File);
					JOptionPane.showMessageDialog(null, "���ο� ���°� �����Ǿ����ϴ�!");
					card.show(me, "MP");
					CP_Owner_Text.setText("");
					CP_AccNum_Text.setText("");
					CP_Passwd_Pass.setText("");
					CP_Valance_Text.setText("");
					if (owner == null || accNum == null || passwd == null || bal == null)
						throw new Exception();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "���»�������! Ȯ���Ͽ��ֽʽÿ�.");
					card.show(me, "MP");
					CP_Owner_Text.setText("");
					CP_AccNum_Text.setText("");
					CP_Passwd_Pass.setText("");
					CP_Valance_Text.setText("");
				}
			}
			if (e.getSource() == Main_exit_Button) // ���������� �����ư
				System.exit(0);
			if (e.getSource() == Main_login_Button) { // ���������� �α��� ��ư
				String accNum = Main_AccInput_Text.getText();
				try {
					user = ATM_FILE.FindUser(acc, acc.length, accNum);
					if (user == null) {
						JOptionPane.showMessageDialog(null, "ã�� ���°� �����ϴ�!");
						Main_AccInput_Text.setText("");
					} else {
						LP_Hello_Label.setText(user.GetName() + "�� �ݰ����ϴ�!");
						card.show(me, "LP");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "���»����� �������ֽʽÿ�!");
				}
			}
			if (e.getSource() == LP_Logout_Button){// �۾����������� �α׾ƿ� ��ư
				Main_AccInput_Text.setText("");
				card.show(me, "MP");
			}
			if (e.getSource() == LP_Deposit_Button) // �۾����������� �Աݹ�ư
				card.show(me, "DP");
			if (e.getSource() == DP_Finish_Button) { // �Ա������� �����ư
				int amnt = Integer.parseInt(DP_Amount_Text.getText());
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				if (user.Deposit(amnt)) {
					ATM_FILE.RefreshFile(acc, acc.length, File);
					JOptionPane.showMessageDialog(null,
							amnt + "�� �Աݼ���!\n" + user.GetName() +"���� �ܾ� : " + user.GetBalance());
					DP_Amount_Text.setText("");
					card.show(me, "LP");
				}
				else
					JOptionPane.showMessageDialog(null, "�߸� �Է��ϼ̽��ϴ�.");
			}
			if (e.getSource() == LP_Withdraw_Button) // ���������� ��ݹ�ư
				card.show(me, "WP");
			if (e.getSource() == WP_Finish_Button) { // ��������� �����ư
				int amnt = Integer.parseInt(WP_Amount_Text.getText());
				String passwd = WP_PW_PassField.getText();
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				try {
					if(user.WithRaw(passwd, amnt) != 0)
						{
							ATM_FILE.RefreshFile(acc, acc.length, File);
							JOptionPane.showMessageDialog(null,
								amnt + "�� ��ݼ���!\n" + user.GetName() +"���� �ܾ� : " + user.GetBalance());
							WP_Amount_Text.setText("");
							WP_PW_PassField.setText("");
							card.show(me, "LP");
						}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					WP_Amount_Text.setText("");
					WP_PW_PassField.setText("");
				}
			}
			if (e.getSource() == LP_Remittance_Button) // ���������� �۱ݹ�ư
				card.show(me, "RP");
			if (e.getSource() == RP_Finish_Button) { // �۱������� �����ư
				String sendToAcc = RP_Acc_Text.getText();
				String passwd = RP_PW_PassField.getText();
				int amnt = Integer.parseInt(RP_Amount_Text.getText());
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				Account receiver = ATM_FILE.FindUser(acc, acc.length, sendToAcc);
				if(receiver == null)
				{
					JOptionPane.showMessageDialog(null, "�۱��Ͻ� ���¹�ȣ�� Ȯ���Ͽ� �ֽʽÿ�.");
					RP_Acc_Text.setText("");
				}
				if(user.Remittance(receiver, passwd, amnt))
				{
					ATM_FILE.RefreshFile(acc, acc.length, File);
					JOptionPane.showMessageDialog(null,receiver.GetName() + "�Կ��� �۱ݼ���!\n "+ user.GetName() +"���� �ܾ� : " + user.GetBalance());
					RP_Acc_Text.setText("");
					RP_Amount_Text.setText("");
					RP_PW_PassField.setText("");
					card.show(me, "LP");
				}
			}
			if (e.getSource() == LP_ShowInfo_Button) { // ���������� ��ȸ��ư
				card.show(me, "SPP");
			}
			if (e.getSource() == SPP_Confirm_Button) { // ��ȸ������ ��й�ȣ Ȯ�ι�ư
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				String passwd = SPP_PW_PassField.getText();
				try {
					user.ShowAccount(passwd);
					JOptionPane.showMessageDialog(null, "��й�ȣ Ȯ��!");
					SP_Name_Label.setText(user.GetName() + "���� ����");
					SP_Acc_Label.setText("���¹�ȣ : " + user.GetNumber());
					SP_Val_Label.setText("�ܾ� : " + user.GetBalance());
					SPP_PW_PassField.setText("");
					card.show(me, "SP");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					SPP_PW_PassField.setText("");
				}
			}
			if (e.getSource() == SP_Confirm_Button) // ��ȸ������ �����ư
				card.show(me, "LP");

		}

	}

}
