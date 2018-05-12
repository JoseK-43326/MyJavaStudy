class ScaryException extends Exception
{
}

public class TestException{
	
	public static void main(String[] args){
		String test = "yes";
		try{
			System.out.println("start try");
			doRisky(test);
			System.out.println("end try");
			}catch(Exception ex){
				System.out.println("ScaryException");
			}finally{
			System.out.println("finally");	
			}
		System.out.println("end main");
		}
	
	static void doRisky(String test) throws ScaryException{
		System.out.println("start risky");
		if("yes".equals(test)){
			throw new ScaryException();
			}
		System.out.println("end risky");
		return;
		
		}
	
	}