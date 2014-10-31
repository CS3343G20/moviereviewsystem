package Testcase;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import MovieReview.*;
import junit.framework.TestCase;

public class DatabaseTest extends TestCase {

	private Database database;
	private ArrayList<Movie> movielist;
	private ArrayList<Comment> commentlist;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { 
		movielist = new ArrayList<Movie>();
		commentlist = new ArrayList<Comment>();
		database = new Database(movielist, commentlist);
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	//Test case 1: Test read movie name function by checking the movie name
	public void testReadMovie(){
		String result;
		result = movielist.get(0).getName();
		assertEquals(result, "The Shawshank redemption");		
	}
	
	//Test case 2: Test the read comment function by checking the content of some comment
	public void testReadComment(){
		String result;
		result = commentlist.get(0).getAuthor();
		assertEquals(result, "Carflo");	
	}
}
