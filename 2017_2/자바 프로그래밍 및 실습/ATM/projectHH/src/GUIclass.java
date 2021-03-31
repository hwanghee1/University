import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class GUIclass {
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("21410785's ATM");
		Panel panel = new Panel();
		frame.add(panel);
		frame.setLocation(400, 200);;
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
