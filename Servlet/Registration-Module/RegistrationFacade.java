package web1;

public class RegistrationFacade {
	
	public void registerStudent(Student student) throws CannotProcessRequestException{

		try {
			//creating object for data handler
			DataAccessObject dao=new DataAccessObject();
			
			//inserting new registration record to database
			dao.insertStudentRecord(student);
			
		} catch (DataInsertionException e) {
			
			throw new CannotProcessRequestException();
		}
	
	}
	
	
	
}
