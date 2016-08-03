package q2;



import java.util.ArrayList;
import java.util.List;

// class to define guest house
public class GuestHouse {
	
	// variable for name of guest house
	private String guestHouseName;
	
	// variable for total rooms in guest house
	private int guestHouseTotalRooms;
	
	
	public GuestHouse(String guestHouseName , int guestHouseTotalRooms){
		
		this.guestHouseName = guestHouseName;
		
		this.guestHouseTotalRooms = guestHouseTotalRooms;
	}
	
	/**
	 * @return guest house name
	 */
	public String getGuestHouseName(){
		
		return this.guestHouseName;
	}
	
	/**
	 * This method initially makes all the rooms empty
	 * 
	 * @return list of rooms
	 */
	public List<Character> assignRoomNumbers(){
		
		List<Character> roomsList = new ArrayList<Character>();
		
		for(int i = 0 ; i < guestHouseTotalRooms ; ++i ){
			
			roomsList.add('E');
		}
		
		return roomsList;
	}
}