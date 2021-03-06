public class TestInner{
	
	public static void main(String[] args){
		int[] list = new int[20];
		for(int i =0; i < list.length; i++){
				list[i] =(int) (100 * Math.random());
			}
		for(int e : list)
				System.out.println(e);
				
		Array1.Pair p = Array1.minmax(list);	
		System.out.println("max value is " + p.getSecond());
		System.out.println("min value is " + p.getFirst());	
		}
	
}

class Array1{
	
	public static class Pair{
		private int first;
		private int second;
		public Pair(int aFirst, int aSecond){
			this.first = aFirst;
			this.second = aSecond;
			}
		public int getFirst(){
			return first;
			}
		public int getSecond(){
			return second;
			}
		}
	
	public static Pair minmax(int[] list){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int v : list){
			if(v < min) min = v;
			if(v > max) max = v;			
			}
		return new Pair(min, max);
		} 
	
	}
