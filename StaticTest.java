
public class StaticTest{
	
	public static void main(String[] args){
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Tom",40000.00);
		staff[1] = new Employee("Bob",65000.00);
		staff[2] = new Employee("Harry",50000.00);
		for(Employee e:staff){
			e.setId();
			System.out.println("name " + e.getName()
			          + " salary " + e.getSalary() 
			          + " ID " + e.getId() );
			}
		int n = Employee.getNextId();
		System.out.println("Next available ID =" + n);
		
		}
	
	}
	
	
class Employee{
	private String name;
	private Double salary;
	private int id;
	private static int nextId = 1;
	
	public Employee(String n, Double s){
		name = n;
		salary = s;
		id = 0;
		}
	
	public String getName(){
		return name;
		}
	public Double getSalary(){
		return salary;
		}
	public int getId(){
		return id;
		}	
	public static int getNextId(){
		return nextId;
		}
		
	public void setId(){
		id = nextId;
		nextId++;
		}
	}