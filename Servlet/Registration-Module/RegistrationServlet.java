package web1;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web1.DBConnectionFailedException;
import web1.DataInsertionException;
import web1.Student;


/**
 *
 * @author KRISHAN
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
	
	

	/*@SuppressWarnings({"null", "ConstantConditions"})*/
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {

		response.setContentType("text/html;charset=UTF-8");

		/*PrintWriter out = response.getWriter();*/

		//getting parameters from request (student details)
		String name=null;
		String pswd = null;
		String gender = null;
		String college = null;
		String year = null;
		String regno = null;

		try {
			name = request.getParameter("name");
			pswd = request.getParameter("pswd");
			gender = request.getParameter("gender");
			college = request.getParameter("college");
			year = request.getParameter("year");
			regno = request.getParameter("regno");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

		//adding symbol for gender             
		if(gender.equals("1")){
			gender="M";
		}else{
			gender="F";
		}     

		//creating student object
		Student student=new Student(name, gender, college, year, regno, pswd);
			
		
		//registration operation
		try {
			
			//creating RegistrationFacade object
			RegistrationFacade facade=new RegistrationFacade();
			//registering student
			facade.registerStudent(student);
			
			//redirecting on success
			response.sendRedirect("index.html?msg=registered");
			
		} catch ( CannotProcessRequestException e) {
			
			e.printStackTrace();
			//redirecting to error page
			response.sendRedirect("errorPage.jsp");
			
		}



	}

	/**
	 * Handles get request
	 * */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles post request
	 * */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	
}
