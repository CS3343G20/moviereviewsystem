package Testcase;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import MovieReview.*;
import junit.framework.TestCase;
/**
 * Test cases in this class will run through both Database.java, Comment.java and Movie.java
 * to perform an integration test
 * Also, this class will be tested dependently to perform unit test on Database.java with test stub
 */
public class TestDatabase extends TestCase {

	private Database database;
	private ArrayList<Movie> movielist;
	private ArrayList<Comment> commentlist;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { 
		database = new Database();
	}
	
	/**
	 * Unit test for Database.java
	 */
	//Test case 1: Test read movie name function by checking the movie name
	public void testReadMovie(){
		String result;
		result = database.getMovieList().get(0).getName();
		assertEquals(result, "The Shawshank redemption");		
	}
	//Test case 2: Test the read comment function by checking the content of some comment
	public void testReadComment(){		
		String result;
		result = database.getCommentList().get(0).getAuthor();
		assertEquals(result, "soumil_dutta");	
	}	
	
	//Stubbing Movie Constructor and getter to test Database.java dependently
	class StubMovie extends Movie{
		private int mid;
		private String mname;
		private String myear;
		private String mdirector;
		private String mactor;
		private String mdes;
		
		public StubMovie(int id,String name,String year,String director,String actor,String des){
			mid=id;
			mname=name;
			myear=year;
			mdirector=director;
			mactor=actor;
			mdes=des;
		}
		public int getMovieid(){return mid;}
		public String getName(){return mname;}
		public String getYear(){return myear;}
		public String getDirector(){return mdirector;}
		public String getActor(){return mactor;}
		public String getDescription(){return mdes;}
	}
	
	//Test cases for addNewMovie method
	public void testAddNewMovie_unitTest0() throws Exception{
		StubMovie movie = new StubMovie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "Matthew McConaughey", "Interstellar is a 2014 science fiction film directed by Christopher Nolan. Starring Matthew McConaughey, Anne Hathaway, Jessica Chastain, Mackenzie Foy and Michael Caine, the film features a team of astronauts who travel through a wormhole in search of a new habitable planet");
		database.addNewMovie(movie);
	}		
	//Test fail case with \t in String
	public void testAddNewMovie_unitTest1() throws Exception{
		setOutput();		
		StubMovie movie = new StubMovie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "Matthew McConaughey", "Description with \t in String");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie_unitTest2() throws Exception{
		setOutput();
		StubMovie movie = new StubMovie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "", "");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie_unitTest3() throws Exception{
		setOutput();
		StubMovie movie = new StubMovie(60, "interstellar", "October 26, 2014", "", "", "");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie_unitTest4() throws Exception{
		setOutput();
		StubMovie movie = new StubMovie(60, "interstellar", "", "", "", "");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie_unitTest5() throws Exception{
		setOutput();
		StubMovie movie = new StubMovie(0,"","","","","");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}	
	
	//Stubbing Comment Constructor and getter to test Database.java dependently
		class StubComment extends Comment{
			private int movieid;
			private int commentid;
			private String title;
			private String author;
			private String date;
			private String comment;
			public StubComment(int movieid, int commentid, String title, String author, String date, String comment) {
				this.movieid = movieid;
				this.commentid = commentid;
				this.title = title;
				this.author = author;
				this.date = date;
				this.comment = comment;
			}
			public int getMovieid(){return movieid;}
			public int getCommentid(){return commentid;}
			public String getTitle(){return title;}
			public String getAuthor(){return author;}
			public String getDate(){return date;}
			public String getComment(){return comment;}
		}
	
	//Test cases for addNewComment method
	public void testAddNewComment_unitTest1() throws Exception{
		StubComment comment = new StubComment(25,15,"interstellar","Jonathan Nolan","October 26, 2014","If you haven't seen this movie yet, do it now! This is the best movie I've seen in a very long time!");
		database.addNewComment(comment);
	}	
	//Test Fail case with \t in String
	public void testAddNewComment_unitTest2() throws Exception{
		setOutput();
		StubComment comment = new StubComment(25,15,"interstellar","Jonathan Nolan","October 26, 2014","Comment with\t in String");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}	
	//Test fail case with empty string
	public void testAddNewComment_unitTest3() throws Exception{
		setOutput();
		StubComment comment = new StubComment(25,15,"interstellar","Jonathan Nolan","","");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewComment_unitTest4() throws Exception{
		setOutput();
		StubComment comment = new StubComment(25,15,"interstellar","","","");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewComment_unitTest5() throws Exception{
		setOutput();
		StubComment comment = new StubComment(25,15,"","","","");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}


	
	/**
	 * Integration test for Database.java and Movie.java
	 */
	//Test cases for addNewMovie method
	public void testAddNewMovie0() throws Exception{
		Movie movie = new Movie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "Matthew McConaughey", "Interstellar is a 2014 science fiction film directed by Christopher Nolan. Starring Matthew McConaughey, Anne Hathaway, Jessica Chastain, Mackenzie Foy and Michael Caine, the film features a team of astronauts who travel through a wormhole in search of a new habitable planet");
		database.addNewMovie(movie);
	}		
	//Test fail case with \t in String
	public void testAddNewMovie1() throws Exception{
		setOutput();		
		Movie movie = new Movie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "Matthew McConaughey", "Description with \t in String");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie2() throws Exception{
		setOutput();
		Movie movie = new Movie(60, "interstellar", "October 26, 2014", "Christopher Nolan", "", "");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie3() throws Exception{
		setOutput();
		Movie movie = new Movie(60, "interstellar", "October 26, 2014", "", "", "");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie4() throws Exception{
		setOutput();
		Movie movie = new Movie(60, "interstellar", "", "", "", "");
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewMovie5() throws Exception{
		setOutput();
		Movie movie = new Movie();
		database.addNewMovie(movie);
		assertEquals("Fail: store the movie to database. Your input is not valid.\r\n", getOutput());
	}		
	
	/**
	 * Integration test for Database.java and Comment.java
	 */
	//Test cases for addNewComment method
	public void testAddNewComment1() throws Exception{
		Comment comment = new Comment(25,15,"interstellar","Jonathan Nolan","October 26, 2014","If you haven't seen this movie yet, do it now! This is the best movie I've seen in a very long time!");
		database.addNewComment(comment);
	}	
	//Test Fail case with \t in String
	public void testAddNewComment2() throws Exception{
		setOutput();
		Comment comment = new Comment(25,15,"interstellar","Jonathan Nolan","October 26, 2014","Comment with\t in String");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}	
	//Test fail case with empty string
	public void testAddNewComment3() throws Exception{
		setOutput();
		Comment comment = new Comment(25,15,"interstellar","Jonathan Nolan","","");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewComment4() throws Exception{
		setOutput();
		Comment comment = new Comment(25,15,"interstellar","","","");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}
	//Test fail case with empty string
	public void testAddNewComment5() throws Exception{
		setOutput();
		Comment comment = new Comment(25,15,"","","","");
		database.addNewComment(comment);
		assertEquals("Fail: store the comment to database. Your input is not valid.\r\n", getOutput());
	}
	
	
	/**
	 * DO NOT MODIFY
	 */
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;  

	private void setOutput() throws Exception
	{
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();  
		System.setOut(new PrintStream(bos)); 
	}
	
	private String getOutput() //throws Exception
	{
		System.setOut(oldPrintStream);
		return bos.toString();
	}

}
