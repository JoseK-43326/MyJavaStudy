import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class TestImage{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
	}
	
class MyFrame extends JFrame{
	
	public MyFrame(){
		setTitle("TestIamge");
		setSize(300,300);
			
		MyPanel panel = new MyPanel();
		add(panel);
		}
	
	}	

class MyPanel extends JPanel{
	private Image image;
	
	public MyPanel(){
	try {
		image = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\back.gif")); 
	} catch (IOException ex) {
		 ex.printStackTrace();
	}
	}
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		//Graphics2D g2 = (Graphics2D) g;
		
		g.drawImage(image, 0, 0, null);
		}
	
	}	