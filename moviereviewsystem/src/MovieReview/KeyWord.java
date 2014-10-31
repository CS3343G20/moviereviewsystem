package MovieReview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class KeyWord{

	private ArrayList<String> positiveKeyWordList = new ArrayList<String>();
	private ArrayList<String> neutralKeyWordList = new ArrayList<String>();
	private ArrayList<String> negativeKeyWordList = new ArrayList<String>();
	
	public KeyWord() {
		
		readKeyWord("positive.txt",positiveKeyWordList);
		readKeyWord("neutral.txt",neutralKeyWordList);
		readKeyWord("negative.txt",negativeKeyWordList);

	}

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
	
	public static ArrayList<String> compareKeyWord(String input, ArrayList<String> keyWord){
		ArrayList<String> matched = new ArrayList<String>();
		String[] container = input.split(" ");
		for(int j=0; j < container.length; j++) {
			if(keyWord.contains(container[j]))
				matched.add(container[j]);
		}
		return matched;
	}
	
	public ArrayList<String> getPositveKeyWord(){
		return positiveKeyWordList;
	}
	
	public ArrayList<String> getNeutralKeyWord(){
		return neutralKeyWordList;
	}
	
	public ArrayList<String> getNegativeKeyWord(){
		return negativeKeyWordList;
	}
}
