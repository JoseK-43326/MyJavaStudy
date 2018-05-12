import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TestConstraints{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}	
}

class MyFrame extends JFrame{
	private JLabel faceLabel;
	private JComboBox face;
	private JLabel sizeLabel;
	private JComboBox size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea text;
	
	public MyFrame(){
		
		setTitle("TestConstraints");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
						.getImage("E:\\java\\Image\\font.png"));
						
		setLayout(new GridBagLayout());
		FontListener listener = new FontListener();
		faceLabel = new JLabel("Face:");
		face = new JComboBox(new String[] 
					{"ËÎÌå", "ºÚÌå", "·ÂËÎ", "¿¬Ìå", "ÐÂËÎÌå"});
		face.addActionListener(listener);
		
		sizeLabel = new JLabel("Size:");
		size = new JComboBox(new String[]
				{"8", "10", "12", "15", "18", "24", "36", "48"});
		size.addActionListener(listener);	
	
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		
		text = new JTextArea();
		text.setText("·®´Ìâ¬³¬¼¶Ï²»¶Ð¡ºËµ¯");
		text.setLineWrap(true);
		text.setEditable(false);
		text.setBorder(BorderFactory.createEtchedBorder());
		
		add(faceLabel, new GBC(0,0).setAnchor(GBC.EAST));
		add(face, new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
		add(sizeLabel, new GBC(0,1).setAnchor(GBC.EAST));
		add(size, new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
		add(bold, new GBC(0,2,2,1).setAnchor(GBC.CENTER).setWeight(100,100));
		add(italic, new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(100,100));
		add(text, new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100,100));
		}
		private class FontListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				String fontFace = (String) face.getSelectedItem();
				int fontSize = Integer.parseInt((String) size.getSelectedItem());
				int fontStyle = (bold.isSelected() ? Font.BOLD : 0) 
							+ (italic.isSelected() ? Font.ITALIC : 0);
				text.setFont(new Font(fontFace, fontStyle, fontSize));
				text.repaint();
				}
			}
}