import java.util.Scanner;
import java.util.ArrayList;
/**
*	This class pervides a terminal interface for the user
*	users can use three command "add passengers", "show seating" and "quit"
*/
public class AirLine {
	public static void sop(Object x) { System.out.println(x); }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AirplaneCabim plane = new AirplaneCabim();
		boolean inLoop = true;
		sop("===================================================================\n");
		sop("## Thank you for choosing EL Airline! ##\n");
		sop("Please follow the instructions on the ternimial.");
		while(inLoop){
			sop("===================================================================\n");
			sop("How can I help you?");
			sop("-------------------------------------------------------------------");
			sop("[\"add passengers\" : add a passenger to the flight.]");
			sop("[\"show seating\" : show the current seating information on the plane.]");
			sop("[\"quit\" : quit the booking process.]");
			sop("-------------------------------------------------------------------");
			//avoid new line interrupt the program while looping
			in.reset();
			String oper = in.nextLine();

			switch(oper){
				case "add passengers":
					boolean entering = true;
					Passenger newPassenger;
					while(entering){
						String name = "";
						String classPreference = "";
						int numOfCompanion = -1;
						String seatPreference = "";
						do{
							sop("-------------------------------------------------------------------");
							sop("Please enter the name of the passenger(first last)");
							name = in.nextLine();
							sop("-------------------------------------------------------------------");
						} while(name.equals("")); 

						do{
							sop("-------------------------------------------------------------------");
							sop("Please select class(\"first class\" / \"economy class\")");
							classPreference = in.nextLine();
							sop("-------------------------------------------------------------------");
						} while(!classPreference.equals("first class") && !classPreference.equals("economy class"));

						do{
							sop("-------------------------------------------------------------------");
							sop("Please enter the number of passengers you are traveling with");
							sop("[First class passengers can take up to 2 companions]");
							sop("[Economy class passengers can take up to 3 companions]");
							numOfCompanion = in.nextInt();
							sop("-------------------------------------------------------------------");
						} while(
							(classPreference.equals("first class")&&numOfCompanion > 2)
							 || (classPreference.equals("economy class")&&numOfCompanion > 3)
							 || numOfCompanion < 0);

						do{
							sop("-------------------------------------------------------------------");
							sop("Please pick your seating preference");
							sop("[first class: window / aisle]");
							sop("[economy class: window / aisle / center]");
							seatPreference = in.next();
							sop("-------------------------------------------------------------------");
						} while(!seatPreference.equals("window")
							&&!seatPreference.equals("aisle")
							&&!(classPreference.equals("economy class")&&seatPreference.equals("center")));

						newPassenger = new Passenger(name, classPreference, numOfCompanion, seatPreference);
						if(plane.addPassenger(newPassenger)) entering = false;
						else sop("ERROR MESSAGE");
					} 
					sop("==================YOUR REQUEST HAS BEEN ACCEPTDE========================");
					// avoiding take new line
					in.skip("\n");
					break;
				case "show seating": 
					sop(plane.seatsState());
					sop(plane.getPassengerToSeat());
					break;
				case "quit":
					inLoop = false; break;
			}
		}
		in.close();
		sop("## Thank you for your support! ##");
		sop("===================================================================\n");
	}
}