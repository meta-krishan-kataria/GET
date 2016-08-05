import java.util.Comparator;


public  class EmployeeNameComparator  implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee e1=(Employee) arg0;
		Employee e2=(Employee) arg1;
		
		
		return e1.getName().compareTo( e2.getName() );
	}
		//return e1.compareTo(e2);		will do natural sorting
	
}



class EmployeeAddressComparator  implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee e1=(Employee) arg0;
		Employee e2=(Employee) arg1;
		
		
		return e1.getAddress().compareTo( e2.getAddress() );
	}
		//return e1.compareTo(e2);		will do natural sorting
	
}
