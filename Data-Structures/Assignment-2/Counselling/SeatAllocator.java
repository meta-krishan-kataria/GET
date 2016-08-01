
public class SeatAllocator {
	private College c1;
	private College c2;
	private College c3;
	
	
	
	public SeatAllocator(){
		 c1=new College("MNIT",1, 5);
		 c2=new College("BITS",2, 5);
		 c3=new College("PCE", 3,5);
		
	}
	
	
	String allocateC1 () throws NoVacantSeatException{
		return c1.getSeat();
	}
	
	String allocateC2 () throws NoVacantSeatException{
		return c2.getSeat();
	}
	String allocateC3 () throws NoVacantSeatException{
		return c3.getSeat();
	}
	
	String showSeatMatrix(){
		return new String(    c1.toString()+ "\n" 
							+ c2.toString()+ "\n"
							+ c3.toString()+ "\n" );
	}
	
	
}
