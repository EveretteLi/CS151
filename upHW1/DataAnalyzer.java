import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;

/**
*	This class reads data from a file
*	then returns the min, max and average of the value
*/
public class DataAnalyzer {
	private float min, max, avg;

	/**
	*	no arg constructor for the class
	*	calls dataProcessing() directly
	*	@throws FileNotFoundException if the data file not found
	*/
	public DataAnalyzer() throws FileNotFoundException {
		this.dataProcessing(); 
	}

	/**
	*	return the minimum number from the data file in float
	*	@return min the minimun from the data
	*/
	public float getMinimum() { return min; }
	/**
	*	return the maximum number from the data file in float
	*	@return max the maximun from the data
	*/
	public float getMaximum() { return max; }
	/**
	*	return the average of the data file in float
	*	@return avg the average of the data
	*/
	public float getAverage() { return avg; }

	/**
	*	ask user for data file
	*	reads the data then initialized the min, max and avg
	*	@throws FileNotFoundException if the data file was not found
	*/
	public void dataProcessing() throws FileNotFoundException {
		ArrayList<Float> dataList = new ArrayList<>();
		
		//get the file name from the user
		Scanner fileName = new Scanner(System.in);
		//try to find the data file
		Scanner fileInput = null;
		System.out.println("Please enter the name of data file: ");
		File dataFile = new File(fileName.next());
		//file not found -> throw an exception
		if(dataFile == null){
			fileName.close();
			fileInput.close();
			throw new FileNotFoundException("ERROE: File not found!");
		}
		fileInput = new Scanner(dataFile);
		fileName.close();

		//read the file
		while(fileInput.hasNextFloat()) {
			dataList.add(fileInput.nextFloat());
		}
		fileInput.close();

		this.min = dataList.get(0);
		this.max = dataList.get(0);			
		this.avg = 0;
		//find min, max and average
		for(float each : dataList){
			if(each < min)					
				min = each;
			else if(each > max)
				max = each;
			avg += each;
		}
		avg = avg / dataList.size();
	}
}