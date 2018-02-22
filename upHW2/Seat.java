/**
*	This class is a support class for AirplaneCabim
*/
public class Seat {
	//package public global variables
	String seatType;
	boolean isOccupied;

	/**
	*	no arg constructor 
	*	set seatType to null and seat non-occupied
	*/
	public Seat(){
		seatType = "";
		isOccupied = false;
	}

	@Override
	public String toString(){
		return seatType + " " + isOccupied +"\n";
	}
}  