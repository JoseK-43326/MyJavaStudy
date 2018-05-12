import javax.swing.*;
import java.awt.*;


public class TestLayout extends JFrame{
	
	public static void main(String[] args){		
		new TestLayout().launchFrame();
		
		}	
	public void launchFrame(){
		
		JButton e1Button = new JButton("Button");
		JButton e2Button = new JButton("Button");
		JButton w1Button = new JButton("Button");
		JButton w2Button = new JButton("Button");
		JButton cd1Button = new JButton("Button");
		JButton cd2Button = new JButton("Button");
		JButton cd3Button = new JButton("Button");
		JButton cd4Button = new JButton("Button");
		JButton cu1Button = new JButton("Button");
		JButton cu2Button = new JButton("Button");
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(2,1));
		eastPanel.add(e1Button);
		eastPanel.add(e2Button);
		add(eastPanel,BorderLayout.EAST);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(2,1));
		westPanel.add(w1Button);
		westPanel.add(w2Button);
		add(westPanel, BorderLayout.WEST);
		
		JPanel cuPanel = new JPanel();
		cuPanel.setLayout(new GridLayout(2,1));
		cuPanel.add(cu1Button);
		cuPanel.add(cu2Button);
		JPanel cdPanel = new JPanel();
		cdPanel.setLayout(new GridLayout(2,2));
		cdPanel.add(cd1Button);
		cdPanel.add(cd2Button);
		cdPanel.add(cd3Button);
		cdPanel.add(cd4Button);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(cuPanel);
		centerPanel.add(cdPanel);
		add(centerPanel, BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
		}
		
}