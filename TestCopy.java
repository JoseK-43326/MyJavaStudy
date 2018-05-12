import java.io.*;

public class TestCopy{

	public static void main(String[] args){
		FileReader fReader = null;
		FileWriter fWriter = null;
		int b = 0;
		try {
			fReader = new FileReader("E:\\java\\java_test\\Test.txt");
			fWriter = new FileWriter("E:\\java\\java_test\\Test_copy1.txt");
			while ((b = fReader.read()) != -1) {
					fWriter.write((char) b);
			}
			System.out.println("文件复制成功");
			fReader.close();
			fWriter.close();
			
		} catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 System.out.println("无法找到文件");
		}catch(IOException ex){
			ex.printStackTrace();
			System.out.println("文件读取异常");
			
			}
		
		}
	}