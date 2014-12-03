package Testcase;

import MovieReview.Movie;
import junit.framework.TestCase;

/**
 * Test cases in this class will perform unit test on Movie.java dependently
 */
public class TestMovie extends TestCase {
	
	private Movie movie;
	
	//Test case 1: Test get and set of actor
	public void testGetSetActor() {
		movie = new Movie();
		movie.setActor("actor");
		String result = movie.getActor();
		assertEquals(result, "actor");
	}
	
	//Test case 2: Test get and set of description
	public void testGetSetDescription() {
		movie = new Movie();
		movie.setDescription("description");
		String result = movie.getDescription();
		assertEquals(result, "description");
	}
	
	//Test case 3: Test get and set of director
	public void testGetSetDirector() {
		movie = new Movie();
		movie.setDirector("director");
		String result = movie.getDirector();
		assertEquals(result, "director");
	}
	
	//Test case 4: Test get and set of movieId
	public void testGetSetMovieId() {
		movie = new Movie();
		movie.setMovieid(123);;
		int result = movie.getMovieid();
		assertEquals(result, 123);
	}
	
	//Test case 5: Test get and set of movie name
	public void testGetSetName() {
		movie = new Movie();
		movie.setName("name");
		String result = movie.getName();
		assertEquals(result, "name");
	}
	
	//Test case 6: Test get and set of year
	public void testGetSetYear() {
		movie = new Movie();		
		movie.setYear("1993");
		String result = movie.getYear();
		assertEquals(result, "1993");
	}
	
	//Test case 7: Test the toString method by the constructor with no parameters
	public void testToString1(){
		movie = new Movie();
		String result = movie.toString();
		assertEquals(result, "Name: \nYear: \nDirector: \nActor: \nDescription: \n");
	}
	
	//Test case 8: Test the toString method by the constructor with no parameters
	public void testToString2(){
		movie = new Movie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "Matthew McConaughey", "Interstellar is a 2014 science fiction film directed by Christopher Nolan. Starring Matthew McConaughey, Anne Hathaway, Jessica Chastain, Mackenzie Foy and Michael Caine, the film features a team of astronauts who travel through a wormhole in search of a new habitable planet");
		String result = movie.toString();
		assertEquals(result, "Name: interstellar\nYear: October 26, 2014\nDirector: Christopher Nolan\nActor: Matthew McConaughey\nDescription: Interstellar is a 2014 science fiction film directed by Christopher Nolan. Starring Matthew McConaughey, Anne Hathaway, Jessica Chastain, Mackenzie Foy and Michael Caine, the film features a team of astronauts who travel through a wormhole in search of a new habitable planet\n");
	}
}
