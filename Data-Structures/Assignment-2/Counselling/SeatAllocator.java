
public class SeatAllocator {
	private College c1;
	private College c2;
	private College c3;
	
	
	
	public SeatAllocator(){
		 c1=new College("MNIT",1, 2);
		 c2=new College("BITS",2, 2);
		 c3=new College("PCE", 3,2);
		
	}
	
	
	String allocateC1 () throws NoVacantSeatException{
		return c1.allocateSeat();
	}
	
	String allocateC2 () throws NoVacantSeatException{
		return c2.allocateSeat();
	}
	String allocateC3 () throws NoVacantSeatException{
		return c3.allocateSeat();
	}
	
	String showSeatMatrix(){
		return new String(   " 1 " +  c1.toString()+ "\n" 
							+ " 2 "+  c2.toString()+ "\n"
							+ " 3 "+  c3.toString()+ "\n" );
	}
	
	/**
	 * checks vacant seats in all colleges
	 * returns true if yes and false if no vacant seats left
	 * */
	public int numberOfSeatsLeft(){
		int numOfVacantSeats=c1.getAvailableSeat()+c2.getAvailableSeat()+c3.getAvailableSeat();
		return numOfVacantSeats;
	}
	
	
}
