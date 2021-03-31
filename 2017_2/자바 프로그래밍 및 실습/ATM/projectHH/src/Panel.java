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

	private JLabel Main_explain = new JLabel("계좌번호 : ");
	private JLabel Main_Label = new JLabel("안녕하십니까. 황희의 ATM입니다.");
	private JTextField Main_AccInput_Text = new JTextField();// 계좌 입력 필드
	private JButton Main_newAcc_Button = new JButton();// 계좌 생성버튼
	private JButton Main_login_Button = new JButton();// 로그인 버튼
	private JButton Main_exit_Button = new JButton("종료");

	private JLabel CP_Owner_Label = new JLabel("예금주 : ");
	private JLabel CP_AccNum_Label = new JLabel("계좌번호 : ");
	private JLabel CP_Passwd_Label = new JLabel("비밀번호 : ");
	private JLabel CP_Valance_Label = new JLabel("초기잔액 : ");
	private JTextField CP_Owner_Text = new JTextField();
	private JTextField CP_AccNum_Text = new JTextField();
	private JPasswordField CP_Passwd_Pass = new JPasswordField();
	private JTextField CP_Valance_Text = new JTextField();
	private JButton CP_Finish_Button = new JButton("완료");

	private JLabel LP_Hello_Label = new JLabel("홍길동님 반갑습니다.");
	private JButton LP_Deposit_Button = new JButton("예금");
	private JButton LP_Withdraw_Button = new JButton("출금");
	private JButton LP_Remittance_Button = new JButton("송금");
	private JButton LP_ShowInfo_Button = new JButton("조회");
	private JButton LP_Logout_Button = new JButton("로그아웃");

	private JLabel DP_Main_Label = new JLabel("입급");
	private JLabel DP_Explain_Label = new JLabel("입금할 금액 : ");
	private JTextField DP_Amount_Text = new JTextField();
	private JButton DP_Finish_Button = new JButton("완료");

	private JLabel WP_Main_Label = new JLabel("출금");
	private JLabel WP_Amount_Label = new JLabel("출금할 금액 : ");
	private JLabel WP_PW_Label = new JLabel("비밀번호 : ");
	private JTextField WP_Amount_Text = new JTextField();
	private JPasswordField WP_PW_PassField = new JPasswordField();
	private JButton WP_Finish_Button = new JButton("완료");

	private JLabel RP_Main_Label = new JLabel("송금");
	private JLabel RP_Acc_Label = new JLabel("송금할 계좌번호 : ");
	private JLabel RP_Amount_Label = new JLabel("송금할 금액 : ");
	private JLabel RP_PW_Label = new JLabel("비밀번호 : ");
	private JTextField RP_Acc_Text = new JTextField();
	private JTextField RP_Amount_Text = new JTextField();
	private JPasswordField RP_PW_PassField = new JPasswordField();
	private JButton RP_Finish_Button = new JButton("완료");

	private JLabel SPP_Main_Label = new JLabel("조회");
	private JLabel SPP_PW_Label = new JLabel("비밀번호 : ");
	private JPasswordField SPP_PW_PassField = new JPasswordField();
	private JButton SPP_Confirm_Button = new JButton("확인");

	private JLabel SP_Main_Label = new JLabel("조회");
	private JLabel SP_Name_Label = new JLabel("홍길동 님의 계좌");
	private JLabel SP_Acc_Label = new JLabel("계좌번호 : 111 - 222");
	private JLabel SP_Val_Label = new JLabel("잔액 : 320000");
	private JButton SP_Confirm_Button = new JButton("확인");

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
		Main_login_Button.setText("로그인");
		Main_newAcc_Button.setBounds(180, 200, 100, 30);
		Main_newAcc_Button.setText("계좌 생성");
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
		DP_Main_Label.setFont(new Font("HY견고딕", 1, 18));
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
		WP_Main_Label.setFont(new Font("HY견고딕", 1, 18));
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
		RP_Main_Label.setFont(new Font("HY견고딕", 1, 18));
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
		SPP_Main_Label.setFont(new Font("HY견고딕", 1, 18));
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
		SP_Main_Label.setFont(new Font("HY견고딕", 1, 18));
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

			if (e.getSource() == Main_newAcc_Button) // 메인페이지 계좌생성버튼
				card.show(me, "CP");
			if (e.getSource() == CP_Finish_Button) { // 계좌생성페이지 완료버튼
				String owner = CP_Owner_Text.getText();
				String accNum = CP_AccNum_Text.getText();
				String passwd = CP_Passwd_Pass.getText();
				String bal = CP_Valance_Text.getText();
				try {
					ATM_FILE.AppendFile(new Account(accNum, owner, passwd, Integer.parseInt(bal)), File);
					JOptionPane.showMessageDialog(null, "새로운 계좌가 생성되었습니다!");
					card.show(me, "MP");
					CP_Owner_Text.setText("");
					CP_AccNum_Text.setText("");
					CP_Passwd_Pass.setText("");
					CP_Valance_Text.setText("");
					if (owner == null || accNum == null || passwd == null || bal == null)
						throw new Exception();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "계좌생성실패! 확인하여주십시오.");
					card.show(me, "MP");
					CP_Owner_Text.setText("");
					CP_AccNum_Text.setText("");
					CP_Passwd_Pass.setText("");
					CP_Valance_Text.setText("");
				}
			}
			if (e.getSource() == Main_exit_Button) // 메인페이지 종료버튼
				System.exit(0);
			if (e.getSource() == Main_login_Button) { // 메인페이지 로그인 버튼
				String accNum = Main_AccInput_Text.getText();
				try {
					user = ATM_FILE.FindUser(acc, acc.length, accNum);
					if (user == null) {
						JOptionPane.showMessageDialog(null, "찾는 계좌가 없습니다!");
						Main_AccInput_Text.setText("");
					} else {
						LP_Hello_Label.setText(user.GetName() + "님 반갑습니다!");
						card.show(me, "LP");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "계좌생성후 실행해주십시오!");
				}
			}
			if (e.getSource() == LP_Logout_Button){// 작업선택페이지 로그아웃 버튼
				Main_AccInput_Text.setText("");
				card.show(me, "MP");
			}
			if (e.getSource() == LP_Deposit_Button) // 작업선택페이지 입금버튼
				card.show(me, "DP");
			if (e.getSource() == DP_Finish_Button) { // 입금페이지 종료버튼
				int amnt = Integer.parseInt(DP_Amount_Text.getText());
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				if (user.Deposit(amnt)) {
					ATM_FILE.RefreshFile(acc, acc.length, File);
					JOptionPane.showMessageDialog(null,
							amnt + "원 입금성공!\n" + user.GetName() +"님의 잔액 : " + user.GetBalance());
					DP_Amount_Text.setText("");
					card.show(me, "LP");
				}
				else
					JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
			}
			if (e.getSource() == LP_Withdraw_Button) // 선택페이지 출금버튼
				card.show(me, "WP");
			if (e.getSource() == WP_Finish_Button) { // 출금페이지 종료버튼
				int amnt = Integer.parseInt(WP_Amount_Text.getText());
				String passwd = WP_PW_PassField.getText();
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				try {
					if(user.WithRaw(passwd, amnt) != 0)
						{
							ATM_FILE.RefreshFile(acc, acc.length, File);
							JOptionPane.showMessageDialog(null,
								amnt + "원 출금성공!\n" + user.GetName() +"님의 잔액 : " + user.GetBalance());
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
			if (e.getSource() == LP_Remittance_Button) // 선택페이지 송금버튼
				card.show(me, "RP");
			if (e.getSource() == RP_Finish_Button) { // 송금페이지 종료버튼
				String sendToAcc = RP_Acc_Text.getText();
				String passwd = RP_PW_PassField.getText();
				int amnt = Integer.parseInt(RP_Amount_Text.getText());
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				Account receiver = ATM_FILE.FindUser(acc, acc.length, sendToAcc);
				if(receiver == null)
				{
					JOptionPane.showMessageDialog(null, "송금하실 계좌번호를 확인하여 주십시오.");
					RP_Acc_Text.setText("");
				}
				if(user.Remittance(receiver, passwd, amnt))
				{
					ATM_FILE.RefreshFile(acc, acc.length, File);
					JOptionPane.showMessageDialog(null,receiver.GetName() + "님에게 송금성공!\n "+ user.GetName() +"님의 잔액 : " + user.GetBalance());
					RP_Acc_Text.setText("");
					RP_Amount_Text.setText("");
					RP_PW_PassField.setText("");
					card.show(me, "LP");
				}
			}
			if (e.getSource() == LP_ShowInfo_Button) { // 선택페이지 조회버튼
				card.show(me, "SPP");
			}
			if (e.getSource() == SPP_Confirm_Button) { // 조회페이지 비밀번호 확인버튼
				String accNum = Main_AccInput_Text.getText();
				user = ATM_FILE.FindUser(acc, acc.length, accNum);
				String passwd = SPP_PW_PassField.getText();
				try {
					user.ShowAccount(passwd);
					JOptionPane.showMessageDialog(null, "비밀번호 확인!");
					SP_Name_Label.setText(user.GetName() + "님의 계좌");
					SP_Acc_Label.setText("계좌번호 : " + user.GetNumber());
					SP_Val_Label.setText("잔액 : " + user.GetBalance());
					SPP_PW_PassField.setText("");
					card.show(me, "SP");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					SPP_PW_PassField.setText("");
				}
			}
			if (e.getSource() == SP_Confirm_Button) // 조회페이지 종료버튼
				card.show(me, "LP");

		}

	}

}
