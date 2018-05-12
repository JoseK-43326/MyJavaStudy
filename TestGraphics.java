import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class TestGraphics{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		}
	
	}
	
class MyFrame extends JFrame{
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public MyFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
	  Dimension screenSize = kit.getScreenSize();
	  int screenWidth = screenSize.width;
	  int screenHeight = screenSize.height;
		setSize(WIDTH, HEIGHT);
		setTitle("Graphics 2D");
		setLocation(screenWidth / 4 , screenHeight / 4);	
		MyPanel panel = new MyPanel();
		add(panel);
		}
		
	}
	
class MyPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Color rectColor = new Color(0,255,0);
		Color ellipseColor = new Color(255, 0, 0);
		Rectangle2D rect = new Rectangle2D.Double(100.0, 100.0 ,100.0, 100.0);
		g2.draw(rect);
		g2.setPaint(rectColor);
		g2.fill(rect);
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		g2.setPaint(ellipseColor);
		g2.fill(ellipse);
		
		
		}
	
	}