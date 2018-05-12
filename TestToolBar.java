import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;

public class TestToolBar{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}

class MyFrame extends JFrame{
	private JPanel panel;
	public MyFrame(){
		
		setTitle("TestToolBar");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\Menu.png"));
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu colorMenu = new JMenu("Color");
		menuBar.add(colorMenu);
		
		ColorAction blackAction = new ColorAction("Blcak" 
									,new ImageIcon("E:\\java\\Image\\blackball.png"), Color.BLACK);
		ColorAction blueAction = new ColorAction("Blue"
									,new ImageIcon("E:\\java\\Image\\blueball.png"), Color.BLUE);
		ColorAction pinkAction = new ColorAction("Pink"
									,new ImageIcon("E:\\java\\Image\\pinkball.png"), Color.PINK);
		//JMenuItem exitItem = new JMenuItem("Exit", new ImageIcon("E:\\java\\Image\\close.png"));
		//exitItem.addActionListener(new ActionListener(){
			
		//	public void actionPerformed(ActionEvent event){
		//			System.exit(0);
		//			}
		//	});
		Action exitAction = new AbstractAction("Exit", new ImageIcon("E:\\java\\Image\\close.png")){
			
			public void actionPerformed(ActionEvent event){
				System.exit(0);
				}
			};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit the program");
		colorMenu.add(blackAction);
		colorMenu.add(blueAction);
		colorMenu.add(pinkAction);
		colorMenu.addSeparator();	
		colorMenu.add(exitAction);
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		//JMenuItem aExitItem = new JMenuItem("Exit", new ImageIcon("E:\\java\\Image\\close.png"));
		//exitItem.addActionListener(new ActionListener(){
			
		//	public void actionPerformed(ActionEvent event){
		//		System.exit(0);
		//		}
		//	});
		toolBar.add(blackAction);
		toolBar.add(blueAction);
		toolBar.add(pinkAction);
		toolBar.addSeparator();
		toolBar.add(exitAction);
		
		}
		
	class ColorAction extends AbstractAction{
		
		public ColorAction(String name, Icon icon, Color c){
			
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue("color", c);
			putValue(Action.SHORT_DESCRIPTION, "Set panel to " + name.toUpperCase());
			}
		public void actionPerformed(ActionEvent event){
			
			Color c = (Color) getValue("color");//键值对的存取方法
			panel.setBackground(c);	
			}
		}
}