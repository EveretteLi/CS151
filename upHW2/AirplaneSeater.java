import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *	Airplane seater assigns passenger to the possible seats according to his/her preference
 */
public class AirplaneSeater {

    //Seat class
    class Seat {
    	String inClass;
        String type;
        boolean isOccupied;
        int[] posi;
        HashMap<Integer, String> columnToLetter;
        /**
         *	no arg constructor
         */
        public Seat() {
        	inClass = null;
            type = null;
            isOccupied = false;
            posi = new int[]{-1,-1};
            columnToLetter = new HashMap<>();
            int[] num = new int[]
                    {0,1,2,3,4,5};
            String[] letter = new String[]
                    {"A","B","C","D","E","F"};
            for(int i = 0; i < 6; i++)
                columnToLetter.put(num[i], letter[i]);
        }

        @Override
        public String toString() {
            StringBuffer temp = new StringBuffer();
            if(inClass.equals("economy")){
            	temp.append(
                    "Row " + (posi[0]+5+1) + " Column: " + columnToLetter.get(posi[1]));
            }
            else {
            	temp.append(
                    "Row " + (posi[0]+1) + " Column: " + columnToLetter.get(posi[1]));
            }
            return temp.toString();
        }
    }

    public Seat[][] first;
    public Seat[][] economy;
    public ArrayList<Seat> seatList;

    /**
     *	no-arg constructor
     */
    public AirplaneSeater() {
        seatList = new ArrayList<>();
        first = new Seat[5][4];
        economy = new Seat[30][6];

        for(int i = 0; i < 5; i++){
            for(int j = 0 ; j < 4; j++){
                first[i][j] = new Seat();
                if(j == 0 || j == 4) first[i][j].type = "window";
                else first[i][j].type = "aisle";
                first[i][j].inClass = "first";
            }
        }
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 6; j++){
                economy[i][j] = new Seat();
                if(j == 0 || j == 5) economy[i][j].type = "window";
                else if(j == 1 || j== 4) economy[i][j].type = "center";
                else economy[i][j].type = "aisle";
                economy[i][j].inClass = "economy";
            }
        }
    }

    /**
     *	add passenger by his/her class and seat type preference
     *	@param classp class prefernce from the user interface
     *	@param preference the seat preference from the user interface
     *	@return true if the passenger has been added
     */
    public boolean addPassenger(int classp, int preference) {

        //firstclass
        if(classp == 1){
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 4; j++){
                    Seat temp = first[i][j];
                    switch(temp.type){
                        case "window":
                            if(!temp.isOccupied &&(preference==1||preference==0)){
                            	temp.isOccupied = true;
                                temp.posi[0] = i;
                                temp.posi[1] = j;
                                return seatList.add(temp);
                            } break;
                        case "aisle":
                            if(!temp.isOccupied &&(preference==2||preference==0)) {
                            	temp.isOccupied = true;
                                temp.posi[0] = i;
                                temp.posi[1] = j;
                                return seatList.add(temp);
                            } break;
                    }
                }
            }
        }
        //economy
		else {
            for(int i = 0; i < 60; i++) {
                for(int j = 0; j < 3; j++) {
                    Seat temp = economy[i][j];
                    switch(temp.type){
                        case "window":
                            if(!temp.isOccupied &&(preference==1||preference==0)){
                            	temp.isOccupied = true;
                                temp.posi[0] = i;
                                temp.posi[1] = j;
                                return seatList.add(temp);
                            } break;
                        case "aisle":
                            if(!temp.isOccupied && (preference==2||preference==0)) {
                            	temp.isOccupied = true;
                                temp.posi[0] = i;
                                temp.posi[1] = j;
                                return seatList.add(temp);
                            } break;
                        case "center":
                            if(!temp.isOccupied && (preference==3||preference==0)) {
                            	temp.isOccupied = true;
                                temp.posi[0] = i;
                                temp.posi[1] = j;
                                return seatList.add(temp);
                            } break;
                    }
                }
            }
        }
        return false;
    }

    /**
     *	print the seat position (Row x column y)
     *	@return the seat position message
     */
    public String print() {
    	if(seatList.isEmpty()) { return "EMPTY"; }

        StringBuffer message = new StringBuffer();
        for(Seat each : seatList){
            message.append(each.toString() + "\n");
        }
        return message.toString();
    }

    //user interaction
    public static void sop(Object x){ System.out.println(x); }
    public static void main(String[] args){
        AirplaneSeater seater = new AirplaneSeater();
        Scanner in = new Scanner(System.in);
        boolean inLoop = true;

        //TODO: welcome message
        sop("Thank you for choosing EL Airline\n");

        while(inLoop){
            in.reset();

            //pick oper
            int oper = 0;
            do{
                sop("How can I help you today?");
                sop("1: Add passenger\n2: Show seating\n3: Quit");
                oper = in.nextInt();
            } while(oper < 1 || oper > 3);

            //add passenger
            if(oper == 1) {
                //determine class preference
				int classp;
                do{
                    sop("Please choose a class: ");
                    sop("1: Firstclass\n2: Economy");
                    classp = in.nextInt();
                } while(classp < 1 || classp > 2);

                //number of tickets
                int tickets = 0;
                do{
                    sop("How many seats do you need");
                    sop("The seats has to be consistent");
                    if(classp == 1) sop("(1 - 2)");		//firstclass
					else sop("(1 - 3)");				//economy
                    tickets = in.nextInt();
                } while(tickets < 1 || (classp==1 && tickets > 2) || (classp==2 && tickets > 3));

                //determine seat preference
                ArrayList<Integer> userSeatPreference = new ArrayList<>();
                while(tickets > 0) {
                    int seat;
                    do{
                        sop("Seating preference for seat: ");
                        if(classp == 1) sop("1: Window\n2: Aisle\n0: no preference");
                        else sop("1: Window\n2: Aisle\n3: Center\n0: no preference");
                        seat = in.nextInt();
                    } while(seat < 0 || (classp==1 && seat > 2) || (classp==2 && seat > 3));
                    
                    if(seater.addPassenger(classp, seat)){
                        sop("Your seat has been added :)");
                        sop(seater.print());
                    } else sop("Sorry, please try again :(");
                    tickets--;
                }
            }

            //show seating
            else if(oper == 2) sop(seater.print());
            //quit
            else if(oper == 3) inLoop = false;
        }
        //ignore new line
        in.skip("\n");
        sop("THANK YOU!");
    }
}