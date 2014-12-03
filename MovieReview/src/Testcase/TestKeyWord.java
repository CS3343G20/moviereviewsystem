package Testcase;

import java.util.ArrayList;
import MovieReview.KeyWord;
import junit.framework.TestCase;

/**
 * Test cases in this class will perform unit test on KeyWord.java dependently
 */
public class TestKeyWord extends TestCase {

	private KeyWord keyWord;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { keyWord = new KeyWord(); }

	
	//Test case 1: Test the getter of positive word
	public void testGetPositiveWord(){
		ArrayList<String> result;
		result = keyWord.getPositveKeyWord();
		assertTrue(result.contains("first-rate"));
	}
	
	//Test case 2: Test the getter of get Neutral word
	public void testGetNeutralWord(){
		ArrayList<String> result;
		result = keyWord.getNeutralKeyWord();
		assertTrue(result.contains("suspenseful"));
	}
	
	//Test case 3: Test the getter of get negative word
	public void testGetNegativeWord(){
		ArrayList<String> result;
		result = keyWord.getNegativeKeyWord();
		assertTrue(result.contains("moronic"));
	}
	
	//Test case 4: Test compareKeyWord
	/*public void testCompareKeyWord1(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("bus");
		list.add("keyword1");
		list.add("apple");
		
		String input = "keyword1 keyword2";
		ArrayList<String> result;
		result = keyWord.compareKeyWord(input, list);
		assertTrue(result.contains("keyword1"));
	}
	
	public void testCompareKeyWord2(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("bus");
		
		String input = "keyword1";
		ArrayList<String> result;
		result = keyWord.compareKeyWord(input, list);
		assertFalse(result.contains("keyword1"));
	}*/
}
