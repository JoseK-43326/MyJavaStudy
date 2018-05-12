
import java.util.*;

public class TestCalendar{
	
	public static void main(String[] args){
		
		GregorianCalendar d = new GregorianCalendar();
		
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		int weekday = d.get(Calendar.DAY_OF_WEEK);
				
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		
		for(int i = Calendar.SUNDAY; i < weekday; i++)
				System.out.print("  ");
		d.set(Calendar.DAY_OF_MONTH,1);
				
		do{
			
				int day = d.get(Calendar.DAY_OF_MONTH);
				    System.out.printf("%3d",day);
				
				if(day == today)
						System.out.print("*");
				else
						System.out.print(" ");
						
				if(weekday == Calendar.SATURDAY)
						System.out.println();
						
				d.add(Calendar.DAY_OF_MONTH,1);
				weekday = d.get(Calendar.DAY_OF_WEEK);
			
			}while(d.get(Calendar.MONTH) == month);
			
		}
	}