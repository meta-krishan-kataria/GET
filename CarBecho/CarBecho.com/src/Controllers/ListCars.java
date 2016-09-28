package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.*;
import Facade.CarFacade;

import java.util.*;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class ListCars extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListCars() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarFacade facade=new CarFacade();
		List<CarVO> carList=facade.getListOfAllCars();
		//
		request.setAttribute("carList", carList);
		//
		RequestDispatcher rd=request.getRequestDispatcher("/ListCars.jsp");
		//
		rd.forward(request, response);
	
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
