package q2;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

// Main class for Room Allotment
public class RoomAllotment {


	
	public static void main(String[] args){
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		// object of roomAllotment class
		RoomAllotment roomAllotment = new RoomAllotment();

		try{

			// initializing guest house object with name and total rooms
			GuestHouse guestHouse = new GuestHouse("Meta Guest House", 70);

			// list of rooms
			List<Character> roomsList = guestHouse.assignRoomNumbers();

			// variable for user permission to continue or not
			char userPermission = '\0';

			// variable for total rooms occupied
			int roomsOccupied = 0;

			do{
				
				System.out.println("Welcome to "+ guestHouse.getGuestHouseName());

				// taking user input for guest name
				System.out.println("Please enter your name");
				String guestName = br.readLine();

				// taking user input for guest age
				System.out.println("Please enter your age");
				int guestAge = Integer.parseInt( br.readLine() );

				// initialized guest with guest name and guest age
				Guest guest = new Guest(guestName , guestAge);

				//alloting room to guest
				int roomAlloted = roomAllotment.allotRoomNumberToGuest(roomsList , guestAge , roomsOccupied);

				// increment the rooms occupied variable 
				roomsOccupied++;

				// displaying result
				if(roomAlloted == -1){

					System.out.println("Sorry " +guest.getGuestName()+" All the rooms are occupied");
				}

				else{
					
					System.out.println("Thank you "+ guest.getGuestName() +" for using our service. "
							+ "\n" +"The room alloted to you is: "+roomAlloted);
				}
				
				System.out.println("Want More rooms (Press Y to continue)");
				// taking user permission to continue
				userPermission = br.readLine().charAt(0);

			}while(userPermission == 'y' || userPermission == 'Y');
			
			System.out.println("Program Ended");
			
		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{

				// closing buffered reader stream
				br.close();

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}	
	}

	/**
	 * This method computes for alloted room , if empty then returned else incremented until 
	 * alloted room is not empty(Linear Probing Method)
	 * 
	 * @param roomsList
	 * @param guestAge
	 * @return alloted room
	 */
	public int allotRoomNumberToGuest(List<Character> roomsList , int guestAge , int roomsOccupied){
		
		// if all the rooms are occupied then return -1
		if(roomsOccupied == roomsList.size()){

			return -1;
		}
		
		// computing alloted room
		int allotedRoom = guestAge % roomsList.size();

		// until alloted room is not empty
		while(roomsList.get(allotedRoom) != 'E'){

			// if room is not empty, allotting next empty room in the order 
			allotedRoom++;

			// if greater than size of rooms then reduce it
			allotedRoom = allotedRoom % roomsList.size();

		}
		//setting allotted room as filled
		roomsList.set(allotedRoom, 'F');

		return allotedRoom;
	}

	
}
