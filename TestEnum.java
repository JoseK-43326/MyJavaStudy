import java.util.*;

public class TestEnum{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size: SMALL MEDIUM LARGE EXTRA_LARGE");
		String input = in.next().toUpperCase();
		
		Size s = (Size) Enum.valueOf(Size.class,input);
		System.out.println("Size : " + s);
		System.out.println("Abbreviation :" + s.getAbbreviation());
		if(s == Size.EXTRA_LARGE){
			System.out.println("Matched");
			
			}
		}
 
	}
		enum Size{
		
		SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
		
		private String abbreviation;
		private Size(String abbreviation){
			this.abbreviation = abbreviation;
			}
		public String getAbbreviation(){
			return abbreviation;
			}
		
		}