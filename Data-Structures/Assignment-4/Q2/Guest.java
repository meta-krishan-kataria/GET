package q2;



// class to define guest
public class Guest {
	
	// variable for guest name
	private String guestName;
	
	// variable for guest age
	private int guestAge;
	
	
	public Guest(String guestName , int guestAge){
		
		this.guestName = guestName;
		
		this.guestAge = guestAge;
	}
	
	// return guest name
	public String getGuestName(){
		
		return this.guestName;
	}
	
	// return guest age
	public int getGuestAge(){
		
		return this.guestAge;
	}

}
