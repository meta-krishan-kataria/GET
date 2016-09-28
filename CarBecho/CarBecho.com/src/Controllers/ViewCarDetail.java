package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyUtil;
import model.CarVO;
import Facade.CarFacade;

/**
 * Servlet implementation class ViewCarDetail
 */
@WebServlet("/ViewCarDetail")
public class ViewCarDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCarDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		CarFacade facade=new CarFacade();
		
		String queryString=request.getQueryString();
		int id=Integer.parseInt( dao.MyUtil.getQueryMap(queryString).get("id") );
		//
		CarVO car=facade.getCarById(id);
		//
		request.setAttribute("car", car);
		//
		RequestDispatcher rd=request.getRequestDispatcher("/CarDetails.jsp");
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
