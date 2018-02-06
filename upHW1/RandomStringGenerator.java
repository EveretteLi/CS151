import java.util.ArrayList;
import java.util.Random;

/**
*	This class will generates a random string 
*	according to the length and range
*/
public class RandomStringGenerator {
	private ArrayList<String> alphabet;
	public ArrayList<String> letterPool;

	public RandomStringGenerator() {
		alphabet = new ArrayList<>();
		letterPool = new ArrayList<>();
		String[] temp = new String[] {
			"a","b","c","d","e","f","g","h","i","j",
			"k","l","m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z","A","B","C","D",
			"E","F","G","H","I","J","K","L","M","N",
			"O","P","Q","R","S","T","U","V","W","X",
			"Y","Z"
		};
		for(String each : temp)
			alphabet.add(each);
	}

	/**
	*	modify the range of the random string
	*	@param from the starting point
	*	@param to the end point
	*/
	public void addRange(char from, char to) {
		String strFrom = Character.toString(from);
		String strTo = Character.toString(to);
		int indexFrom = alphabet.indexOf(strFrom);
		int indexTo = alphabet.indexOf(strTo);

		ArrayList<String> temp = new ArrayList<>(
			alphabet.subList(indexFrom, indexTo+1));
		for(String each : temp){
			if(!letterPool.contains(each))
				letterPool.add(each);
		}
	}

	/**
	*	Generate the random string in the length determained by the users
	*	@param len the length of the string
	*	@return ranStr random string in length len
	*/
	public String nextString(int len) {
		StringBuffer ranStr = new StringBuffer("");
		Random ran = new Random();
		if(!letterPool.isEmpty()){
			for(int i = 0; i < len; i++){
				ranStr.append(letterPool.get(ran.nextInt(letterPool.size())));
			}
		}
		
		return ranStr.toString();
	}

	/**
	*	reset the range to 0
	*/
	public void reset() { this.letterPool.clear(); }

}