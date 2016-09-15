package web1;


/**
 *
 * @author Krishan
 */
public class Student {
	
	private String name;
	private String pswd;
	private String gender;
	private String college;
	private String year;
	private String regno ;	//registration number
	
	//constructor
	public Student(String name, String pswd, String gender, String college,
			String year, String regno) {
		super();
		this.name = name;
		this.pswd = pswd;
		this.gender = gender;
		this.college = college;
		this.year = year;
		this.regno = regno;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}
		
	
}
