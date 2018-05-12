import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestTextArea{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}
	
class MyFrame extends JFrame{
	private JTextArea text;
	private JScrollPane scrollPane;
	private JButton wrapButton; 
	private JButton clearButton;
	public MyFrame(){
		
		setTitle("TestTextArea");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
						.getImage("E:\\java\\Image\\Doc.png"));
						
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		text = new JTextArea(40, 30);
		scrollPane = new JScrollPane(text);
		//scrollPane.setVerticalScrollBar();
		add(scrollPane);
		
		JButton insertButton = new JButton("Insert");
		buttonPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				
				text.append("Ï²»¶Ð¡ºËµ¯ ");
				}
			});
			
		wrapButton = new JButton("Wrap");
		buttonPanel.add(wrapButton);
		wrapButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				boolean wrap = !text.getLineWrap();
				text.setLineWrap(wrap);
				scrollPane.revalidate();
				wrapButton.setText(wrap? "No Wrap" : "wrap");
				}
			});
			
		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);
		clearButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				text.setText("");
				}
			});
		}
	
}
	
