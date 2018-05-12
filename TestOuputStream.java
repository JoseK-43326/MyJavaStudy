import java.io.*;
public class TestOuputStream{
		
	public static void main(String[] args){
		FileInputStream in = null;
		FileOutputStream out = null;
		int b;
		try{
			in = new FileInputStream("E:\\java\\java_test\\Test.txt");
			out = new FileOutputStream("E:\\java\\java_test\\Test_copy.txt");
			}catch(FileNotFoundException ex){
				System.out.println("File Not Found");
				}
		
		try {
		 		while((b = in.read()) != -1){
		 		  out.write((char)b);
		 		}
		 		in.close();
		 		out.close();
		 		System.out.println("文件复制成功");
		 } catch (IOException ex) {
		 	 System.out.println("Failed to read the file");
		 }
	
		
		
		
		}
		
	
	
	
	}