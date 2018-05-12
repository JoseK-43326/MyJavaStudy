import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;


public class TestSpinner{
	
	public static void main(String[] args){
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}
	
class MyFrame extends JFrame{
	
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JButton button;
	public MyFrame(){
		
		setTitle("TestSpinner");
		setSize(700, 300);
		setIconImage(Toolkit.getDefaultToolkit()
							.getImage("E:\\java\\Image\\qq.png"));
		
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		button = new JButton("OK");
		buttonPanel.add(button);
		
		mainPanel = new JPanel();
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(0, 3));
		
		JSpinner defaultSpinner = new JSpinner();
		addRow("Default", defaultSpinner);
		
		JSpinner boundSpinner = new JSpinner(
								new SpinnerNumberModel(4,0,10,0.5));
		addRow("Bound", boundSpinner);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
											.getAvailableFontFamilyNames();
		JSpinner listSpinner = new JSpinner(new SpinnerListModel(fonts));
		addRow("List", listSpinner);
		
		JSpinner reveseSpinner = new JSpinner(new SpinnerListModel(fonts){
			
			public Object getNextValue(){
				return super.getPreviousValue();
				}
			public Object getPreviousValue(){
			return super.getNextValue();
				}
			});
		addRow("Revese", reveseSpinner);
		
		JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
		addRow("Date", dateSpinner);
		
		JSpinner timeSpinner = new JSpinner(new SpinnerDateModel(
											new GregorianCalendar(2017, Calendar.JANUARY, 15, 11 , 0 , 0)
											.getTime(), null, null, Calendar.HOUR));
		addRow("Time", timeSpinner);
		}
	public void addRow(String name, JSpinner spinner){
		
		JLabel nameLabel = new JLabel(name);
		mainPanel.add(nameLabel);
		mainPanel.add(spinner);
		JLabel valueLabel = new JLabel();
		mainPanel.add(valueLabel);
		button.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				
				Object value = spinner.getValue();
				valueLabel.setText("" + value.toString());
				}
			});
		}
	
}