import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


public class TestOptionPane{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}	
	
}

class ButtonPanel extends JPanel{
	private ButtonGroup group;
	public ButtonPanel(String title, String[] options){
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		group = new ButtonGroup();
		for(int i = 0; i < options.length; i++){
				JRadioButton b = new JRadioButton(options[i]);
				b.setActionCommand(options[i]);
				group.add(b);
				add(b);				
			}		
	}	
	public String getSelection(){
		return group.getSelection().getActionCommand();
		}
}

class MyFrame extends JFrame{
	private ButtonPanel typePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel messagePanel;
	private ButtonPanel confirmPanel;
	private ButtonPanel optionPanel;
	private ButtonPanel inputPanel; 
	private JButton showButton;	
	private JPanel gridPanel;
	private JPanel buttonPanel;
	
	private String messageString = "Message";
	private Icon messageIcon = new ImageIcon("E:\\java\\Image\\calculator.png");
	private Component messageComponent = new SamplePanel();
	private Object messageObject = new Date();
	
	public MyFrame(){
		
		setTitle("TestOptionPane");
		setSize(600, 400);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\font.png"));
							
		typePanel = new ButtonPanel("Type", new String[]{
			"Message", "Confirm", "Option", "Input"});
		messageTypePanel = new ButtonPanel("Message Type", new String[]{
			"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE","PLAIN_MESSAGE"});
		messagePanel = new ButtonPanel("Message", new String[]{
			"String", "Icon", "Component", "Other", "Object[]"});
		confirmPanel = new ButtonPanel("Confirm", new String[]{
			"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"});
		optionPanel = new ButtonPanel("Option", new String[]{
			"String[]", "Icon[]", "Object[]"});
		inputPanel = new ButtonPanel("Input", new String[]{
			"Text field", "Combo box"});
		
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 3));
		gridPanel.add(typePanel);
		gridPanel.add(messageTypePanel);
		gridPanel.add(messagePanel);
		gridPanel.add(confirmPanel);
		gridPanel.add(optionPanel);
		gridPanel.add(inputPanel);
		
		buttonPanel = new JPanel();
		showButton = new JButton("Show");
		ShowListener listener = new ShowListener();
		showButton.addActionListener(listener);
		buttonPanel.add(showButton);
		
		add(gridPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		}
		
	public Object getMessage(){
		String s = messagePanel.getSelection();
		if(s.equals("String"))
				return messageString;
		else if (s.equals("Icon"))
				return messageIcon;
		else if (s.equals("Component"))
				return messageComponent;
		else if (s.equals("Other"))
				return messageObject;
		else if (s.equals("Object[]"))
				return new Object[]{messageString,messageIcon,messageComponent,messageObject};
		else 
				return null;
		}
		
	public Object[] getOptions(){
		String s = optionPanel.getSelection();
		if(s.equals("String[]"))
				return new String[]{"Black","Blue","Pink"};
		else if(s.equals("Icon[]"))
				return new ImageIcon[]
				{new ImageIcon("E:\\java\\Image\\blackball.png"),
				 new ImageIcon("E:\\java\\Image\\blueball.png"),
				 new ImageIcon("E:\\java\\Image\\pinkball.png")};
		else if(s.equals("Object[]"))
				return new Object[]{messageString,messageIcon,messageComponent,messageObject};
		else 
				return null;
		}
		
	public int getType(ButtonPanel panel){
		String s = panel.getSelection();
		try {
			return JOptionPane.class.getField(s).getInt(null);
		} catch (Exception e) {
			return -1; 
		}
		}
		
	class ShowListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			if(typePanel.getSelection().equals("Message"))
					JOptionPane.showMessageDialog(
					MyFrame.this, getMessage(), "Title", getType(messageTypePanel));
			else if (typePanel.getSelection().equals("Confirm"))
					JOptionPane.showConfirmDialog(
					MyFrame.this, getMessage(), "Title", 
					getType(confirmPanel), getType(messageTypePanel));
			else if (typePanel.getSelection().equals("Option"))
					JOptionPane.showOptionDialog(
					MyFrame.this, getMessage(), "Title", 
					getType(confirmPanel), getType(messageTypePanel),null,
					getOptions(), getOptions()[0]);
			else if (typePanel.getSelection().equals("Input")){
				if(inputPanel.getSelection().equals("Text field"))
						JOptionPane.showInputDialog(
						MyFrame.this, getMessage(), "Title", getType(messageTypePanel));
				else if (inputPanel.getSelection().equals("Combo box"))
						JOptionPane.showInputDialog(
						MyFrame.this, getMessage(), "Title", getType(messageTypePanel),null,
						new String[]{"Black","Blue","Pink"}, "Black");				
			}
					
			}
		
		}
		
	class SamplePanel extends JPanel{
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			Rectangle2D rect = new Rectangle2D.Double(0,0,50,20);
			g2.setPaint(Color.YELLOW);
			g2.fill(rect);
			}
		}
		
}