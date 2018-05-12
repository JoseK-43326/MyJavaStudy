import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestJRadio{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
}
	
class MyFrame extends JFrame{
	private JLabel textLabel;
	private JPanel labelPanel;
	private ButtonGroup group;
	private JPanel groupPanel;
	public MyFrame(){
		
		setTitle("TestJRadio");
		setSize(400, 300);
		setIconImage(Toolkit.getDefaultToolkit()
						.getImage("E:\\java\\Image\\font.png"));
						
		labelPanel = new JPanel();
		add(labelPanel, BorderLayout.CENTER);
		textLabel = new JLabel("����ϲ��С�˵�");
		textLabel.setFont(new Font("����", Font.PLAIN, 10));
		labelPanel.add(textLabel);
		
		groupPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Small", 5);
		addRadioButton("Medium", 10);
		addRadioButton("Large", 15);
		addRadioButton("EX_Large", 20);
		
		
		add(groupPanel, BorderLayout.SOUTH);
		
		}
	public void addRadioButton(String label, int size){
		
		JRadioButton radioButton = new JRadioButton(label, false);
		group.add(radioButton);
		groupPanel.add(radioButton);
		radioButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				
				textLabel.setFont(new Font("����", Font.PLAIN, size));
				}
			
			});
		}
	
}