
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class TestChannel{
	private FileInputStream fis;
	private FileOutputStream fos;
	private FileChannel inChannel;
	private FileChannel outChannel;
	public static void main(String[] args){
			new TestChannel().fileCopy();		
		}	
		
		public void fileCopy(){
			
			File f = new File("E:\\java\\TestChannel.java");
			try {
				fis = new FileInputStream(f);
				fos = new FileOutputStream("E:\\java\\java_test\\a.txt");
				inChannel = fis.getChannel();
				outChannel = fos.getChannel();
				MappedByteBuffer buf = inChannel.map(FileChannel.MapMode.READ_ONLY,
	                                     0,f.length());
				Charset cn = Charset.forName("GBK");  
				CharBuffer charBuf = cn.decode(buf);
				System.out.println(charBuf);
				ByteBuffer byteBuf = cn.encode(charBuf);
				outChannel.write(byteBuf);				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}				
			                            
		}
	
}

