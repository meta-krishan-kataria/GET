
public class College {
	private String name;
	private int id;
	private final int numOfSeats;
	private int availabelSeats;
	
	public College(String name,int id, int numOfSeats) {
		super();
		this.name = name;
		this.numOfSeats = numOfSeats;
		availabelSeats=numOfSeats;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	/**
	 * returns number of available seats
	 * */
	public int getAvailableSeat(){
		return availabelSeats;
	}
	
	/**
	 * updates available seats number and returns college name
	 * @throws NoVacantSeatException if no vacant seat available
	 * */
	public String allocateSeat() {
		if( isAvailabe() ){
			availabelSeats--;
			return this.name;
		}else{
			throw new  NoVacantSeatException();
		}
		
	}
	
	public boolean isAvailabe(){
		if(availabelSeats > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return new String( "College: " + this.name + "  Vacant seats: " +availabelSeats );
	}
	
	
}
