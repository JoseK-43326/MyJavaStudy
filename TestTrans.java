import java.io.*;
import java.util.*;

public class TestTrans{
	
	public static void main(String[] args){
		
		String s = null;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			while((s = br.readLine())!= null){
				if(s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
			}
			br.close();
			//System.exit(0);
		} catch (IOException ex) {
			 ex.printStackTrace();
		}
		
		
		}
	
	}