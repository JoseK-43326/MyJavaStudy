import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class TestFont{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}

class MyFrame extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	public MyFrame(){
		setTitle("FontTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setLocation(screenWidth / 4, screenHeight / 4);
		MyPanel panel = new MyPanel();
		add(panel);
		}
	
	}	
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			String message = "Hello, World";
			Font f = new Font("Serif", Font.PLAIN, 36);
			g2.setFont(f);
			
			FontRenderContext context = g2.getFontRenderContext();
			Rectangle2D bounds = f.getStringBounds(message, context);
			
			double x = (getWidth() - bounds.getWidth()) / 2;
			double y = (getHeight() - bounds.getHeight()) / 2;
			
			double ascent = -bounds.getY();
			double baseY = y + ascent;
			g2.setPaint(Color.BLACK);
			g2.drawString(message, (int) x, (int) baseY);
			g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
			Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
			g2.draw(rect);
			}
		}