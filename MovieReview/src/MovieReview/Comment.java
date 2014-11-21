package MovieReview;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
public class Comment {
	
	/** The movieid. */
	private int movieid;
	
	/** The commentid. */
	private int commentid;
	
	/** The title. */
	private String title;
	
	/** The author. */
	private String author;
	
	/** The date. */
	private String date;
	
	/** The comment. */
	private String comment;
	
	/** The rating. */
	private String rating;
	
	/** The comment num. */
	private int commentNum;
	
	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
		movieid = 0;
		commentid = 0;
		title = "";
		author = "";
		date = "";
		comment = "";
		rating = "Neutral";
	}
	
	/**
	 * Instantiates a new comment.
	 *
	 * @param movieid the movieid
	 * @param commentid the commentid
	 * @param title the title
	 * @param author the author
	 * @param date the date
	 * @param comment the comment
	 */
	public Comment(int movieid, int commentid, String title, String author, String date, String comment) {
		this.movieid = movieid;
		this.commentid = commentid;
		this.title = title;
		this.author = author;
		this.date = date;
		this.comment = comment;
		rating = "Neutral";
	}
	
	/**
	 * Instantiates a new comment.
	 *
	 * @param movieid the movieid
	 * @param commentid the commentid
	 * @param title the title
	 * @param author the author
	 * @param date the date
	 * @param comment the comment
	 * @param rating the rating
	 */
	public Comment(int movieid, int commentid, String title, String author, String date, String comment, String rating) {
		this.movieid = movieid;
		this.commentid = commentid;
		this.title = title;
		this.author = author;
		this.date = date;
		this.comment = comment;
		this.rating = rating;
	}

	/**
	 * Gets the movieid.
	 *
	 * @return the movieid
	 */
	public int getMovieid() {
		return movieid;
	}

	/**
	 * Sets the movieid.
	 *
	 * @param movieid the new movieid
	 */
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	/**
	 * Gets the commentid.
	 *
	 * @return the commentid
	 */
	public int getCommentid() {
		return commentid;
	}

	/**
	 * Sets the commentid.
	 *
	 * @param commentid the new commentid
	 */
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(String rating){
		this.rating = rating;
	}
	
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating(){
		return rating;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nDate: " + date + "\nRating: " + rating + "\nComment: " + comment;
	}
	
}
