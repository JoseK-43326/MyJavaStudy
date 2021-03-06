import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestKeyAction{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}
	
class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestKeyAction");
		setSize(300, 300);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("C:\\Users\\Administrator\\Desktop\\qq.png");
		setIconImage(img);
		
		MyPanel panel = new MyPanel();
		add(panel);
		}
	
	}
	
class MyPanel extends JPanel{
	
	public MyPanel(){
		
		ColorAction blueAction = new ColorAction("blue", Color.BLUE);
		ColorAction redAction = new ColorAction("red", Color.RED);
		ColorAction greenAction = new ColorAction("green", Color.GREEN);
		
		add(new JButton(blueAction));
		add(new JButton(redAction));
		add(new JButton(greenAction));
		
		InputMap imap = getInputMap(JComponent
													.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "red");
		imap.put(KeyStroke.getKeyStroke("ctrl G"), "green");
		
		ActionMap amap = getActionMap();
		amap.put("blue", blueAction);
		amap.put("red", redAction);
		amap.put("green", greenAction);
		}
		
	class ColorAction extends AbstractAction{
		
		public ColorAction(String name, Color c){
			putValue(Action.NAME, name);
			putValue(Action.SHORT_DESCRIPTION, "set panel to " + name.toUpperCase());
			putValue("color", c);
			}
		public void actionPerformed(ActionEvent event){
			Color color = (Color) getValue("color");
			setBackground(color);
			}
		
		}	
	
	}