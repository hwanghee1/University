import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ATM_FILE {
	
	static Account[] ReadFile(String File)
	{
		LineNumberReader r = null;
		Account[] acc = null;
		try
		{
			int cnt = 0;
			Account[] temp = new Account[100];
			
			r = new LineNumberReader(new FileReader(File));
			while(true)
			{
				String line = r.readLine();
				if(line == null)
					break;
				StringTokenizer stok = new StringTokenizer(line);
				
				String number = stok.nextToken();
				String name = stok.nextToken();
				String pass = stok.nextToken();
				int balance = Integer.parseInt(stok.nextToken());
				temp[cnt++] = new Account(number, name, pass, balance);
			}
			if(cnt != 0)
				acc = new Account[cnt];
			
			for(int i = 0; i<cnt; i++)
				acc[i] = temp[i];
			
		}
		catch(FileNotFoundException fnfe)
		{
			acc = null;
		}
		catch(IOException ioe)
		{
			acc = null;
		}
		finally
		{
			try
			{
				r.close();
				return acc;
			}
			catch(Exception e)
			{
				return null;
			}
		}
		
		
		
	}
	static boolean AppendFile(Account acc, String File)
	{
		PrintWriter w = null;
		boolean ret = false;
		try
		{
			w = new PrintWriter(new FileWriter(File, true));
			
			w.println(acc.GetNumber() + " " + acc.GetName() + " " + 
						acc.GetPass() + " " + acc.GetBalance());
			
			ret = true;
		}
		catch(IOException ioe)
		{
			ret = false;;
		}
		finally
		{
			try
			{
				w.close();
				return ret;
			}
			catch(Exception e)
			{
				return false;
			}
		}

	}
	static boolean RefreshFile(Account[] acc, int cnt, String File)
	{
		PrintWriter w = null;
		boolean ret = false;
		try
		{
			w = new PrintWriter(new FileWriter(File));
			for(int i=0; i<cnt; i++)
			{
				w.println(acc[i].GetNumber() + " " + acc[i].GetName() + " " + 
						acc[i].GetPass() + " " +  acc[i].GetBalance());
			}
			ret = true;
		}
		catch(IOException ioe)
		{
			ret = false;;
		}
		finally
		{
			try
			{
				w.close();
				return ret;
			}
			catch(Exception e)
			{
				return false;
			}
		}

	}
	static Account FindUser(Account acc[], int cnt, String number)
	{
		for(int i=0; i<cnt; i++)
		{
			if(acc[i].GetNumber().equals(number))
			{
				return acc[i];
			}
		}
		return null;
	}
	public static void FileCheck(String File)
	{
		FileWriter w = null;
		FileReader r = null;
		try {
			r = new FileReader(File);
		} catch (FileNotFoundException e1) {
			try {
				w = new FileWriter(File);
				JOptionPane.showMessageDialog(null, "Account.txt »ý¼ºµÊ");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {}
		try {
			r.close();
		} catch (Exception e) {}
		try {
			w.close();
		} catch (Exception e) {}

	}
}
