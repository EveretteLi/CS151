import java.util.Scanner;

/**
*	This is a simple calculator handle basic math opertations
*/
public class Calculator {
	public static void sop(Object x) { System.out.println(x); }

	//main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//initializing
		String operation = in.next();
		float num1 = in.nextFloat();
		float num2 = in.nextFloat();
		in.close();
		
		//switch based on operation
		switch(operation) {
			case "add": sop("The sum is " + (num1 + num2)); break;
			case "diff": sop("The diff is " + (num1 - num2)); break;
			case "mult": sop("The product is " + (num1 * num2)); break;
			case "div": sop("The division is " + (num1 / num2)); break;
			default: sop("ERROR: Invalid Input"); break;
		}
	}
}