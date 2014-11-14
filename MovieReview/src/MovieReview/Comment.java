package MovieReview;

public class Comment {
	private int movieid;
	private int commentid;
	private String title;
	private String author;
	private String date;
	private String comment;
	private String rating;
	
	public Comment() {
		movieid = 0;
		commentid = 0;
		title = "";
		author = "";
		date = "";
		comment = "";
		rating = "Neutral";
	}
	
	public Comment(int movieid, int commentid, String title, String author, String date, String comment) {
		this.movieid = movieid;
		this.commentid = commentid;
		this.title = title;
		this.author = author;
		this.date = date;
		this.comment = comment;
		rating = "Neutral";
	}
	
	public Comment(int movieid, int commentid, String title, String author, String date, String comment, String rating) {
		this.movieid = movieid;
		this.commentid = commentid;
		this.title = title;
		this.author = author;
		this.date = date;
		this.comment = comment;
		this.rating = rating;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setRating(String rating){
		this.rating = rating;
	}
	
	
	public String getRating(){
		return rating;
	}
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nDate: " + date + "\nRating: " + rating + "\nComment: " + comment;
	}
	
}
