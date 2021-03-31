import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextField display_Text;
	private JButton[] buttons;
	private String[] labels = { "←", "CE", "C", "±", "√", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2",
			"3", "-", "", "0", "", ".", "+", "=", };
	private double result = 0;
	private String operator = "=";

	public Calculator() {
		JFrame frame = new JFrame("21410785's Calculator");
		display_Text = new JTextField(10);
		panel = new JPanel();
		display_Text.setText("");
		panel.setLayout(new GridLayout(0, 5, 7, 7));
		buttons = new JButton[25];
		int index = 0;
		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons[index] = new JButton(labels[index]);
				panel.add(buttons[index]);
				buttons[index].addActionListener(this);
				index++;
			}
		}
		frame.add(display_Text, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setLocation(400, 200);
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String infix = display_Text.getText();
		if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
			display_Text.setText(infix.concat(command));
		} else if (command.charAt(0) == 'C') {
			result = 0;
			display_Text.setText("");
		} else if (command.equals("CE")) {
			display_Text.setText("");
		} else if (command.charAt(0) == '←') {
			display_Text.setText(infix.substring(0, infix.length() - 1));
		} else if (command.charAt(0) == '√') {
			display_Text.setText(infix.concat(command));
		} else if (command.equals("1/x")) {
			result = 1 / calculate(infix);
			display_Text.setText(String.valueOf(result));
		} else if (command.charAt(0) == '=') {
			result = calculate(infix);
			display_Text.setText(String.valueOf(result));
		} else {
			char last = infix.charAt(infix.length() - 1);
			if (last >= '0' && last <= '9' || last == ')')
				if (command.charAt(0) == '+' || command.charAt(0) == '-' || command.charAt(0) == '*'
						|| command.charAt(0) == '/')
					display_Text.setText(infix.concat(command));
		}

	}

	private double calculate(String infix) {
		LinkedList<String> postfix = getPostfix(infix);
		LinkedList<String> stack = new LinkedList<String>();
		double op1, op2;
		String token;
		while (!postfix.isEmpty()) {
			token = postfix.removeFirst();
			if (token.charAt(0) <= '9' && token.charAt(0) >= '0')
				stack.addLast(token);
			else {
				op1 = Double.parseDouble(stack.removeLast());
				op2 = Double.parseDouble(stack.removeLast());
				switch (token) {
				case "-":
					stack.addLast(String.valueOf(op2 - op1));
					break;
				case "+":
					stack.addLast(String.valueOf(op2 + op1));
					break;
				case "/":
					stack.addLast(String.valueOf(op2 / op1));
					break;
				case "*":
					stack.addLast(String.valueOf(op2 * op1));
					break;
				}
			}
		}
		return Double.parseDouble(stack.removeLast());
	}

	private int getInStackPriority(char token) // 스텍내의 연산자 우선순위를 숫자로 보내줌.
	{
		switch (token) {
		case '(':
			return 1;
		case ')':
			return 10; // 오른쪽 괄호는 등장과 동시에 괄호안의 부호를 모두 꺼내야하므로
		case '*': // 우선순위가 제일 크다
		case '/':
			return 5;
		case '+':
		case '-':
			return 2;
		}
		return 0;
	}

	private int getPriority(char token) // 부호를 스택에 넣을 때의 우선순위를 반환해주는 함수
	{
		switch (token) {
		case '(': // 숫자는 우선순위를 나타냄
		case ')':
			return 10; // 괄호가 제일 우선순위가높음
		case '*':
		case '/':
			return 5;
		case '+':
		case '-':
			return 2;
		}
		return 0;
	}

	private LinkedList<String> getPostfix(String infix) {
		LinkedList<String> postfix = new LinkedList<String>();
		LinkedList<String> stack = new LinkedList<String>();
		stack.addLast(new String("0"));
		StringTokenizer stok = new StringTokenizer(infix, "/*-+√()", true);
		while (stok.hasMoreTokens()) {
			String token = stok.nextToken();
			if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
				postfix.addLast(new String(token));
			} else if (token.equals("√")) {
				token = String.valueOf(Math.sqrt(Double.parseDouble(stok.nextToken())));
			} else {
				if (token.equals(")")) {
					do {
						postfix.addLast(stack.removeLast());
					} while (!stack.getLast().equals("("));
					if (stack.getLast().equals("(")) {
						stack.removeLast();
						continue;
					}
				}
				while (getInStackPriority(stack.getLast().charAt(0)) >= getPriority(token.charAt(0))) {
					postfix.addLast(stack.removeLast());
				}
				stack.addLast(token);
			}
		}
		do {

			postfix.addLast(stack.removeLast());
		} while (!stack.getLast().equals("0"));
		return postfix;
	}

	public static void main(String args[]) {
		Calculator s = new Calculator();
	}
}
