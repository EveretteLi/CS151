import java.util.ArrayList;

/**
*	A passenger queue that put passenger into airplane cabim
*/
public class PassengerHandler extends ArrayList<Passenger>{

	/**
	*	return and remove the next first passenger in the queue
	*	@return the next first passenger in the passenger queue
	*/
	public Passenger pop() {
		if(this.isEmpty())
			return null;
		else return this.remove(0);
	}

	/**
	*	push a new passenger at the end of the queue
	*	@param newPassenger the new passenger
	*	@return true if the passenger has been pushed 
	*/
	public boolean push(Passenger newPassenger) 
	{ return this.add(newPassenger); }


}