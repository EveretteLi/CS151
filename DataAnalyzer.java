import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;

/**
*	This class reads data from a file
*	then returns the min, max and average of the value
*/
public class DataAnalyzer {
	public static void sop(Object x){ System.out.println(x); }
	//main
	public static void main(String[] args){
		ArrayList<Float> dataList = new ArrayList<>();
		//get the file name from the user
		Scanner fileName = new Scanner(System.in);
		//try to find the data file
		Scanner fileInput = null;
		do{
			sop("Please enter the name of data file: ");
			try{
				fileInput = new Scanner(new File(fileName.nextLine()));
			} catch(FileNotFoundException e) {
				sop("ERROR: file not found");
			}
		} while(fileInput == null);
		fileName.close();
		//read the file
		while(fileInput.hasNextFloat()) {
			dataList.add(fileInput.nextFloat());
		}
		fileInput.close();

		float min = dataList.get(0);
		float max = dataList.get(0);			
		float avg = 0;
		//find min, max and average
		for(float each : dataList){
			if(each < min)					
				min = each;
			else if(each > max)
				max = each;
			avg += each;
		}
		avg = avg / dataList.size();

		sop("Minimun: " + min);
		sop("Maximun: " + max);
		sop("Average: " + avg);
	}
}