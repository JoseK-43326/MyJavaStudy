import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


//代买需要改进，实现相同效果，尽量代码少一点
public class TestMenu{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}
	
class MyFrame extends JFrame{
	private JCheckBoxMenuItem readOnlyItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	public MyFrame(){
		
		setTitle("TestMenu");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
							.getImage("E:\\java\\Image\\Menu.png"));
							
		JPanel panel = new JPanel();
		add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		
		saveItem = new JMenuItem("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveAsItem = new JMenuItem("Save As");
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.addSeparator();
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
				}
			});
		fileMenu.add(exitItem);		
		
		JMenuItem cutItem = new JMenuItem("Cut", new ImageIcon("E:\\java\\Image\\Cut.png"));
		JMenuItem copyItem = new JMenuItem("Copy", new ImageIcon("E:\\java\\Image\\Copy.png"));
		JMenuItem pasteItem = new JMenuItem("Paste", new ImageIcon("E:\\java\\Image\\Paste.png"));
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.addSeparator();
		
		JMenu optionMenu = new JMenu("Options");
		editMenu.add(optionMenu);	
		
		ButtonGroup group = new ButtonGroup();
		readOnlyItem = new JCheckBoxMenuItem("Read-only");
		readOnlyItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				boolean b = readOnlyItem.isSelected();
				saveItem.setEnabled(!b);
				saveAsItem.setEnabled(!b);
				}
			});
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		group.add(insertItem);
		group.add(overtypeItem);
		optionMenu.add(readOnlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		helpMenu.setMnemonic('H');
		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.setMnemonic('A');
		helpMenu.add(indexItem);
		helpMenu.add(aboutItem);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem aCutItem = new JMenuItem("Cut", new ImageIcon("E:\\java\\Image\\Cut.png"));
		JMenuItem aCopyItem = new JMenuItem("Copy", new ImageIcon("E:\\java\\Image\\Copy.png"));
		JMenuItem aPasteItem = new JMenuItem("Paste", new ImageIcon("E:\\java\\Image\\Paste.png"));
		popupMenu.add(aCutItem);
		popupMenu.add(aCopyItem);
		popupMenu.add(aPasteItem);
		panel.setComponentPopupMenu(popupMenu);
		}
}
	
	