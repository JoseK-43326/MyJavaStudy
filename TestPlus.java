import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestPlus extends JFrame{
	private JTextField text1;
	private JTextField text2;
	private JButton button;
	private JTextField answer;
	public static void main(String[] args){
		new TestPlus().launchFrame();
		}	
	
	public void launchFrame(){
		setTitle("TestPlus");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		add(panel,BorderLayout.CENTER);
		text1 = new JTextField(5);
		text2 = new JTextField(5);
		answer = new JTextField(5);
		JLabel plusLabel = new JLabel("+");
		button = new JButton("=");	
		panel.add(text1);
		panel.add(plusLabel);
		panel.add(text2);
		panel.add(button);
		panel.add(answer);
		button.addActionListener(new ButtonListener());
		setVisible(true);
		}
		
		class ButtonListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
					
					int number_text1 = Integer.parseInt(text1.getText());
					int number_text2 = Integer.parseInt(text2.getText());
					int number_answer = number_text1 + number_text2;
					String string_answer = String.valueOf(number_answer);
					answer.setText(string_answer);
					text1.setText("");
					text2.setText("");					
				}
		}
	
	
}