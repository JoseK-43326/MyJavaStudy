import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SendClient{
		JFrame frame;
		JPanel panel;
		JTextField outText;
		JTextArea inText;
		JScrollPane scroller;
		JButton sendButton;
		BufferedReader reader;
		PrintWriter writer;
	public class MyThread implements Runnable{
				
		public void run(){
			try {
				String message = reader.readLine();
				reader.close();
				inText.append(message + "\n");	
			} catch (IOException ex) {
				 ex.printStackTrace();
			}										
			}	
		}
	public static void main(String[] args){
		SendClient client = new SendClient();
		client.go();
		}
		
	public void go(){
		
		frame = new JFrame("ChatBox");
		panel = new JPanel();
		outText = new JTextField(20);
		inText = new JTextArea(10,20);
		scroller = new JScrollPane(inText);
		sendButton = new JButton("Send");
		
		sendButton.addActionListener(new buttonListener());
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		panel.add(outText);
		panel.add(sendButton);
		
		MyThread t = new MyThread();
		Thread thread = new Thread(t);
		thread.start();	
		netWorkSeting();
		
		frame.setSize(300,300);
		frame.setVisible(true);
		}
public class buttonListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		String sendText = outText.getText();
		try {
			writer.println(sendText);
			writer.close();
		}catch (Exception ex) {
			 ex.printStackTrace();
		}
		outText.setText("");
		outText.requestFocus();
		}	
	}
public void netWorkSeting(){
		try {
			Socket socket = new Socket("127.0.0.1",4242);
			InputStreamReader stream = new InputStreamReader(socket.getInputStream());
		  reader = new BufferedReader(stream);
			writer = new PrintWriter(socket.getOutputStream());
		} catch (IOException ex) {
			 ex.printStackTrace();
		}			
	}
	
}