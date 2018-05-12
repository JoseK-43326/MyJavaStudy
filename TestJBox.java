import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestJBox{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
}
	
class MyFrame extends JFrame{
	private JLabel label;
	private JPanel labelPanel;
	private JPanel boxPanel;
	private JCheckBox boldBox; 
	private JCheckBox italicBox;
	public MyFrame(){
		
		setTitle("TestJBox");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\font.png"));
		BoxListener listener = new BoxListener();
					
		label = new JLabel("Chao ji xi huan xiao he dan");	
		labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		add(labelPanel, BorderLayout.CENTER);
		labelPanel.add(label, BorderLayout.CENTER);
		
		boxPanel = new JPanel();
		add(boxPanel, BorderLayout.SOUTH);
		boldBox = new JCheckBox("Bold");
		boldBox.addActionListener(listener);
		boxPanel.add(boldBox);
		italicBox = new JCheckBox("Italic");
		italicBox.addActionListener(listener);
		boxPanel.add(italicBox);
		}
	class BoxListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			int mode = 0;
			if(boldBox.isSelected()) mode += Font.BOLD;
			if(italicBox.isSelected()) mode += Font.ITALIC;
			label.setFont(new Font("Arial", mode , 24)); 
			}
		}
}

