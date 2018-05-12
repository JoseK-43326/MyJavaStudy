import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TestTimer{
	
	public static void main(String[] args){
		TimerListener listener = new TimerListener();
		Timer t = new Timer(3000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null,"Quit Program?");
		System.exit(0);
		}
	
	}
	
class TimerListener implements ActionListener{
	
	public void actionPerformed(ActionEvent ev){
		Date now = new Date();
		System.out.println("The current time is " + now);
		Toolkit.getDefaultToolkit().beep();
		}
	
	}