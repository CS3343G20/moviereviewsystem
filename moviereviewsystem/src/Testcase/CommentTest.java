package Testcase;

import MovieReview.Comment;
import junit.framework.TestCase;

public class CommentTest extends TestCase {

	private Comment comment;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() { comment = new Comment(); }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	//Test case 1: Test getter and setter of movieId
	public void testGetSetMovieId() {
		int result;
		comment.setMovieid(123);
		result = comment.getMovieid();
		assertEquals(result, 123);
	}
	
	//Test case 2: Test getter and setter of author
	public void testGetSetAuthor() {
		String result;
		comment.setAuthor("author");
		result = comment.getAuthor();
		assertEquals(result, "author");
	}
	
	//Test case 3: Test getter and setter of date
	public void testGetSetDate() {
		String result;
		comment.setDate("1-1-2014");
		result = comment.getDate();
		assertEquals(result, "1-1-2014");
	}
	
	//Test case 4: Test getter and setter of title
	public void testGetSetTitle() {
		String result;
		comment.setTitle("title");
		result = comment.getTitle();
		assertEquals(result, "title");
	}
	
	//Test case 5: Test getter and setter of comment
	public void testGetSetComment() {
		String result;
		comment.setComment("comment");
		result = comment.getComment();
		assertEquals(result, "comment");
	}
	
	//Test case 6: Test getter and setter of commentId
	public void testGetSetCommentId() {
		int result;
		comment.setCommentid(123);
		result = comment.getCommentid();
		assertEquals(result, 123);
	}
}
