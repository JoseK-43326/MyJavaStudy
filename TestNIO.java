import java.nio.*;

public class TestNIO{
	
public static void main(String[] args){
	CharBuffer buf = CharBuffer.allocate(8);
	buf.put('a');
	buf.put('b');
	buf.put('c');
	System.out.println(buf);
	/*System.out.println(buf.position());
	buf.flip();
	System.out.println(buf.position());
	System.out.println(buf);
	buf.clear();
	System.out.println(buf.get(1));
	buf.put('x');
	buf.clear();
	System.out.println(buf);
	System.out.println(buf.get(0));*/
	}	
	
}