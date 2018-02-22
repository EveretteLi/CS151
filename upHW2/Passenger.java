/**
*	A passenger class which define the basic state of a passenger
*/
public class Passenger {
	private String name;
	private String classPreference;
	private int numOfCompanion;
	private String seatingPreference;

	/**
	*	no arg constructor
	*	passenger with no information
	*/
	public Passenger(){
		name = "";
		//"first class" || "economy class"
		classPreference = "";
		numOfCompanion = 0;
		seatingPreference = "";
	}

	/**
	*	stander constructor for a passenger
	*	@param name the name of the passenger
	*	@param classPreference the class preference of the passenger
	*	@param numOfCompanion number of companion with the passenger
	*	@param seatingPreference passenger's seating preference
	*/
	public Passenger(String name, String classPreference, 
		int numOfCompanion, String seatingPreference) {
		this.name = name;
		this.classPreference = classPreference;
		this.numOfCompanion = numOfCompanion;
		this.seatingPreference = seatingPreference;
	}

	/**
	*	get name of the passenger
	*	@return name the name of the passenger
	*/
	public String getName() {return this.name; }
	/**
	*	get class preference of the passenger
	*	@return classPreference the class preference of the passenger
	*/
	public String getClassPreference() {return this.classPreference; }
	/**
	*	get number of companion with the passenger
	*	@return numOfCompanion number of companion with the passenger
	*/
	public int getNumOfCompanion() {return this.numOfCompanion; }
	/**
	*	get passenger's seating preference
	*	@return seatingPreference passenger's seating preference
	*/
	public String getSeatingPreference() {return this.seatingPreference; }
	/**
	*	set name of the passenger
	*	@param newName new name of the passenger
	*/
	public void setName(String newName) {this.name = newName;}
	/**
	*	set class preference of the passenger
	*	@param newClassPreference new class preference of the passenger
	*/
	public void setClassPreference(String newClassPreference) 
	{this.classPreference = newClassPreference; }
	/**
	*	set number of companion of the passenger
	*	@param newNumOfCompanion new number of companion with the passenger
	*/
	public void setNumOfCompanion(int newNumOfCompanion) 
	{this.numOfCompanion = newNumOfCompanion; }
	/**
	*	set passenger's new seating preference
	*	@param newSeatingPreference passenger's new seating preference
	*/
	public void setSeatingPreference(String newSeatingPreference) 
	{this.seatingPreference = newSeatingPreference; }

	



}