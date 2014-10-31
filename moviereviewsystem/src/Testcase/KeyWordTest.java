package Testcase;

import java.util.ArrayList;
import MovieReview.KeyWord;
import junit.framework.TestCase;

public class KeyWordTest extends TestCase {

	private KeyWord keyWord;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { keyWord = new KeyWord(); }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
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
}
