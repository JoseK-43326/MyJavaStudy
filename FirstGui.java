
import javax.swing.*;
import java.awt.*;

 class FirstGui extends JPanel{
	public static void main(String[] args){
	
		
		}
	
	class MyDraw extends JPanel{
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 100, 100, Color.orange);
		g2d.setPaint(gradient);
		g2d.fillOval(70,70,100,100);
		
		}
	}
		
	}