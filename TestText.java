import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;


public class TestText{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}
	
class MyFrame extends JFrame{
	private JTextField hourText;
	private JTextField minuteText;
	private MyPanel clockPanel;
	public MyFrame(){
		//FrameÄ¬ÈÏµÄBorderLayout
		setTitle("TestText");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\java\\Image\\clock.png"));
		
		JPanel labelPanel = new JPanel();
		add(labelPanel, BorderLayout.SOUTH);
		
		ClockListener listener = new ClockListener();
		
		JLabel hourLabel = new JLabel("Hour:");
		labelPanel.add(hourLabel);
		hourText = new JTextField("12", 3);
		labelPanel.add(hourText);
		hourText.getDocument().addDocumentListener(listener);
		
		JLabel minuteLabel = new JLabel("Minute:");
		labelPanel.add(minuteLabel);
		minuteText = new JTextField("00", 3);
		labelPanel.add(minuteText);
		hourText.getDocument().addDocumentListener(listener);
		
		clockPanel = new MyPanel();
		add(clockPanel, BorderLayout.CENTER);
		pack();
		}
		public void setClock(){
			try {
				int hour = Integer.parseInt(hourText.getText().trim());
				int minute = Integer.parseInt(minuteText.getText().trim());
				clockPanel.setTime(hour, minute);	
			} catch (Exception ex) {
				 ex.printStackTrace();
			}	
			}
		class ClockListener implements DocumentListener{
			public void insertUpdate(DocumentEvent event){ setClock();}
			public void removeUpdate(DocumentEvent event){ setClock();}
			public void changedUpdate(DocumentEvent event){ }
			}
}	

class MyPanel extends JPanel{
	private double minute = 0;
	private final int RADIUS = 100;
	private final int HOUR_HAND_LENGHT = 40;
	private final int  MINUTE_HAND_LENGHT= 80;
		public MyPanel(){
			setPreferredSize(new Dimension(2 * RADIUS + 1, 2 * RADIUS + 1 ));		
			}
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			Ellipse2D circle = new Ellipse2D.Double(0, 0, 2 * RADIUS, 2 * RADIUS);
			g2.draw(circle);
			
			double hourAngle = Math.toRadians(90 - 360 * minute / (12*60));
			drawHand(g2, hourAngle, HOUR_HAND_LENGHT);
			
			double minuteAngle = Math.toRadians(90 - 360 * minute / 60);
			drawHand(g2, minuteAngle, MINUTE_HAND_LENGHT);
			
			}
			
		public void drawHand(Graphics2D g2, double angle,int handLength){
			Point2D begin = new Point2D.Double(RADIUS, RADIUS);
			Point2D end = new Point2D.Double(RADIUS + handLength * Math.cos(angle),
													RADIUS - handLength * Math.sin(angle));
			Line2D hand =new Line2D.Double(begin, end);
			g2.draw(hand);
			}
			
		public void setTime(int hour, int minute){
			this.minute = hour * 60 + minute;
			repaint();
			}	
	
}
