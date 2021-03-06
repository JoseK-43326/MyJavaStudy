import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestCalculator{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
}
	
class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("Calculator");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\calculator.png"));
		MyPanel panel = new MyPanel();
		add(panel);
		//pack();//
		}
	
}
	
class MyPanel extends JPanel{
	
	public MyPanel(){
		setLayout(new BorderLayout());
		result = 0;
		lastcommand = "=";
		start = true;
		InsertListener insert = new InsertListener();
		CommandListener command = new CommandListener();
		
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);
		
		aPanel = new JPanel();
		aPanel.setLayout(new GridLayout(4,4));
		
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);
		
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);
		
		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);
		add(aPanel,BorderLayout.CENTER);
		}
	public void addButton(String label, ActionListener listener){
		
		JButton button = new JButton(label);
		button.addActionListener(listener);
		aPanel.add(button);		
		}
	class InsertListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			String input = event.getActionCommand();
			if(start){
				display.setText("");
				start = false;
				}
			display.setText(display.getText() + input);
			}
		}
	class CommandListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			String command = event.getActionCommand();
			if(start){
					if(command.equals("-")){
						display.setText("-");
						start = false;
						}
					else {
					 	lastcommand = command;
					}
				}
			else{
				calculator(Double.parseDouble(display.getText()));
				lastcommand = command;
				start = true;
				}
			}
		}
 	public void calculator(double x){
 		
 		if(lastcommand.equals("+")) result += x;
 		else if (lastcommand.equals("-")) result -= x;
 		else if (lastcommand.equals("*")) result *= x;
 		else if (lastcommand.equals("/")) result /= x;
 		else if (lastcommand.equals("=")) result = x;
 		display.setText("" + result);
 		}
	private JPanel aPanel;
	private JButton display;
	private String lastcommand;
	private static boolean start;
	private double result;
}