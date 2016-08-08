import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class UserInterface {
	
	Scanner sc;
	
	public Employee getEmployeeEntry(  ){

		Employee employee=new Employee();
		
		try {
			sc=new Scanner(System.in );
			
			
			System.out.println("Enter Employee Name");
			employee.setName( sc.nextLine() );
			
			System.out.println("Enter Employee ID");
			employee.setId( sc.nextInt() );
			
			/*System.out.println("Enter Employee Address");
			employee.setAddress( sc.nextLine() );
			
			System.out.println("Enter Employee Salary");
			employee.setSalary( sc.nextInt() );*/
			
		} catch (Exception e) {
			System.out.println("***Invalid Input***");
			//e.printStackTrace();
		}
		
		return employee;
	}
	
	public char askChoice(){
		sc=new Scanner(System.in );
		System.out.println("\nFill more entries ? (y/n)");
		return sc.nextLine().charAt(0);
	}
	
	public void printMessage(String message){
		System.out.println(message);
	}
	
	void printSet(Set<Employee> eSet){
		System.out.println(eSet);
	}
	
	void printList(List<Employee> list){
		System.out.println(list);
	}
	
}
