import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestDialog{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
}

class MyFrame extends JFrame{
	private AboutDialog dialog;
	public MyFrame(){
		
		setTitle("TestDialog");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\qq.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem aboutItem = new JMenuItem("About");
		menu.add(aboutItem);
		menu.add(exitItem);
		
		exitItem.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				System.exit(0);
				}
			});
			
		aboutItem.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				if(dialog == null)
						dialog = new AboutDialog(MyFrame.this);
				dialog.setVisible(true);
				}
			});
		}
		
	class AboutDialog extends JDialog{
		
		public AboutDialog(JFrame frame){
			
			super(frame, "AboutDialog", true);
			
			add(new JLabel(
			"<html><h1><i>Core Java</i></h1><hr>By Cay Horstman and GaryCornell</html>")
			,BorderLayout.CENTER);
			
			JPanel buttonPanel = new JPanel();
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent event){
					setVisible(false);
					}
				});
			buttonPanel.add(okButton);
			add(buttonPanel,BorderLayout.SOUTH);
			setSize(250,150);
			}
		
		}
	
}