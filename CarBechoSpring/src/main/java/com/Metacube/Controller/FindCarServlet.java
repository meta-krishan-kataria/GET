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
 * Servlet implementation class FindCarServlet
 * This class fetch the data from View layer(findCarUI.jsp) and encapsulate that data in an object and send to Model layer(CarFacade)
 */
@WebServlet("/FindCarServlet")
public class FindCarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * method to fetch the data from View layer(findCarUI.jsp) and encapsulate that data in an object and send to Model layer(CarFacade)
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
			
			//fetch the data from View layer(findCarUI.jsp) and encapsulate that data in an object
			car.setCompany(request.getParameter("companyName"));
			car.setModel(request.getParameter("modelName"));
			
			//send the object to Model layer and process according to result
			if(facade.findCar(car)){

				response.sendRedirect("/CarBechoSpring/carDetailedViewUI.jsp?companyName="+car.getCompany()+"&modelName="+car.getModel()+
						"&engineInCC="+car.getEngineInCC()+"&fuelCapacity="+car.getFuelCapacity()+"&mileage="+car.getMileage()+
						"&price="+car.getPrice()+"&roadTax="+car.getRoadTax()+"&AC="+car.getAC()+"&powerSteering="+car.getPowerSteering()+
						"&accessoryKit="+car.getAccessoryKit()+"&onRoadPrice="+car.getOnRoadPrice());
			}else{
				
				out.println("<html><body>");
				out.println("<b>Something Went wrong.</b>");
				out.println("<a href='/CarBechoSpring/index.jsp'>Home</a>");
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