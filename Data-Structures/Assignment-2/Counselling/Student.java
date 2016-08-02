
public class Student {
	String name;
	int rank;
	String allotedCollege;
	
	public Student(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
		allotedCollege=new String("None");
	}

	public String getAllotedCollege() {
		return allotedCollege;
	}

	public void setAllotedCollege(String allotedCollege) {
		this.allotedCollege = allotedCollege;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rank=" + rank + ", allotedCollege="
				+ allotedCollege + "]";
	}
	
	
	
	
	
	
}
