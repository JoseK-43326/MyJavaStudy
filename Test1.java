import javax.swing.*;
import java.awt.*;

public class Test1{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
		
	}

class MyFrame extends JFrame{
		
		public MyFrame(){
			setTitle("Test");
			setSize(300,400);
			setIconImage(Toolkit.getDefaultToolkit().
						getImage("E:\\java\\Image\\Tank.png"));
			}
	}
