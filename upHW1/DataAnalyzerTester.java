import java.io.PrintWriter;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

/**
*   This class will create random data to test DataAnalyzer class
*/
public class DataAnalyzerTester { 
    /**
    *   This function will make a random data file named dataFile.txt at
    *   current directory
    */
    public void dataFileWriter() {
        File dataFile = new File(
            "dataFile.txt");
        PrintWriter pr = null;
        Random ran = new Random();
        //make file
        try{
            pr  = new PrintWriter(dataFile);
            for(int i = 0; i < 50; i++)
                pr.println(ran.nextInt(50) + ran.nextFloat());
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally { pr.close(); }
    }
    //main
    public static void main(String[] args){
        DataAnalyzerTester t = new DataAnalyzerTester();
        t.dataFileWriter();
    }
}