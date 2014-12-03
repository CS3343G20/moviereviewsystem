package Testcase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

import MovieReview.ControlPanel;
import junit.framework.TestCase;
/**
 * Test cases in this class is designed to test the whole system
 * to perform system on the project
 */
public class TestMovieReview extends TestCase {
	private static ControlPanel controlPanel;
	
	//Test case 1: Test select movie function with alphabetic input	
	public void testSelectMovieWithAlphabet(){		
		controlPanel = new ControlPanel();
		String input = "Alphabet\n0\n";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		controlPanel.selectMovie(null);
        assertTrue(outContent.toString().contains("Your input is invalid, please try again."));
	}
	
	//Test case 2: Test select movie function with alphabetic input
	public void testSelectMovieWithBigInteger(){		
		String input = "1111111111111111111111\n0\n";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		controlPanel.selectMovie(null);
        assertTrue(outContent.toString().contains("Your input is invalid, please try again."));
	}
	
	/* Test case 3: Testing the view info function from select function
	 * case 1: 1\r Test viewMovieInfo(mid)
	 * case 2: 2\r Test viewComment(mid)
	 * The result should display both movie info and comment info 
	 */
	public static void testSelectFunction1(){		
		String input = "1\r2\r6\r";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectFunction(0,null);
	    boolean result = outContent.toString().contains("The Shawshank redemption") && outContent.toString().contains("A movie revolution upon all others");
	    assertTrue(result) ;
	}	
	
	//Test case 4: Test the post comment function from selectFunction with a correct comment input simulated
	public static void testSelectFunction2(){		
		String input = "3\nTestAuthor\nTestTitle\nThis is a test comment\n6";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	   
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectFunction(0,null);
	    assertTrue(outContent.toString().contains("This is a test comment"));
	}
	
	//Test case 5: Test the viewMovieNames and selectMovie function from selectFunction, test if the function retrieve correct information
	public static void testSelectFunction3(){		
		String input = "4\r0\r6\r";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	   
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectFunction(0,null);
	    assertTrue(outContent.toString().contains("The Lord of the Rings: The Fellowship of the Ring"));
	}
	
	//Test case 6: Test selectFunction with incorrect input
	public static void testSelectFunction4(){
		String input = "7\n6\n";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectFunction(0,null);
	    assertTrue(outContent.toString().contains("Your input is invalid, please try again."));
	}
	
	//Test case 7: Test selectFunction with incorrect input
	public void testSelectFunctionWithAlphabet(){
		String input = "Alphabet\n6\n";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));		
		controlPanel.selectFunction(10,null);
		assertTrue(outContent.toString().contains("Your input is invalid, please try again."));
	}

	//Test case 8: Test selectMovieOption from selectFunction with incorrect input
	public static void testSelectMovieOption1(){		
		String input = "5\r4\r3\r6\r";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	   
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectFunction(0,null);
	    assertTrue(outContent.toString().contains("Your input is invalid, please try again."));
	}
	
	//Test case 9: Test select movie function with out of range input
	public void testSelectMovieWithOutOfRangeNumber(){
		String input = "1000\r0\r";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectMovie(null);
		
		assertTrue(outContent.toString().contains("Your input is invalid, please try again."));		
	}
	
	//Test case 10: Test select movie function with negative number
	public void testSelectMovieWithNegativeNumber(){
		String input = "-1\r0\r6\n";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectMovie(null);
		
		assertTrue(outContent.toString().contains("Your input is invalid, please try again."));		
	}
	//Test case 11: Test select movie function with correct input
	public void testSelectMovie1(){
		String input = "1\r1\r6\r0\r";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectMovie(null);
		
		assertTrue(outContent.toString().contains("Director: Frank Darabont"));
	}
	
	//Test case 12: Test view movie info function select the first movie
	public void testViewMovieInfo(){		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.viewMovieInfo(0);
	    assertTrue(outContent.toString().contains("The Shawshank redemption"));		
	}
	
	//Test case 13: Test view movie comment by checking comment content
	public void testViewComment(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.viewComment(0);
	    assertTrue(outContent.toString().contains("Tim Cox"));		
	}
	
	//Test case 14: Test the post comment function by posting a test comment
	public void testPostComment1(){
		String comment = "TestAuthor\nTestTitle\nThis is a test comment";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    controlPanel.postComment(1,null);	    
	    assertTrue(outContent.toString().contains("TestAuthor"));
	}
	
	/* Test case 15: Test the post comment validation
	 * Case 1: \n\n\n
	 * Case 2: Test\n\n
	 * Case 3: Test\nTest\n\n
	 * Result should not display New comment: 
	 * indicating a new comment is posted
	 */
	public void testPostComment2_1(){
		String comment = "3\n\n\n\n3\nTest\n\n\n3\nTest\nTest\n\n6\n";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    controlPanel.selectFunction(1,null);
	    
	    boolean result = !(outContent.toString().contains("New comment:"));
	    assertTrue(result);		
	}
	
	/* Test case 16: Test the storeCommentToDB validation from postCommnet
	 * Case 1:   \n  \n\t\n
	 * Case 2: Test\n  \n  \n
	 * Case 3: Test\nTest\n   \n
	 * 3 branch cannot be covered as one parameter is hard-coded
	 * Result should display database error
	 */
	public void testPostComment4(){
		String comment = "3\n\t\n  \n  \n3\nTest\n  \n  \n3\nTest\nTest\n   \n6\n";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    controlPanel.postComment(1,null);
	    
	    boolean result = outContent.toString().contains("Fail: store the comment to database. Your input is not valid.");
	    assertTrue(result);		
	}
	
	//Test case 17: Test case 6: Test view movie name function by check the movie names
	public void testViewMovieNames(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    controlPanel.viewMovieNames();
	    
	    assertTrue(outContent.toString().contains("The Shawshank redemption"));	
	}
	
	//Test case 18: Test add new movie with success case
	public void testAddNewMoive0(){
		String comment = "TestName\nTestYear\nTestDirector\nTestActor\nThis is a test description";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.addMovie(null);
	    controlPanel.viewMovieNames();
	    
	    assertTrue(outContent.toString().contains("This is a test description"));	
	}
	
	/* Test case 19: Test add new movie function with fail case
	 * Case 1: \n\n\n\n\n
	 * Case 2: Test\n\n\n\n\n
	 * Case 3: Test\nTest\n\n\n\n
	 * Case 4: Test\nTest\nTest\n\n
	 * Case 5: Test\nTest\nTest\nTest\n\n
	 * All cases should not display a success message: "New movie:"
	 */
	public void testAddNewMovie1() throws FileNotFoundException{
		String comment = "2\n\n\n\n\n\n2\nTest\n\n\n\n\n2\nTest\nTest\n\n\n\n2\nTest\nTest\nTest\n\n\n2\nTest\nTest\nTest\nTest\n\n3\n";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.main(null);
	    boolean result = outContent.toString().contains("New movie:");
	    assertTrue(result);	
	}
	
	//Test case 20: Test case: test from main method to reach other method
	public void testMain1() throws FileNotFoundException{
		String comment = "1\r0\r3\r";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.main(null);
	    assertTrue(outContent.toString().contains("Press 0 to exit"));	
	}
	
	//Test case 21: Test case: test main method to add a new comment
	public void testMain2() throws FileNotFoundException{
		String comment = "2\rTestName\nTestYear\nTestDirector\nTestActor\nThis is a test description\r3";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.main(null);
	    controlPanel.viewMovieNames();
	    assertTrue(outContent.toString().contains("This is a test description"));	
	}


}
