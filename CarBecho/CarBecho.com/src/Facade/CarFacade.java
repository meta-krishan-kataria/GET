package Facade;
import java.util.*;

import dao.CarDao;
import model.*;

public class CarFacade {
	
	//
	public List<CarVO> getListOfAllCars(){
		CarDao dao=new CarDao();
		return dao.selectAllCar();
		
	}
	
	//
	public CarVO getCarById(int id){
		CarDao dao=new CarDao();
		return dao.selectCarDetailById(id);
		
	}
	
	//
	public boolean addCar(CarVO car){
		CarDao dao=new CarDao();
		return dao.addCar(car);
	}
	
	//
	public boolean editCar(CarVO car){
		CarDao dao=new CarDao();
		return dao.editCar(car);
	}
	
	
}
