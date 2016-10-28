package Model;

/**
 * class to get and set the details of the employees
 */
public class EmployeeVO {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	
	
	
	

	/**
	 * unparameterized constructor
	 */
	public EmployeeVO() {
		
		id = 0;
		name = null;
		age = 0;
		gender = null;
		address = null;
	}
	
	/**
	 * get the id of the employee
	 * @return : id of the employee
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * set the id of the employee
	 * @param id : id of the employee
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * get the name of the employee
	 * @return : name of the employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the employee
	 * @param name : name of the employee
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the age of the employee
	 * @return : age of the employee
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * set the age of the employee
	 * @param age : age of the employee
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * get the gender of the employee
	 * @return : gender of the employee
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * set the gender of the employee
	 * @param gender : gender of the employee
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * get the address of the employee
	 * @return : address of the employee
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * set the address of the employee
	 * @param name : address of the employee
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}	
	
	
}