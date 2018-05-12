class TestStatic{
	static{
		System.out.println("Super Static Block");
		}
		
	TestStatic(){
		System.out.println("Super Constructor");
		}	
	}
	public class Test extends TestStatic{
		
		static int rand;
		
		static{
			rand = (int) (Math.random()*6);
			System.out.println("static block" + rand);
			}
			
		Test(){
			System.out.println("constructor");	
			}	
		
		
		
		public static void main(String[] args){
			System.out.println("in main");
			Test st = new Test();
			}
	}
