import javax.swing.*;

public class TestString{
	public static void main(String[] args){
		String name = JOptionPane.showInputDialog("What is your name?");
		String age = JOptionPane.showInputDialog("How old are you?");
		int ageInt = Integer.parseInt(age);
		
		System.out.println("Hello!" + name + ",your age is " + ageInt);
		System.exit(0);
		}
	}