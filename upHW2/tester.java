import java.util.Arrays;

/**
*	create passengers put into Airplane
*/
public class tester {
	public static void sop(Object x){System.out.println(x);}
	public static void main(String[] args){
		AirplaneCabim CX389 = new AirplaneCabim();
		Passenger evt = new Passenger("Evt", "first class", 1, "window");
		Passenger elvis = new Passenger("Elvis", "economy class", 1, "window");
		
		CX389.addPassenger(evt);
		CX389.addPassenger(elvis);
		sop(CX389.seatsState());
		sop(CX389.getPassengerToSeat());
		sop(Arrays.toString(CX389.economyClass));
		sop(Arrays.toString(CX389.firstClass));
		sop(CX389.passengerToSeat.get(elvis));
		}

}