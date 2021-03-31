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
			throw new Exception("패스워드가 일치하지 않습니다.");
		}
		if(money > balance)
		{
			throw new Exception("잔액이 부족합니다.");
		}
		if(money <= 0)
		{
			throw new Exception("금액을 잘못입력하셨습니다.");
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
		if(!pass.equals(pPass))//비밀번호가 틀리면
		{
			throw new Exception("비밀번호가 틀립니다!");
		}
	}
	
}
