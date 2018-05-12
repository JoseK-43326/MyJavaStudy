import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestFrame{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		}
	
	}
class MyFrame extends JFrame{
	
	public MyFrame(){
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenWidth = screenSize.width;
			int	screenHeight = screenSize.height;
			
			setSize(screenWidth / 2, screenHeight / 2);
			setLocation(screenWidth / 4, screenHeight / 4);
			
			Image img = kit.getImage("icon.gif");
			setIconImage(img);
			
			setTitle("FirstFrame");
	}
}