package MovieReview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyWord.
 */
public class KeyWord{

	/** The positive key word list. */
	private ArrayList<String> positiveKeyWordList = new ArrayList<String>();
	
	/** The neutral key word list. */
	private ArrayList<String> neutralKeyWordList = new ArrayList<String>();
	
	/** The negative key word list. */
	private ArrayList<String> negativeKeyWordList = new ArrayList<String>();
	
	/**
	 * Instantiates a new key word.
	 */
	public KeyWord() {
		
		readKeyWord("positive.txt",positiveKeyWordList);
		readKeyWord("neutral.txt",neutralKeyWordList);
		readKeyWord("negative.txt",negativeKeyWordList);

	}

	/**
	 * Read key word.
	 *
	 * @param path the path
	 * @param keyWordList the key word list
	 */
	private void readKeyWord(String path,ArrayList<String> keyWordList){
		File filename = new File(path);	
		Scanner scan = null;
		
		try {
			scan = new Scanner(filename);
			scan.useDelimiter("\t|\n");
			
			while (scan.hasNext()) {
				String keyWord = scan.nextLine();
				keyWordList.add(keyWord);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
	
	/**
	 * Compare key word.
	 *
	 * @return the array list
	 */
	/*
	public static ArrayList<String> compareKeyWord(String input, ArrayList<String> keyWord){
		ArrayList<String> matched = new ArrayList<String>();
		String[] container = input.split(" ");
		for(int j=0; j < container.length; j++) {
			if(keyWord.contains(container[j]))
				matched.add(container[j]);
		}
		return matched;
	}*/
	
	/**
	 * Gets the positve key word.
	 *
	 * @return the positve key word
	 */
	public ArrayList<String> getPositveKeyWord(){
		return positiveKeyWordList;
	}
	
	/**
	 * Gets the neutral key word.
	 *
	 * @return the neutral key word
	 */
	public ArrayList<String> getNeutralKeyWord(){
		return neutralKeyWordList;
	}
	
	/**
	 * Gets the negative key word.
	 *
	 * @return the negative key word
	 */
	public ArrayList<String> getNegativeKeyWord(){
		return negativeKeyWordList;
	}
}
