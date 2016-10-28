package DAOLayer;


import java.util.List;

import Model.EmployeeFacade;
import Model.EmployeeVO;

public class TestEmp1 {

	public static void main(String[] args) {
		EmployeeFacade facade=new EmployeeFacade();
		List<EmployeeVO> list=facade.getAllEmployees();
		
		for(EmployeeVO e : list){
			System.out.println(e);
		}

	}

}
