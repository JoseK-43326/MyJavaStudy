import java.io.*;
import java.net.*;

public class DailyAdviceServer{
	public String[] advice = {"get up","sleep","eat"};
	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
		}
	public void go(){
		
		try {
				ServerSocket serverSocket = new ServerSocket(4242);
				while(true){
					Socket socket = serverSocket.accept();
					
					PrintWriter writer = new PrintWriter(socket.getOutputStream());
					String s = getAdvice();
					writer.println(s);
					writer.close();
					System.out.println(s);
					}			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		}
	public String getAdvice(){
			int i = (int) (Math.random() * advice.length);
			return advice[i];
			}
}