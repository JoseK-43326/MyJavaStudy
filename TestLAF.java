import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestLAF{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		}
	
	}
	
class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestLAF");
		setSize(300, 300);
		MyPanel panel = new MyPanel();
		add(panel);
		}
		
	}
	
class MyPanel extends JPanel{
	
	public MyPanel(){
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos){
			makeButton(info.getName(),info.getClassName());
			}
			
		}		
			
	public void makeButton(String name, String plafName){
			JButton button = new JButton(name);
			add(button);
			button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
			
			try {
				UIManager.setLookAndFeel(plafName);
				SwingUtilities.updateComponentTreeUI(MyPanel.this);
			} catch (Exception ex) {
				 ex.printStackTrace();
			}
			}		});	

	
		}
	
}