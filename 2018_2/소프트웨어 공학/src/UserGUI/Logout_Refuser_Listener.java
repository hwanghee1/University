package UserGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//���� �α׾ƿ� �Ͻðڽ��ϱ�?
class Logout_Refuse_Listener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
	   	JFrame Fail = new JFrame("");        //Fail�������� ����      
	   	Fail.setLocation(1000, 500);         //��ġ����
	   	Fail.setPreferredSize(new Dimension(250,110)); //ũ������
	   	JPanel p=new JPanel();
	   	JPanel pp=new JPanel();
	   	p.add(new JLabel("���� �α׾ƿ� �Ͻðٽ��ϱ�?"));
	   	
	   	JButton button1 = new JButton("Ȯ��");
	   	JButton button2 = new JButton("���");
	   	pp.add(button1);
	   	pp.add(button2);
	   	button1.addActionListener(new Logout_Listener(Fail));
	   	button2.addActionListener(new Exit_Listener(Fail));
	   	Fail.add(p,"Center");
	   	Fail.add(pp,"South");
	   	Fail.pack();                     //�������� �����ش�
	   	Fail.setVisible(true);           //�гε��� �����ش�      
	}
}

