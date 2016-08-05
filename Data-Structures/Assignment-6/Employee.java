
public class Employee implements Comparable{

	private int id;
	private String name;
	private String address;
	private int salary;
	
	public Employee(){
		super();
	}
	
	public Employee(int id, String name, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	/*
	 * natural ordering based on employee id
	 * */
	public int compareTo(Object employee) {
		return this.getId() - ( (Employee)employee ).getId();
		
	}
	
	/*
	 *	return ((Employee) employee).getId().compareTo( this.getId() ) ;
		will not work since compareTo is not defined for primitive type int (int id) 

		return this.getName().compareTo(  ((Employee)employee).getName());
		is ok bcoz compareTo is defined for String

	 */

	
	
}
