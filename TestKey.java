import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


public class TestKey{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}
	
class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestKey");
		setSize(300, 300);
		MyPanel panel = new MyPanel();
		add(panel);
		}
	
	}
	
class MyPanel extends JPanel{
	private Point2D last;
	private Line2D line;
	private ArrayList<Line2D> lines;
	public MyPanel(){
		
		last = new Point2D.Double(100, 100);
		lines = new ArrayList<Line2D>();
		MyListener listener = new MyListener();
		addKeyListener(listener);
		setFocusable(true);
		}
	public void add(int dx, int dy){
		
		Point2D end = new Point2D.Double(last.getX() + dx, last.getY() + dy);
		line = new Line2D.Double(last,end);
		lines.add(line);
		repaint();
		last = end;
		
		}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Line2D l : lines)
				g2.draw(l);
		}
	private	static final int MAX_LENGHT = 5;
	private static final int MIN_LENGHT = 1;
	class MyListener implements KeyListener{
	
		public void keyPressed(KeyEvent event){
			
			int d;
			int keyCode = event.getKeyCode();
			if(event.isShiftDown()){
				d = MAX_LENGHT;
				}
			else{
				d = MIN_LENGHT;	
				}
			if(keyCode == KeyEvent.VK_LEFT) add(-d,0);
			else if (keyCode == KeyEvent.VK_RIGHT) add(d,0);
			else if (keyCode == KeyEvent.VK_UP) add(0,d);
			else if (keyCode == KeyEvent.VK_DOWN) add(0,-d);
			}
			
		public void keyReleased(KeyEvent event){}
		
		public void keyTyped(KeyEvent event){
			int d;
			char keyChar = event.getKeyChar();
			if(Character.isUpperCase(keyChar)){
				d = MAX_LENGHT;
				keyChar = Character.toLowerCase(keyChar);
				}
			else{
				d = MIN_LENGHT;
				}
		if(keyChar == 'h') add(-d,0);
		else if (keyChar == 'l') add(d,0);
		else if (keyChar == 'k') add(0,-d);
		else if (keyChar == 'j') add(0,d);		
			}
		}	
	
	}