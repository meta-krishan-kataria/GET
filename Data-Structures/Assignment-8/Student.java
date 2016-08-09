
public class Student implements Comparable {
	private String name;
	private int rollno;
	
	public Student(String name, int rollno) {
		super();
		this.name = name;
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}

	public int getRollno() {
		return rollno;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + "]";
	}
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return this.rollno - ((Student)arg0).rollno;
	}
	
	@Override
	public boolean equals(Object ob){
		Student s=(Student)ob;
		if(s.getRollno()==this.getRollno() && s.getName().equals(this.getName()))
			return true;
		else
			return false;
	}
	
	
}
