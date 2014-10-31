package Testcase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import MovieReview.ControlPanel;
import junit.framework.TestCase;

public class ControlPanelTest extends TestCase {
	private ControlPanel controlPanel;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { 
		controlPanel.init(); 
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	//Test case 1: Test select movie function with alphabetic input
	public void testSelectMovieWithAlphabet(){
		String input = "Alphabet";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		controlPanel.selectMovie();
		
		assertEquals(outContent.toString(), "Your input is invalid, please try again.");
	}

	//Test case 2: Test select movie function with out of range input
	public void testSelectMovieWithOutOfRangeNumber(){
		String input = "100";
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.selectMovie();
		
		assertEquals(outContent.toString(), "Your input is invalid, please try again.");
	}
	
	//Test case 3: Test view movie info function select the first movie
	public void testViewMovieInfo(){		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.viewMovieInfo(0);
	    assertTrue(outContent.toString().contains("The Shawshank redemption"));		
	}
	
	//Test case 4: Test view movie comment with checking comment content
	public void testViewComment(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.viewComment(0);
	    assertTrue(outContent.toString().contains("Tim Cox"));		
	}
	
	//Test case 5: Test the post comment function by posting a test comment
	public void testPostComment(){
		String comment = "TestAuthor\nTestTitle\nThis is a test comment";
	    System.setIn(new ByteArrayInputStream(comment.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    controlPanel.postComment(1);
	    
	    boolean validAuthor = outContent.toString().contains("TestAuthor");
	    boolean validTitle = outContent.toString().contains("TestTitle");
	    boolean validComment = outContent.toString().contains("This is a test comment");
	    
	    assertTrue(validAuthor && validTitle && validComment);		
	}
	
	//Test case 6: Test view movie name function by check the movie names
	public void testViewMovieNames(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    controlPanel.viewMovieNames();
	    assertTrue(outContent.toString().contains("The Shawshank redemption"));	
	}
	

}
