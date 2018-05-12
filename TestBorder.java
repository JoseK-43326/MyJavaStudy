import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestBorder{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}
	
class MyFrame extends JFrame{
	private JPanel buttonPanel;
	private JPanel aPanel;
	private ButtonGroup group;
	public MyFrame(){
		
		setTitle("TestBorder");
		setSize(500, 300);
		setIconImage(Toolkit.getDefaultToolkit()
						.getImage("E:\\java\\Image\\font.png"));
		
		aPanel = new JPanel();
		add(aPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.NORTH);
		
		group = new ButtonGroup();
		
		addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched", BorderFactory.createEtchedBorder());
		addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
		addRadioButton("Empty", BorderFactory.createEmptyBorder());
		
		
		
		
		}
		
		public void addRadioButton(String name, Border b){
			
			JCheckBox radioButton = new JCheckBox(name);
			group.add(radioButton);
			buttonPanel.add(radioButton);
			radioButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent event){
					aPanel.setBorder(b);
					validate();
					}
				});
			
			}
			
}