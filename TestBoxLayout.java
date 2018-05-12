import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestBoxLayout{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}

class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestBoxLayout");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\font.png"));
					
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(10);
		nameText.setMaximumSize(nameText.getPreferredSize());
		Box nameBox = Box.createHorizontalBox();
		nameBox.add(nameLabel);
		nameBox.add(Box.createHorizontalStrut(10));
		nameBox.add(nameText);
		
		JLabel passLabel = new JLabel("Password:");
		JTextField passText = new JTextField(10);
		passText.setMaximumSize(passText.getPreferredSize());
		Box passBox = Box.createHorizontalBox();
		passBox.add(passLabel);
		passBox.add(Box.createHorizontalStrut(10));
		passBox.add(passText);
		
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(okButton);
		buttonBox.add(Box.createGlue());
		buttonBox.add(cancelButton);
		
		Box vBox = Box.createVerticalBox();
		vBox.add(nameBox);
		vBox.add(passBox);
		vBox.add(Box.createGlue());
		vBox.add(buttonBox);
		
		add(vBox, BorderLayout.CENTER);
		}
}