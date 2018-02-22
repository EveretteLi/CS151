import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
*	The main class of the system
*	manage the state of seats 
*	pair passenger with seat
*/
public class AirplaneCabim {
	private final int capacity = 200;
	private int passengersOnBoard;
	private Seat[] firstClass, economyClass;
	private HashMap<Passenger, Seat> passengerToSeat;
	private int firstClassWindow, firstClassAisle, 
	economyClassWindow, economyClassAisle, economyClassCenter;

	/**
	*	no arg constructor
	*	it initialized the seat type for both classes
	*/
	public AirplaneCabim(){
		this.reset();
	}

	/**
	*	Helper funciton to reset all the variables
	*/
	public void reset(){ 
		passengersOnBoard = 0;
		firstClass = new Seat[20];
		economyClass = new Seat[180];
		passengerToSeat = new HashMap<>();
		firstClassWindow = 0;
		firstClassAisle = 10;
		economyClassWindow = 0;
		economyClassAisle = 60;
		economyClassCenter = 120;
		//seat type assigning//

		//in first class aisle and window are the only seat types
		//50% each -> 10-aisle, 10-window
		int i = 0;
		while(i < firstClass.length) {
			firstClass[i] = new Seat();
			//assign first half to window
			if(i < 10) firstClass[i].seatType = "window";
			//assign the rest to aisle
			else firstClass[i].seatType = "aisle";
			i++;
		}
		//each type takes 1/3 of 180
		//60-window, 60-aisle, 60-center
		i = 0;
		while(i < economyClass.length) {
			economyClass[i] = new Seat();
			//first 1/3 to window
			if(i < 60) economyClass[i].seatType = "window";
			//next 1/3 to aisle
			else if(i >= 60 && i < 120) economyClass[i].seatType = "aisle";
			//the rest are center
			else economyClass[i].seatType = "center";
			i++;
		}
	}

	/**
	*	add passenger into the queue based on capacity of the plane
	*	@param newPassenger the new passenger added
	*	@return true if the passenger has been added
	*/
	public boolean addPassenger(Passenger newPassenger) {
		//no more space
		if(passengersOnBoard >= capacity)
			return false;
		if(newPassenger.getClassPreference().equals("first class") 
			&& newPassenger.getNumOfCompanion() < 3){
			switch(newPassenger.getSeatingPreference()){
				case "window":
					if(firstClassWindow < 10){
						passengerToSeat
						.put(newPassenger, firstClass[firstClassWindow]);
						firstClass[firstClassWindow].isOccupied = true;
						firstClassWindow++; passengersOnBoard++; break;
					} else return false;
				case "aisle":
					if(firstClassAisle < firstClass.length){
						passengerToSeat
						.put(newPassenger, firstClass[firstClassAisle]);
						firstClass[firstClassAisle].isOccupied = true;
						firstClassAisle++; passengersOnBoard++; break;
					} else return false;
			}
			//added 
			return true;
		}
		else if(newPassenger.getClassPreference().equals("economy class")
			&& newPassenger.getNumOfCompanion() < 4){
			switch(newPassenger.getSeatingPreference()){
				case "window":
					if(economyClassWindow < 60){
						passengerToSeat
						.put(newPassenger, economyClass[economyClassWindow]);
						economyClass[economyClassWindow].isOccupied = true;
						economyClassWindow++; passengersOnBoard++; break;
					} else return false;
				case "aisle":
					if(economyClassAisle < 120){
						passengerToSeat
						.put(newPassenger, economyClass[economyClassAisle]);
						economyClass[economyClassAisle].isOccupied = true;
						economyClassAisle++; passengersOnBoard++; break;
					} else return false;
				case "center":
					if(economyClassCenter < economyClass.length){
						passengerToSeat
						.put(newPassenger, economyClass[economyClassCenter]);
						economyClass[economyClassCenter].isOccupied = true;
						economyClassCenter++; passengersOnBoard++; break;
					} else return false;
			}
			//added
			return true;
		}
		else return false;
	}

	/**
	*	show the state of the seats
	*	based on class and type
	*	@return seatsState the state of the seats
	*/
	public String seatsState() {
		int window = 0;
		int aisle = 0;
		int center = 0;
		for(Seat each : firstClass){
			if(each.isOccupied) continue;
			switch(each.seatType){
				case "window": window++; break;
				case "aisle": aisle++; break;
			}
		}
		String firstClassState = "First Class Seats:\n"
		 + "Window: " + window + " available\n"
		 + "Aisle: " + aisle + " available\n\n";

		window = 0;
		aisle = 0;
		for(Seat each : economyClass){
			if(each.isOccupied) continue;
			switch(each.seatType){
				case "window": window++; break;
				case "aisle": aisle++; break;
				case "center": center++; break;
			}
		}
		String economyClassState = "Ecomomy Seats:\n"
		 + "Window: " + window + " available\n"
		 + "Aisle: " + aisle + " available\n"
		 + "Center: " + center + " available\n\n";

		return firstClassState + economyClassState;
	}

	/**
	*	get passenger to seat list
	*	@return list the passenger to seat list
	*/
	public String getPassengerToSeat() {
		StringBuffer list = new StringBuffer();
		list.append("===========START============\n");
		for(Passenger each : passengerToSeat.keySet()){
			list.append(each.getName() + "	|	");
			Seat temp = passengerToSeat.get(each);
			list.append("Type: "+temp.seatType+" Occupied: "+temp.isOccupied);
			list.append("\n");
		}
		list.append("============END============\n");
		return list.toString();
	}
}










