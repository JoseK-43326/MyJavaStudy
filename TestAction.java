import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestAction{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}
		
class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestAction");
		setSize(300, 300);
		MyPanel panel = new MyPanel();
		add(panel);
		
		}
	
	}
	
class MyPanel extends JPanel{
	
	public MyPanel(){
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton greenButton = new JButton("Green");
		
		add(yellowButton);
		add(blueButton);
		add(greenButton);
		
		MyListener yellowListener = new MyListener(Color.YELLOW);
		MyListener blueListener = new MyListener(Color.BLUE);
		MyListener greenListener = new MyListener(Color.GREEN);	
		yellowButton.addActionListener(yellowListener);
		blueButton.addActionListener(blueListener);
		greenButton.addActionListener(greenListener);
		}
		
		
		
	class MyListener implements ActionListener{
		
		private Color backgroundColor;
		
		public MyListener(Color c){
			backgroundColor = c;
			}
		
		public void actionPerformed(ActionEvent event){
			
			setBackground(backgroundColor);
			}
		
		}
	
	}