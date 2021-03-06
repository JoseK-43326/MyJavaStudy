import java.util.*;

public class TestHashSet{
	
	public static void main(String[] args){
		
		HashSet s1 = new HashSet();
		HashSet s2 = new HashSet();
		s1.add("a");s1.add("b");s1.add("c");
		s2.add("d");s2.add("a");s2.add("b");
		
		HashSet sn = new HashSet(s1);
		sn.retainAll(s2);
		
		HashSet su = new HashSet(s2);
		su.addAll(s1);
		
		System.out.println(sn);
		System.out.println(su);
		}
}