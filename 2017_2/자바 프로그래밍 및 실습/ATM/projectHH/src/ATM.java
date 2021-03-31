import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

class Account
{
	private String number;
	private String name;
	private String pass;
	private int balance;
	public String GetNumber()
	{
		return number;
	}
	public String GetName()
	{
		return name;
	}
	public String GetPass()
	{
		return pass;
	}
	public int GetBalance()
	{
		return balance;
	}
	public Account (String pNumber, String pName, String pPass,
			int pBalance)
	{
		number = pNumber;
		name = pName;
		pass = pPass;
		balance = pBalance;
	}
	public void SetAccount
	(String pNumber, String pName, String pPass,
			int pBalance)
	{
		number = pNumber;
		name = pName;
		pass = pPass;
		balance = pBalance;
	}
	public boolean Deposit(int money)
	{
		
		if(money <= 0)
		{
			return false;
		}
		balance += money;
		return true;
	}
	
	public int WithRaw(String pPass, int money) throws Exception
	{
		if(!pass.equals(pPass))
		{
			throw new Exception("�н����尡 ��ġ���� �ʽ��ϴ�.");
		}
		if(money > balance)
		{
			throw new Exception("�ܾ��� �����մϴ�.");
		}
		if(money <= 0)
		{
			throw new Exception("�ݾ��� �߸��Է��ϼ̽��ϴ�.");
		}
		balance -= money;
		return money;
	}
	public boolean Remittance(Account acc, String pPass, int money)
	{
		int sendmoney = 0;
		try {
			sendmoney = WithRaw(pPass, money);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if(sendmoney == 0)
		{
			return false;
		}
		if(!acc.Deposit(sendmoney))
		{
			return false;
		}
		return true;
	}
	public void ShowAccount(String pPass)throws Exception
	{
		if(!pass.equals(pPass))//��й�ȣ�� Ʋ����
		{
			throw new Exception("��й�ȣ�� Ʋ���ϴ�!");
		}
	}
	
}
