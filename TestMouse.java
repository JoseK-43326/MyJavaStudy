import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

public class TestMouse{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
	}
	
class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestMouse");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
								.getImage("C:\\Users\\Administrator\\Desktop\\qq.png"));
		MyPanel panel = new MyPanel();
		add(panel);				
		}
	}	
	
class MyPanel extends JPanel{
	private ArrayList<Rectangle2D> squares;
	private static final int SIDELENGHT = 20;
	private Rectangle2D current;
	
	public MyPanel(){
		
		squares = new ArrayList<Rectangle2D>();
		current = null;
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(Rectangle2D r : squares)
				g2.draw(r);
		}
	public Rectangle2D find(Point2D p){
		for(Rectangle2D r : squares){ 
			if(r.contains(p)) return r;
			 }
			return null;	
		}
	public void add(Point2D p){
		
		double x = p.getX();
		double y = p.getY();
		current = new Rectangle2D.Double(
				x - SIDELENGHT / 2,				
				y - SIDELENGHT / 2,
				SIDELENGHT,SIDELENGHT);
		squares.add(current);
		repaint();
		}
	public void remove(Rectangle2D r){
		if(r == null) return;
		if(r == current) current = null;
		squares.remove(r);
		repaint();
		}
		
private	class MouseHandler extends MouseAdapter{
	
	public void mousePressed(MouseEvent event){
		current = find(event.getPoint());
		if(current == null) 
				add(event.getPoint());
		}
	public void mouseClicked(MouseEvent event){
		current = find(event.getPoint());
		if(current != null && event.getClickCount() >= 2)
				remove(current);
		}
	}
private class MouseMotionHandler implements MouseMotionListener{
		
		public void mouseMoved(MouseEvent event){
			if(find(event.getPoint()) == null )
					setCursor(Cursor.getDefaultCursor());
			else
					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		public void mouseDragged(MouseEvent event){
			if(current != null ) {
					int x = event.getX();
					int y = event.getY();
					current.setFrame(
								x - SIDELENGHT / 2,
								y - SIDELENGHT / 2,
								SIDELENGHT,SIDELENGHT);
			repaint();
			}
		}
	
	}	
}	
