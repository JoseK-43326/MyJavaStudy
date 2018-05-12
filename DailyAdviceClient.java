import java.io.*;
import java.net.*;


public class DailyAdviceClient{
	
	public static void main(String[] args){
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
		}
	public void go(){
		
		try { 
			Socket s = new Socket("127.0.0.1",4242);
			
			InputStreamReader stream = new InputStreamReader(s.getInputStream());
			
			BufferedReader reader = new BufferedReader(stream);
			
		  String advice = reader.readLine();
			System.out.println("You should :" + advice);
			
			reader.close();
			
		} catch (IOException ex) {
			ex.printStackTrace(); 
		}
		
		}
	
	}