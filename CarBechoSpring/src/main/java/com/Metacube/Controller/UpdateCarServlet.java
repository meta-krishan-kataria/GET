package com.Metacube.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Metacube.Factory.FacadeFactory;
import com.Metacube.Model.CarFacade;
import com.Metacube.Model.CarVO;

/**
 * Servlet implementation class UpdateCarServlet
 * This class fetch the data from View layer(updateCarUI.jsp) and encapsulate that data in an object and send to Model layer(CarFacade)
 */
@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * method to fetch the data from View layer(updateCarUI.jsp) and encapsulate that data in an object and send to Model layer(CarFacade)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = null;
		try {
			
			response.setContentType("text/html");
			out = response.getWriter();
			//getting facade object
			FacadeFactory facadeFactory = new FacadeFactory();
			CarFacade facade = facadeFactory.getFacade();
			
			CarVO car = new CarVO();

			//fetch the data from View layer(addCarUI.jsp) and encapsulate that data in an object
			car.setCompany(request.getParameter("companyName"));
			car.setModel(request.getParameter("modelName"));
			car.setEngineInCC(Integer.parseInt(request.getParameter("engineInCC")));
			car.setFuelCapacity(Double.parseDouble(request.getParameter("fuelCapacity")));
			car.setMileage(Double.parseDouble(request.getParameter("mileage")));
			car.setPrice(Double.parseDouble(request.getParameter("price")));
			car.setRoadTax(Double.parseDouble(request.getParameter("roadTax")));
			
			if(request.getParameter("AC").equals("Yes")){

				car.setAC(1);
			}

			if(request.getParameter("powerSteering").equals("Yes")){

				car.setPowerSteering(1);
			}
			
			if(request.getParameter("accessoryKit").equals("Yes")){

				car.setAccessoryKit(1);
			}
		
			//send the object to Model layer and process according to result
			if(facade.updateCar(car)){

				out.println("<html><body>");
				out.println("<b>Car Details are successfully updated</b>");
				out.println("<a href='/CarBechoSpring/viewCarsListUI.jsp'>View Cars List</a>");
				out.println("</body></html>");
			}else{
				
				out.println("<html><body>");
				out.println("<b>Something Went wrong.</b>");
				out.println("<a href='/CarBechoSpring/viewCarsListUI.jsp'>View Cars List</a>");
				out.println("</body></html>");
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}