package MovieReview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Database.
 */
public class Database {
	
	/** The movieid. */
	private int movieid;
	
	/** The commentid. */
	private int commentid;
	
	/** The movielist. */
	private static ArrayList<Movie> movielist = new ArrayList<Movie>();
	
	/** The commentlist. */
	private static ArrayList<Comment> commentlist = new ArrayList<Comment>();
	
	/** The key word list. */
	private static KeyWord keyWordList = new KeyWord();
	
	/**
	 * Instantiates a new database.
	 */
	public Database()  {
		try {
			readMovie();
			readComment();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read movie.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void readMovie() throws FileNotFoundException {
		File filename = new File("movie.txt");	
		Scanner scan = null;

		String name;
		String year;
		String director;
		String actor;
		String description;
		try {
			scan = new Scanner(filename);
			scan.useDelimiter("\t|\n");
			
			while (scan.hasNext()) {
				movieid = Integer.parseInt(scan.next());
				name = scan.next();
				year = scan.next();
				director = scan.next();
				actor = scan.next();
				description = scan.next();
				
				Movie m = new Movie(movieid , name, year, director, actor, description);
				movielist.add(m);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
	
	/**
	 * Read comment.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void readComment() throws FileNotFoundException {
		File filename = new File("comment.txt");	
		Scanner scan = null;
		
		String title;
		String author;
		String date;
		String comment;
		String rating = "";
		
		try {
			scan = new Scanner(filename);
			scan.useDelimiter("\t|\n");
			
			while(scan.hasNextLine()) {
				movieid = Integer.parseInt(scan.next());
				commentid = Integer.parseInt(scan.next());
				title = scan.next();
				author = scan.next();
				date = scan.next();
				comment = scan.next();
				rating = calCommentRating(comment);
				
				Comment c = new Comment(movieid, commentid, title, author, date, comment,rating);
				commentlist.add(c);
				
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}

	/**
	 * Store comments to db.
	 *
	 * @param movieid the movieid
	 * @param commentid the commentid
	 * @param title the title
	 * @param author the author
	 * @param date the date
	 * @param comment the comment
	 */
	public static void storeCommentsToDB(int movieid, int commentid, String title, String author, String date, String comment){
		String comments = movieid + "\t" + commentid + "\t" + title + "\t" + author + "\t" + date + "\t" + comment;
		try {
			BufferedWriter bwriter = new BufferedWriter(new FileWriter("comment.txt", true));
			if(commentValidation(title) && commentValidation(author) && commentValidation(date) && commentValidation(comment)) { 
				bwriter.newLine();
				bwriter.write(comments);
			}
			else
				System.out.println("Fail: store the comments to database. Your input is not valid.");
			bwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds the new comment.
	 *
	 * @param commentnew the commentnew
	 */
	public void addNewComment(Comment commentnew){
		addToCommentList(commentnew);
		storeCommentsToDB(commentnew.getMovieid(),commentnew.getCommentid(),commentnew.getTitle(),commentnew.getAuthor(),commentnew.getDate(),commentnew.getComment());
	}
	
	/**
	 * Adds the to comment list.
	 *
	 * @param newComment the new comment
	 */
	private void addToCommentList(Comment newComment){
		 commentlist.add(newComment);
	}
	
	/**
	 * Comment validation.
	 *
	 * @param input the input
	 * @return true, if successful
	 */
	public static boolean commentValidation(String input){
		return (!input.contains("\t") && !(input.trim() == ""));
	}
	
	/**
	 * Gets the movie list.
	 *
	 * @return the movie list
	 */
	public ArrayList<Movie> getMovieList(){
		return movielist;
	}
	
	/**
	 * Gets the comment list.
	 *
	 * @return the comment list
	 */
	public ArrayList<Comment> getCommentList(){
		return commentlist;
	}
	
	/**
	 * Cal comment rating.
	 *
	 * @param comment the comment
	 * @return the string
	 */
	private String calCommentRating(String comment){
		
		int pos = 0;
		int neg = 0;
		int neu = 0;
		Set<String> words = new HashSet<String>();
		String delims = "[ \t\n.,?!\"]+";
		String[] tokens = comment.split(delims);
		for (int i = 0; i < tokens.length; i++){
			if (!words.contains(tokens[i]))
				words.add(tokens[i]);
		}
		
		Iterator it = words.iterator();  
	    while (it.hasNext()){
	    	String word = ((String) it.next()).toLowerCase();
	    	
	    	if (keyWordList.getPositveKeyWord().contains(word)){
	    		pos++;
	    		
	    	}
	    	else if (keyWordList.getNegativeKeyWord().contains(word)){
	    		neg++;
	    		
	    	}
	    	else if (keyWordList.getNeutralKeyWord().contains(word)){
	    		neu++;
	    		
	    	}
	    }
	    
	   
	    if (pos+neg == 0)
	    	return "Neutral";
	    
	  	if (pos > neg)
	  		return "Positive";
	    
	    if (neg > pos)
	    	return "Negative";
	    
	    
	    return "Neutral";
	}
}
