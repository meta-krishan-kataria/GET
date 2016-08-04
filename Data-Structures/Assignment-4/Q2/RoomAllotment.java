package q2;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

// class for Room Allotment mechanism
// uses hash table like concept
public class RoomAllotment {


	/**
	 * allocate room based on their age if its available
	 * unless increments until 
	 * got a empty room 
	 * i.e. using Linear Probing Method
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

		// allotting room based on age
		int allotedRoom = guestAge % roomsList.size();

		// if alloted room is not empty
		while(roomsList.get(allotedRoom) != 'E'){

			//allotting next empty room in the order 
			allotedRoom++;

			//if greater than size of rooms then reduce it
			allotedRoom = allotedRoom % roomsList.size();

		}
		//setting allotted room as filled
		roomsList.set(allotedRoom, 'F');

		return allotedRoom;
	}

	/**
	 * (Version: 2)
	 * allocate room based on their age if its available
	 * unless allocates room no. 1 and keep incrementing until 
	 * it find an empty room
	 * 
	 * @param roomsList
	 * @param guestAge
	 * @return alloted room
	 */
	public int allotRoomNumberToGuestV2(List<Character> roomsList , int guestAge , int roomsOccupied){

		// if all the rooms are occupied then return -1
		if(roomsOccupied == roomsList.size()){

			return -1;
		}

		// allotting room based on age
		int room = guestAge % roomsList.size();

		// if alloted room is not empty then assigning room no. 1
		if( roomsList.get(room) != 'E' ){
			room=1;
		}
		//if room no. 1 is also not empty then allotting next room in the sequence
		while(roomsList.get(room) != 'E'){

			//allotting next empty room in the order 
			room++;

			//if greater than size of rooms then reduce it
			room = room % roomsList.size();

		}
		//setting allotted room as filled
		roomsList.set(room, 'F');

		return room;
	}

	
	


}
