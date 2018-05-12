import java.io.*;

public class TestPrint1{
	
	public static void main(String[] args){
		
		String fileName = args[0];
		if(fileName != null) {
			list(fileName);
			}
		
		}
	public static void list(String aFileName){
		
		
		try {
			FileReader file = new FileReader(aFileName);
			BufferedReader br = new BufferedReader(file);
			String b = null;
			while((b = br.readLine()) != null){
				System.out.println(b);
				}
			br.close();
		} catch (FileNotFoundException ex) {
			 System.out.println("找不到文件");
		}catch(IOException ex){
			ex.printStackTrace();
			}
		}
	
	}