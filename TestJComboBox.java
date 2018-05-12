import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestJComboBox{
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
		}
}

class MyFrame extends JFrame{
	private JPanel labelPanel;
	private JPanel selectPanel;
	private JComboBox<String> comboBox;
	public MyFrame(){
		setTitle("TestJComboBox");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
					.getImage("E:\\java\\Image\\font.png"));
		
		labelPanel = new JPanel();
		add(labelPanel, BorderLayout.CENTER);
		JLabel label = new JLabel("chao ji xi huan xiao he dan");
		labelPanel.add(label);
		
		selectPanel = new JPanel();
		add(selectPanel, BorderLayout.SOUTH);
		
		
		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.addItem("Arial");
		comboBox.addItem("Serif");
		comboBox.addItem("SanSerif");
		comboBox.addItem("MonoSpaced");
		comboBox.addItem("Dialog");
		comboBox.addItem("DialogInput");
		
		selectPanel.add(comboBox);
		
		comboBox.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				label.setFont(new Font((String) comboBox.getSelectedItem(),
									Font.PLAIN, 15));
				}
			});
		}
	
}	