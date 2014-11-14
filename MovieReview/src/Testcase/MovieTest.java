package Testcase;

import MovieReview.Movie;
import junit.framework.TestCase;

public class MovieTest extends TestCase {
	
	private Movie movie;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { movie = new Movie(); }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	//Test case 1: Test get and set of actor
	public void testGetSetActor() {
		String result;
		movie.setActor("actor");
		result = movie.getActor();
		assertEquals(result, "actor");
	}
	
	//Test case 2: Test get and set of description
	public void testGetSetDescription() {
		String result;
		movie.setDescription("description");
		result = movie.getDescription();
		assertEquals(result, "description");
	}
	
	//Test case 3: Test get and set of director
	public void testGetSetDirector() {
		String result;
		movie.setDirector("director");
		result = movie.getDirector();
		assertEquals(result, "director");
	}
	
	//Test case 4: Test get and set of movieId
	public void testGetSetMovieId() {
		int result;
		movie.setMovieid(123);;
		result = movie.getMovieid();
		assertEquals(result, 123);
	}
	
	//Test case 5: Test get and set of movie name
	public void testGetSetName() {
		String result;
		movie.setName("name");
		result = movie.getName();
		assertEquals(result, "name");
	}
	
}
