import java.util.*;


public class TestStackTrace{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter: n");
		int n = in.nextInt();
		go(n);
		}	
		
	public static int go(int n){
				System.out.println("�����nΪ��" + n);
				Throwable t = new Throwable();
				StackTraceElement[] frames = t.getStackTrace();
				for(StackTraceElement f : frames)
						System.out.println(f);
				int result;
				if(n <= 1) result = 1;
				else result = n * go(n - 1);
				System.out.println("���Ϊ��" + result);
				return result;
		}
	
}