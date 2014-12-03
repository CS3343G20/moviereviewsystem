package Testcase;

import MovieReview.Comment;
import junit.framework.TestCase;

/**
 * Test cases in this class will perform unit test on Comment.java dependently
 */
public class TestComment extends TestCase {

	private Comment comment;

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	//Test case 1: Test getter and setter of movieId
	public void testGetSetMovieId() {
		comment = new Comment();
		int result;
		comment.setMovieid(123);
		result = comment.getMovieid();
		assertEquals(result, 123);
	}
	
	//Test case 2: Test getter and setter of author
	public void testGetSetAuthor() {
		comment = new Comment();
		String result;
		comment.setAuthor("author");
		result = comment.getAuthor();
		assertEquals(result, "author");
	}
	
	//Test case 3: Test getter and setter of date
	public void testGetSetDate() {
		comment = new Comment();
		String result;
		comment.setDate("1-1-2014");
		result = comment.getDate();
		assertEquals(result, "1-1-2014");
	}
	
	//Test case 4: Test getter and setter of title
	public void testGetSetTitle() {
		comment = new Comment();
		String result;
		comment.setTitle("title");
		result = comment.getTitle();
		assertEquals(result, "title");
	}
	
	//Test case 5: Test getter and setter of comment
	public void testGetSetComment() {
		comment = new Comment();
		String result;
		comment.setComment("comment");
		result = comment.getComment();
		assertEquals(result, "comment");
	}
	
	//Test case 6: Test getter and setter of commentId
	public void testGetSetCommentId() {
		comment = new Comment();
		int result;
		comment.setCommentid(123);
		result = comment.getCommentid();
		assertEquals(result, 123);
	}
	
	//Test case 7: Test getter and setter of commentId
	public void testGetSetRating() {
		comment = new Comment();
		String result;
		comment.setRating("Neutral");
		result = comment.getRating();
		assertEquals(result, "Neutral");
	}
	
	//Test case 8: Test the toString method by the constructor with no parameters
	public void testToString1() {
		comment = new Comment();
		String result;
		result = comment.toString();
		assertEquals(result, "Title: \nAuthor: \nDate: \nRating: Neutral\nComment: ");		
	}
	
	//Test case 9:  Test the toString method by the constructor with 6 parameters
	public void testToString2() {
		comment = new Comment(25,15,"interstellar","Jonathan Nolan","October 26, 2014","Because sometimes it is the unknown that fascinates us, frightens us and brings out the best in us.");
		String result;
		result = comment.toString();
		assertEquals(result, "Title: interstellar\nAuthor: Jonathan Nolan\nDate: October 26, 2014\nRating: Neutral\nComment: Because sometimes it is the unknown that fascinates us, frightens us and brings out the best in us.");
	}
	
	//Test case 10:  Test the toString method by the constructor with 7 parameters
	public void testToString3() {
		comment = new Comment(25,15,"interstellar","Jonathan Nolan","October 26, 2014","If you haven't seen this movie yet, do it now! This is the best movie I've seen in a very long time!", "Extraordinary");
		String result;
		result = comment.toString();
		assertEquals(result, "Title: interstellar\nAuthor: Jonathan Nolan\nDate: October 26, 2014\nRating: Extraordinary\nComment: If you haven't seen this movie yet, do it now! This is the best movie I've seen in a very long time!");
	}
}
