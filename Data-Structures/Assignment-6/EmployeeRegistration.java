import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
public class EmployeeRegistration {
	

	
	public void startRegistrationProcess(){
		
		Set<Employee> eSet=new TreeSet<Employee>();
		UserInterface userInterface=new UserInterface();
		char choice='y';
		
		while( choice=='y' || choice=='Y' ){
			boolean b=eSet.add( userInterface.getEmployeeEntry() );
			
			if(b==true){
				Collections.sort( new ArrayList(eSet) );
				userInterface.printSet( eSet );
				
				Collections.sort( new ArrayList(eSet), new EmployeeNameComparator() );
				userInterface.printSet( eSet );
				
				choice=userInterface.askChoice();
			}else{
				userInterface.printMessage("Sorry Employee id already exist");
				continue;
			}
		}	
	}

}
